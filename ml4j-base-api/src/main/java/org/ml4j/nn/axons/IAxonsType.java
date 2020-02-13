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

import java.io.Serializable;

/**
 * Base interface for identifiers of axons type - allows both enums (AxonsBaseType) and subclasses (AxonsType) to 
 * implement the same interface.
 * 
 * @author Michael Lavelle
 */
interface IAxonsType extends Serializable {

	/**
	 * @return All axons type descend from one of the instances of AxonsBaseType - this method returns the root AxonsBaseType for
	 * this axons type.   If this axons type itself represents a standard base type, this method returns this.
	 */
	AxonsBaseType getBaseType();

	/**
	 * @return The direct parent of this axons type - if this axons type is itself a root level type,  this method returns this
	 */
	IAxonsType getParentType();

	/**
	 * @return The leaf-level id of this axons type.
	 */
	String getId();

	/**
	 * @return The fully qualified id of this axons type.
	 */
	String getQualifiedId();

	/**
	 * @return Whether this type represents one of the standard base types specified by AxonsBaseType.
	 */
	boolean isStandardBaseType();

	/**
	 * @return Whether this type represents a custom base type - eg. a type that is requested to be added to AxonsBaseType.
	 */
	boolean isCustomBaseType();

}
