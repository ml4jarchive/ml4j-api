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

public enum AxonsBaseType implements IAxonsType {

	CUSTOM, FULLY_CONNECTED, CONVOLUTIONAL, MAX_POOLING, AVERAGE_POOLING,
	BATCH_NORM, SCALE_AND_SHIFT, PASS_THROUGH;
	
	@Override
	public IAxonsType getParentType() {
		return this;
	}
	
	@Override
	public String getId() {
		return name();
	}

	@Override
	public AxonsBaseType getBaseType() {
		return this;
	}

	/**
	 * @return this type represented as an AxonsType
	 */
	AxonsType asAxonsType() {
		return new AxonsType(this, getId(), isStandardBaseType(), isCustomBaseType());
	}

	@Override
	public String getQualifiedId() {
		return AxonsBaseType.class.getName() + "." + getId();
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
