package com.java.advanced;

import java.math.BigInteger;
import java.time.Clock;
import java.util.concurrent.ForkJoinPool;

public class BigIntMain {
  public static void main(String[] args) {
    Clock clock = Clock.systemDefaultZone();
    long start, stop;
    int upperBound = 5000;
    MakeBigIntArray test = new MakeBigIntArray(upperBound);
    
    // Check the number of available processors
    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println("Number of threads: " + nThreads);
    
    Runtime.getRuntime().totalMemory();
    
    
    // Print outs for threaded results
    RecursiveFactorial rSum = new RecursiveFactorial(test.getList());
    ForkJoinPool pool = new ForkJoinPool(nThreads);

    start = clock.millis();
    pool.invoke(rSum);
    stop = clock.millis();
    long recursiveTime = stop - start;
    
    BigInteger result = rSum.result;
    System.out.println("\nRecursive Factorial of " + upperBound);
    System.out.println("Time in ms (recursion): " + (stop - start));
    System.out.println("Pooled Result: " + result);



    // Print outs for sequential results
    BigInteger sum = new BigInteger("1");
    System.out.println("\nSequential Factorial of " + upperBound);
    
    start = clock.millis();
    for (int i = 0; i < test.getList().length; i++) {
        sum = sum.multiply(test.getList()[i]);
    }
    stop = clock.millis();
    long sequentialTime = (stop - start);
    
    System.out.println("Time in ms (sequential): " + (stop - start));
    System.out.println("Serial Result: " + sum);
    System.err.println("\nRecursion with ForkJoinPool is " + (sequentialTime - recursiveTime) + " ms faster than processing sequentially with a for loop");
    
  }
}
