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
package org.ml4j.nn.activationfunctions;

import java.io.Serializable;
import java.util.Optional;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * Container for properties for common activation functions.
 * 
 * @author Michael Lavelle
 */
public class ActivationFunctionProperties implements Serializable {
		
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	public static final float DEFAULT_ALPHA = 0.01f;
	
	private Float alpha;

	public Optional<Float> getAlpha() {
		if (alpha == null) {
			return Optional.of(DEFAULT_ALPHA);
		} else {
			return Optional.ofNullable(alpha);
		}
	}

	public ActivationFunctionProperties withAlpha(float alpha) {
		this.alpha = alpha;
		return this;
	}

	@Override
	public String toString() {
		return "ActivationFunctionProperties [alpha=" + alpha + "]";
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
