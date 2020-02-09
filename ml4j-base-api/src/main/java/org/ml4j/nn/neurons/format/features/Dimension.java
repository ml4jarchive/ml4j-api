/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.neurons.format.features;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Represents a named Dimension.
 * 
 * @author Michael Lavelle
 */
public class Dimension implements Serializable {
	
	
	
	/**
	 * Default serialization id
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String HEIGHT_ID = "H";
	private static final String INPUT_HEIGHT_ID = "IH";
	private static final String OUTPUT_HEIGHT_ID = "OH";
	private static final String WIDTH_ID = "W";
	private static final String INPUT_WIDTH_ID = "IW";
	private static final String OUTPUT_WIDTH_ID = "OW";
	private static final String DEPTH_ID = "D";
	private static final String INPUT_DEPTH_ID = "ID";
	private static final String OUTPUT_DEPTH_ID = "OD";
	private static final String CHANNEL_ID = "C";
	private static final String EXAMPLE_ID = "E";
	private static final String SAMPLE_ID = "S";
	private static final String BATCH_ID = "B";
	private static final String INSTANCE_ID = "I";
	private static final String FEATURE_ID = "F";
	private static final String INPUT_FEATURE_ID = "IF";
	private static final String OUTPUT_FEATURE_ID = "OF";
	private static final String FILTER_HEIGHT_ID = "FH";
	private static final String FILTER_WIDTH_ID = "FW";
	private static final String FILTER_POSITION_ID = "FP";
	
	public static final Dimension HEIGHT = new Dimension(HEIGHT_ID, "Height", DimensionScope.ANY);
	public static final Dimension WIDTH = new Dimension(WIDTH_ID, "Width", DimensionScope.ANY);
	public static final Dimension DEPTH = new Dimension(DEPTH_ID, "Depth", DimensionScope.ANY);
	public static final Dimension INPUT_HEIGHT = new Dimension(INPUT_HEIGHT_ID, "InputHeight", DimensionScope.INPUT, HEIGHT);
	public static final Dimension INPUT_WIDTH = new Dimension(INPUT_WIDTH_ID, "InputWidth", DimensionScope.INPUT, WIDTH);
	public static final Dimension INPUT_DEPTH = new Dimension(INPUT_DEPTH_ID, "InputDepth", DimensionScope.INPUT, DEPTH);
	public static final Dimension OUTPUT_HEIGHT = new Dimension(OUTPUT_HEIGHT_ID, "OutputHeight", DimensionScope.OUTPUT, HEIGHT);
	public static final Dimension OUTPUT_WIDTH = new Dimension(OUTPUT_WIDTH_ID, "OutputWidth", DimensionScope.OUTPUT, WIDTH);
	public static final Dimension OUTPUT_DEPTH = new Dimension(OUTPUT_DEPTH_ID, "OutputDepth", DimensionScope.OUTPUT, DEPTH);
	public static final Dimension CHANNEL = new Dimension(CHANNEL_ID, "Channel", DimensionScope.ANY, DEPTH);
	public static final Dimension EXAMPLE = new Dimension(EXAMPLE_ID, "Example", DimensionScope.ANY);
	public static final Dimension SAMPLE = new Dimension(SAMPLE_ID, "Example", DimensionScope.ANY, EXAMPLE);
	public static final Dimension BATCH = new Dimension(BATCH_ID, "Batch", DimensionScope.ANY, EXAMPLE, SAMPLE);
	public static final Dimension INSTANCE = new Dimension(INSTANCE_ID, "Instance", DimensionScope.ANY, EXAMPLE, SAMPLE, BATCH);
	public static final Dimension FEATURE = new Dimension(FEATURE_ID, "Feature", DimensionScope.ANY, EXAMPLE, SAMPLE, BATCH);
	public static final Dimension INPUT_FEATURE = new Dimension(INPUT_FEATURE_ID, "InputFeature", DimensionScope.INPUT, FEATURE);
	public static final Dimension OUTPUT_FEATURE = new Dimension(OUTPUT_FEATURE_ID, "OutputFeature", DimensionScope.OUTPUT, FEATURE);
	public static final Dimension FILTER_HEIGHT = new Dimension(FILTER_HEIGHT_ID, "Filter Height", DimensionScope.ANY);
	public static final Dimension FILTER_WIDTH = new Dimension(FILTER_WIDTH_ID, "Filter Width", DimensionScope.ANY);
	public static final Dimension FILTER_POSITIONS = new Dimension(FILTER_POSITION_ID, "Filter Positions", DimensionScope.ANY,
			new CompositeDimension(Arrays.asList(OUTPUT_HEIGHT, OUTPUT_WIDTH), DimensionScope.OUTPUT));
	
	private String id;
	private String name;
	private Set<Dimension> aliases;
	private DimensionScope scope;
	
	public Dimension(String id, String name, DimensionScope scope, Dimension... aliases) {
		this.id = id;
		this.name = name;
		this.scope = scope;
		this.aliases = new HashSet<>(Arrays.asList(aliases));
		this.aliases.forEach(d -> d.aliases.add(this));
	}
	
	public Set<Dimension> getAliases(DimensionScope scope) {
		Set<Dimension> allAliases = getAliases(this, new HashSet<>());
		if (scope == DimensionScope.ANY || this.scope.isValidWithin(scope)) {
			allAliases = allAliases.stream().filter(a -> a.scope == this.scope || a.scope == DimensionScope.ANY || a.scope == scope).collect(Collectors.toSet());
		} else {
			allAliases = allAliases.stream().filter(a -> a.scope == this.scope).collect(Collectors.toSet());
		}
		allAliases.remove(this);
		return allAliases;
	}
	
	public boolean isEquivalent(Dimension other, DimensionScope dimensionScope) {
		return isEquivalent(this.decompose(), other.decompose(), dimensionScope);
	}
	
	public static boolean isEquivalent(List<Dimension> decomposedFirst, List<Dimension> decomposedSecond, DimensionScope dimensionScope) {
		
		if (decomposedFirst.isEmpty() && decomposedSecond.isEmpty()) {
			return true;
		} else if (decomposedFirst.isEmpty() || decomposedSecond.isEmpty()) {
			return false;
		} else {
			Dimension first = decomposedFirst.get(0);
			Dimension second = decomposedSecond.get(0);
			List<Dimension> remainingFirstAfterMatch = new ArrayList<>();
			List<Dimension> remainingSecondAfterMatch = new ArrayList<>();

			boolean firstMatchesSecond = false;
			if (first.equals(second) && first.scope.isValidWithin(dimensionScope) && second.scope.isValidWithin(dimensionScope)
					&& first.scope.equals(second.scope)) {
				firstMatchesSecond = true;
				remainingFirstAfterMatch = new ArrayList<>();
				remainingFirstAfterMatch.addAll(decomposedFirst);
				remainingFirstAfterMatch.remove(0);
				remainingSecondAfterMatch = new ArrayList<>();
				remainingSecondAfterMatch.addAll(decomposedSecond);
				remainingSecondAfterMatch.remove(0);
			} else {
				// Consider the aliases
				Set<List<Dimension>> firstDecomposedAliases = first.getAllDecomposedAliases(dimensionScope);
				firstDecomposedAliases.add(Arrays.asList(first));
				Set<List<Dimension>> secondDecomposedAliases = second.getAllDecomposedAliases(dimensionScope);
				secondDecomposedAliases.add(Arrays.asList(second));

				for (List<Dimension> firstDecomposedAlias : firstDecomposedAliases) {
					for (List<Dimension> secondDecomposedAlias : secondDecomposedAliases) {
						if (firstDecomposedAlias.isEmpty() || secondDecomposedAlias.isEmpty()) {
							return false;
						}

						if (firstMatchesSecond || (firstDecomposedAlias.get(0).equals(secondDecomposedAlias.get(0)))) {
							if (!firstMatchesSecond) {
								remainingFirstAfterMatch = new ArrayList<>();
								remainingFirstAfterMatch.addAll(firstDecomposedAlias);
								remainingFirstAfterMatch.remove(0);
								remainingFirstAfterMatch.addAll(decomposedFirst.subList(1, decomposedFirst.size()));
								remainingSecondAfterMatch = new ArrayList<>();
								remainingSecondAfterMatch.addAll(secondDecomposedAlias);
								remainingSecondAfterMatch.remove(0);
								remainingSecondAfterMatch.addAll(decomposedSecond.subList(1, decomposedSecond.size()));
							} 
							firstMatchesSecond = true;
						}
					}
				}
			}
		
			if (!firstMatchesSecond) {
				return false;
			} else {
				return isEquivalent(remainingFirstAfterMatch, remainingSecondAfterMatch, dimensionScope);
			}
		}
	}
	
	public Set<List<Dimension>> getAllDecomposedAliases(DimensionScope dimensionScope) {
		Set<List<Dimension>> allDecomposedAliases = new HashSet<>();
		allDecomposedAliases.add(decompose().stream().collect(Collectors.toList()));
		allDecomposedAliases.addAll(getAliases(dimensionScope).stream().map(a -> a.decompose().stream().collect(Collectors.toList())).collect(Collectors.toSet()));
		return allDecomposedAliases.stream().filter(a -> a.stream().allMatch(d -> d.scope.isValidWithin(dimensionScope))).collect(Collectors.toSet());
	}
	
	
	private Set<Dimension> getAliases(Dimension dimension, Set<Dimension> visited) {
		if (visited.isEmpty()) {
			visited = new HashSet<>(Arrays.asList(this));
		}
		for (Dimension alias : dimension.aliases) {
			if (!visited.contains(alias)) {
				visited.add(alias);
				getAliases(alias, visited);
			}
		}
		return visited;
	}
	
	public List<Dimension> decompose() {
		return Arrays.asList(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
	
	@Override
	public String toString() {
		return "Dimension [id=" + id + ", name=" + name + ", scope=" + scope + "]";
	}

	public static class CompositeDimension extends Dimension {

		/**
		 * Default serilization id.
		 */
		private static final long serialVersionUID = 1L;
		private List<Dimension> components;
		
		public CompositeDimension(List<Dimension> components, DimensionScope dimensionScope, Dimension... aliases) {
			super(getCompositeString(components.stream().map(Dimension::getId).collect(Collectors.toList())),
					getCompositeString(components.stream().map(Dimension::getName).collect(Collectors.toList())), dimensionScope, aliases);
			components.forEach(d -> {
				if (!d.scope.isValidWithin(dimensionScope)) {
					throw new IllegalArgumentException("Dimension:" + d + " is not valid for scope:" + dimensionScope);
				}
			});
			this.components = components;
		}
		
		@Override
		public List<Dimension> decompose() {
			return components.stream().flatMap(c -> c.decompose().stream()).collect(Collectors.toList());
		}
		
		private static String getCompositeString(List<String> strings) {
			StringBuilder composite = new StringBuilder();
			Iterator<String> it = strings.iterator();
			while (it.hasNext()) {
				composite.append(it.next());
				if (it.hasNext()) {
					composite.append(", ");
				}
			}
			return composite.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj);
		}

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this);
		}
		
	}

}
