package org.ml4j.nn.components.builders.skipconnection;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.componentsgraph.Components3DGraphBuilder;

public interface Components3DGraphSkipConnectionBuilder<P, Q> extends Components3DGraphBuilder<Components3DGraphSkipConnectionBuilder<P, Q>, ComponentsGraphSkipConnectionBuilder<Q>>, Axons3DBuilder {

	P endSkipConnection();
	
}
