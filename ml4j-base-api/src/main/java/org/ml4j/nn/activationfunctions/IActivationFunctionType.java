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

/**
 * Base interface for identifiers of activation function type - allows both enums (ActivationFunctionBaseType) 
 * and subclasses (ActivationFunctionType) to implement the same interface.
 * 
 * @author Michael Lavelle
 */
interface IActivationFunctionType extends Serializable {

	/**
	 * @return All activation function types descend from one of the instances of ActivationFunctionBaseType - this method returns 
	 * the root ActivationFunctionBaseType for this activation function type.   
	 * If this activation function type itself represents a standard base type, this method returns this.
	 */
	ActivationFunctionBaseType getBaseType();

	/**
	 * @return The direct parent of this activation function type - if this activation function type is itself a root level type,  
	 * this method returns this
	 */
	IActivationFunctionType getParentType();

	/**
	 * @return The leaf-level id of this activation function type.
	 */
	String getId();

	/**
	 * @return The fully qualified id of this activation function type.
	 */
	String getQualifiedId();

	/**
	 * @return Whether this type represents one of the standard base types specified by ActivationFunctionBaseType.
	 */
	boolean isStandardBaseType();

	/**
	 * @return Whether this type represents a custom base type - eg. a type that is requested to be added to ActivationFunctionBaseTypes.
	 */
	boolean isCustomBaseType();

}
