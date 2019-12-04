package org.ml4j.nn.components.builders.skipconnection;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;

public interface SkipConnection3DPermitted<C extends Axons3DBuilder> {

	C withSkipConnection();
}
