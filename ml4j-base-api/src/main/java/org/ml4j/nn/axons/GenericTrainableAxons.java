package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.Neurons;

/**
 * Convenience interface for use in situations where the concrete type of Axons is unknown, or is not important.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of neurons on the LHS of the axons.
 * @param <R> The type of neuron on the RHS of the axons.
 */
public interface GenericTrainableAxons<L extends Neurons, R extends Neurons> extends TrainableAxons<L, R, GenericTrainableAxons<L, R>> {
}
