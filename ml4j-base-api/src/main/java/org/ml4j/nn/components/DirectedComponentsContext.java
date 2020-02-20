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
package org.ml4j.nn.components;

import java.io.Serializable;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.ml4j.MatrixFactory;

public interface DirectedComponentsContext extends Serializable {

	/**
	 * @param <C> The type of context we wish to obtain.
	 * @param component The component for which we wish to retrieve the context.
	 * @param defaultContextSupplier A supplier of a default context should there be no pre-existing context available.
	 * @param creator A creator of a new context, given a pre-existing context.
	 * @return The context for the component.
	 */
	<C extends Serializable> C getContext(ContextualNeuralComponent<C> component, Supplier<C> defaultContextSupplier, UnaryOperator<C> creator);

	/**
	 * @param <C> The type of context we wish to set.
	 * @param component The component whose context we wish to set.
	 * @param context The context we wish to set.
	 */
	<C extends Serializable> void setContext(ContextualNeuralComponent<C> component, C context);

	MatrixFactory getMatrixFactory();

	/**
	 * @return Whether this context is for training
	 */
	boolean isTrainingContext();
	
	/**
	 * @return This context as a training context.
	 */
	DirectedComponentsContext asTrainingContext();
	
	/**
	 * 
	 * @return This context as a non-training context.
	 */
	DirectedComponentsContext asNonTrainingContext();
}
