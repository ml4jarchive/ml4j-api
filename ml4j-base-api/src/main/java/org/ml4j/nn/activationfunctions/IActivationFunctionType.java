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

interface IActivationFunctionType extends Serializable {

	ActivationFunctionBaseType getBaseType();

	IActivationFunctionType getParentType();

	String getId();

	String getQualifiedId();

	static IActivationFunctionType customType(ActivationFunctionType parentType, String id) {
		return new ActivationFunctionType(parentType, id, false, false);
	}

	static ActivationFunctionType baseType(ActivationFunctionBaseType baseType) {
		return baseType.asActivationFunctionType();
	}

	boolean isStandardBaseType();

	boolean isCustomBaseType();

}
