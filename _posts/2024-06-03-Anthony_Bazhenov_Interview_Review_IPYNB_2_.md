---
toc: True
comments: False
layout: post
title: Interview Review
description: Blog Showcasing Projects During CSA
type: ccc
courses: {'csa': {'week': 30}}
---

```python
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
from scipy.signal import savgol_filter
from scipy import stats
```

# Interview Review


## CSA Projects


### Cosmic Carnage : Passion Project
Sep 6th, 2023 - Nov 2nd, 2023

- This was my first full in-depth dive into Object Oriented Programming, VSCODE, and Java.
- In this project we created a website oriented around space that allowed you to post and recieve images of space, and do other space-related things like games, and a space quiz.
- I learned a lot about how API's worked and how we planned to use them to post and recieve images of space.
- I primarily worked on the game during the time spent on this project adding a boss, shooting, and progressive difficulty.

<img width="598" alt="Screenshot 2024-06-04 at 11 24 37 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/de13378c-b9ee-4a3a-b4ad-f7e45e5378ef">

What I Learned:
- I learned countless things about how teams work in the Computer Science setting with everyone working on individual parts assisting each other when necessary until they combine it into one huge project.
- I learned how to code in a language I originally had no experience with html, and I began to start coding in Java.

[Cosmic Carnage Game](https://cosmic-carnage.github.io/Cosmic-Front/game)


### Code Demons : Mini Project
Nov 16, 2023 - Dec 18, 2023

- In this project we dived into sorting algorithms and fibonachi sequences tasked to create a code that compares different types of sorting algorithms and differnet fibonachi methods to see which are the fastest.
- I was a major contributer to this thinking to also use different sized datasets that were easily adjustable to see when certain sorting algorithms were more adventageous and when they're less.
- I primarily worked on the frontend code creating the entire frontend in a way that I am still proud of.
- I used SASS one of the topics for that trimester and creadted an extremely creative and in depth frontend.


<iframe width="560" height="315" src="https://github.com/Ant11234/BazhRepo/assets/40652645/351fcad1-1d6f-43fd-aa09-b7db2abc9ec3" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


What I Learned:
- I learned a lot about leading a team and giving tasks to do that I used later on. In my last and first project I had taken a more lax approach letting others lead and tell me what to do. This changed however in this project when, on some occassions, my team wouldn't do what's necessary for where we need to be and it was my job during this time to get them back on track.

[Mini Project Issue](https://github.com/Code-Demons/miniproject/issues/10)

### The GPT Warriors : PBL Project
Jan 30th, 2024 - Mar 2nd, 2024

- This was my largest and most interesting dive into Java code I've had during my time in CSA.
- I used Java to create 26 individual percepetrons that would give a "confidence" value and determine which sign it believes the person is showing at any given time.
- The percepetron works by getting training data in the form of a 2d array with each row being a new image and each item in a row being a pixel brightness except for the first that works as a label. The model is then trained on the images by letting it guess and then based on its guess change the weights around with a loss function. The model takes the derivative of the loss function to find its absolute minimum, and therefor the weights that lead to the most accuracy.

<img width="416" alt="Screenshot 2024-06-04 at 11 38 45 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/60f59e8d-d4a7-4963-ab90-1c0127220269">

What I Learned:
- I learned a lot about java backend coding and I gained a mroe in depth understanding of Artificial Intelligence with this project.
- This was my first time using post and get requests and API's in order to store image data, and prediction results.

[ASL Blog](https://ant11234.github.io/BazhRepo/2024/03/07/IndividualProgress_IPYNB_2_.html)

### CSA AI : PBL Project
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
- learned about more models and pytouch equivilents in Java and Javascript
- Compare different colors and create my own bounded box model.
- Learned more about hidden layers and how they work and benefit our project, and saw the similarities between that and bounded box causing me to choose it.

[Bounded Box Login](https://csa-ai.github.io/CSA_AI_Frontend/pages/aslsignin.html)
