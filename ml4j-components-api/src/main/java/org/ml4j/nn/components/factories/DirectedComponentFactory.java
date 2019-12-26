package org.ml4j.nn.components.factories;

import java.util.List;
import java.util.function.IntSupplier;

import org.ml4j.Matrix;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.components.activationfunctions.DifferentiableActivationFunctionComponent;
import org.ml4j.nn.components.axons.BatchNormDirectedAxonsComponent;
import org.ml4j.nn.components.axons.DirectedAxonsComponent;
import org.ml4j.nn.components.manytomany.DefaultDirectedComponentChainBatch;
import org.ml4j.nn.components.manytoone.ManyToOneDirectedComponent;
import org.ml4j.nn.components.manytoone.PathCombinationStrategy;
import org.ml4j.nn.components.onetomany.OneToManyDirectedComponent;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentBipoleGraph;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChain;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * 
 * Factory interface whose implementations are responsible for creating
 * differentiable components required by DirectedNeuralNetworks
 * 
 * @author Michael Lavelle
 *
 */
public interface DirectedComponentFactory {

	/**
	 * Create a fully-connected axons component, connecting leftNeurons to rightNeurons via connectionWeights.
	 * 
	 * @param leftNeurons The neurons on the left of the fully-connected axons component.
	 * @param rightNeurons The neurons on the right of the fully-connected axons component.
	 * @param connectionWeights Optionally specify the connection weights of the axons - if not provided the weights will be initialised to defaults.
	 * @param biases Optionally specify the left-to-right biases of the axons - if not provided the biases will be initialised to defaults.
	 * @return A fully-connected axons component, connecting leftNeurons to rightNeurons via connectionWeights.
	 */
	DirectedAxonsComponent<Neurons, Neurons, ?> createFullyConnectedAxonsComponent(Neurons leftNeurons, Neurons rightNeurons, Matrix connectionWeights, Matrix biases);
	
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createConvolutionalAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, Matrix connectionWeights, Matrix biases);

	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createMaxPoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, boolean scaleOutputs);

	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createAveragePoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight);

	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons);
	
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons);
	
	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	<L extends Neurons, R extends Neurons> DirectedAxonsComponent<L, R, ?> createDirectedAxonsComponent(Axons<L, R, ?> axons);
	
	<N extends Neurons> DirectedAxonsComponent<N, N, ?> createPassThroughAxonsComponent(N leftNeurons, N rightNeurons);
	
	OneToManyDirectedComponent<?> createOneToManyDirectedComponent(IntSupplier targetComponentsCount);
	
	ManyToOneDirectedComponent<?> createManyToOneDirectedComponent(PathCombinationStrategy pathCombinationStrategy);

	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(Neurons neurons, DifferentiableActivationFunction differentiableActivationFunction);
	
	DefaultDirectedComponentChain createDirectedComponentChain(List<DefaultChainableDirectedComponent<?, ?>> sequentialComponents);
	
	DefaultDirectedComponentChainBatch createDirectedComponentChainBatch(List<DefaultDirectedComponentChain> parallelChains);
	
	DefaultDirectedComponentBipoleGraph createDirectedComponentBipoleGraph(Neurons inputNeurons, Neurons outputNeurons, DefaultDirectedComponentChainBatch batchOfParallelChains, PathCombinationStrategy pathCombinationStrategy);
}
