---
comments: True
layout: post
title: Array-ArrayList FRQ
description: FRQ problem 3.
type: ccc
courses: {'csp': {'week': 2}}
categories: ['C4.1']
---

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
                if (commment.chatAt(length-1) != "!" || comment.chatAt(length-1) != ".")
                    comment = comment + ".";
                commentsList.add(rating + "-" + comment);
            }
   

        }

        return commentsList;
    }
 
}
```

## Self Grading

<img src="FRQ3Grading3A.png"/>

-The first point avalible is initializing and accumulting sum. I did this by initializing allReviews in the review analysis function then in the getAverageRating I created new local variables totalrating and numreviews in order to record the sum of the rating and the number of reviews accounted for in a for loop. I belive I deserve this point because I initialized allReviews and used a totalRating variable to record the sum of all ratings.
-All objects of allReviews were accessed and analyzed. Due to this I believe I deserve the point on this question.
-I managed to write the getAverageRating function to use getRating() in order to return a double value of the average rating of all reviews in allReviews.

-Total Score on part A 3/3

<img src="FRQ3Grading3B.png"/>

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

