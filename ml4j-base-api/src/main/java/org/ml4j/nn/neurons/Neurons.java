/*
 * Copyright 2017 the original author or authors.
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

package org.ml4j.nn.neurons;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Represents a set of Neurons in a NeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public class Neurons implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The number of neurons excluding any bias unit.
	 */
	private int neuronCountExcludingBias;

	/**
	 * Whether this set of Neurons has an additional bias unit.
	 */
	protected boolean hasBiasUnit;

	/**
	 * Construct a new set of Neurons.
	 * 
	 * @param neuronCountExcludingBias The number of neurons excluding any bias unit
	 * @param hasBiasUnit              Whether this set of Neurons has an additional
	 *                                 bias unit
	 */
	public Neurons(int neuronCountExcludingBias, boolean hasBiasUnit) {
		this.neuronCountExcludingBias = neuronCountExcludingBias;
		this.hasBiasUnit = hasBiasUnit;
	}

	/**
	 * Determine whether this set of Neurons has an additional bias unit.
	 * 
	 * @return Whether this set of Neurons has an additional bias unit
	 */
	public boolean hasBiasUnit() {
		return hasBiasUnit;
	}

	/**
	 * @return The number of neurons including any bias unit.
	 */
	public int getNeuronCountIncludingBias() {
		return neuronCountExcludingBias + (hasBiasUnit() ? 1 : 0);
	}

	/**
	 * @return The number of neurons excluding any bias unit.
	 */
	public int getNeuronCountExcludingBias() {
		return neuronCountExcludingBias;
	}

	@Override
	public String toString() {
		   return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
