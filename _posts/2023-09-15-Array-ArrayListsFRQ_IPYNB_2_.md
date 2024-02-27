---
comments: True
layout: post
title: Array/Array Lists FRQ Analysis
description: The analysis for FRQ 3 array/ array lists.
type: ccc
courses: {'csa': {'week': 5}}
categories: ['C4.1']
---

<img width="730" alt="FRQ3" src="https://github.com/Ant11234/student/assets/40652645/e12f15d4-6051-483b-8b98-72eb6d8685ac">

## Review Class

-Is used in order to get the rating or comments of someone's review.


```java
public class Review {
    private int rating;
    private String comment;


    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    
}

```

## ReviewAnalysis Class

-Is used in order to analyze the data collected from the reviews provided by the users.


```java
public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis() {
        
    }

    public double getAverageRating() {

        }

    public ArrayList<String> collectComments() {

    }

}

```


    |       public double getAverageRating() {

    |   

    |           }

    missing return statement

    

    |       public ArrayList<String> collectComments() {

    |   

    |       }

    missing return statement

    


<img width="713" alt="FRQ3A" src="https://github.com/Ant11234/student/assets/40652645/d2bcb99f-1978-4a46-bdad-a32896979334">

## FRQ 3 part A

-Part A asks to write the ReviewAnalysis using getAverageRating which returns the arithmetic mean of allReviews as a double.
-We do this by first setting allReviews equal to all the user entered ratings, and then creating a for loop which creates a total rating and a total number of reviews and then returns the total rating value / number of reviews as a double.


```java
public class Review {
    private int rating;
    private String comment;


    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    
}

public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    public double getAverageRating() {
        int totalRating = 0;
        int numReviews = 0;
        for (Review review : allReviews) {
            int rating = review.getRating();
            totalRating += rating;
            numReviews++;
        }


        return (double) totalRating / numReviews;
    }

    public ArrayList<String> collectComments() {

    }
 
}
```


    |       public ArrayList<String> collectComments() {

    |   

    |       }

    missing return statement

    


<img width="607" alt="FRQ3B" src="https://github.com/Ant11234/student/assets/40652645/2bf35870-2348-4f30-864c-2e5eed4bd3d8">

## FRQ 3 part B

-Part B asks to create a new array list of comments given by the user that contain an exclamation point. They then want you to return it in the format of (rating)"-"(comment) and it wants it to be in the order of the Review in allReviews.
-In order to complete part B I created a for loop that goes through all items in allReview and checks whether or not the comment contains an exclamation point and if it does it adds it to commentList in the order of reviews in allReviews.


```java
public class Review {
    private int rating;
    private String comment;


    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    
}

public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    public double getAverageRating() {
        int totalRating = 0;
        int numReviews = 0;

        for (Review review : allReviews) {
            int rating = review.getRating();
            totalRating += rating;
            numReviews++;
        }


        return (double) totalRating / numReviews;
    }

    public ArrayList<String> collectComments() {
        ArrayList<String> commentsList = new ArrayList<>();

        for (Review review : allReviews) {
            String comment = review.getComment();
            int rating = review.getRating();

            if (comment.contains("!")) {
                if (commment.chatAt(length-1) != "." || comment.chatAt(length-1) != "!")
                    comment = comment + ".";
                commentsList.add(rating + "-" + comment);
            }
   

        }

        return commentsList;
    }
 
}
```


    |                       comment = comment + "."

    ';' expected

    


## Self Grading

<img width="725" alt="FRQGrading3A" src="https://github.com/Ant11234/student/assets/40652645/4602dfa8-bc71-4a66-9fb0-70afd1c4e1e4">


-The first point avalible is initializing and accumulting sum. I did this by initializing allReviews in the review analysis function then in the getAverageRating I created new local variables totalrating and numreviews in order to record the sum of the rating and the number of reviews accounted for in a for loop. I belive I deserve this point because I initialized allReviews and used a totalRating variable to record the sum of all ratings.
-All objects of allReviews were accessed and analyzed. Due to this I believe I deserve the point on this question.
-I managed to write the getAverageRating function to use getRating() in order to return a double value of the average rating of all reviews in allReviews.

-Total Score on part A 3/3

<img width="494" alt="FRQGrading3B" src="https://github.com/Ant11234/student/assets/40652645/cbb9b41b-a001-4620-8fd7-64869387d13b">


-I created an ArrayList that is capable of storing strings that are added to it.
-getComment goes through every element in allReview in order to be analyzed.
-My code calls getComment and calls at least one string method appropriatley.
-I successfully compare the last term of the string and check whether or not it ends with a . or an !, and if it doesn't I add one to the end of the comment, and then add it to commmentsList.
-I also successfully assembled the strings with the (rating) - (comment) format, and added it to commentsList.
-My code succesfully added all the necessary comments with ratings to commentsList to return.

-Total Score on part B 6/6



-Total Score in 2022 FRQ 3, 9/9


```java
public class Review {
    private int rating;
    private String comment;


    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    
}

public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    public double getAverageRating() {
        int totalRating = 0;
        int numReviews = 0;

        for (Review review : allReviews) {
            int rating = review.getRating();
            totalRating += rating;
            numReviews++;
        }


        return (double) totalRating / numReviews;
    }

    public ArrayList<String> collectComments() {
        ArrayList<String> commentsList = new ArrayList<>();

        for (Review review : allReviews) {
            String comment = review.getComment();
            int rating = review.getRating();

            if (comment.contains("!")) {
                if (comment.charAt(comment.length() - 1) != '.' && comment.charAt(comment.length() - 1) != '!') {
                    comment = comment + ".";
                }
                commentsList.add(rating + "-" + comment);
            }

        }

        return commentsList;
    }

    

    public static void main(String[] args) {
        Review[] reviews = new Review[5];
        reviews[0] = new Review(4, "Great product!");
        reviews[1] = new Review(5, "Excellent service!");
        reviews[2] = new Review(3, "Average experience.");
        reviews[3] = new Review(2, "Terrible experience");
        reviews[4] = new Review(5, "Outstanding! I'll definitly come back soon");

        ReviewAnalysis analysis = new ReviewAnalysis(reviews);

        double averageRating = analysis.getAverageRating();
        System.out.println("Average Rating: " + averageRating);

        ArrayList<String> commentsList = analysis.collectComments();
        System.out.println("Formatted Comments:");
        for (String comment : commentsList) {
            System.out.println(comment);
        }
    }
}

ReviewAnalysis.main(null)
```

    Average Rating: 3.8
    Formatted Comments:
    4-Great product!
    5-Excellent service!
    5-Outstanding! I'll definitly come back soon.


## Final Code With Java Inputs


```java
import java.util.Scanner;

public class Review {
    private int rating;
    private String comment;

    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}

public class ReviewAnalysis {
    private Review[] allReviews;

    public ReviewAnalysis(Review[] reviews) {
        allReviews = reviews;
    }

    public double getAverageRating() {
        int totalRating = 0;
        int numReviews = 0;

        for (Review review : allReviews) {
            int rating = review.getRating();
            totalRating += rating;
            numReviews++;
        }

        return (double) totalRating / numReviews;
    }

    public ArrayList<String> collectComments() {
        ArrayList<String> commentsList = new ArrayList<>();

        for (Review review : allReviews) {
            String comment = review.getComment();
            int rating = review.getRating();

            if (comment.contains("!")) {
                if (comment.charAt(comment.length() - 1) != '.' && comment.charAt(comment.length() - 1) != '!') {
                    comment = comment + ".";
                }
                commentsList.add(rating + "-" + comment);
            }
        }

        return commentsList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many reviews are you inputting:");
        int numReviews = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Review[] reviews = new Review[numReviews];
        
        for (int i = 0; i < numReviews; i++) {
            System.out.println("Enter the rating for review " + (i + 1) + ":");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter the comment for review " + (i + 1) + ":");
            String comment = scanner.nextLine();

            reviews[i] = new Review(rating, comment);
        }

        scanner.close();

        ReviewAnalysis analysis = new ReviewAnalysis(reviews);

        double averageRating = analysis.getAverageRating();
        System.out.println("Average Rating: " + averageRating);

        ArrayList<String> commentsList = analysis.collectComments();
        System.out.println("Formatted Comments:");
        for (String comment : commentsList) {
            System.out.println(comment);
        }
    }
}

ReviewAnalysis.main(null)
```

    How many reviews are you inputting:
    Enter the rating for review 1:
    Enter the comment for review 1:
    Enter the rating for review 2:
    Enter the comment for review 2:
    Average Rating: 7.5
    Formatted Comments:
    10-very good!


## Notes for other stundents during presentation

Multiple Choice Practice
-Constructor head with parameters in the beggining

-Superconstructors are super important make sure to learn what they are

-
