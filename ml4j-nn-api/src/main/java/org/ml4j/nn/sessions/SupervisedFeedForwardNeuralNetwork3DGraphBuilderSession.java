package org.ml4j.nn.sessions;

import org.ml4j.nn.components.builders.componentsgraph.Components3DGraphBuilder;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.supervised.SupervisedFeedForwardNeuralNetwork;

public interface SupervisedFeedForwardNeuralNetwork3DGraphBuilderSession extends 
	Components3DGraphBuilder<SupervisedFeedForwardNeuralNetwork3DGraphBuilderSession, SupervisedFeedForwardNeuralNetworkGraphBuilderSession, DefaultChainableDirectedComponent<?, ?>>{
	
	SupervisedFeedForwardNeuralNetwork build();
	
	SupervisedFeedForwardNeuralNetwork3DBuilderSession endComponentGraph();
}
