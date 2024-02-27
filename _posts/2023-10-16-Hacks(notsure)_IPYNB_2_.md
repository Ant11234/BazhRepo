---
toc: True
comments: True
layout: post
title: Unit 2 | Objects
description: Unit 2
type: ccc
courses: {'csa': {'week': 7}}
---

# Hack 1
- Create a void method that takes an integer input and adds it to an ArrayList. Then, add a non-void method that is able to call a certain index from the ArrayList.


```java
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHack {
    private ArrayList<Integer> integerList;
    private Scanner scanner;

    public ArrayListHack() {
        // Initialize the ArrayList in the constructor
        integerList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Void method to add an integer to the ArrayList
    public void inputToList() {
        while (true) {
            System.out.println("Input a Number to add to the Array List or enter 'Break' to leave: ");

            String input = scanner.next();

            if (input.equalsIgnoreCase("break")) {
                // Exit the loop if the user enters "Break"
                break;
            }

            int number = Integer.parseInt(input);
            integerList.add(number);
        }
    }

    // Non-void method to get an element at a specific index
    public int getIntAtIndex(int index) {
        if (index >= 0 && index < integerList.size()) {
            return integerList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public static void main(String[] args) {
        ArrayListHack example = new ArrayListHack();

        example.inputToList();

        // Gets the element at a specific index
        int valueAtIndex = example.getIntAtIndex(1);

        System.out.println("Value at index 1: " + valueAtIndex);
    }
}

ArrayListHack.main(null);
```

    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Input a Number to add to the Array List or enter 'Break' to leave: 
    Value at index 1: 20


# Hack 2
- Create a simple guessing game with random numbers in math, except the random number is taken to a random exponent (also includes roots), and the person has to find out what the root and exponent is (with hints!). Use at least one static and one non-static method in your class.


```java
import java.util.Random;
import java.util.Scanner;

public class MathGuessingGame {
    private static Random random = new Random();
    private int base;
    private int exponent;
    private int answer;

    public MathGuessingGame() {
        generateRandomMathProblem();
    }

    private void generateRandomMathProblem() {
        base = random.nextInt(10) + 1; // Random base (1 to 10)
        exponent = random.nextInt(5) + 2; // Random exponent (2 to 6, including roots)
        answer = (int) Math.pow(base, exponent);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;

        System.out.println("Welcome to the Math Guessing Game!");
        System.out.println("I've selected a random number taken to a random exponent (including roots). Your task is to guess the base and exponent.");

        while (true) {
            System.out.print("Make your guess (base): ");
            baseInput = scanner.nextInt();
            System.out.print("Make your guess (exponent): ");
            exponentInput = scanner.nextInt();
            

            
            if (guess == answer) {
                System.out.println("Congratulations! You've guessed the base and exponent correctly!");
                break;
            } else {
                System.out.println("Sorry, that's not correct. Here are some hints:");
                displayHints();
                attempts++;
            }
        }

        System.out.println("You got it in " + attempts + " attempts.");
    }

    private void displayHints() {
        System.out.println("Hints:");
        System.out.println("1. The result is " + answer);
        System.out.println("2. The base is between 1 and 10.");
        System.out.println("3. The exponent is between 2 and 6 (including roots).");
    }

    public static void main(String[] args) {
        MathGuessingGame game = new MathGuessingGame();
        game.play();
    }
}

MathGuessingGame.main(null);
```

    Welcome to the Math Guessing Game!
    I've selected a random number taken to a random exponent (including roots). Your task is to guess the base and exponent.
    Make your guess (base exponent): 


    ---------------------------------------------------------------------------

    java.util.InputMismatchException: null

    	at java.base/java.util.Scanner.throwFor(Scanner.java:947)

    	at java.base/java.util.Scanner.next(Scanner.java:1602)

    	at java.base/java.util.Scanner.nextInt(Scanner.java:2267)

    	at java.base/java.util.Scanner.nextInt(Scanner.java:2221)

    	at MathGuessingGame.play(#20:1)

    	at MathGuessingGame.main(#20:1)

    	at .(#22:1)

