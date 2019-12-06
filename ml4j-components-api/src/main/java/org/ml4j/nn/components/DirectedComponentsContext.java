package org.ml4j.nn.components;

import java.io.Serializable;
import java.util.function.Supplier;

import org.ml4j.MatrixFactory;

public interface DirectedComponentsContext {

	/**
	 * @param synapsesIndex
	 *            The index of the synapses within this DirectedLayer.
	 * @return The context we use to propagate data through the directed synapses of
	 *         this Layer.
	 */
	<C extends Serializable> C getContext(DirectedComponent<?, ?, C> component, Supplier<C> defaultContextSupplier);
	
	<C extends Serializable> void setContext(DirectedComponent<?, ?, C> component, C context);

	MatrixFactory getMatrixFactory();
	
	/**
	 * @return Whether this context is for training
	 */
	boolean isTrainingContext();
}
