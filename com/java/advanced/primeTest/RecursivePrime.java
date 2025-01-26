package com.java.advanced.primeTest;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class RecursivePrime extends RecursiveAction{

	private BigInteger n;
	private int k;
	public boolean result;
	
	public RecursivePrime (BigInteger n, int k) {
		this.n = n;
		this.k = k;
}
	
private static boolean probablyPrime(BigInteger n, int k) {
	
    // Make sure the input is greater than 3 and is odd
    // compareTo returns -1 for < val and 0 if == val	
    if (n.compareTo(BigInteger.valueOf(3)) <= 0) {
      if (n.compareTo(BigInteger.ZERO) <= 0) {
        System.out.println("Non-positive n passed to prime test.");
        System.exit(0);
      }
      if (n.equals(BigInteger.ONE)) {
        return false;
      }
      return true;
    }
    if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
      return false;
    }

    // n = 2^r * d + 1 with d odd (by factoring out powers of 2 from n-1)
    BigInteger d = n.subtract(BigInteger.ONE);
    BigInteger r = BigInteger.ZERO;
    while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
      d = d.shiftRight(1);
      r = r.add(BigInteger.ONE);
    }

    // Witness loop
    // This repeats k times
    boolean skipOuter;
    for (int i = 0; i < k; i++) {
    	
     // Generate a random BigInt between 2 and n - 2
      BigInteger maxLimit = n.subtract(BigInteger.valueOf(2));
      BigInteger minLimit = BigInteger.valueOf(2);
      BigInteger bigInteger = maxLimit.subtract(minLimit);
      Random randNum = new Random();
      int len = maxLimit.bitLength();
      BigInteger a = new BigInteger(len, randNum);
      if (a.compareTo(minLimit) < 0)
        a = a.add(minLimit);
      if (a.compareTo(bigInteger) >= 0)
        a = a.mod(bigInteger).add(minLimit);

      // x ← a^d mod n
      BigInteger x = a.modPow(d, n);

      // If x = 1 or x = n − 1 then
      if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
        continue;
      }
      skipOuter = false;

      // Repeat r - 1 times
      for (BigInteger j = BigInteger.ZERO; j.compareTo(r.subtract(BigInteger.ONE)) < 0; j = j.add(BigInteger.ONE)) {
    	  
        // x ← x^2 mod n
        x = x.modPow(BigInteger.valueOf(2), n);
        
        // If x = n − 1 then
        if (x.equals(n.subtract(BigInteger.ONE))) {
          skipOuter = true;
          break;
        }
      }

      if (skipOuter) {
        continue;
      }

      // Composite found
      return false;
    }

    // Probably prime found
    return true;
  }
@Override
protected void compute() {
	
}
}