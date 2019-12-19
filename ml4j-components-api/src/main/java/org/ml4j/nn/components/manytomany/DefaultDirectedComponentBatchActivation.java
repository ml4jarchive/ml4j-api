package org.ml4j.nn.components.manytomany;

import org.ml4j.nn.components.DirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponentBatchActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBatchActivation extends DirectedComponentBatchActivation<NeuronsActivation, DirectedComponentActivation<NeuronsActivation, NeuronsActivation>> {

	
}
