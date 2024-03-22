---
toc: True
comments: True
layout: post
title: FRQ for POJO
description: Hacks for POJO Unit
courses: {'csa': {'week': 27}}
type: ccc
authors: Anthony B
---

# Question 2: POJO (Unit 5)


Situation: You are developing a system to manage a small personal library. Each book in the library is represented by a POJO called **Book** .

(a) Explain the concept of a POJO in Java and provide an example scenario where using POJOs is beneficial in a programming task.

(b) Code:

You need to implement a class **Library** that maintains a collection of **Book** objects. The Book class has already been defined with the following private instance variables: **title** (a **String** representing the title of the book), **author** (a **String** representing the author of the book), and **yearPublished** (an **int** representing the year the book was published). The class has the corresponding getters for these variables.

Write the POJO class **Book** including a no-argument constructor, a constructor with parameters to initialize all the fields, getters for all the instance variables, and a **toString()** method that returns a String in the format "Title by Author (Year)".

Implement the Library class with the following methods:

- **addBook(Book newBook)**: A method that takes a Book object and adds it to the library's collection.
- **getOldestBook()**: This method returns the Book that was published the earliest in the collection.
- **toString()**: This method returns a String with all books' details in the library, each separated by a newline character.

# Question 2: POJO FRQ Frading Rubric (Unit 5)

(a) Explanation and Scenario:

* 1 point: Provides a clear explanation of POJOs in Java and presents a relevant scenario.


(b) Code Implementation:

* POJO Class **Book**:
    * No-argument Constructor: 0.5 points
    * Parameterized Constructor: 0.5 points
    * Getters: 1 point
    * toString() Method: 0.5 points

* Class Library Implementation:
    * addBook Method: 1 point
    * getOldestBook Method: 1 point
    * toString() Method: 1 point
