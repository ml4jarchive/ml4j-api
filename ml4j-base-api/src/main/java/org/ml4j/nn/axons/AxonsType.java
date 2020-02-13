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
package org.ml4j.nn.axons;

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * An instance of IAxonsType which is not one of the instances of AxonsBaseType.
 * 
 * @author Michael Lavelle
 */
public final class AxonsType implements IAxonsType {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private final IAxonsType parentType;
	private final String id;
	private final boolean isStandardBaseType;
	private final boolean isCustomBaseType;

	/**
	 * Create a sub-type of an AxonsType
	 * 
	 * @param parentType The parent type.
	 * @param id The id of the sub-type.
	 * @return The subtype.
	 */
	public static AxonsType createSubType(AxonsType parentType, String id) {
		return new AxonsType(parentType, id, false, false);
	}

	/**
	 * Create a sub-type of an AxonsType
     *
	 * @param parentType The parent type.
	 * @param id The id of the sub-type.
	 * @return The subtype.
	 */
	public static AxonsType createSubType(AxonsBaseType parentType, String id) {
		return new AxonsType(parentType, id, false, false);
	}

	/**
	 * Create a custom root-level base type - useful for representing base types before they are added to
	 * AxonsBaseType.
	 * 
	 * @param id The id of the type.
	 * @return A AxonsType instance that acts as a pseduo-AxonsBaseType.
	 */
	public static AxonsType createCustomBaseType(String id) {
		if (Arrays.asList(AxonsBaseType.values()).stream()
				.anyMatch(v -> v.getId().compareToIgnoreCase(id) == 0)) {
			throw new IllegalArgumentException("Name clash with existing standard base type:" + id);
		}
		return new AxonsType(AxonsBaseType.CUSTOM, id, false, true);
	}

	/**
	 * Get an AxonsType representation of an AxonsBaseType.
	 * 
	 * @param baseType The AxonsBaseType to represent as an AxonsType
	 * @return an AxonsType representation of an AxonsBaseType.
	 */
	public static AxonsType getBaseType(AxonsBaseType baseType) {
		if (AxonsBaseType.CUSTOM.equals(baseType)) {
			throw new IllegalArgumentException(
					"Use createCustomBaseType(String id) method to obtain a custom base type");
		}
		return baseType.asAxonsType();
	}

	AxonsType(IAxonsType parentType, String id, boolean isStandardBaseType,
			boolean isCustomBaseType) {
		this.parentType = parentType;
		this.id = id;
		this.isStandardBaseType = isStandardBaseType;
		this.isCustomBaseType = isCustomBaseType;
		if (isStandardBaseType) {
			if (!Arrays.asList(AxonsBaseType.values()).contains(parentType)) {
				throw new IllegalArgumentException("isStandardBaseType is set to true but parent type is not an AxonsBaseType");
			}
			if (!parentType.getId().equals(id)) {
				throw new IllegalArgumentException("Parent type id must match the specified id for standard base types");
			}
		}
		if (isStandardBaseType && isCustomBaseType) {
			throw new IllegalArgumentException("A type cannot be both a custom base type and a standard base type");
		}
	}

	@Override
	public AxonsBaseType getBaseType() {
		return parentType.getBaseType();
	}

	@Override
	public IAxonsType getParentType() {
		return parentType;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getQualifiedId() {
		if (isStandardBaseType) {
			return AxonsBaseType.class.getName() + "." + getId();
		} else {
			return AxonsBaseType.CUSTOM.equals(getParentType()) ? AxonsBaseType.class.getName() + "." + getId()
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
