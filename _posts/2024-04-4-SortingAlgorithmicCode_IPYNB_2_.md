---
toc: True
comments: True
layout: post
title: Algorithmic Code Sort
description: Showing the sorting of Selection, Insertion, Merge, Bubble, and Quick sort and thier time complexities.
courses: {'csa': {'week': 28}}
type: ccc
authors: Anthony B
---

## Testing the followign Sorting algorithms
- Selection Sort
- Insertion Sort
- Merge Sort
- Bubble Sort
- Quick Sort

### Selection Sort

Selection Sort works by selecting the smallest (or largest, depending on sorting order) element from the unsorted part of the list and swapping it with the first unsorted element. It then moves the boundary between the sorted and unsorted sections one step forward and repeats until the list is fully sorted.

Time Complexity: O($n^2$)


```java
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 92, 95, 23, 73, 89, 14};

        System.out.println("Selection Sort:");
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}

SelectionSort.main(null);
```

    Selection Sort:
    [14, 23, 38, 73, 89, 92, 95]


### Insertion Sort


Insertion Sort builds a sorted list by iteratively taking each element from the unsorted section and inserting it into the correct position in the sorted section.

Time Complexity: O($n^2$)


```java
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Insertion Sort:");
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}

InsertionSort.main(null);
```

    Insertion Sort:
    [11, 12, 22, 25, 34, 64, 90]


### Merge Sort


Merge Sort is a divide-and-conquer algorithm that recursively divides the list into smaller halves until each sublist contains only one element. It then merges these sublists back together in the correct order to produce a sorted list.

Time Complexity: O($n \log(n)$)


```java
public class MergeSort {

    // Method to sort an array using merge sort algorithm
    public void sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = getMiddle(left, right);

            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Getter for the middle index of an array segment
    private int getMiddle(int start, int end) {
        return start + (end - start) / 2;
    }

    // Method to merge two subarrays of arr[]
    private void merge(int arr[], int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // A utility method to print array of size n
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Merge Sort:");
        printArray(arr);
    }
}

MergeSort.main(null);
```

    Merge Sort:
    5 6 7 11 12 13 


### Bubble Sort


Bubble Sort repeatedly iterates through the list, comparing adjacent elements and swapping them if they are in the wrong order. This process is repeated until no swaps are needed, indicating that the list is sorted.

Time Complexity: O($n^2$)


```java
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int l = array.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {57, 20, 22, 66, 19, 50, 85, 81};

        System.out.println("Bubble Sort:");
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

BubbleSort.main(null);
```

    Bubble Sort:
    [19, 20, 22, 50, 57, 66, 81, 85]


### Quick Sort


Quick Sort is another divide-and-conquer algorithm. It selects a "pivot" element from the list and partitions the remaining elements into two groups: those smaller than the pivot and those larger. It then recursively sorts the sublists and recombines them with the pivot in the middle.

Time Complexity: Normally O($n \log(n)$) however, in worse cases can be O($n^2$) in nearly sorted or pivot selection bad.


```java
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // this is where the array is partitioned
            int pi = partition(arr, low, high);
            // sorts the elements before and after the partition
            quickSort(arr, low, pi - 1); // recursive calls
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot defined
        int i = low - 1; // index of the smaller element
        for (int j = low; j < high; j++) {
            // if the element is smaller than the pivot, it is moved to the left
            if (arr[j] < pivot) {
                i++;
                // swapping the array
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swapping the higher value with the pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Quick Sort:");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

QuickSort.main(null);
```

    Quick Sort:
    [11, 12, 22, 25, 34, 64, 90]





```java
import java.util.ArrayList;
import java.util.List;

public class FlowerCollection {

    public static class Flower implements Comparable<Flower> {
        private final int numberPetals;
        private final String name;

        public Flower(int petals, String name) {
            this.numberPetals = petals;
            this.name = name;
        }

        public int getNumberPetals() {
            return numberPetals;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Flower other) {
            return Integer.compare(this.numberPetals, other.numberPetals);
        }

        @Override
        public String toString() {
            return String.format("Flower(%s, petals: %d)", name, numberPetals);
        }
    }

    public static class FlowerIterator {
        private final List<Flower> flowerList;

        public FlowerIterator(List<Flower> flowerList) {
            this.flowerList = flowerList;
        }

        public void bubbleSort() {
            int n = flowerList.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (flowerList.get(j).compareTo(flowerList.get(j + 1)) > 0) {
                        Flower temp = flowerList.get(j);
                        flowerList.set(j, flowerList.get(j + 1));
                        flowerList.set(j + 1, temp);
                    }
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (Flower flower : flowerList) {
                sb.append(flower.toString()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }

    public static class GenerateNecklace {
        public static FlowerIterator generate() {
            List<Flower> flowerNecklace = new ArrayList<>();

            flowerNecklace.add(new Flower(5, "Rose"));
            flowerNecklace.add(new Flower(6, "Lily"));
            flowerNecklace.add(new Flower(4, "Tulip"));
            flowerNecklace.add(new Flower(8, "Daisy"));
            flowerNecklace.add(new Flower(3, "Sunflower"));
            flowerNecklace.add(new Flower(5, "Carnation"));
            flowerNecklace.add(new Flower(7, "Orchid"));
            flowerNecklace.add(new Flower(4, "Daffodil"));
            flowerNecklace.add(new Flower(6, "Peony"));
            flowerNecklace.add(new Flower(5, "Hibiscus"));

            return new FlowerIterator(flowerNecklace);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            FlowerIterator flowerNecklace = GenerateNecklace.generate();

            System.out.println("Forest before sort: " + flowerNecklace);
            flowerNecklace.bubbleSort();
            System.out.println("Forest after sort: " + flowerNecklace);
        }
    }

    public static void runMain() {
        Main.main(null);
    }
}

FlowerCollection.runMain();

```

    Forest before sort: [Flower(Rose, petals: 5), Flower(Lily, petals: 6), Flower(Tulip, petals: 4), Flower(Daisy, petals: 8), Flower(Sunflower, petals: 3), Flower(Carnation, petals: 5), Flower(Orchid, petals: 7), Flower(Daffodil, petals: 4), Flower(Peony, petals: 6), Flower(Hibiscus, petals: 5)]
    Forest after sort: [Flower(Sunflower, petals: 3), Flower(Tulip, petals: 4), Flower(Daffodil, petals: 4), Flower(Rose, petals: 5), Flower(Carnation, petals: 5), Flower(Hibiscus, petals: 5), Flower(Lily, petals: 6), Flower(Peony, petals: 6), Flower(Orchid, petals: 7), Flower(Daisy, petals: 8)]



```java
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class FlowerCollection {

    public static class Flower implements Comparable<Flower> {
        private final int numberPetals;
        private final String name;

        public Flower(int petals, String name) {
            this.numberPetals = petals;
            this.name = name;
        }

        public int getNumberPetals() {
            return numberPetals;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Flower other) {
            return Integer.compare(this.numberPetals, other.numberPetals);
        }

        @Override
        public String toString() {
            return String.format("Flower(%s, petals: %d)", name, numberPetals);
        }
    }

    public static class FlowerIterator {
        private final List<Flower> flowerList;

        public FlowerIterator(List<Flower> flowerList) {
            this.flowerList = flowerList;
        }

        public void bubbleSort() {
            int n = flowerList.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (flowerList.get(j).compareTo(flowerList.get(j + 1)) > 0) {
                        Flower temp = flowerList.get(j);
                        flowerList.set(j, flowerList.get(j + 1));
                        flowerList.set(j + 1, temp);
                    }
                }
            }
        }

        public void selectionSort() {
            int n = flowerList.size();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (flowerList.get(j).compareTo(flowerList.get(minIndex)) < 0) {
                        minIndex = j;
                    }
                }
                // Swap the found minimum element with the first element
                Flower temp = flowerList.get(minIndex);
                flowerList.set(minIndex, flowerList.get(i));
                flowerList.set(i, temp);
            }
        }

        public void insertionSort() {
            int n = flowerList.size();
            for (int i = 1; i < n; i++) {
                Flower key = flowerList.get(i);
                int j = i - 1;
                while (j >= 0 && flowerList.get(j).compareTo(key) > 0) {
                    flowerList.set(j + 1, flowerList.get(j));
                    j--;
                }
                flowerList.set(j + 1, key);
            }
        }

        public void mergeSort(int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(left, mid);
                mergeSort(mid + 1, right);
                merge(left, mid, right);
            }
        }

        private void merge(int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            List<Flower> leftList = new ArrayList<>(flowerList.subList(left, mid + 1));
            List<Flower> rightList = new ArrayList<>(flowerList.subList(mid + 1, right + 1));

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                    flowerList.set(k++, leftList.get(i++));
                } else {
                    flowerList.set(k++, rightList.get(j++));
                }
            }

            while (i < n1) {
                flowerList.set(k++, leftList.get(i++));
            }

            while (j < n2) {
                flowerList.set(k++, rightList.get(j++));
            }
        }

        public void quickSort(int low, int high) {
            if (low < high) {
                int pi = partition(low, high);
                quickSort(low, pi - 1);
                quickSort(pi + 1, high);
            }
        }

        private int partition(int low, int high) {
            Flower pivot = flowerList.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (flowerList.get(j).compareTo(pivot) < 0) {
                    i++;
                    Flower temp = flowerList.get(i);
                    flowerList.set(i, flowerList.get(j));
                    flowerList.set(j, temp);
                }
            }
            Flower temp = flowerList.get(i + 1);
            flowerList.set(i + 1, flowerList.get(high));
            flowerList.set(high, temp);
            return i + 1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (Flower flower : flowerList) {
                sb.append(flower.toString()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }

    public static class GenerateNecklace {
        public static FlowerIterator generate() {
            List<Flower> flowerNecklace = new ArrayList<>();

            flowerNecklace.add(new Flower(5, "Rose"));
            flowerNecklace.add(new Flower(6, "Lily"));
            flowerNecklace.add(new Flower(4, "Tulip"));
            flowerNecklace.add(new Flower(8, "Daisy"));
            flowerNecklace.add(new Flower(3, "Sunflower"));
            flowerNecklace.add(new Flower(5, "Carnation"));
            flowerNecklace.add(new Flower(7, "Orchid"));
            flowerNecklace.add(new Flower(4, "Daffodil"));
            flowerNecklace.add(new Flower(6, "Peony"));
            flowerNecklace.add(new Flower(5, "Hibiscus"));

            return new FlowerIterator(flowerNecklace);
        }
    }

    public static class Main {
        public static void main(String[] args) {
            List<Flower> flowerNecklace = GenerateNecklace.generate();

            System.out.println("Flower Necklace before sort:");
            System.out.println(flowerNecklace);

            System.out.println("\nAfter Bubble Sort:");
            flowerNecklace.bubbleSort();
            System.out.println(flowerNecklace);

            System.out.println("\nAfter Selection Sort:");
            flowerNecklace.selectionSort();
            System.out.println(flowerNecklace);

            System.out.println("\nAfter Insertion Sort:");
            flowerNecklace.insertionSort();
            System.out.println(flowerNecklace);

            System.out.println("\nAfter Merge Sort:");
            flowerNecklace.mergeSort(0, flowerNecklace.size() - 1);
            System.out.println(flowerNecklace);

            System.out.println("\nAfter Quick Sort:");
            flowerNecklace.quickSort(0, flowerNecklace.size() - 1);
            System.out.println(flowerNecklace);
        }
    }

    public static void runMain() {
        Main.main(null);
    }
}

FlowerCollection.runMain();

```


    |               List<Flower> flowerNecklace = GenerateNecklace.generate();

    incompatible types: FlowerCollection.FlowerIterator cannot be converted to java.util.List<FlowerCollection.Flower>

    

    |               flowerNecklace.bubbleSort();

    cannot find symbol

      symbol:   method bubbleSort()

    

    |               flowerNecklace.selectionSort();

    cannot find symbol

      symbol:   method selectionSort()

    

    |               flowerNecklace.insertionSort();

    cannot find symbol

      symbol:   method insertionSort()

    

    |               flowerNecklace.mergeSort(0, flowerNecklace.size() - 1);

    cannot find symbol

      symbol:   method mergeSort(int,int)

    

    |               flowerNecklace.quickSort(0, flowerNecklace.size() - 1);

    cannot find symbol

      symbol:   method quickSort(int,int)

    

