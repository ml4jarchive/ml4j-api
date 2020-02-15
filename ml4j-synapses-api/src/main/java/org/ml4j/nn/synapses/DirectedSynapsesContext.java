/*
 * Copyright 2017 the original author or authors.
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

package org.ml4j.nn.synapses;

import org.ml4j.nn.axons.AxonsContext;

/**
 * Defines the context for activations travelling through DirectedSynapses.
 * 
 * @author Michael Lavelle
 *
 */
public interface DirectedSynapsesContext extends SynapsesContext {
	
	/**
	 * Get the AxonsContext, given identifiers which specify the location of
	 * the Axons within the Synapses
	 * 
	 * @param pathIndex        The index of the path of Axons in these Synapses.
	 * @param axonsIndexInPath The index of the Axons within the path.
	 * @return The AxonsContext
	 */
	AxonsContext getAxonsContext(int pathIndex, int axonsIndexInPath);
}
