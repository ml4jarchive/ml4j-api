package org.ml4j.nn.components;

import java.util.List;

public interface DirectedComponentBatch<I, L extends DirectedComponent<I, A ,C> , Y extends DirectedComponentBatchActivation<I, A>, A extends DirectedComponentActivation<I, I>, C, C2>
		extends DirectedComponent<List<I>, Y, C2> {

	public List<L> getComponents();
}
