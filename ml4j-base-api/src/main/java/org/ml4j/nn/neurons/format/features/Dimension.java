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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a named Dimension.
 * 
 * @author Michael Lavelle
 */
public class Dimension {
	
	private final static String HEIGHT_ID = "H";
	private final static String WIDTH_ID = "W";
	private final static String DEPTH_ID = "D";
	private final static String CHANNEL_ID = "C";
	private final static String EXAMPLE_ID = "E";
	private final static String SAMPLE_ID = "S";
	private final static String BATCH_ID = "B";
	private final static String INSTANCE_ID = "I";
	private final static String FEATURE_ID = "F";
	private final static String FILTER_HEIGHT_ID = "FH";
	private final static String FILTER_WIDTH_ID = "FW";
	private final static String FILTER_POSITION_ID = "FP";
	
	public final static Dimension HEIGHT = new Dimension(HEIGHT_ID, "Height");
	public final static Dimension WIDTH = new Dimension(WIDTH_ID, "Width");
	public final static Dimension DEPTH = new Dimension(DEPTH_ID, "Depth");
	public final static Dimension CHANNEL = new Dimension(CHANNEL_ID, "Channel", DEPTH);
	public final static Dimension EXAMPLE = new Dimension(EXAMPLE_ID, "Example");
	public final static Dimension SAMPLE = new Dimension(SAMPLE_ID, "Example", EXAMPLE);
	public final static Dimension BATCH = new Dimension(BATCH_ID, "Batch", EXAMPLE, SAMPLE);
	public final static Dimension INSTANCE = new Dimension(INSTANCE_ID, "Instance", EXAMPLE, SAMPLE, BATCH);
	public final static Dimension FEATURE = new Dimension(FEATURE_ID, "Feature", EXAMPLE, SAMPLE, BATCH);
	public final static Dimension FILTER_HEIGHT = new Dimension(FILTER_HEIGHT_ID, "Filter Height");
	public final static Dimension FILTER_WIDTH = new Dimension(FILTER_WIDTH_ID, "Filter Width");
	public final static Dimension FILTER_POSITIONS = new Dimension(FILTER_POSITION_ID, "Filter Positions");
	
	private String id;
	private String name;
	private Set<Dimension> aliases;
	
	public Dimension(String id, String name, Dimension... aliases) {
		this.id = id;
		this.name = name;
		this.aliases = new HashSet<>(Arrays.asList(aliases));
		this.aliases.forEach(d -> d.aliases.add(this));
	}
	
	public Set<Dimension> getAliases() {
		Set<Dimension> aliasDimensions = new HashSet<>();
		aliasDimensions.addAll(aliases.stream().flatMap(a -> a.aliases.stream()).collect(Collectors.toSet()));
		aliasDimensions.addAll(aliases);
		return aliasDimensions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
	

	@Override
	public String toString() {
		return "Dimension [id=" + id + ", name=" + name + "]";
	}

}
