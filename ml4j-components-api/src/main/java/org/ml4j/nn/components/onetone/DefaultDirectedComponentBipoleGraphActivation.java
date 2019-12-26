package org.ml4j.nn.components.onetone;

import java.util.List;

public interface DefaultDirectedComponentBipoleGraphActivation extends DefaultChainableDirectedComponentActivation {

	@Override
	List<DefaultChainableDirectedComponentActivation> decompose();
	
}
