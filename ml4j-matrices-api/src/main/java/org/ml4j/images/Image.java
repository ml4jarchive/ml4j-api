package org.ml4j.images;

public interface Image extends ImageContainer<Image> {
	
	Image getChannels(int channelRangeStart, int channelRangeEnd);

}
