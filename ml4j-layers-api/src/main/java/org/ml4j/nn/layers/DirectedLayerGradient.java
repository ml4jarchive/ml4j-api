package org.ml4j.nn.layers;

import org.ml4j.nn.synapses.DirectedSynapsesGradient;

import java.util.List;

public interface DirectedLayerGradient {

  public List<DirectedSynapsesGradient> getSynapsesGradients();
}
