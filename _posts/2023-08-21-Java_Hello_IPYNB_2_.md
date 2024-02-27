---
comments: True
layout: post
title: Java Hello
description: This is where students use their knowledge of java and put it into practice.
type: devops
courses: {'csa': {'week': 2}}
categories: ['C4.1']
---

## Constructors, Setters, and Getters


```java
public class fencing {
    // Instance variables to store fencing information
    private String name;
    private int age;
    private int nationalRanking;
    private String fencingRating;
    private String ageGroup;

    // Default constructor sets initial values
    public fencing() {
        this.name = "None";
        this.age = 0;
        this.nationalRanking = 0;
        this.fencingRating = "None";
        this.ageGroup = "None";
    }

    // Constructor with parameters to initialize fencing information
    public fencing(String name, int age, int nationalRanking, String fencingRating) {
        this.name = name;
        this.age = age;
        this.nationalRanking = nationalRanking;
        this.fencingRating = fencingRating;

        // Determine the age group based on age
        if (age >= 18) {
            if ("A".equals(fencingRating) || "B".equals(fencingRating) || "C".equals(fencingRating)) {
                ageGroup = "Div 1";
            }
            
            else if ("C".equals(fencingRating) || "D".equals(fencingRating) || "E".equals(fencingRating)) {
                ageGroup = "Div 2";
            }
            
            else if ("D".equals(fencingRating) || "E".equals(fencingRating) || "U".equals(fencingRating)) {
                ageGroup = "Div 3";
            }
        } else if (age >= 16) {
            ageGroup = "Junior";
        } else if (age >= 14) {
            ageGroup = "Cadets";
        } else if (age >= 12) {
            ageGroup = "Youth-14";
        } else if (age >= 10) {
            ageGroup = "Youth-12";
        } else if (age < 10) {
            ageGroup = "Youth-10";
        }
    }

    // Setter method to update the name
    public void setName(String name) {
        this.name = name;
    }

    // Setter method to update the age
    public void setAge(int age) {
        this.age = age;
    }

    // Setter method to update the fencing ranking
    public void setNationalRanking(int nationalRanking) {
        this.nationalRanking = nationalRanking;
    }

    // Setter method to update the fencing rating
    public void setFencingRating(String fencingRating) {
        this.fencingRating = fencingRating;
    }

    // Setter method to update the fencing rating
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    // Method to display fencer's information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Fencing Ranking: " + nationalRanking);
        System.out.println("Fencing Rating: " + fencingRating);
        if ("Unknown".equals(ageGroup)) {
            if (age >= 18) {
                if ("A".equals(fencingRating) || "B".equals(fencingRating) || "C".equals(fencingRating)) {
                    ageGroup = "Div 1";
                }
                
                else if ("C".equals(fencingRating) || "D".equals(fencingRating) || "E".equals(fencingRating)) {
                    ageGroup = "Div 2";
                }
                
                else if ("D".equals(fencingRating) || "E".equals(fencingRating) || "U".equals(fencingRating)) {
                    ageGroup = "Div 3";
                }
            } else if (age >= 16) {
                ageGroup = "Junior";
            } else if (age >= 14) {
                ageGroup = "Cadets";
            } else if (age >= 12) {
                ageGroup = "Youth-14";
            } else if (age >= 10) {
                ageGroup = "Youth-12";
            } else if (age < 10) {
                ageGroup = "Youth-10";
            }
        }
        System.out.println("Age Group: " + ageGroup);
    }

    // Main method for testing and demonstrating the class
    public static void main(String[] args) {
        // Create instances of the fencing class using constructors
        fencing fencer1 = new fencing();
        fencing fencer2 = new fencing("Orion Singha", 16, 4, "A");

        System.out.println("Fencer 1:");
        fencer1.displayInfo();
        System.out.println();

        System.out.println("Fencer 2:");
        fencer2.displayInfo();
        System.out.println();

        // Update information using setters
        fencer1.setName("Leon Fu");
        fencer1.setAge(15);
        fencer1.setNationalRanking(7);
        fencer1.setFencingRating("A");
        fencer1.setAgeGroup("Unknown");

        System.out.println("Updated Fencer 1:");
        fencer1.displayInfo();
    }
}
fencing.main(null);
```

    Fencer 1:
    Name: None
    Age: 0
    Fencing Ranking: 0
    Fencing Rating: None
    Age Group: None
    
    Fencer 2:
    Name: Orion Singha
    Age: 16
    Fencing Ranking: 4
    Fencing Rating: A
    Age Group: Junior
    
    Updated Fencer 1:
    Name: Leon Fu
    Age: 15
    Fencing Ranking: 7
    Fencing Rating: A
    Age Group: Cadets





```java

```


