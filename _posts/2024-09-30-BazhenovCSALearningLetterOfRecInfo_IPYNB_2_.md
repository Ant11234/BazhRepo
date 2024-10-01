---
toc: True
comments: False
layout: post
title: Bazhenov CSA Learning for Letter of Recommendation Info
description: Blog Showcasing Learning from Projects During CSA
type: ccc
courses: {'csa': {'week': 36}}
---

```python
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
from scipy.signal import savgol_filter
from scipy import stats
```

# Bazhenov CSA Learning for Letter of Recommendation Information


## <u>CSA Projects</u>


### **Cosmic Carnage : Passion Project**
Sep 6th, 2023 - Nov 2nd, 2023

- This was my first full in-depth dive into Object Oriented Programming, VSCODE, and Java.
- In this project we created a website oriented around space that allowed you to post and recieve images of space, and do other space-related things like games, and a space quiz.
- I learned a lot about how API's worked and how we planned to use them to post and recieve images of space.
- I primarily worked on the game during the time spent on this project adding a boss, shooting, and progressive difficulty.

<img width="598" alt="Screenshot 2024-06-04 at 11 24 37 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/de13378c-b9ee-4a3a-b4ad-f7e45e5378ef">

What I Learned:
- I learned countless things about how teams work in the Computer Science setting with everyone working on individual parts assisting each other when necessary until they combine it into one huge project.
- I learned how to code in a language I originally had no experience with html, and I began to start coding in Java.

How I Applied The Learning:
- This was my first real introduction into vscode and jupyter notebook, tools I used countless times following the class in both my UCSD research project and Salk.
    * In the beginning of my research with UCSD we soley used applications like google collaboration, but due to the slow run times and confusing UI, we disliked the IDE and searched for alternatives. Through my time in AP CSA, I was prepared for the switch from google collaboration to vscode, more so than my peer at Del Norte who didn't take the class. I was able to continue my work, with almost more understanding of the overall structure of the Sleep-like replay and its effect on AI code.
    * Throughout Salk I would constantly use vscode for everything I did while there. I felt prepared coming into a space dominated by vscode with practically everyone, except suprisingly my Principal Investigator, using it for all of there projects. I also was prepared and able to understand when Graduate Students or Postdoctoral Fellow would show me their code on Jupyter notebook, and used it constantly for practically all my work while testing or coding before creating final files.

[Cosmic Carnage Game](https://cosmic-carnage.github.io/Cosmic-Front/game)


### **Code Demons : Mini Project**
Nov 16, 2023 - Dec 18, 2023

- In this project we dived into sorting algorithms and fibonachi sequences tasked to create a code that compares different types of sorting algorithms and differnet fibonachi methods to see which are the fastest.
- I was a major contributer to this thinking to also use different sized datasets that were easily adjustable to see when certain sorting algorithms were more adventageous and when they're less.
- I primarily worked on the frontend code creating the entire frontend in a way that I am still proud of.
- I used SASS one of the topics for that trimester and creadted an extremely creative and in depth frontend.


<iframe width="560" height="315" src="https://github.com/Ant11234/BazhRepo/assets/40652645/351fcad1-1d6f-43fd-aa09-b7db2abc9ec3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


What I Learned:
- I learned a lot about leading a team and giving tasks to do that I used later on. In my last and first project I had taken a more lax approach letting others lead and tell me what to do. This changed however in this project when, on some occassions, my team wouldn't do what's necessary for where we need to be and it was my job during this time to get them back on track.

How I Applied The Learning:
- Taking up a leadership position during this project prepared me for the independence and self-reliance needed in Salk.
    * The Salk Institute for Biological Studies Heithoff Brody Summer Scholars Program was a drastic shift in independence. Where in every other aspect of my academic life would revolve around listening to what teachers tell me to do and preform the task, but with Salk it was drastically different with weeks in between any input from my mentor, having to figure out solutions to problems, different routes to take, and different tests or experiments to do completely independently. My time working on this project prepared me for that where previously in the course I had spent majority of it listening to others instructions, and throughout this project I was spearheading what direction to take and what routes to take to debug problems, and improve the code. I spent a sizeable amount of time brainstorming experiments to do to eliminate different locations or factors as to why I was recieving errors, routes to take while adapting the previous Hyperbolic and Euclidean Multi-dimensional scaling code to work with annData, and deciding the most logical and intuitive way to structure my code and data to promote reusability and compatibility with other labs data.

[Mini Project Issue](https://github.com/Code-Demons/miniproject/issues/10)

### **The GPT Warriors : PBL Project**
Jan 30th, 2024 - Mar 2nd, 2024

- This was my largest and most interesting dive into Java code I've had during my time in CSA.
- I used Java to create 26 individual percepetrons that would give a "confidence" value and determine which sign it believes the person is showing at any given time.
- The percepetron works by getting training data in the form of a 2d array with each row being a new image and each item in a row being a pixel brightness except for the first that works as a label. The model is then trained on the images by letting it guess and then based on its guess change the weights around with a loss function. The model takes the derivative of the loss function to find its absolute minimum, and therefor the weights that lead to the most accuracy.

<img width="416" alt="Screenshot 2024-06-04 at 11 38 45 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/60f59e8d-d4a7-4963-ab90-1c0127220269">

What I Learned:
- I learned a lot about java backend coding and I gained a more in depth understanding of Artificial Intelligence with this project.
- This was my first time using post and get requests and API's in order to store image data, and prediction results.

How I Applied The Learning:
- This was one of my first entirely independent Artificial Intelligence projects which helped my understanding of creating Neural Networks, and how the structure of them change, as the inputs and classes do.
    * Throughout my previous AI projects, I would never be entirely on my own which helped hugely when facing confusions, or when I needed more insight like during my UCSD Sleep-like Replay AI project. Where previously I would recieve help when needed, the AI model in this project was created entirely by me causing any confusions to be faced on my own. And through the trials this project provided me, I gained a much deeper and more insightful grasp of Artifical Networks, and more specifically how the model changes with a different number of classes and pixels, and how you can break the structure of larger more complicated Neural Networks into simple, single input, weight, and output percepetrons.

[ASL Blog](https://ant11234.github.io/BazhRepo/2024/03/07/IndividualProgress_IPYNB_2_.html)

### **CSA AI : PBL Project**
March 18, 2024 - May 29, 2024

- Worked on changing the original percepetron code to train on our data and give a prediction based on the hand signal it believes was there.
- Spearheaded the project helping my teamates figure out stuff to do like Ethan Tran, or understaning more about our old backend and each part of it with Tay Kim.
- Created Data Frames which stores each individual frame of a video the user creates for training data in a format the model can read.
- Brainstormed possibilities and ways to increase the acuraccy of our model after recieving feedback.
- Came up with generalization and bounded boxes and pursued bounded boxes, a method in which you create a seperate model that uses differences in brightness and edges in order to find out the general area the object thats being tested on is.
- Went throughn multiple iterations creating it on my own before using a tenserflow model and implementing it to share the bounded area with the model.

<img width="1468" alt="Screenshot 2024-06-04 at 11 48 06 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/f566e151-2da5-4358-b17d-ba3a511042ba">

What I Learned:
- I learned a lot about being a leader and being there for my teamates. There were countless nights were I would stay up texting or calling Ethan to help him with his project, or Tay with the post and get requests and I feel like I became a more valuable teamate with the experiences garnered.
- Learned about more models and pytouch equivilents in Java and Javascript
- Compare different methods to increase accuracy and created my own bounded box model.
- Learned more about hidden layers and how they work and benefit our project, and saw the similarities between that and bounded box causing me to choose it.

How I Applied the Learning:
- This project gave me a much better understanding of hidden layers in Neural Networks, how they work, and what makes them increase performance. This was also one of the most creative oppurtunities I've had throughout my life, having to think of a way to implement a Stock Prediciton AI and a Sign Language Interpreter AI.
    * I always knew the value of hidden layers while creating them in the Sleep-Like Replay AI project, but didn't fully understand what made them so beneficial, and exactly how they worked. Throughout this project I had done tons of research defining hidden layers and what each layer did in differentiating between the object its working on and pointless details. Each layer defines a certain characteristic like edges, corners and countour, and object parts. Based on where those are located, the models final output changes based on different weights of the model. I implemented this by using bounded boxes, and through the experience of coding it gained a lot of knowledge on their actual structure and how they work which helped me better understand my UCSD Sleep-Like Replay AI project when working on it and presenting it.
    * This was also a unique experience to implement two drastically different codes together which posed quite a challenge. Through working on this project, and brainstorming on ways to implement the two projects I practiced and learned a lot about out of the box ideas, and how to transform these initially far-fetched ideas into working functional code. I used the skills from this project while brainstorming ways to calculate large distance matrices that would cause my computer to crash. I ended up coming up with batch-processing as a solution, and through hours of writing and debugging, I was able to create a fully functional code that could calculate distance matrices of data, no matter how large.

[Bounded Box Login](https://csa-ai.github.io/CSA_AI_Frontend/pages/aslsignin.html)
