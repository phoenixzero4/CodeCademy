package com.java.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{

	private static final int N = 10;
	
	public static void main(String[] args) throws InterruptedException{
		
		ExecutorService executor =  Executors.newFixedThreadPool(N);
		
		for(int i = 0; i <= 500; i++) {
			RunnableTask r = new RunnableTask(1000000000L + i);
			executor.execute(r);
		}
		
		executor.shutdown();
		executor.awaitTermination(30,  TimeUnit.SECONDS);
		System.out.println("Finished all threads");
	}
}
