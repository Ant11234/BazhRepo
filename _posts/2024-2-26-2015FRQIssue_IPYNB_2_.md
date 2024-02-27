---
toc: True
comments: True
layout: post
title: 2015 FRQ Issue
description: None
type: ccc
courses: {'csa': {'week': 21}}
---

# 2015 College Board FRQ

## FRQ 1 (Array/ ArrayLists and 2D Arrays)

### Connection to American Sign Language AI Project CSA
This question from the 2015 College Board FRQ has 3 parts and centers around arrays and array lists. Throughout this trimester and especially in my ASL project, I've had to use arrays in order to process the frame data from the webcam. We stored all the frame data as an 784 element array (28*28 pixels) in order to have an easier time reading and testing on the data. In one of the sections of the code I created, I had to read the data uploaded by Ethan Tran's frame API onto /mnist. In doing so I learned a lot about how to use arrays from the difficulties I experienced trying to implement it.


```python
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

        double rate = 0.05;
        int epoch = 500;  //change to 50 in final version
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

```

Additionally, the weights of the AI neural network were stored as an Array. These weights are changed during AI training based on the results of the AI predictions and how accurate predictions are. This made the implementation of the weights array a lot more difficult than the others arrays I've previously created because we need to constantly change the weights based on the derivative of the loss function. Indeed, this is how  AI training usually works - the derivatives  help to find where the minimum of the loss function is, which is where the AI model is the most accurate. Also different types of loss functions can be used but it has to somehow reflect how accurate the model is. In our case we use a simple "expected value - predicted value" function, so when the model is accurate the loss function would output 0 and when its not accurate it will output a non-zero number. We use this function to change the weights: w = w - lr(dL/dw), where the new weight is obtained from old one based on the learning rate (lr) and the derivative of the loss function (L) in respect to that specfic weight (w). This allows the weights to change to reach the minima of the loss function where our model is the most accurate. 


```python
double[][] weights = new double[25][785];
```

Furthermore, we also have to multiply arrays when we are testing and getting our predictions in order to get our y_pred value, which can basically just be thought of as a confidence value for that specific percepetron. By finding y_pred value for all 26 perceptrons, we can determine which perceptron is the most confident by finding the largest y_pred value. This tells us what letter the model believes the image is. In the code below we use xt which stands for x test, a K * 748 array which contains 748  brightness values for K images we are currently testing on, and weights, another 26 * 749 array which contains all the 748 weights, plus one bias, for all the 26 perceptrons. During testing, for each perceptron, we multiply  each weight by the brightness of each pixel, add bias, and add the result to y_pred. If the pixel is bright in the image, and the weight has a high value for that specific pixel, the y_pred would increase by a lot, whereas if the pixel brightness is low or the weight at the pixel your looking at is low, the y_pred would only increase insignificantly. By setting it up like this, the y_pred value is the greatest when the brightest pixels in the testing image overlaps with the highest values in the weights array. During training phase each perceptron develops its own set of weights that are tuned to match one specific class of letters.


```python
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
```

One reason I like this project so much is because it takes the things I've been learning in math, which sometimes seems like it has no point, and actually creates a use for it. I love math and seeing how the multiplying of arrays that we use in the AI model stems from AP Calc AB and the derivative of the loss function in order to find the minimum stems from Calc BC is super interesting to me.

## FRQ 2 (Classes)

### Connection to American Sign Language AI Project CSA
Question 2 of the FRQ asked students to create a HiddenWorld class and create a wordle-type game where, based on the input, you would know which letters are in the correct place, which ones are in the word but not in the right place, and which letter is not in the word at all. Our AI project used tons of classes and methods within those classes in order to get the functions to be called from within other sections of the code.


```python
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

        double rate = 0.05;
        int epoch = 500;  //change to 50 in final version
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

By storing all the functions for the AI model in one class, it makes it way easier to call those functions from within other files, and its more organized to see where our training is, our prediction, and all the other functions that we need to get the AI model working. This is much like how in the Hidden word class, there are two functions inside pertraining to the game. By having the class encapsilate all the objects and functions needed for predictions it makes it more intuitive and easier to experiment with, to improve and to make sure data are safe for each class. Because of our team's organizational skills, I do not believe that we will face to much difficulty while adding improvments to our project during trimester 3. We have an extremely good foundation to improve the project. By increasing the resolution and contrast of the image, so that the hand is the only pixels lit up in the image, we can get our AI to be much more accurate. Because of how we organized our code, we shouldn't find too much difficulty in changing the resolution of the images, or adding another function that increases the contrast, and making our ASL AI project better. We can also add hidden layers to the AI network to make it more accurate.

## FRQ 3 (2D Arrays and Control Structures)

### Connection to American Sign Language AI Project CSA
The third FRQ had both 2D arrays and control structures in both parts. Part A of the question asked students to write a method that returned the value of a specific element, based on the column and row, in an array. Whereas part B of the question asked the students to remove a column from the array. A similar example in my ASL Project is the recieve data and predict method and controller in the prediction API controller.


```python
@PostMapping("/smnist")
 //   public ResponseEntity<String> receiveDataAndPredict(@RequestBody List<Integer> mnistData) {
    public ResponseEntity<String> receiveDataAndPredict(@RequestBody List<List<Integer>> mnistData) {

        System.out.println("---------PostMapping");
        String predictionResult = predictionService.predictAndSave(mnistData);
        System.out.println("predictionResult=" + predictionResult);
        return new ResponseEntity<>(predictionResult, HttpStatus.OK);
    }
```

This is my favorite part that I created out of the whole ASL AI project. It uses all the functions up until now and combines it perfectly within a single function. Although some of the other pieces of the code I created were more complex and technically difficult, like the actual AI model, I'm proud of this one in particular because of how it uses the data from the frames endpoint, and calls in functions from other files all into one well written function that if you run, will do everything needed in the code. How this code works is that it waits until it recieves a post request to /smnist which happens whenever new frame data gets uploaded to the /mnist endpoint. Then it takes in that mnist data and runs it through the function predictandsave from within prediction service. The predictandsave function uses prediction logic, that has already being trained after we start up the backend, in order to make a prediction based on the mnist data and save it to a jpa repository. Then after recieving the result as a single letter string, it prints it out and sends a print statement.

## FRQ 4 (Interfaces, Methods, and Control Structures)

### Connection to American Sign Language AI Project CSA
This topic was also quite new to me. Theres no python equivilent, at least not that I know of, for interfaces. It took tons of reasearch and watching videos in order to understand how they work. Classes were also used in this frq along with methods and control structures in order to find out whether a number fell within a certain range.


```python
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

        double rate = 0.05;
        int epoch = 500;  //change to 50 in final version
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
```

In the code above I use the method innit and the control structure @PostConstruct in order to have the trainlogic function run whenever the bean is initialized. This was a huge improvement for the project because previously it would train the AI model every single time you would test, so by sepereating the training and testing into two different functions I was able to have only the testing occur when it starts recieving images, and to just save the weights from when it ran in the beggining when the bean was initiallized. Additionally one thing we could do to even go a step further is to just remove the train logic function all together and just save the weights from a previous attempt. This however could prove quite difficult because in order to make our model more accurate we have to adjust trainlogic. Despite its potential downsides this would cut our training time from ~5 minutes every time the code is run, to eventually nothing. This maybe even more important if we try to augment our training data by creating images with different contrast or brightness, which will increae training time. This is something cool that I want to try because I've never experimented with saving weights from one run to another, and I'm interested to see how much faster it would make our model.

# Reflections/ Key Takeaways/ Observations

- While working on the FRQ's I feel as if I broadened my knowledge on java altogether. Learning about interfaces, classes, or working to debug a code, I now see the benefits that stem from practcing with these college board tests. Additionally, I feel as if seeing the connections between the college board questions and my project helps me understand the importance behind what I'm doing in my project, and gives me ideas on where else I can implement them. I also feel as if I have a better understanding about the format of the college board test. I did the AP test for CSP last year and I recieved a good score but I never did that much practice for it because my online course didn't provide it. I enjoy these oppurtunities to experince new (at least for me) parts of Java because I've never been given that oppurtunity before. I found it quite difficult, in a good way, how they implemented multiple units into every single question with no two parts of the same question following the same theme. This provided a worth while challenge because getting all these segments of code working in Unison taught me a lot about debugging, a skill I hope to use in the Trimester 3 Project. 
- One thing I need to work on is my time for some of these questions. If I were to perform how I did on some of the question on the actual AP test, I think I would run out of time before finishing due to only 4 frq's taking me 5 hours.
- These FRQ's give me motivation to work on and improve our ASL project. I feel as if by taking the skills I learned from FRQ's, like debugging, interfaces, and so forth into our ASL code, we could make certain sections of it better, for example by reducing training time or creating functions that increase the contrast, so the weights are constantly being multiplied by overly saturated numbers, that will improve accuracy of prediction.
