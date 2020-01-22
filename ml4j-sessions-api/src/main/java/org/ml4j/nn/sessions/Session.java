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
package org.ml4j.nn.sessions;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.factories.NeuralComponentFactory;

/**
 * Session interface for the creation of Neural Component graphs.
 * 
 * @author Michael Lavelle
 *
 * @param <T> The type of NeuralComponent within the session.
 */
public interface Session<T extends NeuralComponent> {

	NeuralComponentFactory<T> getNeuralComponentFactory();

	ComponentGraphBuilderSession<T> buildComponentGraph();

	DirectedComponentsContext getDirectedComponentsContext();
	
	MatrixFactory getMatrixFactory();
}
