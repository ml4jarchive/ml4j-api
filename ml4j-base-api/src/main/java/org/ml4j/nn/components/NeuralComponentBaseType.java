/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.components;

public enum NeuralComponentBaseType implements INeuralComponentType {

	COMPONENT_CHAIN, COMPONENT_BATCH, COMPONENT_BIPOLE_GRAPH, COMPONENT_CHAIN_BATCH, COMPONENT_CHAIN_BIPOLE_GRAPH,
	AXONS, AXONS_CHAIN, AXONS_GRAPH, SYNAPSES, SYNAPSES_CHAIN, SYNAPSES_GRAPH, LAYER, LAYER_CHAIN, NETWORK,
	ACTIVATION_FUNCTION, ONE_TO_MANY, MANY_TO_ONE, DEFINITION, CUSTOM;

	@Override
	public INeuralComponentType getParentType() {
		return this;
	}

	@Override
	public String getId() {
		return name();
	}

	@Override
	public NeuralComponentBaseType getBaseType() {
		return this;
	}

	NeuralComponentType asNeuralNetworkType() {
		return new NeuralComponentType(this, getId(), isStandardBaseType(), isCustomBaseType());
	}

	@Override
	public String getQualifiedId() {
		return getId();
	}

	@Override
	public boolean isStandardBaseType() {
		return true;
	}

	@Override
	public boolean isCustomBaseType() {
		return false;
	}
}
