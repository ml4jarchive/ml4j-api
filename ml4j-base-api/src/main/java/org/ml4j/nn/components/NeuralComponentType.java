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

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class NeuralComponentType implements INeuralComponentType {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private final INeuralComponentType parentType;
	private final String id;
	private final boolean isStandardBaseType;
	private final boolean isCustomBaseType;

	public static NeuralComponentType createSubType(NeuralComponentType parentType,
													String id) {
		return new NeuralComponentType(parentType, id, false, false);
	}

	public static NeuralComponentType createSubType(NeuralComponentBaseType parentType,
													String id) {
		return new NeuralComponentType(parentType, id, false, false);
	}

	public static NeuralComponentType createCustomBaseType(String id) {
		if (Arrays.asList(NeuralComponentBaseType.values()).stream()
				.anyMatch(v -> v.getId().compareToIgnoreCase(id) == 0)) {
			throw new IllegalArgumentException("Name clash with existing standard base type:" + id);
		}
		return new NeuralComponentType(NeuralComponentBaseType.CUSTOM, id, false, true);
	}

	public static NeuralComponentType getBaseType(NeuralComponentBaseType baseType) {
		if (NeuralComponentBaseType.CUSTOM.equals(baseType)) {
			throw new IllegalArgumentException(
					"Use createCustomBaseType(String id) method to obtain a custom base type");
		}
		return baseType.asNeuralNetworkType();
	}

	NeuralComponentType(INeuralComponentType parentType, String id, boolean isStandardBaseType,
			boolean isCustomBaseType) {
		this.parentType = parentType;
		this.id = id;
		this.isStandardBaseType = isStandardBaseType;
		this.isCustomBaseType = isCustomBaseType;
		if (isStandardBaseType && isCustomBaseType) {
			throw new IllegalArgumentException("A type cannot be both a custom base type and a standard base type");
		}
	}

	@Override
	public NeuralComponentBaseType getBaseType() {
		return parentType.getBaseType();
	}

	@Override
	public INeuralComponentType getParentType() {
		return parentType;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getQualifiedId() {
		return isStandardBaseType ? getId()
				: (NeuralComponentBaseType.CUSTOM.equals(getParentType()) ? getId()
						: (getParentType().getQualifiedId() + "." + getId()));
	}

	@Override
	public boolean isStandardBaseType() {
		return isStandardBaseType;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return getQualifiedId();
	}


	@Override
	public boolean isCustomBaseType() {
		return isCustomBaseType;
	}
}
