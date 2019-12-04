package org.ml4j.nn.components.builders.skipconnection;

import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphBuilder;

public interface ComponentsGraphSkipConnectionBuilder<P> extends ComponentsGraphBuilder<ComponentsGraphSkipConnectionBuilder<P>>  {

	P endSkipConnection();
	
}
