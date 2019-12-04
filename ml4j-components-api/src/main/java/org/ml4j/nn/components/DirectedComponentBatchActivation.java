package org.ml4j.nn.components;

import java.util.List;

public interface DirectedComponentBatchActivation<I, A extends DirectedComponentActivation<I, I>>
		extends DirectedComponentActivation<List<I>, List<I>> {

	List<A> getActivations();
}
