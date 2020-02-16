package org.ml4j.nn;

import java.util.List;

import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;

/**
 * Interface for containers of NeuralNetworkComponents.
 * 
 * @author Michael Lavelle
 *
 * @param <C> The type of component in the NeuralNetwork.
 */
public interface NeuralNetworkComponentsContainer<C extends DefaultChainableDirectedComponent<?, ?>> {

	/**
	 * @return The list of components.
	 */
	List<C> getComponents();
}
