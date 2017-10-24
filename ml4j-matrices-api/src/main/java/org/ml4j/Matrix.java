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

package org.ml4j;

import java.io.Serializable;

/**
 * Interface for a Matrix.
 * 
 * @author Michael Lavelle
 */
public interface Matrix extends MatrixOperations<Matrix>, Serializable {

  /**
   * Obtain the number of rows of this matrix.
   * 
   * @return The number of rows of this matrix
   */
  int getRows();

  /**
   * Obtain the number of columns of this matrix.
   * 
   * @return The number of columns of this matrix
   */
  int getColumns();

  /**
   * Obtain data of this matrix returned as a flattened array.
   * 
   * @return The data of this matrix returned as a flattened array
   */
  double[] toArray();

  /**
   * Return the row of this Matrix identified by rowIndex.
   * 
   * @param rowIndex The index of the row to return
   * @return The row of this Matrix identified by rowIndex
   */
  Matrix getRow(int rowIndex);

  /**
   * Return the column of this Matrix identified by columnIndex.
   * 
   * @param columnIndex The index of the column to return
   * @return The row of this Matrix identified by columnIndex
   */
  Matrix getColumn(int columnIndex);

  /**
   * @return A Matrix formed from the sigmoid function applied to each element of this Matrix.
   */
  Matrix sigmoid();

  /**
   * A Matrix formed by multiplying this matrix by the other Matrix.
   * 
   * @param other The other Matrix
   * @return The result
   */
  Matrix mmul(Matrix other);

  /**
   * @return A clone of this Matrix.
   */
  Matrix dup();

  /**
   * Obtain the value in the Matrix at row and column specified.
   * 
   * @param row The row
   * @param column The column
   * @return The value in the Matrix at row and column specified
   */
  double get(int row, int column);

  /**
   * Append the other matrix to the right of this matrix horizontally
   * 
   * @param other The other matrix to append.
   * @return The appended Matrix
   */
  Matrix appendHorizontally(Matrix other);

  /**
   * Append the other matrix to the bottom of this matrix vertically.
   * 
   * @param other The other matrix to append.
   * @return The appended Matrix
   */
  Matrix appendVertically(Matrix other);

  /**
   * A Matrix formed by raising each element of this Matrix to the power value.
   * 
   * @param value The value
   * @return A Matrix formed by raising each element of this Matrix to the power value
   */
  Matrix pow(int value);

  /**
   * A Matrix formed by taking the log of each element of this Matrix.
   * 
   * @return A Matrix formed by taking the log of each element of this Matrix.
   */
  Matrix log();

  /**
   * Replace each element of this Matrix with exp(elementValue) in place.
   * 
   * @return This Matrix with each element of this Matrix replaced with exp(elementValue) in place.
   */
  Matrix expi();

  /**
   * Raise each element of this Matrix to the power value in place
   * 
   * @param value The value
   * @return this Matrix with each element replaced by the element to the power value in place.
   */
  Matrix powi(int value);

  /**
   * Replace each element of this Matrix with exp(elementValue) in place.
   * 
   * @return this Matrix with each element replaced by exp(elementValue) in place.
   */
  Matrix logi();

  /**
   * @return This Matrix as a JBlasMatrix.
   */
  Matrix asJBlasMatrix();

  /**
   * @return This Matrix as a CudaMatrix.
   */
  Matrix asCudaMatrix();
}
