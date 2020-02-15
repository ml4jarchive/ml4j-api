package org.ml4j.nn.layers;

import java.util.List;

import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;

public interface LayersContainer<L extends DefaultChainableDirectedComponent<?, ?>> {

	List<L> getLayers();
}
