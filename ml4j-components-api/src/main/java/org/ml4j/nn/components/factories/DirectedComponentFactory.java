package org.ml4j.nn.components.factories;

import java.util.List;

import org.ml4j.Matrix;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponentsContext;
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
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChainActivation;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedComponentFactory {

	DirectedAxonsComponent<Neurons, Neurons> createFullyConnectedAxonsComponent(Neurons leftNeurons, Neurons rightNeurons, Matrix connectionWeights, Matrix biases);
	
	DirectedAxonsComponent<Neurons3D, Neurons3D> createConvolutionalAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, Matrix connectionWeights, Matrix biases);

	DirectedAxonsComponent<Neurons3D, Neurons3D> createMaxPoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight, boolean scaleOutputs);

	DirectedAxonsComponent<Neurons3D, Neurons3D> createAveragePoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, int strideWidth, int strideHeight, Integer paddingWidth, Integer paddingHeight);

	<N extends Neurons> BatchNormDirectedAxonsComponent<N, N> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons);
	
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, N> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	BatchNormDirectedAxonsComponent<Neurons3D, Neurons3D> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons);
	
	BatchNormDirectedAxonsComponent<Neurons3D, Neurons3D> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	<L extends Neurons, R extends Neurons> DirectedAxonsComponent<L, R> createDirectedAxonsComponent(Axons<L, R, ?> axons);
	
	<N extends Neurons> DirectedAxonsComponent<N, N> createPassThroughAxonsComponent(N leftNeurons, N rightNeurons);
	
	OneToManyDirectedComponent<?> createOneToManyDirectedComponent(List<? extends ChainableDirectedComponent<NeuronsActivation, 
			? extends ChainableDirectedComponentActivation<NeuronsActivation>, DirectedComponentsContext>> targetComponents);
	
	ManyToOneDirectedComponent<?> createManyToOneDirectedComponent(PathCombinationStrategy pathCombinationStrategy);

	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(DifferentiableActivationFunction differentiableActivationFunction);
	
	DefaultDirectedComponentChain createDirectedComponentChain(List<DefaultChainableDirectedComponent<?, ?>> sequentialComponents);
	
	DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation> createDirectedComponentChainBatch(List<DefaultDirectedComponentChain> parallelChains);
	
	DefaultDirectedComponentBipoleGraph createDirectedComponentBipoleGraph(DefaultDirectedComponentChainBatch<DefaultDirectedComponentChain, DefaultDirectedComponentChainActivation> batchOfParallelChains, PathCombinationStrategy pathCombinationStrategy);
}
