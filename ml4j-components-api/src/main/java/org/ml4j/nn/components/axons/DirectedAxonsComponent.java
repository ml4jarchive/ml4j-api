package org.ml4j.nn.components.axons;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.Neurons;

public interface DirectedAxonsComponent<L extends Neurons, R extends Neurons, A extends Axons<?, ?, ?>> extends DefaultChainableDirectedComponent<DirectedAxonsComponentActivation, AxonsContext> {

	 A getAxons();
	 
	  @Override
	  DirectedAxonsComponent<L, R, A> dup();
}
