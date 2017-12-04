/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j;

import java.io.Serializable;

/**
 * Base interface for common operations between different matrix provider implementations.
 * 
 * @author Michael Lavelle
 *
 * @param <M> The type of MatrixOperations.
 */
public interface MatrixOperations<M extends MatrixOperations<M>> extends Serializable {

  M transpose();

  M add(M matrices);

  M add(double value);

  M addi(M matrices);
  
  M addi(double value);

  M sub(M matrices);

  M subi(M matrixOperations);

  M mul(double value);

  M mul(M matrix);

  M muli(M matrix);

  M muli(double value);

  M divi(double value);
  
  M divi(M other);

  M mmul(M matrix);

  M mmul(M matrix, M result);

  double[][] toArray2();

  double[] toArray();

  double dot(M matrices);

  M copy(M matrices);

  int[] rowArgmaxs();

  void putColumn(int columnIndex, M columnMatrix);

  void putRow(int rowIndex, M rowMatrix);

  int getLength();

  M rowSums();

  void put(int index, double value);

  void put(int rowIndex, int columnIndex, double value);
  
  void put(int[] indicies, int inputInd, M matrixOperations);

  M getRowRange(int offset, int iv, int jv);

  void reshape(int rows, int cols);

  M diviColumnVector(M matrixOperations);

  double sum();

  int getRows();
  
  M getRows(int[] rowInds);

  int getColumns();
  
  M getColumns(int[] colInds);

  M dup();

  M getRow(int row);

  int[] findIndices();

  M div(double value);
  
  M div(M other);
  
  M getColumn(int columnIndex);

  double get(int index);
  
  double get(int rowIndex, int columnIndex);
  
  M get(int[] rows, int[] cols);

  int argmax();
}
