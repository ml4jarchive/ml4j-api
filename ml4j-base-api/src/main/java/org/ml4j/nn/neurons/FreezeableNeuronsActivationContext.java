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
package org.ml4j.nn.neurons;

public interface FreezeableNeuronsActivationContext<C extends NeuronsActivationContext> extends NeuronsActivationContext {

	/**
	 * @return Whether these Axons are frozen out for training.
	 */
	boolean isWithFreezeOut();

	/**
	 * @param withFreezeOut Whether these Axons are frozen out for training.
	 * @return the axons context
	 */
	C withFreezeOut(boolean withFreezeOut);
	
	/**
	 * @return The name of the component with which this context is associated.
	 */
	String getOwningComponentName();
	
	/**
	 * Allows a FreezeableNeuronsActivationContext to add itself as an override to the freezeout of this context.
	 * 
	 * @param freezeoutOverrideContext The context that wishes to override the freezeout of this context.
	 */
	void addFreezeoutOverrideContext(FreezeableNeuronsActivationContext<?> freezeoutOverrideContext);
	
	/**
	 * Allows a FreezeableNeuronsActivationContext to remove itself as an override to the freezeout of this context.
	 * 
	 * @param freezeoutOverrideContext The context that wishes to override the freezeout of this context.
	 */
	void removeFreezeoutOverrideContext(FreezeableNeuronsActivationContext<?> freezeoutOverrideContext);

}
