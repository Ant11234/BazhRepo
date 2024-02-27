---
comments: True
layout: post
title: Primitive Data Types
description: This is where students use thier knowledge of primitive data types.
type: devops
courses: {'csa': {'week': 2}}
categories: ['C4.1']
---

## Scanner with Warning Message

## Primitive Datatypes with Warnings


```java
import java.util.Scanner;

public class ScanPrimitives {
    public static void main(String[] args) {
        Scanner input;

        // primitive int
        int sampleInputInt = 0;
        boolean isValidInt = false;
        while (!isValidInt) {
            input = new Scanner(System.in);
            System.out.print("Enter an integer: ");
            try {
                sampleInputInt = input.nextInt();
                System.out.println(sampleInputInt);
                isValidInt = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype, should be an integer");
            } finally {
                input.close();
            }
        }

        // primitive double
        double sampleInputDouble = 0.0;
        boolean isValidDouble = false;
        while (!isValidDouble) {
            input = new Scanner(System.in);
            System.out.print("Enter a double: ");
            try {
                sampleInputDouble = input.nextDouble();
                System.out.println(sampleInputDouble);
                isValidDouble = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype, should be a double");
            } finally {
                input.close();
            }
        }

        // primitive boolean
        boolean sampleInputBoolean = false;
        boolean isValidBoolean = false;
        while (!isValidBoolean) {
            input = new Scanner(System.in);
            System.out.print("Enter a boolean: ");
            try {
                sampleInputBoolean = input.nextBoolean();
                System.out.println(sampleInputBoolean);
                isValidBoolean = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype, should be a boolean");
            } finally {
                input.close();
            }
        }

        // wrapper class String
        String sampleInputString = "";
        boolean isValidString = false;
        while (!isValidString) {
            input = new Scanner(System.in);
            System.out.print("Enter a String: ");
            try {
                sampleInputString = input.nextLine();
                System.out.println(sampleInputString);
                isValidString = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype, should be a string");
            } finally {
                input.close();
            }
        }
    }
}
ScanPrimitives.main(null);
```

    Enter an integer: Wrong datatype, should be an integer
    Enter an integer: Wrong datatype, should be an integer
    Enter an integer: 16
    Enter a double: Wrong datatype, should be a double
    Enter a double: 0.055
    Enter a boolean: true
    Enter a String: buttface

