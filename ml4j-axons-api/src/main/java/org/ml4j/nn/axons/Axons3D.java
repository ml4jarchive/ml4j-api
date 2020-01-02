package org.ml4j.nn.axons;

import org.ml4j.nn.neurons.Neurons3D;

public interface Axons3D<A extends Axons3D<A>> extends Axons<Neurons3D, Neurons3D, A> {

	Axons3DConfig getConfig();
}
