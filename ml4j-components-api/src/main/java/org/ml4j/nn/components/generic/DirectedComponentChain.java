package org.ml4j.nn.components.generic;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;

 /**
  * Encapsulates a sequential chain of ChainableDirectedComponents
  * 
  * @author Michael Lavelle
 *
 * @param <I> The type of input to the chain.
 * @param <L> THe type of each component within the chain.
 * @param <A> The type of activation of each component of the chain.
 * @param <B> The type of activation produced by this chain.
 */
public interface DirectedComponentChain<I, L extends ChainableDirectedComponent<I, ? extends A, ?>, A extends ChainableDirectedComponentActivation<I>, B extends DirectedComponentChainActivation<I, A>>
		extends DirectedComponent<I, B, DirectedComponentsContext>, ChainableDirectedComponent<I, B, DirectedComponentsContext>{

	public List<L> getComponents();
	
	@Override
	DirectedComponentChain<I, L, A, B> dup();
	
	
	
}
