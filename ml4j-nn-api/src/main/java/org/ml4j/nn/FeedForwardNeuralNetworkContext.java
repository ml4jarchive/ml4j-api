package org.ml4j.nn;

/**
 * Encapsulates the runtime context used with a FeedForwareNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface FeedForwardNeuralNetworkContext extends DirectedNeuralNetworkContext {

	/**
	 * @return A lightweight wrapper around the current context, 
	 * with shared factories and configuration, but with training mode set to true.
	 * This does not change the training/non-training status of the session that
	 * may have generated this context, or that of the current context.
	 */
	FeedForwardNeuralNetworkContext asTrainingContext();
	
	/**
	 * @return A lightweight wrapper around the current context, 
	 * with shared factories and configuration, but with training mode set to false.
	 * This does not change the training/non-training status of the session that
	 * may have generated this context, or that of the current context.
	 */
	FeedForwardNeuralNetworkContext asNonTrainingContext();

}
