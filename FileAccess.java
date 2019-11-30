// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;


public class FileAccess {
  
  public static boolean loadPrimes(Primes primes, String filename) {
	  try {
		  Scanner scanner = new Scanner(new File(filename));
		  // Loop through each prime and append to primes class
		  while (scanner.hasNextBigInteger())
			  primes.addPrime(scanner.nextBigInteger());
		  
		  return true; // No Errors
	  } catch (Exception e) {
		  return false;
	  }
  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
	  try {
		  Scanner scanner = new Scanner(new File(filename));
		  // Loop through each prime and append to primes class
		  while (scanner.hasNextLine()) {
			  Scanner line = new Scanner(scanner.nextLine());
			  line.useDelimiter(","); // Each prime is separated by ',' so set it as delimiter for next() functions
			  primes.addCross(new Pair<BigInteger>(line.nextBigInteger(), line.nextBigInteger()));
		  }
		  
		  return true; // No Errors
	  } catch (Exception e) {
		  return false;
	  }
  }

  public static boolean savePrimes(Primes primes, String filename) {
	  try {
		  PrintWriter file = new PrintWriter(filename);
		  Primes.IterablePrimes iterable = primes.iteratePrimes();
		  for (BigInteger prime : iterable) 
			  file.println(prime);
		  
		  file.close();
		  return true;
	  } catch (Exception e) {
		  return false;
	  }
  }
  
  public static boolean saveCrosses(Primes primes, String filename) {
	  try {
		  PrintWriter file = new PrintWriter(filename);
		  Primes.IterableCrosses iterable = primes.iterateCrosses();
		  for (Pair<BigInteger> prime : iterable)
			  file.println(prime.left() + "," + prime.right());
		  
		  file.close();
		  return true;
	  } catch (Exception e) {
		  return false;
	  }
  }
}