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

	void setSynapsesBuilder(SynapsesAxonsGraphBuilder<?, ?> synapsesBuilder);

	SynapsesAxonsGraphBuilder<?, ?> getSynapsesBuilder();

}
