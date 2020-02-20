package org.ml4j.nn.components;

import org.ml4j.nn.neurons.NeuronsActivationContext;

public interface DirectedComponentActivationContext extends NeuronsActivationContext {

	DirectedComponentsContext getDirectedComponentsContext();
	
	void setDirectedComponentsContext(DirectedComponentsContext directedComponentsContext);
}
