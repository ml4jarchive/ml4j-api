package org.ml4j.nn.components;

import java.io.Serializable;

public interface ContextualNeuralComponent<C extends Serializable> extends Serializable  {

	String getName();
}
