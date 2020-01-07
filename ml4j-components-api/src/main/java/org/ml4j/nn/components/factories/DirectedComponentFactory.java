package org.ml4j.nn.components.factories;

import java.util.List;
import java.util.function.IntSupplier;

import org.ml4j.Matrix;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.Axons3DConfig;
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
	 * @param biases Optionally specify the left-to-right biases of the axons - if not provided the biases will be initialised to defaults if the LHS neurons
	 * have a bias unit.
	 * @return A fully-connected axons component, connecting leftNeurons to rightNeurons via connectionWeights.
	 */
	DirectedAxonsComponent<Neurons, Neurons, ?> createFullyConnectedAxonsComponent(Neurons leftNeurons, Neurons rightNeurons, Matrix connectionWeights, Matrix biases);
	
	/**
	 * 
	 * Create a convolutional axons component.
	 * 
	 * @param leftNeurons The neurons on the left of the convolutional axons component.
	 * @param rightNeurons The neurons on the right of the convolutional axons component.
	 * @param config The Axons3DConfig.
	 * @param connectionWeights Optionally specify the convolutional connection weights of the axons - if not provided the weights will be initialised to defaults.
	 * @param biases Optionally specify the left-to-right biases of the axons - if not provided the biases will be initialised to defaults if the LHS neurons have a bias unit.
	 * @return A fully-connected axons component, connecting leftNeurons to rightNeurons convolutionally via convolutional connectionWeights.
	 */
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createConvolutionalAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config, Matrix connectionWeights, Matrix biases);

	/**
	 * Create a max-pooling axons component.
	 * 
	 * @param leftNeurons The neurons on the left of the max pooling axons component.
	 * @param rightNeurons The neurons on the right of the max pooling axons component.
	 * @param config The Axons3DConfig.
	 * @param scaleOutputs Whether to scale the output of the max pooling axons by a scaling factor to compensate for the max-pooling dropout.
	 * @return A max-pooling axons component.
	 */
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createMaxPoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config, boolean scaleOutputs);

	/**
	 * Create an average-pooling axons component.
	 * 
	 * @param leftNeurons The neurons on the left of the average pooling axons component.
	 * @param rightNeurons The neurons on the right of the average pooling axons component.
	 * @param config The Axons3DConfig.
	 * @return An average-pooling axons component.
	 */
	DirectedAxonsComponent<Neurons3D, Neurons3D, ?> createAveragePoolingAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Axons3DConfig config);

	/**
	 * Create a batch-norm directed axons component with default initialised weights.
	 * 
	 * @param <N> The type of neurons on the LHS/RHS of these axons.
	 * @param leftNeurons The left neurons.
	 * @param rightNeurons The right neurons.
	 * @return A batch-norm directed axons component with default initialised weights.
	 */
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons);
	
	/**
	 * 
	 * @param <N>
	 * @param leftNeurons
	 * @param rightNeurons
	 * @param gamma
	 * @param beta
	 * @param mean
	 * @param stddev
	 * @return
	 */
	<N extends Neurons> BatchNormDirectedAxonsComponent<N, ?> createBatchNormAxonsComponent(N leftNeurons, N rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	/**
	 * 
	 * @param leftNeurons
	 * @param rightNeurons
	 * @return
	 */
	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons);
	
	/**
	 * 
	 * @param leftNeurons
	 * @param rightNeurons
	 * @param gamma
	 * @param beta
	 * @param mean
	 * @param stddev
	 * @return
	 */
	BatchNormDirectedAxonsComponent<Neurons3D, ?> createConvolutionalBatchNormAxonsComponent(Neurons3D leftNeurons, Neurons3D rightNeurons, Matrix gamma, Matrix beta, Matrix mean, Matrix stddev);

	/**
	 * 
	 * @param <L>
	 * @param <R>
	 * @param axons
	 * @return
	 */
	<L extends Neurons, R extends Neurons> DirectedAxonsComponent<L, R, ?> createDirectedAxonsComponent(Axons<L, R, ?> axons);
	
	/**
	 * Construct a pass-through (no-op) axons component - used within residual networks for skip-connections.
	 * 
	 * @param <N> The type of neurons on the LHS/RHS of the pass-through axons.
	 * @param leftNeurons
	 * @param rightNeurons
	 * @return
	 */
	<N extends Neurons> DirectedAxonsComponent<N, N, ?> createPassThroughAxonsComponent(N leftNeurons, N rightNeurons);
	
	/**
	 * Construct a OneToManyDirectedComponent.
	 * 
	 * @param targetComponentsCount
	 * @return
	 */
	OneToManyDirectedComponent<?> createOneToManyDirectedComponent(IntSupplier targetComponentsCount);
	
	/**
	 * Construct a ManyToOneDirectedComponent
	 * 
	 * @param pathCombinationStrategy
	 * @return
	 */
	ManyToOneDirectedComponent<?> createManyToOneDirectedComponent(PathCombinationStrategy pathCombinationStrategy);

	/**
	 * Construct a DifferentiableActivationFunctionComponent.
	 * 
	 * @param neurons
	 * @param differentiableActivationFunction
	 * @return
	 */
	DifferentiableActivationFunctionComponent createDifferentiableActivationFunctionComponent(Neurons neurons, DifferentiableActivationFunction differentiableActivationFunction);
	
	/**
	 * Construct a DefaultDirectedComponentChain instance.
	 * 
	 * @param sequentialComponents
	 * @return
	 */
	DefaultDirectedComponentChain createDirectedComponentChain(List<DefaultChainableDirectedComponent<?, ?>> sequentialComponents);
	
	/**
	 * Construct a DefaultDirectedComponentChainBatch instance.
	 * 
	 * @param parallelChains
	 * @return
	 */
	DefaultDirectedComponentChainBatch createDirectedComponentChainBatch(List<DefaultDirectedComponentChain> parallelChains);
	
	/**
	 * Construct a DefaultDirectedComponentBipoleGraph instance.
	 *  
	 * @param inputNeurons The neurons on the LHS of the bipole graph.
	 * @param outputNeurons The neurons on the RHS of the bipole graph.
	 * @param batchOfParallelChains The batch of parallel chains, connecting the input neurons to the output neurons.
	 * @param pathCombinationStrategy The strategy specifying how the outputs of the parallel chains are combined to produce the output.
	 * @return A DefaultDirectedComponentBipoleGraph instance.
	 */
	DefaultDirectedComponentBipoleGraph createDirectedComponentBipoleGraph(Neurons inputNeurons, Neurons outputNeurons, DefaultDirectedComponentChainBatch batchOfParallelChains, PathCombinationStrategy pathCombinationStrategy);
}
