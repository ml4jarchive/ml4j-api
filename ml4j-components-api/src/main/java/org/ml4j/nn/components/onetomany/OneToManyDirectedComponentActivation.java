package org.ml4j.nn.components.onetomany;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the activation from a OneToManyDirectedComponent.
 * 
 * @author Michael Lavelle
 */
public interface OneToManyDirectedComponentActivation extends DirectedComponentActivation<NeuronsActivation, List<NeuronsActivation>> {

}
