package org.ml4j.nn.sessions;

import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.supervised.SupervisedFeedForwardNeuralNetwork;

public interface NeuralNetworkBuilder<T extends NeuralComponent> {
	
	SupervisedFeedForwardNeuralNetwork build();

}
