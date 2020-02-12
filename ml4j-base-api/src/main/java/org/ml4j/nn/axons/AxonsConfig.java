/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.axons;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.Neurons;


/**
 * Base class for configurations for Axons.
 *
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the LHS of the axons.
 * @param <R> The type of Neurons on the RHS of the axons.
 */
public class AxonsConfig<L extends Neurons, R extends Neurons> implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	protected L leftNeurons;
	protected R rightNeurons;
	
	public AxonsConfig(L leftNeurons, R rightNeurons) {
		this.leftNeurons = leftNeurons;
		this.rightNeurons = rightNeurons;
	}
	
	public L getLeftNeurons() {
		return leftNeurons;
	}

	public R getRightNeurons() {
		return rightNeurons;
	}

	AxonsConfig<L, R> dup() {
		return new AxonsConfig<>(leftNeurons, rightNeurons);
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
