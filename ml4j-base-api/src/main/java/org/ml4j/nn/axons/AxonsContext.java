/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 * Defines the context for activations travelling through Axons.
 * 
 * @author Michael Lavelle
 *
 */
public interface AxonsContext extends NeuronsActivationContext {

	/**
	 * @return The keep probability for input dropout on the left hand side of an
	 *         Axons instance.
	 */
	float getLeftHandInputDropoutKeepProbability();

	/**
	 * @return Whether these Axons are frozen out for training.
	 */
	boolean isWithFreezeOut();

	/**
	 * @param withFreezeOut Whether these Axons are frozen out for training.
	 * @return the axons context
	 */
	AxonsContext withFreezeOut(boolean withFreezeOut);

	/**
	 * @param inputDropoutKeepProbability The keep probability for input dropout on
	 *                                    the left hand side of an Axons instance.
	 * @return the axons context
	 */
	AxonsContext withLeftHandInputDropoutKeepProbability(float inputDropoutKeepProbability);

	/**
	 * @param regularisationLamdba The regularisation lambda to use with the primary
	 *                             axons of a DirectedLayer.
	 * @return the axons context
	 */
	AxonsContext withRegularisationLambda(float regularisationLamdba);

	/**
	 * @return The regularisation lambda to use with the primary axons of a
	 *         DirectedLayer.
	 */
	float getRegularisationLambda();

}
