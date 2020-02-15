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
 * Base builder for non-3d subclasses of AxonsConfig.
 * 
 * @author Michael Lavelle
 *
 */
public abstract class AxonsConfigBuilderBase<C extends AxonsConfig<?, ?>, T extends AxonsConfigBuilderBase<C, T>> implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	protected Neurons leftNeurons;
	protected Neurons rightNeurons;

	public AxonsConfigBuilderBase() {
	}
	
	public boolean isFullyPopulated() {
			return leftNeurons != null && rightNeurons != null;
	}
	
	public AxonsConfigBuilderBase(Neurons leftNeurons) {
		this();
		if (leftNeurons == null) {
			throw new IllegalArgumentException("Left neurons cannot be null for this constructor");
		}
		this.leftNeurons = leftNeurons;
	}
	
	protected abstract C createDefaultConfig(Neurons leftNeurons, Neurons rightNeurons);
	
	protected abstract T getInstance();

	public T withInputNeurons(Neurons neurons) {

		if (leftNeurons == null) {
			this.leftNeurons = neurons;
		} else {
			if (!leftNeurons.equals(neurons)) {
				throw new IllegalArgumentException(
						"Inconsistency been the passed in input neurons and those already set");
			}
		}

		return getInstance();
	}

	public abstract C build();

	public T withOutputNeurons(Neurons rightNeurons) {
		if (rightNeurons == null) {
			throw new IllegalArgumentException("Output neurons cannot be set to null");
		}
		this.rightNeurons = rightNeurons;
		return getInstance();
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
