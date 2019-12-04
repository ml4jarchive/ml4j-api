package org.ml4j.nn.components;

import java.util.List;

public interface ChainableDirectedComponentActivation<I> extends DirectedComponentActivation<I, I> {

	public List<ChainableDirectedComponentActivation<I>> decompose();

}
