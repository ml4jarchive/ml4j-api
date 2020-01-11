package org.ml4j.nn.definitions;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphBuilder;
import org.ml4j.nn.components.builders.componentsgraph.InitialComponents3DGraphBuilder;
import org.ml4j.nn.neurons.Neurons3D;

public interface Component3DtoNon3DGraphDefinition extends NeuralComponent {

	@Override
	Neurons3D getInputNeurons();

	public <T extends NeuralComponent> ComponentsGraphBuilder<?, T> createComponentGraph(
			InitialComponents3DGraphBuilder<T> start);

	@Override
	default NeuralComponentType getComponentType() {
		return NeuralComponentType.DEFINITION;
	}

}
