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
 * A Matrix factory.
 * 
 * @author Michael Lavelle
 *
 */
public interface MatrixFactory extends Serializable {

  /**
   * Create a new Matrix with every element value set to 1.
   * 
   * @param rows The number of rows of this Matrix
   * @param columns The number of columns of this Matrix
   * @return A new Matrix of size (rows, columns) with every element value set to 1
   */
  Matrix createOnes(int rows, int columns);
  
  /**
   * Create a new column Matrix with every element value set to 1.
   * 
   * @param rows The number of rows of this column Matrix.
   * @return A new Matrix of size (rows, 1) with every element value set to 1
   */
  Matrix createOnes(int rows);

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
   * Create a new Matrix with every element value set to a normally distributed random number.
   * 
   * @param rows The number of rows of this Matrix
   * @param columns The number of columns of this Matrix
   * @return A new Matrix of size (rows, columns) with every element value set to a uniformly
   *         distributed random number
   */
  Matrix createRand(int rows, int columns);
  
  /**
   * Create a new Matrix from the provided double array
   * 
   * @param data The values of this matrix, with the value for row r, column c equal to data[r][c].
   * @return A new Matrix of size (rows, columns) with the value for row r, column c equal to
   *         data[r][c].
   */
  Matrix createMatrixFromRows(float[][] data);
 
  /**
   * Create a new uninitialised Matrix for the provided shape
   * 
   * @param rows The number of rows
   * @param cols The number of columns
   * @return A new Matrix of size (rows, columns).
   */
  Matrix createMatrix(int rows, int cols);

  /**
   * Create a new Matrix from the provided flattened double array
   * 
   * @param rows The number of rows
   * @param cols The number of columns
   * @param data The values of this matrix, with the value for row r, column c equal to data[r][c].
   * @return A new Matrix of size (rows, columns) with the value for row r, column c equal to
   *         data[r * cols + c].
   */
  Matrix createMatrixFromColumnsByColumnsArray(int rows, int cols, float[] data);
  
  /**
   * Create a new Matrix from the provided flattened double array
   * 
   * @param rows The number of rows
   * @param cols The number of columns
   * @param data The values of this matrix, with the value for row r, column c equal to data[r][c].
   * @return A new Matrix of size (rows, columns) with the value for row r, column c equal to
   *         data[r * cols + c].
   */
  Matrix createMatrixFromRowsByRowsArray(int rows, int cols, float[] data);
 
  /**
   * @return Create a new uninitialised Matrix.
   */
  Matrix createMatrix();

  /**
   * @param data The data.
   * @return Create a new uninitialised Matrix wrapping the data.
   */
  Matrix createMatrix(float[] data);
  
  /**
   * Return a new Matrix formed of a horizontal concatenation of matrix1, matrix2.
   * 
   * @param matrix1 The first Matrix
   * @param matrix2 The second Matrix
   * @return The horizontal concatenation
   */
  Matrix createHorizontalConcatenation(Matrix matrix1, Matrix matrix2);
  
  /**
   * Return a new Matrix formed of a vertical concatenation of matrix1, matrix2.
   * 
   * @param matrix1 The first Matrix
   * @param matrix2 The second Matrix
   * @return The vertical concatenation
   */
  Matrix createVerticalConcatenation(Matrix matrix1, Matrix matrix2);
}
