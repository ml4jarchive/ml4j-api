package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.onetone.DefaultDirectedComponentChain;

public interface InitialComponentsGraphBuilder extends ComponentsGraphBuilder<InitialComponentsGraphBuilder> {

	DefaultDirectedComponentChain getComponentChain();
	
}
