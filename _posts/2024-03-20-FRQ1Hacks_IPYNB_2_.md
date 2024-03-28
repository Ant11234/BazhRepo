---
toc: True
comments: True
layout: post
title: Methods and Control Structures Hacks
description: Hacks for the wednesday workshop on 3/19/2024
courses: {'csa': {'week': 27}}
type: ccc
authors: Anthony B
---

## Hacks for Question 3 : Arraylists (Unit 6)

Situation: You are developing a student management system where you need to store and analyze the grades of students in a class.

(a) Define an arrayList in Java. Explain its significance and usefulness in programming.

- An arraylist is a part of the java.util package and works as a resizeable array that can be changed in size.

(b) Code:

You need to implement a method `calculateAverageGrade` that takes an arrayList `grades` of integers representing student grades and returns the average of all the elements in the arrayList. Write the method signature and the method implementation. Include comments to explain your code.




```Java
import java.util.ArrayList;
import java.util.Arrays;

public class StudentManagementSystem {
    public static double calculateAverageGrade(ArrayList<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public static void main(String[] args) {
        // Correctly initializing the ArrayList and passing it to the method
        ArrayList<Integer> grades = new ArrayList<>(Arrays.asList(81, 20, 89, 97, 91, 102));
        double average = calculateAverageGrade(grades);
        System.out.println("The average grade is: " + average);
    }
}

StudentManagementSystem.main(null);
```

    The average grade is: 80.0


## Hacks for Question 4 : Math Class (Unit 2)

Situation: You are developing a scientific calculator application where users need to perform various mathematical operations.

(a) Discuss the purpose and utility of the Math class in Java programming. Provide examples of at least three methods provided by the Math class and explain their usage.

- The Math class in Java is part of the java.lang package, which means it's available by default without needing to import it. This class provides a wide range of mathematical functions and constants that are useful for performing mathematical operations. These operations include basic arithmetic, exponentiation, logarithms, and trigonometry, among others. The utility of the Math class lies in its ability to perform complex mathematical computations accurately and efficiently without the programmer having to implement these functions from scratch.

Examples of methods provided by the Math class include:

- Math.abs(double a): Returns the absolute value of a given double value. This is useful for ensuring non-negative results from calculations.
- Math.pow(double a, double b): Returns the value of the first parameter raised to the power of the second parameter. This method is crucial for exponential calculations.
- Math.sqrt(double a): Returns the square root of a given double value. This method is often used in geometry, physics, and other fields requiring square root calculations.

(b) Code:

You need to implement a method `calculateSquareRoot` that takes a `double` number as input and returns its square root using the Math class. Write the method signature and the method implementation. Include comments to explain your code.



```Java
public class ScientificCalculator {
    public static double calculateSquareRoot(double number) {
        // Use Math.sqrt to calculate and return the square root of the input number
        return Math.sqrt(number);
    }

    public static void main(String[] args) {
        double number = 81.0;
        double squareRoot = calculateSquareRoot(number);
        
        System.out.println("The square root of " + number + " is: " + squareRoot);
    }
}

ScientificCalculator.main(null);
```

    The square root of 81.0 is: 9.0

