package org.ml4j.nn.activationfunctions;

/**
 * 
 * Encapsulates the activations from an activation through a DifferentiableActivationFunctionComponent,
 * and the logic required in order to back propagate gradients back through the activations.
 * 
 * 
 * @author Michael Lavelle
 */
public interface DifferentiableActivationFunctionActivation extends
    ActivationFunctionActivation<DifferentiableActivationFunction, 
    DifferentiableActivationFunctionActivation> {


}
