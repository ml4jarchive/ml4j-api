package org.ml4j.nn.sessions;

import java.util.List;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.factories.NeuralComponentFactory;

public interface NeuralNetworkBuilderSession<T extends NeuralComponent> {

	NeuralComponentFactory<T> getNeuralComponentFactory();
	
	NeuralNetworkBuilder<T> withComponents(List<T> components);

	
	/*
	SupervisedFeedForwardNeuralNetworkFactory getSupervisedFeedForwardNeuralNetworkFactory();

	NeuralNetworkBuilder<T> startWith3DNeurons(Neurons3D neurons);

	NeuralNetworkBuilder<T> startWithNeurons(Neurons neurons);
	


	/*
	default NeuralNetworkBuilder<T> startWith(Component3DtoNon3DGraphDefinition definition) {
		return definition.createComponentGraph(this);
	}

	default NeuralNetworkBuilder<T> startWith(Component3Dto3DGraphDefinition definition) {
		return definition.createComponentGraph(this);
	}
	*/
}
