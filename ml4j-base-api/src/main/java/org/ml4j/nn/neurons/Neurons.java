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

/**
 * Represents a set of Neurons in a NeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public  class Neurons implements Serializable {

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
		return "Neurons [neuronCountExcludingBias=" + neuronCountExcludingBias + ", hasBiasUnit=" + hasBiasUnit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasBiasUnit ? 1231 : 1237);
		result = prime * result + neuronCountExcludingBias;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Neurons other = (Neurons) obj;
		if (hasBiasUnit != other.hasBiasUnit)
			return false;
		if (neuronCountExcludingBias != other.neuronCountExcludingBias)
			return false;
		return true;
	}
}
