package org.ml4j.nn.components.builders;

import org.ml4j.Matrix;
import org.ml4j.nn.components.builders.axons.UncompletedFullyConnectedAxonsBuilder;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.components.builders.synapses.SynapsesAxonsGraphBuilder;
import org.ml4j.nn.neurons.Neurons;

public interface BaseGraphBuilderState {

	ComponentsGraphNeurons<Neurons> getComponentsGraphNeurons();

	Matrix getConnectionWeights();
	Matrix getBiases();

	void setConnectionWeights(Matrix connectionWeights);
	void setBiases(Matrix biases);

	UncompletedFullyConnectedAxonsBuilder<?> getFullyConnectedAxonsBuilder();

	void setFullyConnectedAxonsBuilder(UncompletedFullyConnectedAxonsBuilder<?> object);

	void setSynapsesBuilder(SynapsesAxonsGraphBuilder<?> synapsesBuilder);
	
	SynapsesAxonsGraphBuilder<?> getSynapsesBuilder();

}
