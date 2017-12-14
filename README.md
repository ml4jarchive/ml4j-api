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



