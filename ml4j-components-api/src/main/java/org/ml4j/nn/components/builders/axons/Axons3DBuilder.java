package org.ml4j.nn.components.builders.axons;

import org.ml4j.nn.components.builders.Base3DGraphBuilderState;
import org.ml4j.nn.components.builders.common.ComponentsContainer;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.neurons.Neurons3D;

public interface Axons3DBuilder extends ComponentsContainer<Neurons3D> {
	
	ComponentsGraphNeurons<Neurons3D> getComponentsGraphNeurons();
	Base3DGraphBuilderState getBuilderState();

}
