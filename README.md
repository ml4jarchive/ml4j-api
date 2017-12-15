# ml4j-api


## Neural Networks
 

A **[NeuralNetwork](https://github.com/ml4j/ml4j-api/blob/master/ml4j-nn-api/src/main/java/org/ml4j/nn/NeuralNetwork.java)** consists of groups of **[Neurons](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/neurons/Neurons.java)** -    connected via **[Synapses](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/synapses/Synapses.java)**, and organised into **[Layers](https://github.com/ml4j/ml4j-api/blob/master/ml4j-layers-api/src/main/java/org/ml4j/nn/layers/Layer.java)**.

```

Neural Network:

Layer1:										Layer2			

Neurons <-> Synapses <-> Neurons <-> Synapses <-> Neurons <->	Neurons <->	Neurons <->....

```

Data flows through the network via **[NeuronsActivation](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/neurons/NeuronsActivation.java)** instances - these instances pass through the Synapses and activate each group of Neurons in turn.


Inside the Synapses there are **[Axons](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/axons/Axons.java)** ( determining the "connections" between the Neurons on either side of the Synapses ), 
and **[ActivationFunctions](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/activationfunctions/ActivationFunction.java)** ( which modify the activations as they exit the Axons )


```
Synapses:						

	ActivationFunction <-> Axons <-> Activation Function
```
Each Layer includes at least one Axons instance ( the *primary Axons* for that Layer, and after which the Layer is named), 
but may also include other Axons if it is a more complex Layer.

Some Axons have fixed connection weights...but other Axons are **[TrainableAxons](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/axons/TrainableAxons.java)** and have connection weights we want to learn.

The aim of training a NeuralNetwork is **optimise the connection weights for all the TrainableAxons** so that the NeuralNetwork
generates some desired output data ( encoded as NeuronsActivation instances), eg., in response to some given input NeuronsActivation.


## Directed Neural Networks

A **[DirectedNeuralNetwork](https://github.com/ml4j/ml4j-api/blob/master/ml4j-nn-api/src/main/java/org/ml4j/nn/DirectedNeuralNetwork.java)** is a subclass of NeuralNetwork in which there is a natural direction for the flow of activations, from left to right.

The Layers within a DirectedNeuralNetwork are **[DirectedLayers](https://github.com/ml4j/ml4j-api/blob/master/ml4j-layers-api/src/main/java/org/ml4j/nn/layers/DirectedLayer.java)**, within which Neurons are connected via **[DirectedSynapses](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/synapses/DirectedSynapses.java)**.
```
DirectedNeuralNetwork:

DirectedLayer1:													

Neurons -> DirectedSynapses -> Neurons -> DirectedSynapses ->	 

```

	
DirectedSynapses contain Axons followed by a specific type of ActivationFunction - a **[DifferentiableActivationFunction](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/activationfunctions/DifferentiableActivationFunction.java)** to the right hand side of the Axons.
```

DirectedSynapses:						

Axons -> DifferentiableActivationFunction

```

DirectedLayers and DirectedSynapses each know how to "forward propagate" the activations of the Neurons on their left hand side to to Neurons on their right hand side.

As NeuronsActivation instances propagate through this DirectedNeuralNetwork, the activations of each of these components are collected into
 "forward propagation" chain.

eg.
```

NeuronsActivation -> AxonsActivation-> DifferentiableActivationFunctionActivation -> NeuronsActivation -> .....

```

The activations within each Synapses instance are grouped together into a DirectedSynapseActivation, and these DirectedSynapseActivations are themselves further grouped into DirectedLayerActivations.

Our **[ForwardPropagation](https://github.com/ml4j/ml4j-api/blob/master/ml4j-nn-api/src/main/java/org/ml4j/nn/ForwardPropagation.java)** now contains a chain of **[DirectedLayerActivations](https://github.com/ml4j/ml4j-api/blob/master/ml4j-layers-api/src/main/java/org/ml4j/nn/layers/DirectedLayerActivation.java)**,  each containing a chain of **[DirectedSynapseActivations](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/synapses/DirectedSynapsesActivation.java)**, each of which contain an **[AxonsActivation](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/axons/AxonsActivation.java)** and **[DifferentiableActivationFunctionActivation](https://github.com/ml4j/ml4j-api/blob/master/ml4j-synapses-api/src/main/java/org/ml4j/nn/activationfunctions/DifferentiableActivationFunctionActivation.java)**

```	
ForwardPropagation:

DirectedLayerActivation1 -> DirectedLayerActivation2 -> ...

```


