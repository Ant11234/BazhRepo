---
toc: True
comments: True
layout: post
title: Individual Progress Blog
description: A blog showing my individual progress constantly being updated and renewed to show at the beginning of individual reviews.
type: ccc
courses: {'csa': {'week': 26}}
---

## Individual Progress

### AP Preperation
- [2014 MCQ](https://ant11234.github.io/BazhRepo//2024/01/12/IndividualReview_IPYNB_2_.html)
- [2015 FRQ 1](https://ant11234.github.io/BazhRepo//2024/02/26/2015FRQ1_IPYNB_2_.html)
- [2015 FRQ 2](https://ant11234.github.io/BazhRepo//2024/02/26/2015FRQ2_IPYNB_2_.html)
- [2015 FRQ 3](https://ant11234.github.io/BazhRepo//2024/02/26/2015FRQ3_IPYNB_2_.html)
- [2015 FRQ 4](https://ant11234.github.io/BazhRepo//2024/02/26/2015FRQ4_IPYNB_2_.html)
- [College Board Connection to Project](https://ant11234.github.io/BazhRepo//2024/02/26/2015FRQIssue_IPYNB_2_.html)



### Key Commits

- [Converting Images](https://github.com/The-GPT-Warriors/ASLFrontend/commit/a8d827cde723e1873dfbc093bd1e424233ad934e)
    - The above commit was in the beginning of the ASL code when we were intially preparing data for training. In the commit I created a .md file that converts it to a string with 784 elements and each element being a differnet pixel brightness. I knew we weren't going to use the code in the final project but one of my teamates was having difficulties making the code so I created this example code to start debugging the prediction logic, and get a working testing code with our own custom images. The code for this was extremely simple first converting the image to greyscale then lowering the resolution to 28*28.



- [Creating Endpoints in Prediction Controller](https://github.com/The-GPT-Warriors/ASLBackend/commit/b26ad4edac1b165a95984c56a7280741021abbb6#diff-bda377c91fb146c295f0e2e7a09e663152e2a7512f260484f4a21277d5f69b12)
- [Creating Endpoints in Prediction Controller](https://github.com/The-GPT-Warriors/ASLBackend/commit/082ae9c269aebf051c2971f38fbf10de8f475592#diff-fae415e081e1810c8e3938ba9d61d732ed228c2998667fdcb51129c683072f67)
    - This was my most in depth exposure to endpoints and API's I've had in my whole CS career. I really feel like the two commits above helped me learn how endpoints work along with getmapping and postmapping to the point where now I have a pretty good understanding of what they each do and when to use them in my code. Before this my teamates were forced to pick up my slack in some aspects like endpoints due to the gaps in my knowledge in some areas, however with this last project and the java basics notebook I made, I filled in the gaps of missing knowledge and was able to complete and create the endpoints entirely on my own.



- [Seperation of Train and Test](https://github.com/The-GPT-Warriors/ASLBackend/commit/1c08358564803b3758bb9f4263792ef1e5ef2b01#diff-24ca48810b6f13fe0c2e7845df6c1fb4e571bab9451d89792de7b336cec55924)
    - This is where I seperated the train and test portions of the model to save time and make the testing a lot faster. For a while with this project I was struggling with how we were gonna make it fast enough to be able to take in a frame every few seconds and output a prediction result instantly. In my initial code it would rerun training every time which was the biggest portion of time wasted, so I began to think about how to reduce/ entirely get rid of this phase. I managed to come up with a few solutions like saving the weights from an initial training phase and using that for every one after, but that didn't allow for a lot of variability or mutability in how many epochs, or the data we use, or any other number of factors.


- [Pull Request with Completed Code](https://github.com/The-GPT-Warriors/ASLBackend/commit/f62a4eb5360875c610e51fd861784c6ed45d042c#diff-c1d0060828e727060debdfd692dc803aa90ed73aadc40fe3703edc5ebfcd2a0d)
    - This was one of the largest commits I did with 27,740 additions including creating ASLPrediction.java, Prediction.javam PredictionApiController.java, PredictionController.java, PredictionRepository.java, PredictionService.java, and sign_mnist_train.csv which all work together in order to make predictions and post them. This commit took the most time out of any other because of how much I had to learn in order to get them all working together, but eventually I was able to take my original percepetron code and convert all the functions to work in the backend. After this commit there was still a lot of debugging to be done, however this was a huge majority of the work for the project shown in one commit.



### Github Analytics

<img width="418" alt="Screenshot 2024-03-08 at 11 51 40 AM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/a685c84f-7f08-4a52-9060-a2a5c6258a52">

- [ASL Frontend Commits](https://github.com/The-GPT-Warriors/ASLFrontend/commits/main/?author=Ant11234)
- [ASL Backend Commits](https://github.com/The-GPT-Warriors/ASLBackend/commits/master/?author=Ant11234)
- [Profile](https://github.com/Ant11234)


### Proof of Scrum Meeting Participation

- [Meeting](https://github.com/The-GPT-Warriors/ASLFrontend/issues/29)
Above is an issue for the meeting that we had in order to discuss where we wanted to continue with this project.



### Blogs about my Projects

[Java Basics](https://ant11234.github.io/BazhRepo//2024/02/28/JavaBasics_IPYNB_2_.html)
In this blog I talk about the java basics showing a deeper understanding of some of the topics I was lacking before.


[N@TM Blog about CSA Project](https://ant11234.github.io/BazhRepo//2024/02/16/N@TMBlog_IPYNB_2_.html)
In this blog there is a lot of information about how the AI percepetron works and how we can make improvments to increase the accuracy of the model.


[Sleep in Artificial Intelligence](https://ant11234.github.io/BazhRepo//2024/02/28/SleepInArtificialIntelligence_IPYNB_2_.html)
In this blog I talk about my 4 long year project to see the effects sleep has on an artificial neural network for low and unbalanced data.


[Debugging Issue](https://github.com/Ant11234/BazhRepo/issues/16)
Shows in depth understanding of debugging.
