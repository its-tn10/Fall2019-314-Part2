// This class is for all our configuration data. By putting it all in one place, we can easily make changes to the program without having to hunt down where in the code a constant is defined.

public class Config {
  public final static String DATAPATH = "data/"; // If you don't know what the static keyword does, you better go look it up now.
  // Prime file: One prime per line.
  public final static String PRIMEFILE = "primes.txt";
  // Cross file: Two primes per line, separated by a comma.
  public final static String CROSSFILE = "crosses.txt";
  public final static String APPLICATIONNAME = "Hexagon Cross for Less"; 
}