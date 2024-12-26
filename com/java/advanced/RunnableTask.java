package com.java.advanced;

public class RunnableTask implements Runnable{
	private final long limit;
	
	RunnableTask(long limit){
		this.limit = limit;
	}
	
	@Override
	public void run() {
	
		int sum = 0;
		for(int i = 1; i < limit; i++) {
			sum += limit;
		}
		
		System.out.println(Thread.currentThread().getName() + " " + sum);
	}
}
