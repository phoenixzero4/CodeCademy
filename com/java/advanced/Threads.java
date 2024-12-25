package com.java.advanced;

public class Threads extends Thread{
	
	public static void main(String[] args) {
	
		System.out.println("Thread name: " + Thread.currentThread().getName());
		
		Thread one = new Threads();
		one.setName("One");
		one.start();
		
	
	
		
	}
	public void run() {
		System.out.println("Thread name: " + Thread.currentThread().getName());
	}

}
