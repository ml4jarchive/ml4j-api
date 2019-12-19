package org.ml4j.nn.components;

import java.util.List;

/**
  * Encapsulates the activation from a DirectedComponentChain after forward propagation.
  * 
  * @author Michael Lavelle
 *
 * @param <I> The type of input to this DirectedComponentChain
 * @param <A> The type of activation produced by this DirectedComponentChain after forward propagation.
 */
public interface DirectedComponentChainActivation<I, A extends ChainableDirectedComponentActivation<I>>
		extends DirectedComponentActivation<I, I>, ChainableDirectedComponentActivation<I>{

	List<A> getActivations();
}
