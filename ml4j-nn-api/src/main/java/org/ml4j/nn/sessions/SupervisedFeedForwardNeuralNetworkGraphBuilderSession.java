package org.ml4j.nn.sessions;

import org.ml4j.nn.components.builders.componentsgraph.ComponentsGraphBuilder;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.supervised.SupervisedFeedForwardNeuralNetwork;

public interface SupervisedFeedForwardNeuralNetworkGraphBuilderSession extends 
	ComponentsGraphBuilder<SupervisedFeedForwardNeuralNetworkGraphBuilderSession, DefaultChainableDirectedComponent<?, ?>>{
	
	SupervisedFeedForwardNeuralNetwork build();
	
	SupervisedFeedForwardNeuralNetworkBuilderSession endComponentGraph();
}
