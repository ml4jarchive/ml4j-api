package org.ml4j.nn;

/**
 * Encapsulates the runtime context used with a DirectedNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface LayeredDirectedNeuralNetworkContext extends DirectedNeuralNetworkContext, LayeredNeuralNetworkContext {

	/**
	 * @return The index of the starting layer for a propagation through a
	 *         DirectedNeuralNetwork.
	 */
	int getStartLayerIndex();

	/**
	 * @return The index of the end layer for a propagation through a
	 *         DirectedNeuralNetwork, or null if the propagation is required to
	 *         reach the final Layer.
	 */
	Integer getEndLayerIndex();

}
