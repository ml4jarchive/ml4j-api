/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
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
