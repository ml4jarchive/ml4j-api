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
package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponentActivation;

/**
 * Interface encapsulating an activation from a DirectedAxonsComponent
 * 
 * @author Michael Lavelle
 *
 */
public interface DirectedAxonsComponentActivation extends DefaultChainableDirectedComponentActivation {

	/**
	 * @return The DirectedAxonsComponent from which this activation originated.
	 */
	DirectedAxonsComponent<?, ?, ?> getAxonsComponent();

	/**
	 * The total regularisation cost of this DirectedAxonsComponent.
	 * 
	 * @return The total regularisation cost.
	 */
	float getTotalRegularisationCost();

	/**
	 * The average regularisation cost of this DirectedAxonsComponent.
	 * 
	 * @return The average regularisation cost.
	 */
	double getAverageRegularisationCost();
}
