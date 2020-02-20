package org.ml4j.nn.components.onetone;

import org.ml4j.nn.components.DirectedComponentsContext;

public interface DefaultPassThroughContextChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation> extends DefaultChainableDirectedComponent<A, DirectedComponentsContext> {

	default void reconcileContexts(DirectedComponentsContext componentSpecificContext, DirectedComponentsContext directedComponentsContext) {
		// No-op, for components whose componentSpecificContext is the root DirectedComponentsContext.
	}
}
