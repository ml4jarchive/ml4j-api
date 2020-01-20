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

public final class NeuralComponentType<T extends NeuralComponent> implements INeuralComponentType {

	private final INeuralComponentType parentType;
	private final String id;
	private final boolean isStandardBaseType;
	private final boolean isCustomBaseType;

	public static <S extends NeuralComponent> NeuralComponentType<S> createSubType(NeuralComponentType<?> parentType,
			String id) {
		return new NeuralComponentType<S>(parentType, id, false, false);
	}

	public static <S extends NeuralComponent> NeuralComponentType<S> createSubType(NeuralComponentBaseType parentType,
			String id) {
		return new NeuralComponentType<>(parentType, id, false, false);
	}

	public static NeuralComponentType<NeuralComponent> createCustomBaseType(String id) {
		if (Arrays.asList(NeuralComponentBaseType.values()).stream()
				.anyMatch(v -> v.getId().compareToIgnoreCase(id) == 0)) {
			throw new IllegalArgumentException("Name clash with existing standard base type:" + id);
		}
		return new NeuralComponentType<>(NeuralComponentBaseType.CUSTOM, id, false, true);
	}

	public static NeuralComponentType<NeuralComponent> getBaseType(NeuralComponentBaseType baseType) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getQualifiedId() == null) ? 0 : getQualifiedId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getQualifiedId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NeuralComponentType<?> other = (NeuralComponentType<?>) obj;
		if (getQualifiedId() == null) {
			if (other.getQualifiedId() != null)
				return false;
		} else if (!getQualifiedId().equals(other.getQualifiedId()))
			return false;
		return true;
	}

	@Override
	public boolean isCustomBaseType() {
		return isCustomBaseType;
	}
}
