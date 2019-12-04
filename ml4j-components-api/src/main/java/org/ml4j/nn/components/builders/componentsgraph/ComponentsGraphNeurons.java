package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.neurons.Neurons;

public interface ComponentsGraphNeurons<N extends Neurons> {
	
	N getCurrentNeurons();
	void setCurrentNeurons(N currentNeurons);
	
	N getRightNeurons();
	void setRightNeurons(N rightNeurons);
	
	boolean hasBiasUnit();
	
	void setHasBiasUnit(boolean biasUnit);
}
