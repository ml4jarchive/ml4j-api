/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ml4j.nn;

import org.ml4j.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the total and average costs and gradients associated with a forward propagation
 * through a FeedForwardNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public class CostAndGradients {

  private double totalCost;
  
  private List<Matrix> totalTrainableAxonsGradients;
  
  private int numberOfTrainingExamples;

  /**
   * @param totalCost The totalCost.
   * @param totalTrainableAxonsGradients The totalGradients.
   * @param numberOfTrainingExamples The number of training examples.
   */
  public CostAndGradients(double totalCost, 
      List<Matrix> totalTrainableAxonsGradients, int numberOfTrainingExamples) {
    super();
    this.totalCost = totalCost;
    this.totalTrainableAxonsGradients = totalTrainableAxonsGradients;
    this.numberOfTrainingExamples = numberOfTrainingExamples;
  }

  public double getTotalCost() {
    return totalCost;
  }
  
  public double getAverageCost() {
    return getTotalCost() / numberOfTrainingExamples;
  }

  public List<Matrix> getTotalTrainableAxonsGradients() {
    return totalTrainableAxonsGradients;
  }
  
  /**
   * @return The average gradients.
   */
  public List<Matrix> getAverageTrainableAxonsGradients() {

    List<Matrix> averages = new ArrayList<>();
    for (Matrix total : getTotalTrainableAxonsGradients()) {
      averages.add(total.div(numberOfTrainingExamples));
    }
    return averages;
  }
}
