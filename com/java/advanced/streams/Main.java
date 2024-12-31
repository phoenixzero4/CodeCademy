package com.java.advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		// intermediate ops 
		
		// map: applies a function to the elements of a stream
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		List<Integer> square = numbers.stream().map( x -> x * x).collect(Collectors.toList());
		System.out.println(square);
		
		// filter: selects elements as per the predicate specified
		List<String> names = Arrays.asList("One", "Two", "Three");
		List<String> find = names.stream()
				.filter(s -> s.startsWith("O"))
				.collect(Collectors.toList());
		System.out.println(find);
		
		// sorted: sorts a stream
		List sorted = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		
		// Terminal ops
		
		// Collect: returns the result of the intermediate operations
		List<Integer> numbers2 = Arrays.asList(1,2,3,4,2);
		Set squareSet = numbers2.stream()
				.map(x -> x * x)
				.collect(Collectors.toSet());
		System.out.println(squareSet);
		
		// forEach: iterates over elements of the stream
		numbers2.stream().map(x -> x * x).forEach( y -> System.out.println(y));
		
		// reduce: reduces the elements of a stream to a single value (param = binary operator)
		int even = numbers.stream().filter(x -> x % 2 == 0).reduce(0,  (answer, i) -> answer + i);
		System.out.println(even);
		
		
	}

}
