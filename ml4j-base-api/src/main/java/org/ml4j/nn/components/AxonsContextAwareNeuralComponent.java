package org.ml4j.nn.components;

import org.ml4j.nn.axons.AxonsContext;
import org.ml4j.nn.components.DirectedComponentsContext;

public interface AxonsContextAwareNeuralComponent extends NeuralComponent {

	AxonsContext getContext(DirectedComponentsContext directedComponentsContext, int componentIndex);

}
