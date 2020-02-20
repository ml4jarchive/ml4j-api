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
package org.ml4j.nn.components.onetone;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.components.ContextualNeuralComponent;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.NeuralComponentVisitor;
import org.ml4j.nn.components.NeuronsActivationComponent;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * A default chainable component within a DirectedNeuralNetwork where an input
 * NeuronsActivation flows in a left-to-right direction through forward
 * propagation.
 * 
 * Error information in the form of a gradient NeuronsActivation is then flowed
 * right-to-left through the resulting DirectedComponentActivation instances via
 * back propagation.
 * 
 * DefaultChainableDirectedComponent instances can be composed together in a
 * sequential chain, as the type of input and output are both single
 * NeuronsActivation instances.
 * 
 * @author Michael Lavelle
 *
 * @param <A> The type of activation produced by the
 *            DefaultChainableDirectedComponent on forward propagation
 * @param <C> The context provided to the DefaultChainableDirectedComponent on
 *            forward propagation.
 */
public interface DefaultChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation, C extends Serializable>
		extends ChainableDirectedComponent<NeuronsActivation, A, C, DirectedComponentFactory>, ContextualNeuralComponent<C>, NeuronsActivationComponent, DefaultNeuralComponent {

	/**
	 * @param directedComponentFactory The directedComponentFactory used to duplicate nested components.
	 * @return A deep copy of this component.
	 */
	@Override
	DefaultChainableDirectedComponent<A, C> dup(DirectedComponentFactory directedComponentFactory);

	/**
	 * @return Decompose this component into a list of the smallest atomic
	 *         ChainableDirectedComponents that can be chained together to form this
	 *         component.
	 */
	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();

	/**
	 * @return The neurons on the LHS of this component to which input data
	 *         activations are applied.
	 */
	Neurons getInputNeurons();

	/**
	 * @return The neurons on the RHS of this component from which output data
	 *         activations are generated.
	 */
	Neurons getOutputNeurons();
	
	/**
	 * @return An assigned name for the component.
	 */
	String getName();

	@Override
	NeuralComponentType getComponentType();
	
	/**
	 * @return Flatten this component into the set of all the components forming it's
	 * component graph (including itself).  This is unordered and will consist of
	 * both parent and child components in the graph,  unlike the decompose() method.
	 */
	Set<DefaultChainableDirectedComponent<?, ?>> flatten();

	/**
	 * A convenience filter on the flatten method which returns all nested components
	 * matching the provided component class, and will exclude this component, although
	 * other nested parent and child components will still be included.
	 */
	
	
	
	/**
	 * A convenience filter on the flatten method which returns all nested
	 * components matching the provided component class, and will exclude this
	 * component, although other nested parent and child components will still be
	 * included.
	 * 
	 * @param <L>            The type of class of the nested components to be
	 *                       retrieved.
	 * @param componentClass The class of the nested components to be retrieved.
	 * @return A set of all nested components matching the provided component class
	 *         and excluding this component
	 */
	default <L> Set<L> getNestedComponents(Class<L> componentClass) {
		Set<L> foundComponents = new HashSet<>();
		for (DefaultChainableDirectedComponent<?, ?> component : flatten()) {
			if (component != this && componentClass.isAssignableFrom(component.getClass())) {
				@SuppressWarnings("unchecked")
				L foundComponent = (L)component;
				foundComponents.add(foundComponent);
			}
		}
		return foundComponents;
	}
	
	/**
	 * Retrieve all the nested contexts of the specified type used by this component, keyed by component name.
	 * 
	 * @param <D> The type of class of the contexts to be retrieved.
	 * @param directedComponentsContext The DirectedComponentsContext containing the contexts.
	 * @param contextClass The class of context to be retrieved.
	 * @return A map of nested contexts of the specified type used by this component, keyed by component name.
	 */
	default <D> Map<String, D> getNestedContexts(DirectedComponentsContext directedComponentsContext, Class<D> contextClass) {
		Map<String, D> foundContexts = new HashMap<>();
		for (DefaultChainableDirectedComponent<?, ?> component : flatten()) {
			if (component != this) {
				Object context = component.getContext(directedComponentsContext);
				if (contextClass.isAssignableFrom(context.getClass())) {
					@SuppressWarnings("unchecked")
					D foundContext = (D)context;
					foundContexts.put(component.getName(), foundContext);
					
				}
	
			}
		}
		return foundContexts;
	}
	
	@Override
	String accept(NeuralComponentVisitor<DefaultChainableDirectedComponent<?, ?>> visitor);
	
	/**
	 * Forward Propagates the activations through component.
	 * 
	 * @param input   The input to the DirectedComponent
	 * @param context The context within which we forward propagate the activations
	 * @return A DirectedComponentActivation encapsulating the artifacts generated
	 *         by this forward propagation - including the output from the right
	 *         hand side of this DirectedComponent.
	 */
	A forwardPropagate(NeuronsActivation input, DirectedComponentsContext context);
	
	/**
	 * Forward Propagates the activations through the component
	 * 
	 * @param inputs   A stream of inputs to the DirectedComponent.
	 * @param context The context within which we forward propagate the activations
	 * @return A stream of activations encapsulating the artifacts generated
	 *         by this forward propagation - including the output from the right
	 *         hand side of this DirectedComponent.
	 */
	default Stream<A> forwardPropagate(Stream<NeuronsActivation> inputs, DirectedComponentsContext context) {
		return inputs.map(n -> forwardPropagate(n, context));
	}
}
