package com.java.advanced.primeTest;

import java.math.BigInteger;
import java.time.Clock;
import java.util.concurrent.ForkJoinPool;


public class LargestPrimeForkJoin {

	// Time limit (ms)
	static int timeLimit = 5 * 1000; 
	
	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		long start, runtime;
		
		BigInteger largestPrime = BigInteger.valueOf(-1);
		BigInteger n = new BigInteger("341550071728321341550071728321341550071728321341550071728321341550071728321341550071728321321341550071728321341550071728321341550071728321");
		int k = 160;
		start = clock.millis();
		
		int nThreads = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(nThreads);
		
		
		while(true) {
			n = n.add(BigInteger.valueOf(2));
			
			// runtime from start time
			runtime = clock.millis() - start;
			
			// 
			RecursivePrime rPrime = new RecursivePrime(n, k);
			pool.invoke(rPrime);
			
			boolean result = rPrime.result;
			
			if(result) {
				System.out.println("Prime found... " + n);
				largestPrime = n;
			}else {
				System.out.println("Not found");
			}
		}
		
		
	}

}
