package org.ml4j.nn;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.optimisation.GradientDescentOptimisationStrategy;
import org.ml4j.nn.optimisation.TrainingLearningRateAdjustmentStrategy;

/**
 * Encapsulates the runtime context used with a DirectedNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface DirectedNeuralNetworkContext extends NeuralNetworkContext {

	/**
	 * @return The learning rate used during training.
	 */
	float getTrainingLearningRate();

	/**
	 * @return The context containing the optional contexts for each directed
	 *         component.
	 */
	DirectedComponentsContext getDirectedComponentsContext();

	/**
	 * @return The number of iterations through the entire data set during training.
	 */
	int getTrainingEpochs();

	/**
	 * @return The size of the mini batch if training in batch mode... or null if
	 *         non-batch mode.
	 */
	Integer getTrainingMiniBatchSize();

	/**
	 * @param trainingLearningRate The learning rate used during training.
	 */
	void setTrainingLearningRate(float trainingLearningRate);

	/**
	 * @param trainingEpochs The number of iterations through the entire data set
	 *                       during training.
	 */
	void setTrainingEpochs(int trainingEpochs);

	/**
	 * @param batchSize The size of the mini batch if training in batch mode... or
	 *                  null if non-batch mode.
	 */
	void setTrainingMiniBatchSize(Integer batchSize);

	/**
	 * @return The gradient descent optimisation strategy if set, null otherwise.
	 */
	GradientDescentOptimisationStrategy getGradientDescentOptimisationStrategy();

	/**
	 * @param gradientDescentOptimisationStrategy The gradient descent optimisation
	 *                                            strategy.
	 */
	void setGradientDescentOptimisationStrategy(
			GradientDescentOptimisationStrategy gradientDescentOptimisationStrategy);

	/**
	 * @return The learning rate adjustment strategy if set, null otherwise.
	 */
	TrainingLearningRateAdjustmentStrategy getTrainingLearningRateAdjustmentStrategy();

	/**
	 * @param trainingLearningRateAdjustmentStrategy The training learning rate
	 *                                               adjustment strategy.
	 */
	void setTrainingLearningRateAdjustmentStrategy(
			TrainingLearningRateAdjustmentStrategy trainingLearningRateAdjustmentStrategy);

	/**
	 * @return The index of the Epoch of training, or null if not set.
	 */
	Integer getLastTrainingEpochIndex();

	/**
	 * @param lastTrainingEpochIndex The index of the Epoch of training.
	 */
	void setLastTrainingEpochIndex(Integer lastTrainingEpochIndex);

	/**
	 * Set a forward propagation listener.
	 * 
	 * @param forwardPropagationListener The forward propagation listener.
	 */
	void setForwardPropagationListener(ForwardPropagationListener forwardPropagationListener);

	/**
	 * Set a back propagation listener.
	 * 
	 * @param backPropagationListener The back propagation listener.
	 */
	void setBackPropagationListener(BackPropagationListener backPropagationListener);

	/**
	 * @return The configured forward propagation listener, or null if not
	 *         configured.
	 */
	ForwardPropagationListener getForwardPropagationListener();

	/**
	 * @return The configured back propagation listener, or null if not configured.
	 */
	BackPropagationListener getBackPropagationListener();

}
