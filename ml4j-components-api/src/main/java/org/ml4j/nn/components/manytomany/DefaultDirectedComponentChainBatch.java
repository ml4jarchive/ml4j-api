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
package org.ml4j.nn.components.manytomany;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentChain;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Container for a batch of DefaultDirectedComponentChain instances that can be activated in parallel.
 * 
 * @author Michael Lavelle
 */
public interface DefaultDirectedComponentChainBatch extends
		ChainableDirectedComponent<List<NeuronsActivation>, DefaultDirectedComponentChainBatchActivation, DirectedComponentsContext> {

	@Override
	DefaultDirectedComponentChainBatch dup();

	/**
	 * @return A list of the parallel DefaultDirectedComponentChain instances within this batch.
	 */
	public List<DefaultDirectedComponentChain> getComponents();
}
