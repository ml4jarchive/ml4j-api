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
 * Interface for a Matrix.
 * 
 * @author Michael Lavelle
 */
public interface Matrix extends Serializable {

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
}
