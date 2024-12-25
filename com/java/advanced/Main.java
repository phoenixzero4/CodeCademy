package com.java.advanced;

public class Main implements Runnable{
	private final long limit;
	
	public Main(long limit) {
		this.limit = limit;
	}
	public static void main(String[] args) {
		int limit = 10;
		Main thread = new Main(10);
		thread.run();
	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
