package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.manytoone.PathCombinationStrategy;

/**
 * Visitor interface for DefaultChainableDirectedComponent.
 * 
 * @author Michael Lavelle
 */
public interface DefaultChainableDirectedComponentVisitor {

	/**
	 * Visit the specified component.
	 * 
	 * @param component The component to visit
	 * @return The name of the visited component.
	 */
	String visitComponent(DefaultChainableDirectedComponent<?, ?> component);
	
	/**
	 * Visit the specified chain of components.
	 * 
	 * @param componentChain The component chain to visit.
	 * @return The last-visited component name.
	 */
	String visitSequentialComponentChain(List<DefaultChainableDirectedComponent<?, ?>> componentChain);
	
	/**
	 * Visit the specified parallel batch of components.
	 * 
	 * @param name The name of the component that joins the output of the components together.
	 * @param componentBatch The batch of parallel components.
	 * @param pathCombinationStrategy The strategy to use to join the output of the components.
	 * @return The name of the component that joins the output of the components together.
	 */
	String visitParallelComponentBatch(String name, List<DefaultChainableDirectedComponent<?, ?>> componentBatch, PathCombinationStrategy pathCombinationStrategy);
}
