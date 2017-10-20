package org.ml4j.nn;

import org.ml4j.nn.layers.DirectedLayerGradient;

import java.util.List;

public interface BackPropagation {

  List<DirectedLayerGradient> getDirectedLayerGradients();
}
