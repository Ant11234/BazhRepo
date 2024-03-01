---
toc: True
comments: True
layout: post
title: The Basics of Java
description: A comprehensive review of all the basics of java based on all java-related jupyter notebooks from trimester 1.
type: ccc
courses: {'csa': {'week': 22}}
---

# A Comprehensive Review of all the Basics of Java

Although I feel much more confident with Java, and have a better understanding of the language all together when compared to trimester 1, their are gaps in my knowledge when it comes to the language. The purpose of this jupyter notebook is to use all the resources provided by Mr. Mortsen in the teacher portfolio pertrayning to the basics of Java in order to fill the gaps in my knowledge and create a stronger foundation for my more advanced projects like the American Sign Language AI, and any others in my future.
## Object Oriented Programming

The following is the link to the video which I took notes on.
[Link From Java Hello](https://www.youtube.com/watch?v=Wok4Xw_5cyY&ab_channel=Code.org)

### Notes
- Java is an Object-Oriented Programming Language
    * Object Oriented Programming is an approach to creating and using models of physical or imagined objects
- In order to create models of objects, we use classes
    * A class is a programmer-defined "blueprint" where objects are created
- Writing a class:
    * First create a java file with the same name as what we will use for the class
    * Name should start with a camptal letter
    * If there are multiple words in a name, the most widely accepted method of differentiating between words is by using Camel Case, a naming convention where the first letter of every word is capatalized in order to clearly show what the name is meant to be
        - Ex: PredictionService.java
    * Classes are started by first writing public class followed by the name of the file and two curly brackets "{}"
    * Majority of our classes are public because we want other files to be able to access the variables and functions created within the class.
        - Below is a diagram explaining public classes and one example of a public class that I've created for ASL Artificial Intelligence:

<img width="992" alt="Screenshot 2024-03-01 at 12 43 51 PM" src="https://github.com/Ant11234/BazhRepo/assets/40652645/fed58399-81c3-4142-9f47-ff771b6dbb3b">



```java
public class PredictionService {
    private final PredictionRepository predictionRepository;
    double[][] weights = new double[25][785];  //weights are available to all classes within PredictionService

    @Autowired
    public PredictionService(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    // Here we want to run trainLogic method once after constructor to train the network by data from online repository
    @PostConstruct
    public void init() {
        trainLogic();
    }

 //   public String predictAndSave(List<Integer> mnistData) {
    public String predictAndSave(List<List<Integer>> mnistData) {   
        System.out.println("---------predictAndSave");
        //Here we run predictionLogic everytime new "mnistData" is obtained
        String predictionResult = predictionLogic(mnistData);
        savePrediction(predictionResult); // Save without needing to return the saved entity
        return predictionResult; // Return the result directly
    }

    
    private List<List<Integer>> readCSV(String fileName) throws IOException {
        List<List<Integer>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true; // To skip the header row
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header row
                }
                String[] values = line.split(",");
                List<Integer> row = new ArrayList<>();
                for (String val : values) {
                    try {
                        row.add(Integer.parseInt(val.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping non-numeric value: " + val);
                        // Handle the non-numeric value, or continue
                    }
                }
                data.add(row);
            }
        }
        return data;
    }
 
    // Assuming this is your train logic method; This is the methos to train only by online data
    public String trainLogic() {
        System.out.println("---------trainLogic");
        List<List<Integer>> data = new ArrayList<>();
        try {
            data = readCSV("sign_mnist_train.csv");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            // Handle the exception, e.g., log it or return a default value
            return "Error"; // or any other error handling mechanism
        }
        int lg = data.size();
        int lg1 = data.get(0).size();

        int[][] x = new int[lg - 1][lg1];
        for (int i = 0; i < lg - 1; i++) {
            for (int j = 0; j < lg1; j++) {
                x[i][j] = data.get(i + 1).get(j);
            }
        }

 //       double[][] weights = new double[25][lg1];
        int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};
        int m = weights[0].length - 1;

        double rate = 0.5;
        int epoch = 50;  //change to 50 in final version
        for (int s = 0; s < 25; s++) {
            for (int ii = 0; ii < epoch; ii++) {
                double error = 0.0;
                for (int i = 0; i < x.length; i++) {
                    double y_pred = weights[s][0];
                    for (int k = 0; k < m; k++) {
                        y_pred += weights[s][k + 1] * x[i][k + 1];
                    }

                    double pred = y_pred >= 0.0 ? 1.0 : 0.0;
                    double expect = x[i][0] == digit[s] ? 1.0 : 0.0;
                    double err = pred - expect;
                    error += err * err;

                    weights[s][0] -= rate * err;
                    for (int k = 0; k < m; k++) {
                        weights[s][k + 1] -= rate * err * x[i][k + 1];
                    }
                }
                System.out.println("Letter: " + alphabet[s] + ", Epoch: " + ii + ", Error: " + error);
            }
        }
        return null;
    }

    // Assuming this is your prediction logic method
 //   private String predictionLogic(List<Integer> mnistData) {
    private String predictionLogic(List<List<Integer>> mnistData) {       
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};

        // To test using mnistData
        List<List<Integer>> test = mnistData;
 //       List<Integer> test = mnistData;

        int lgt = test.size();
        int lg1t = test.get(0).size() - 1;
        System.out.println(lgt + ", " + lg1t);
        int s0 = 0;
        int[][] xt = new int[lgt][lg1t];
        for (int i = 0; i < lgt; i++) {
            for (int j = 0; j < lg1t; j++) {
                xt[i][j] = test.get(i).get(j+1);
            }
        }
        for (int[] innerArray : xt) {
            System.out.println(Arrays.toString(innerArray));
        }
        double pred0 = -100000000;
 //       for (int ii = 0; ii < lgt - 1; ii++) {
            for (int s = 0; s < 25; s++) {
                double y_pred = weights[s][0];
                for (int k = 0; k < lg1t; k++) {
                    y_pred += weights[s][k + 1] * xt[lgt-1][k];
 //                   System.out.println(xt[lgt-1][k]);
                }
                if (y_pred > pred0) {
                    pred0 = y_pred;
                    s0 = s;
                }
            }
 //       }

        

 //       s0=11;  //for test only , REMOVE!
        return alphabet[s0];
    }

    public Prediction savePrediction(String prediction) {
        Prediction newPrediction = new Prediction(prediction, LocalDateTime.now());
        return predictionRepository.save(newPrediction);
    }

    public List<Prediction> getAllPredictions() {
        return predictionRepository.findAll();
    }
}
```
The code above was called constantly throughout our project. Whether that be trainlogic in the begging of the code to initialize and create the weights, or predictandsave that uses predictionlogic in order to return a prediction based on the data and save it to be sent to /predictions PredictionService needed to be a public class in order to work with the other files about the AI model in the backend. By having the class encapsilate all the objects and functions needed for predictions it makes it more intuitive and easier to experiment with, to improve and to make sure data are safe for each class.


### Summary

Java is an Object-Oriented Programming Language that emphasizes the use of classes as blueprints for creating objects, embodying both data and behavior. Classes in Java are named with a capital letter, adhering to Camel Case for multi-word names, such as PredictionService.java. A class is typically public, allowing its methods and variables to be accessible from other parts of the program, and is defined with the syntax public class ClassName {}. This approach facilitates the modeling of real-world or conceptual objects, enabling developers to structure software in a more intuitive and manageable way.





## Creating Objects

The following is the link to the video which I took notes on.
[Link From Java Hello](https://www.youtube.com/watch?v=C5Ks_u87Ltg&ab_channel=Code.org)

### Notes
- A class is a list of attributes and instructions for how to create an instance of itself.
    * An attribute is a characteristic of an object
    * Classes can also define the behavior for an object
    * A behavior is the actions that an object can perform and an object is an instance of a class
- In java we have to instantiate our objects which is when you call the constructor to create an object
- A constructor is a block of code that has the same name as the class and holds information telling the computer how to instantiate a new object
- In java we need to designate memory space for an object followed by a name for the object, or a reference variable.
    * A reference variable is a variable that points to an object
- The new keyword tells the computer to instantiate the new object
- This is followed by the type of object we want to create
- In order to get the instructions for creating an object, we call it by using ();
    * This method of creating objects makes it extremely easy to create new objects each with their own attributes based on the class
- The state is the attributes represented by the objects instance variables


### Summary

In Java, a class serves as a blueprint detailing attributes (characteristics of an object) and behaviors (actions an object can perform), essentially defining how an instance of itself can be created. Attributes represent the state of an object through instance variables, while behaviors dictate what actions the object can undertake. Object instantiation in Java involves calling a constructor—a special block of code named after the class, designed to initialize a new object by allocating memory space and assigning it a reference variable, which acts as a pointer to the object. Utilizing the new keyword followed by the class type and parentheses, Java simplifies the creation of new objects, allowing each to possess its unique attributes as defined by the class blueprint. This mechanism facilitates the dynamic generation of objects, each with its distinct state based on the class's specifications.

## Calling Methods

The following is the link to the video which I took notes on.
[Link From Java Hello](https://www.youtube.com/watch?v=Wok4Xw_5cyY&ab_channel=Code.org)

### Notes
- Method is a named set of instructions to perform a task
- Parameter is a variable in the method that defines the type of value to recieve when the method is called
    * ex: Numbers, Text, True or False
- Calling a method
    * NameOfObject.NameOfTheMethod(Argument)
        - Argument is a value passed to a mehthod when the method is called
        - ex: fido.bark();
- Class contains methods and methods are named comands for actions we want to perform

In Java, a method is a named set of instructions designed to perform a specific task, encapsulated within a class to define actions that objects of the class can undertake. Methods may require parameters, which are variables specifying the type of value they accept upon being called—these could range from numbers and text to Boolean values. The process of calling a method involves using the syntax NameOfObject.NameOfTheMethod(Argument), where the argument is the actual value passed to the method. This structure allows classes to contain methods as named commands for actions, enabling objects to execute defined behaviors through method calls, thus facilitating interaction and manipulation of object states and behaviors in a structured manner.





## JavaScript and Jupyter References
