package org.ml4j.nn.components;

import org.ml4j.nn.neurons.Neurons;

public interface NeuralComponent  {

	NeuralComponentType getComponentType();

	Neurons getInputNeurons();
	
}
