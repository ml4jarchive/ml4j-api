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

/**
 * A Matrix factory.
 * 
 * @author Michael Lavelle
 *
 */
public interface MatrixFactory {

  /**
   * Create a new Matrix with every element value set to 1.
   * 
   * @param rows The number of rows of this Matrix
   * @param columns The number of columns of this Matrix
   * @return A new Matrix of size (rows, columns) with every element value set to 1
   */
  Matrix createOnes(int rows, int columns);

  /**
   * Create a new Matrix with every element value set to 0.
   * 
   * @param rows The number of rows of this Matrix
   * @param columns The number of columns of this Matrix
   * @return A new Matrix of size (rows, columns) with every element value set to 0
   */
  Matrix createZeros(int rows, int columns);

  /**
   * Create a new Matrix with every element value set to a normally distributed random number.
   * 
   * @param rows The number of rows of this Matrix
   * @param columns The number of columns of this Matrix
   * @return A new Matrix of size (rows, columns) with every element value set to a normally
   *         distributed random number
   */
  Matrix createRandn(int rows, int columns);

  /**
   * Create a new Matrix from the provided double array
   * 
   * @param data The values of this matrix, with the value for row r, column c equal to data[r][c].
   * @return A new Matrix of size (rows, columns) with the value for row r, column c equal to
   *         data[r][c].
   */
  Matrix createMatrix(double[][] data);
}
