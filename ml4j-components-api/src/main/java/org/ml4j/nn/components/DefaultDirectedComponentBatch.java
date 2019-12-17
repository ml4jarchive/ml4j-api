package org.ml4j.nn.components;

import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultDirectedComponentBatch<C, C2> extends DirectedComponentBatch<NeuronsActivation, DirectedComponent<NeuronsActivation, DirectedComponentActivation<NeuronsActivation, NeuronsActivation>, C>, DefaultDirectedComponentBatchActivation, DirectedComponentActivation<NeuronsActivation, NeuronsActivation>, C, C2> {

}
