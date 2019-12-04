package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;

public interface Axons3DGraphSkipConnectionBuilder<P, Q> extends Axons3DGraphBuilder<Axons3DGraphSkipConnectionBuilder<P, Q>, AxonsGraphSkipConnectionBuilder<Q>>, Axons3DBuilder {

	P endSkipConnection();
}
