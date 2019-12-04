package org.ml4j.nn.components.builders;

import org.ml4j.Matrix;
import org.ml4j.nn.components.builders.axons.UncompletedBatchNormAxonsBuilder;
import org.ml4j.nn.components.builders.axons.UncompletedConvolutionalAxonsBuilder;
import org.ml4j.nn.components.builders.axons.UncompletedFullyConnectedAxonsBuilder;
import org.ml4j.nn.components.builders.axons.UncompletedPoolingAxonsBuilder;
import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphNeurons;
import org.ml4j.nn.components.builders.synapses.SynapsesAxons3DGraphBuilder;
import org.ml4j.nn.neurons.Neurons3D;

public interface Base3DGraphBuilderState {
	
	ComponentsGraphNeurons<Neurons3D> getComponentsGraphNeurons();

	Matrix getConnectionWeights();

	void setConnectionWeights(Matrix connectionWeights);

	UncompletedConvolutionalAxonsBuilder<?> getConvolutionalAxonsBuilder();

	void setConvolutionalAxonsBuilder(UncompletedConvolutionalAxonsBuilder<?> object);

	UncompletedPoolingAxonsBuilder<?> getMaxPoolingAxonsBuilder();

	void setMaxPoolingAxonsBuilder(UncompletedPoolingAxonsBuilder<?> maxPoolingAxonsBuilder);

	void setFullyConnectedAxonsBuilder(UncompletedFullyConnectedAxonsBuilder<?> axonsBuilder);
	
	UncompletedFullyConnectedAxonsBuilder<?> getFullyConnectedAxonsBuilder();

	void setSynapsesBuilder(SynapsesAxons3DGraphBuilder<?, ?> synapsesBuilder);
	
	SynapsesAxons3DGraphBuilder<?, ?> getSynapsesBuilder();

	BaseGraphBuilderState getNon3DBuilderState();

	void setAveragePoolingAxonsBuilder(UncompletedPoolingAxonsBuilder<?> axonsBuilder);
	
	UncompletedPoolingAxonsBuilder<?> getAveragePoolingAxonsBuilder();

	void setBatchNormAxonsBuilder(UncompletedBatchNormAxonsBuilder<?> axonsBuilder);

	UncompletedBatchNormAxonsBuilder<?> getBatchNormAxonsBuilder();

	void setBiases(Matrix biases);
	
	Matrix getBiases();

}
