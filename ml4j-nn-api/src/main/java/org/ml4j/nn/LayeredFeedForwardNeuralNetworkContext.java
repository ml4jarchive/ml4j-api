package org.ml4j.nn;

/**
 * Encapsulates the runtime context used with a FeedForwareNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface LayeredFeedForwardNeuralNetworkContext
		extends LayeredDirectedNeuralNetworkContext, FeedForwardNeuralNetworkContext {

	@Override
	LayeredFeedForwardNeuralNetworkContext asTrainingContext();

	@Override
	LayeredFeedForwardNeuralNetworkContext asNonTrainingContext();

}
