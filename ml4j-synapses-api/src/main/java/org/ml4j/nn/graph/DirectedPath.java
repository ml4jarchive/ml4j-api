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

package org.ml4j.nn.graph;

import java.util.List;

/**
 * Data structure consisting of a path of edges of type E between two points in the Network.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of edge in this path.
 */
public interface DirectedPath<E> {

  List<E> getEdges();
  
  void addEdge(E edge);
  
}
