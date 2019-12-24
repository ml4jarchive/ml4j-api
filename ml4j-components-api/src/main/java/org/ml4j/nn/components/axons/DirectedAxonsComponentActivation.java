package org.ml4j.nn.components.axons;

import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponentActivation;

public interface DirectedAxonsComponentActivation extends DefaultChainableDirectedComponentActivation {

	  public DirectedAxonsComponent<?, ?, ?> getAxonsComponent();
	  
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
