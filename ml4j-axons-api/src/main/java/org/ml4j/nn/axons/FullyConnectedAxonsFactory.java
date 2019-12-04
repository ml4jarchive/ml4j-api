package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;

public interface FullyConnectedAxonsFactory extends Serializable {

	FullyConnectedAxons createFullyConnectedAxons(Neurons leftNeurons, Neurons rightNeurons, Matrix connectionWeights, Matrix biases);
}
