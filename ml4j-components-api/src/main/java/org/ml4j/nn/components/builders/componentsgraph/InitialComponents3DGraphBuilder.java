package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.DefaultDirectedComponentChain;

public interface InitialComponents3DGraphBuilder extends Components3DGraphBuilder<InitialComponents3DGraphBuilder, InitialComponentsGraphBuilder> {

	DefaultDirectedComponentChain getComponentChain();
}
