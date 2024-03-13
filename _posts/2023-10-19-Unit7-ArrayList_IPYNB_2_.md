---
toc: True
comments: True
layout: post
title: ArrayLists
description: Lesson on Array Lists
courses: {'csa': {'week': 24}}
type: ccc
authors: Anthony B, Tay K
---

# ArrayLists

- An **ArrayList** is a utility from the ``java.util`` package

- To declare a variable, use the format `ArrayList<DataType> variableName = new ArrayList<DataType>(initial number of elements);`

- Unlike arrays, ArrayLists are mutable (can be resized after initialization)

- Functions as a more versatile array

    - Does technically take more space than an array but for the purposes of CSA it shouldn't matter
<br>
<br>

Difference between Array and Arraylist:


| Array | Arraylist |
| - | - |
| Fixed length | Resizable length |
| Fundamental Java Feature | Part of a Framework |
| An object with no methods | A Class with many methods |
| Not very flexible | Flexible |
| Can store primitives | Cannot store primitives - stores objects instead |


```Java
import java.util.ArrayList;

class ArrayListExample { 
    public static void main(String[] args) 
    { 
        // Size of ArrayList 
        int n = 5; 
  
        // Declaring ArrayList with initial size n 
        ArrayList<Integer> arr1 = new ArrayList<Integer>(n); 
  
        // Declaring ArrayList without initial size
        ArrayList<Integer> arr2 = new ArrayList<Integer>(); 
  
        // Printing ArrayList 
        System.out.println("Array 1:" + arr1); 
        System.out.println("Array 2:" + arr2); 
  
        // Appending new elements to the end of the list 
        for (int i = 1; i <= n; i++) { 
            arr1.add(i); 
            arr2.add(i); 
        } 
  
        // Printing ArrayList 
        System.out.println("Array 1:" + arr1); 
        System.out.println("Array 2:" + arr2); 
    } 
}
ArrayListExample.main(null);
```

    Array 1:[]
    Array 2:[]
    Array 1:[1, 2, 3, 4, 5]
    Array 2:[1, 2, 3, 4, 5]


## Arraylist Methods
- add()
    - Adding a value to the ArrayList
    - Can be used to create an element at a specific index in the ArrayList - when this happens, everything at the positions of index and higher are moved to the right by 1 
- get()
    - Get the value of an index in the ArrayList
- set()
    - Change the value at an index in the ArrayList
- remove()
    - Delete the value at in index in the ArrayList
- clear()
    - Remove all values in an ArrayList
- size()
    - Get the length of the ArrayList


```Java
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println(test.size());
        test.add(1); //index 0
        test.add(2); // index 1
        test.add(3); // index 2
        test.add(4); // index 3
        test.add(5); // index 4
        test.add(6); // index 5
        test.add(7); // index 6

        System.out.println(test);

        int i = test.set(1, 200); // prints what used to be at index 1
        int x = test.remove(4); // prints what was removed

        System.out.println(i);
        System.out.println(x);
        System.out.println(test);
    }
}
Test.main(null);
```

    0
    [1, 2, 3, 4, 5, 6, 7]
    2
    5
    [1, 200, 3, 4, 6, 7]


## Traversing ArrayLists

- Deleting elements in the ArrayList while iterating over the ArrayList needs to be carefully done because the index changes as you delete elements
- Using an enhanced for loop can result in the ConcurrentModificationException error
    - Do not delete elements in an ArrayList while using an enhanced for loop


```Java
public static void main(String[] args)
{
    ArrayList<Integer> arr = new ArrayList<>();        
    arr.add(1);
    arr.add(7);
    arr.add(9);
    arr.add(13);
    arr.add(3);
    arr.add(7);
    arr.add(9);
    arr.add(2);

    for (int i = 0; i < arr.size(); i++) //for loop, would work the same as with an array
    {
        System.out.print(arr.get(i) + " ");
    }
    System.out.println();

    for (Integer i : arr) //enhanced for loop without removing, same as an array
    {
        System.out.print(i + " ");
    }

}
main(null);
```

    1 7 9 13 3 7 9 2 
    1 7 9 13 3 7 9 2 

## Sorting
- There are 2 main sorting algorithms that Collegeboard focuses on, **selection sort** and **insertion sort**

### Built-In Sorting
- Uses the Collections package (import) with the sort() method
- Can sort both alphabetically and numerically
- Also has a built-in reverseSort() method

#### Example of Built-In Sorting


```Java
import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(64);
        arrayList.add(25);
        arrayList.add(12);
        arrayList.add(22);
        arrayList.add(11);

        Collections.sort(arrayList);

        System.out.println("Sorted ArrayList: " + arrayList);

        ArrayList<Character> arrayListX = new ArrayList<>();
        arrayListX.add('T');
        arrayListX.add('G');
        arrayListX.add('E');
        arrayListX.add('B');
        arrayListX.add('M');

        Collections.sort(arrayListX);
        System.out.println ("Second Sorted ArrayList: " +arrayListX);
    }
}
SelectionSort.main(null);
```

### Selection sort
- Selection sort divides the ArrayList into two "subarrays," the first is sorted and the second is unsorted.
- Selection sort is easy to implement and is useful for sorting through small datasets.

### Example of Selection Sort


```Java
import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(64);
        arrayList.add(25);
        arrayList.add(12);
        arrayList.add(22);
        arrayList.add(11);

        selectionSort(arrayList);

        System.out.println("Sorted ArrayList: " + arrayList);
    }

    public static void selectionSort(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at index i
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
    }
}
SelectionSort.main(null);
```

### Insertion Sort
- In insertion sort, we assume that the first element is already sorted
- The second element is then taken and is either inserted before the first element or kept in place to make the first 2 elements sorted
- Insertion sort is adaptive as it does not need to perform as many comparisons and swaps as selection sort. If you expect the data to be partially ordered, insertion sort is the better option.

#### Example of Insertion Sort


```Java
import java.util.ArrayList;

public class InsertionSort {
    public static void insertionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(11);
        arrayList.add(13);
        arrayList.add(5);
        arrayList.add(6);

        System.out.println("Original ArrayList: " + arrayList);

        insertionSort(arrayList);

        System.out.println("Sorted ArrayList: " + arrayList);
    }
}
InsertionSort.main(null);
```

# Hacks

- Write a Java program that creates an ArrayList of integers. Create methods for adding, removing, setting, getting, etc numbers and also sort the list in acending order.
