package org.ml4j.images;

public interface Images extends ImageContainer<Images> {

	int getExamples();
	
	Images getChannels(int channelRangeStart, int channelRangeEnd);

}
