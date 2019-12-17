package org.ml4j.nn.components.axons;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DefaultChainableDirectedComponent;
import org.ml4j.nn.neurons.Neurons;

public interface DirectedAxonsComponent<L extends Neurons, R extends Neurons> extends DefaultChainableDirectedComponent<DirectedAxonsComponentActivation, AxonsContext> {

	 Axons<? extends L, ? extends R, ?> getAxons();
	 
	  @Override
	  DirectedAxonsComponent<L, R> dup();
}
