package org.ml4j.nn.definitions;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentBaseType;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.builders.componentsgraph.InitialComponents3DGraphBuilder;
import org.ml4j.nn.components.builders.componentsgraph.InitialComponentsGraphBuilder;
import org.ml4j.nn.components.factories.NeuralComponentFactory;
import org.ml4j.nn.neurons.Neurons3D;
import org.ml4j.nn.sessions.Session;

public interface Component3DtoNon3DGraphDefinition extends NeuralComponent {

	@Override
	Neurons3D getInputNeurons();

	<T extends NeuralComponent> InitialComponentsGraphBuilder<T> createComponentGraph(
			InitialComponents3DGraphBuilder<T> start, NeuralComponentFactory<T> neuralComponentFactory);
	
	default <T extends NeuralComponent> InitialComponentsGraphBuilder<T> createComponentGraph(
			Session<T> session) {
		return createComponentGraph(session.startWith3DNeurons(getInputNeurons()), session.getNeuralComponentFactory());
	}

	@Override
	default NeuralComponentType<?> getComponentType() {
		return NeuralComponentType.getBaseType(NeuralComponentBaseType.DEFINITION);
	}

}
