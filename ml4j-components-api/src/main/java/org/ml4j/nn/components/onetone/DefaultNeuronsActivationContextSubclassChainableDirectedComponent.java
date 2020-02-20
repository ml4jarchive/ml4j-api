package org.ml4j.nn.components.onetone;

import java.util.HashMap;
import java.util.Map;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.neurons.NeuronsActivationContext;

public interface DefaultNeuronsActivationContextSubclassChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation, C extends NeuronsActivationContext> extends DefaultChainableDirectedComponent<A, C> {
	
	default <D> Map<String, D> getNestedContexts(DirectedComponentsContext directedComponentsContext, Class<D> contextClass) {
		Map<String, D> foundContexts = new HashMap<>();
		for (DefaultChainableDirectedComponent<?, ?> component : flatten()) {
			if (component != this) {
				Object context = component.getContext(directedComponentsContext);
				if (contextClass.isAssignableFrom(context.getClass())) {
					@SuppressWarnings("unchecked")
					D foundContext = (D)context;
					foundContexts.put(component.getName(), foundContext);
				}
			}
		}
		return foundContexts;
	}
}
