package org.ml4j.nn.components.axons;

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedAxonsComponent<L extends Neurons, R extends Neurons> extends ChainableDirectedComponent<NeuronsActivation, DirectedAxonsComponentActivation, AxonsContext> {

	 Axons<? extends L, ? extends R, ?> getAxons();
}
