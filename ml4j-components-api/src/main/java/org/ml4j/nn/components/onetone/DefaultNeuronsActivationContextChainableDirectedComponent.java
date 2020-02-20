package org.ml4j.nn.components.onetone;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.NeuronsActivationContext;

public interface DefaultNeuronsActivationContextChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation>
		extends DefaultChainableDirectedComponent<A, NeuronsActivationContext> {

	default void reconcileContexts(NeuronsActivationContext componentSpecificContext,
			DirectedComponentsContext directedComponentsContext) {
		//if (!componentSpecificContext.isTrainingContextStatusConsistentWith(directedComponentsContext)) {
			//componentSpecificContext.setTrainingContext(directedComponentsContext.isTrainingContext());
		//	throw new IllegalStateException(
		//			"Conflict between contexts - context of type " + componentSpecificContext.getClass().getSimpleName()
						//	+ " and DirectedComponentsContext disagree on isTrainingContext status");
		//}
	}

}
