package com.nighthawk.hacks;

public class StackHeapTest {
    public int n = 5; // primative datatype on the heap
    public static void changeInt(int nValue, int nRefn, StackHeapTest nRef) {
        System.out.println("BEFORE:");
        System.out.println("nValue : " + nValue);
        System.out.println("nRefn : " + nRefn);
        System.out.println("nRef.n : " + nRef.n);
        System.out.println("HashCode : " + System.identityHashCode(nRef));

        nValue += 10;
        nRefn += 10;
        nRef.n += 10;

        System.out.println("AFTER:");
        System.out.println("nValue : " + nValue);
        System.out.println("nRefn  : " + nRefn);
        System.out.println("nRef.n : " + nRef.n);
        System.out.println("HashCode : " + System.identityHashCode(nRef));
    }

    public static void main(String[] args) {
        int n = 5; // primitive datatype on the stack
        StackHeapTest nRef = new StackHeapTest();

        System.out.println("BEFORE:");
        System.out.println("n : " + n);
        System.out.println("nRef : " + nRef);
        System.out.println("nRef.n : " + nRef.n);
        System.out.println("HashCode n : " + System.identityHashCode(n));
        System.out.println("HashCode nRef.n : " + System.identityHashCode(nRef.n));
        System.out.println("HashCode nRef : " + System.identityHashCode(nRef));

        changeInt(n, nRef.n, nRef);  // stack by value, heat by value, heat by reference

        System.out.println("AFTER:");
        System.out.println("n : " + n);
        System.out.println("nRef : " + nRef);
        System.out.println("nRef.n : " + nRef.n);
        System.out.println("HashCode n : " + System.identityHashCode(n));
        System.out.println("HashCode nRef.n : " + System.identityHashCode(nRef.n));
        System.out.println("HashCode : " + System.identityHashCode(nRef));
    }

}