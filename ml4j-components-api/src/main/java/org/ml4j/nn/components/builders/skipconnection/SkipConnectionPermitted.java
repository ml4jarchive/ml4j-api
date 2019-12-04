package org.ml4j.nn.components.builders.skipconnection;

import org.ml4j.nn.components.builders.axons.AxonsBuilder;

public interface SkipConnectionPermitted<C extends AxonsBuilder> {

	C withSkipConnection();
}
