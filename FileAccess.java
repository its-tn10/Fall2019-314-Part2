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
		  Scanner scanner = new Scanner(new File(Config.DATAPATH + filename));
		  // Loop through each prime and append to primes class
		  while (scanner.hasNextBigInteger())
			  primes.addPrime(scanner.nextBigInteger());
		  
		  return true; // No Errors
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }
  
  public static boolean loadCrosses(Primes primes, String filename) {
	  try {
		  Scanner scanner = new Scanner(new File(Config.DATAPATH + filename));
		  // Loop through each prime and append to primes class
		  while (scanner.hasNextLine()) {
			  Scanner line = new Scanner(scanner.nextLine());
			  line.useDelimiter(","); // Each prime is separated by ',' so set it as delimiter for next() functions
			  primes.addCross(new Pair<BigInteger>(line.nextBigInteger(), line.nextBigInteger()));
		  }
		  
		  return true; // No Errors
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }
  
  // TODO: Ask about for-each iterables
  
  public static boolean savePrimes(Primes primes, String filename) {
	  try {
		  PrintWriter file = new PrintWriter(Config.DATAPATH + filename);
		  
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }
  
  public static boolean saveCrosses(Primes primes, String filename) {
	  try {
		  PrintWriter file = new PrintWriter(Config.DATAPATH + filename);
		  
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return false;
  }
}