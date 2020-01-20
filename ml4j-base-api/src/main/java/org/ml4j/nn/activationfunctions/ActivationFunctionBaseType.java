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
package org.ml4j.nn.activationfunctions;

public enum ActivationFunctionBaseType implements IActivationFunctionType {

	CUSTOM, LINEAR, RELU, SIGMOID, SOFTMAX;

	@Override
	public IActivationFunctionType getParentType() {
		return this;
	}

	@Override
	public String getId() {
		return name();
	}

	@Override
	public ActivationFunctionBaseType getBaseType() {
		return this;
	}

	ActivationFunctionType asNeuralNetworkType() {
		return new ActivationFunctionType(this, getId(), isStandardBaseType(), isCustomBaseType());
	}

	@Override
	public String getQualifiedId() {
		return getId();
	}

	@Override
	public boolean isStandardBaseType() {
		return true;
	}

	@Override
	public boolean isCustomBaseType() {
		return false;
	}
}
