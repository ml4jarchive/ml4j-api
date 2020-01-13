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

import java.util.List;

import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;
import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.NeuralComponent;
import org.ml4j.nn.components.NeuralComponentType;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.components.onetone.DefaultDirectedComponentBipoleGraph;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * DirectedSynapses are containers for Axons with a DifferentiableActivationFunction applied
 * to the right hand Axons output on a push of data left-to-right during forward propagation.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left of these DirectedSynapses.
 * @param <R> The type of Neurons on the right of these DirectedSynapses.
 */
public interface DirectedSynapses<L extends Neurons, R extends Neurons>
    extends Synapses<DirectedSynapses<L, R>>, DefaultChainableDirectedComponent<DirectedSynapsesActivation, DirectedComponentsContext>, NeuralComponent {

  /**
   * @return The DifferentiableActivationFunction applied
   *     to the right hand Axons output on a push of data left-to-right.
   */
  DifferentiableActivationFunction getActivationFunction();
  
  /**
   * @return The Axons graph within these DirectedSynapses.
   */
  DefaultDirectedComponentBipoleGraph getAxonsGraph();
  
  /**
   * @return The Neurons on the left hand side of these DirectedSynapses.
   */
  L getLeftNeurons();
  
  /**
   * @return The Neurons on the right hand side of these DirectedSynapses.
   */
  R getRightNeurons();
  
  /**
   * Forward Propagates the activations through the Synapses via the Axons and 
   * DifferentiableActivationFunction.
   * 
   * @param input The input to the DirectedSynapses
   * @param synapsesContext The context within which we forward propagate the activations
   * @return A DirectedSynapsesActivation encapsulating the artifacts generated by this forward 
   *        propagation  - including the NeuronsActivation output from the right hand side of these 
   *        DirectedSynapses.
   */
  DirectedSynapsesActivation forwardPropagate(NeuronsActivation input,
      DirectedComponentsContext synapsesContext);

  
  List<DefaultChainableDirectedComponent<?, ?>> decompose();

  @Override
  NeuralComponentType<DirectedSynapses<L, R>> getComponentType();
  
 
 
}
