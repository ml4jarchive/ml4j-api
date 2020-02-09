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

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class ActivationFunctionType implements IActivationFunctionType {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private final IActivationFunctionType parentType;
	private final String id;
	private final boolean isStandardBaseType;
	private final boolean isCustomBaseType;

	public static ActivationFunctionType createSubType(ActivationFunctionType parentType, String id) {
		return new ActivationFunctionType(parentType, id, false, false);
	}

	public static ActivationFunctionType createSubType(ActivationFunctionBaseType parentType, String id) {
		return new ActivationFunctionType(parentType, id, false, false);
	}

	public static ActivationFunctionType createCustomBaseType(String id) {
		if (Arrays.asList(ActivationFunctionBaseType.values()).stream()
				.anyMatch(v -> v.getId().compareToIgnoreCase(id) == 0)) {
			throw new IllegalArgumentException("Name clash with existing standard base type:" + id);
		}
		return new ActivationFunctionType(ActivationFunctionBaseType.CUSTOM, id, false, true);
	}

	public static ActivationFunctionType getBaseType(ActivationFunctionBaseType baseType) {
		if (ActivationFunctionBaseType.CUSTOM.equals(baseType)) {
			throw new IllegalArgumentException(
					"Use createCustomBaseType(String id) method to obtain a custom base type");
		}
		return baseType.asActivationFunctionType();
	}

	ActivationFunctionType(IActivationFunctionType parentType, String id, boolean isStandardBaseType,
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
	public ActivationFunctionBaseType getBaseType() {
		return parentType.getBaseType();
	}

	@Override
	public IActivationFunctionType getParentType() {
		return parentType;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getQualifiedId() {
		if (isStandardBaseType) {
			return ActivationFunctionBaseType.class.getName() + "." + getId();
		} else {
			return ActivationFunctionBaseType.CUSTOM.equals(getParentType()) ? ActivationFunctionBaseType.class.getName() + "." + getId()
					: (getParentType().getQualifiedId() + "." + getId());
		}
	}

	@Override
	public boolean isStandardBaseType() {
		return isStandardBaseType;
	}

	@Override
	public String toString() {
		return getQualifiedId();
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
	public boolean isCustomBaseType() {
		return isCustomBaseType;
	}
}
