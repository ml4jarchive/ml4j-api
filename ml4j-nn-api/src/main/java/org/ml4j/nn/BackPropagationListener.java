package org.ml4j.nn;

import java.io.Serializable;

public interface BackPropagationListener extends Serializable {

  /**
   * A listener for back propagations through the network.
   * 
   * @author Michael Lavelle
   */
  void onBackPropagation(BackPropagation forwardPropagation);
}
