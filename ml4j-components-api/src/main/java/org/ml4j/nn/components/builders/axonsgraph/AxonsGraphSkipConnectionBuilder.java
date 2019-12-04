package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.AxonsBuilder;

public interface AxonsGraphSkipConnectionBuilder<P> extends AxonsGraphBuilder<AxonsGraphSkipConnectionBuilder<P>>, AxonsBuilder {

	P endSkipConnection();
}
