package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DirectedAxonsComponentActivation extends ChainableDirectedComponentActivation<NeuronsActivation> {

	  public DirectedAxonsComponent<?, ?> getAxonsComponent();
	  
	  /**
	   * The total regularisation cost of these synapse.
	   * 
	   * @param synapsesContext The synapses context.
	   * @return The total regularisation cost.
	   */
	  float getTotalRegularisationCost();
	  
	  /**
	   * The average regularisation cost of these synapse.
	   * 
	   * @param synapsesContext The synapses context.
	   * @return The total regularisation cost.
	   */
	  double getAverageRegularisationCost();
}
