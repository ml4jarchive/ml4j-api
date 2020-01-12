package org.ml4j.nn.definitions;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentBaseType;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.builders.componentsgraph.Components3DGraphBuilder;
import org.ml4j.nn.components.builders.componentsgraph.InitialComponents3DGraphBuilder;
import org.ml4j.nn.neurons.Neurons3D;

public interface Component3Dto3DGraphDefinition extends NeuralComponent {

	@Override
	Neurons3D getInputNeurons();
	
	@Override
	Neurons3D getOutputNeurons();

	public <T extends NeuralComponent> Components3DGraphBuilder<?, ?, T> createComponentGraph(
			InitialComponents3DGraphBuilder<T> start);

	@Override
	default NeuralComponentType getComponentType() {
		return NeuralComponentType.getBaseType(NeuralComponentBaseType.DEFINITION);
	}

}
