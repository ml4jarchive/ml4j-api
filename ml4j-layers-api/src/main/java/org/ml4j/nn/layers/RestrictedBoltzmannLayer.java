package org.ml4j.nn.layers;

import org.ml4j.nn.axons.Axons;

public interface RestrictedBoltzmannLayer<A extends Axons<?, ?, ?>, L extends 
    RestrictedBoltzmannLayer<A, L>> 
    extends UndirectedLayer<A, RestrictedBoltzmannLayer<A, L>> {

}
