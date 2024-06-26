---
layout: post
title: U3 | Boolean and If statements
description: Lesson on booleans and if statements!
comments: True
courses: {'csa': {'week': 8}}
type: ccc
---

# APCSA Unit 3: College Board Learning Objectives and Standards

## Learning Objectives

The objective of today's lesson is to...

- Evaluate Boolean expressions that use relational operators in program code

## Essential Knowledge

College Board wants you to know that...

- Primitive values and reference values can be compared using relational operators (i.e., == and !=)
- Arithmetic expression values can be compared using relational operators (such as <, >, <=, >=)
- An expression involving relational operators evaluates to a Boolean value

## Warm Up

Answer the following questions as a group or individually. Write down your answers in your hacks notebook.

- What is a boolean?
    * A boolean is a varible that is either True or False.
- What values can a boolean represent? How many?
    * A boolean can prepresent 2 values, True and False.
- What is an example of when we'd use a boolean?
    * We'd use a boolean if we wanted to do a while loop until something becomes false.

## Recap on Booleans

A boolean is a type of variable that can evaluate to true or false. In Java, there are various comparison operators that can be used in order to compare two values. **What are some**?

The format is `val1 <oper> val2`, and will return a boolean given the state of the system. Like all booleans, this can only return two values `true` or `false` 


```java
public class Example {

    private static boolean isAdult = false;
    private static int myAge = 16;

    public static void main(String [] args){

        if(myAge >= 18){
            System.out.println("You are an adult!");
            isAdult = true;
        } else {
            System.out.println("You are not an adult!");
        }  

        System.out.println(isAdult);
    }
}

Example.main(null);
```

    You are not an adult!
    false


## Comparison Operators

Whenever you want to make a boolean statement (such as setting a boolean to be true or false), you want to use the `"="` or `"!="` sign and not the `"=="` sign.

On the other hand, if you are ever trying to compare String objects, use the String methods such as `.equals` or `.compareTo`, NOT the Boolean expressions mentioned above. 

### Setup Class

**Note the utilization of the `compareTo` in a custom class in order to compare two classes**


```java
public class ComparisonExample implements Comparable<ComparisonExample> {
    private int comp;
    private int comp2;

    public ComparisonExample(int _comp, int _comp2) {
        this.comp = _comp;
        this.comp2 = _comp2;
    }

    @Override
    public int compareTo(ComparisonExample s) {
        return Integer.compare(this.comp, s.comp);
    }

    public static int compare(ComparisonExample a, ComparisonExample b)
    {
        if(Integer.compare(a.comp, b.comp)==0){
            return Integer.compare(a.comp2, b.comp2);
        }
        else {
            return Integer.compare(a.comp, b.comp);
        }
    }
}
```

### Comparing using compareTo

Describe this code and the code above using comments. Talk about how we define the `compareTo` in the class definition and how that compares each instance of a class using a certain comparison variables. <br>
<br>
**In your notes** Compare and contrast `Comparator<>` and `compareTo`


```java
ComparisonExample c = new ComparisonExample(2, 2);
ComparisonExample v = new ComparisonExample(2, 3);
System.out.println(c.compareTo(v)); // Allows comparison of these two instances of a class
System.out.println(ComparisonExample.compare(c, v)); // Also allows for the instances

if(ComparisonExample.compare(c, v) < 0){ // Using the comparison 
    System.out.println("This is less than!");
}
else { System.out.println("it is not"); }
```

    0
    -1
    This is less than!


### Comparing using .equals

You can use the .equals method to compare the contents of two strings. To test if the two strings are the same or not, you can use Sysout (System.out.println) so that the console will provide a value that is either true or false. 


```java
System.out.println("hello".equals("hello")); // will return true, since the strings are the same
System.out.println("Hello".equals("hello")); // will return false, as the one thing that separates these two strings is that the h is capitalized in the first string
```

    true
    false


### Comparing two arrays

The code below compares the contents of two arrays to see if they are equal. It uses the `equals` method. However, as we see below, this is rather shallow as opposed to deep comparison.


```java
  int arr1[] = { 1, 2, 3 };
  int arr2[] = { 1, 2, 3 };

  if (Arrays.equals(arr1, arr2)){

      System.out.println("Same");
  }
  else {


      System.out.println("Not same");
  }

```

    Same


## Deep Equality

All of the methods you just saw are examples of **regular equality.** Whereas regular equality methods such as the .equals method compares the content of the objects themselves to check if they are equal (i.e. point to the same object), deep equality methods such as the .deepequals method compares the content of nested objects or arrays to determine equality. 


```java
import java.util.Arrays;

public class DeepEquality {

    public static void main(String[] args) {
        
        String[][] fruit1 = {
            {"apple", "banana"},
            {"orange", "grape"}
        };

        String[][] fruit2 = {
            {"apple", "banana"},
            {"orange", "grape"}
        };

        // Regular comparison (compares array references, not contents)
        System.out.println("Regular/shallow equality result: " + (fruit1.equals(fruit2))); // will output false since the arrays do not reference the same object

        // Deep comparison (compares array contents, not just references)
        System.out.println("Deep equality result: " + (Arrays.deepEquals(fruit1, fruit2))); // will output true since the arrays have the same content
    }
}

DeepEquality.main(null);
```

    Regular/shallow equality result: false
    Deep equality result: true


## Challenge!

Identify the issue(s) in the code below (hint: try running it yourself). Then, make the necessary corrections to ensure that the program runs as intended.


```java
public class Challenge {

    private static boolean isName = false;
    private static String name = new String("John");


    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Guess my name!");

        String guess = sc.nextLine();
        System.out.println("Your guess: "+guess);

    
        if(guess = name){ 
            isName = true;
        } else {
            System.out.println("Wrong! L Cope");
        }

        System.out.println(isName);

    }
}

Challenge.main(null);
```

    Guess my name!
    John
    Your guess: John
    Wrong! L Cope
    false


# Your Homework

Now that you know what boolean expressions are and how to write them, as well as several comparison methods, your task is to write a class that uses either the compareTo or comparator and compare. Then create two instances of these classes and demonstrate using if statements. 




BONUS: Create a program that checks if a year is a leap year or not.

Here is how the method should work: 

(1) Prompt the user to input any year that they would like <br>
(2) Determine if the year is a leap year or not <br>
(3) Print the necessary dialogue (ex. [year] is/is not a leap year) AND return the value of any boolean(s) used





```java
public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";

        int result = str1.compareTo(str2);

        if (result < 0) {
            System.out.println("str1 comes before str2");
        } else if (result > 0) {
            System.out.println("str1 comes after str2");
        } else {
            System.out.println("str1 and str2 are equal");
        }
    }
}
```

# Bonus


```java
// Leap year

Scanner scanner = new Scanner(System.in);
int year = scanner.nextInt();
int quotient = 4;
if(year % 4 == 0){
    System.out.println(year+" is a leap year");
}
else{
    System.out.println(year+" isn't a leap year");
}
```

    2042 isn't a leap year


### Weird Questions

1. !(true)&&(false) = ? what in boolean values?
- True
2. not ((((true and not (false)) ^ false) ^ true) && false) (remember PEMDASNAO!)
- False
3. Prove the following: !A * !(B + !C) = !A * (!B * !C)
- You can use demorgans law in order to get the right side equal to !A * (!B * C), which means that the right side is equal to !A *!B * C and you can also distribute the ! into the pranthesis on the left side making the question !A * !B * C = !A * !B * C showing how the two sides are equal.
4. (1 / !A) * !A * !(B + !C) = (1 / !A) * !A * (!B * !C)
- !A/!A = 1, therefore this equation can be simplified to !(B + !C) = (!B * !C) the same thing as below.
5. !(B + !C) = (!B * !C)
- !(B + C) = !B * C
