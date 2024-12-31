package com.java.advanced.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ParallelStreams {

	public static void main(String[] args) throws IOException{
		
		File file = new File("./test.txt");
		
		List<String> line = Files.readAllLines(file.toPath());
		System.out.println("Parallel streaming from list");
		
		for(String s: line) {
			System.out.println(s);
		}
		
		line.parallelStream().forEach(System.out::println);
		

	}

}
