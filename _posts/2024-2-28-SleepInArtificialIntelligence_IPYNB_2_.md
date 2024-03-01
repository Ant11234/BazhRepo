---
toc: True
comments: True
layout: post
title: Sleep In Artificial Intelligence
description: A look into my recent project with UCSD doing research about the effects of sleep on AI when trained on low or unblanaced data.
type: ccc
courses: {'csa': {'week': 22}}
---

AI models have great performance on many tasks, including image processing or natural language processing (ChatGPT). However, they have many problems that are not very obvious. E.g., AI systems cannot learn continuously. If we take AI model trained on some tasks and start training it again on new tasks, it will forget the first tasks very quickly. E.g., if we train AI on MNIST digits 0-4, it can process them well. If we then train it on 5-9, it will learn 5-9 but forgets 0-4. This problem is called catastrophic forgetting. All AI models, including ChatGPT, suffer from it.  Humans can learn continuously and without forgetting.



Another problem is that AI models require a huge amount of data for training. E.g., MNIST dataset is just 10 digits but it includes ~5000 versions of each digit (total ~50000 images). And the model needs to be trained on these data several times, so it needs to see each type of  digit (e.g, digit 0) tens of thousands of time to get good performance. Humans can learn from just few examples. (How many times you need to be bit by dog to start avoiding dogs?)



AI is also very bad to generalize. E.g., AI trained on clean MNIST images, cannot recognize noisy images and AI trained on noise images cannot recognize clean images. Humans can see a clean image once or just few times and can then recognize it in fog or rain without problem. This is all very bad , e.g., for self-driving cars because it is impossible to train AI on all variations (different strength of fog, rain, light) of cars, pedestrians, bicyclists, etc.



We do not know yet how humans can solve all these problems so well but one idea is that sleep helps us. When we sleep our brain is very active. Brain neurons fire in complex patterns that we just start to understand. Scientists think now that one of the things that happens during sleep is memory replay. E.g., if brain neurons fire in specific order to represent the path from my home to my friend’s home when I first drive car there, the same neurons can fire in the same order during sleep, and because of that, on the next day I can drive to my friends home better. This repetition of important firing sequences of neurons during sleep is called replay (like in the Inception movie).



The goal of the project I was helping with is to implement sleep-like replay to AI. We trained the network on very small amount of data (100s , not 1000s, of MNIST images) and tested if sleep-like state to AI model would help to improve accuracy. We also did the same using another dataset - Fashion MNIST data. Here it is how we implemented sleep-like state.



We first just trained AI on small number of MNIST images. We did training as everybody does by changing weights to reduce prediction error (to make loss function smaller). In AI model each node sums the inputs from a previous layer nodes multiplied by weights: SUM(w_ij*x_i) (normally we add bias we did not use biases in this project), here x_i is i-th neuron of the previous layer and w_ij is the weight from that i-th neuron of the previous layer to the j-th neuron of the next layer. After we take this SUM, we usually use ReLU function which is simply zero if argument is negative and it increases linearly for positive arguments. Because of that, any input that is positive will make some impact on the following layer, higher the SUM, more impact it makes.  To implement sleep we changed that.



 We made each node to behave like brain neuron that makes a “spike” when its input (SUM(w_ij*x_i)) exceeds a threshold (SUM(w_ij*x_i)>Threshold). If a neuron makes a spike, that spike affects neurons in the following layer. But if a neuron does not reach the threshold (SUM(w_ij*x_i)<Threshold), it does not make a spike and it does not make any impact on the following neurons. Another change was that we made the activation state of each neurons (SUM(w_ij*x_i)) to decay exponentially (*exp(-t/Tau)) if the neuron does not reach the threshold and does not make a spike. Because of this , if next input to the neuron arrives soon, it is easier for that neuron to reach the threshold and spike. The 3d change we did is to use some random spikes as an input to the first layer of our network , instead of applying images. Finally, we changed the rule how weights change. Instead of using backpropagation to minimize loss function, we simply used a rule that a weight is increasing between two neurons if both neurons spike, but it decreases if postsynaptic (later in chain) neuron spike but presynaptic neuron does not. This is called Hebbian rule and this is what we know how weights between neurons change in the brain.

 

After we processed out network trained first on small number of images through this sleep-like phase, we found performance increase like if the network was actually trained on more images. We believe it happened because during sleep-like phase the neurons replayed the same orders of spikes as they do during training and this increased right weights and decreased wrong ones, so sleep was kind of doing extra training but without actually using any extra data.


