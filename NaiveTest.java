import java.math.BigInteger;

public class NaiveTest
{
	// O(n^2)
	/*public static boolean isPrime(BigInteger candidate)
	{
		if (!candidate.isProbablePrime((100))) return false; // Weed out the likely not primes.
		
		BigInteger loopStop = candidate.sqrt().add(BigInteger.ONE);

		for (BigInteger outerIndex = BigInteger.TWO; !outerIndex.equals(loopStop); outerIndex = outerIndex.add(BigInteger.ONE))
		{
			for (BigInteger innerIndex = outerIndex; !innerIndex.equals(loopStop); innerIndex = innerIndex.add(BigInteger.ONE))
			{
				if (candidate.equals(innerIndex.multiply(outerIndex))) return false;
			}
		}
		return true;
	}*/
	
	// O(n)
	// https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/ : OPTIMIZED SCHOOL METHOD
	public static boolean isPrime(BigInteger candidate)
	{
		if (!candidate.isProbablePrime(100))	return false;
		if (candidate.compareTo(BigInteger.ONE) <= 0)	return false;
		if (candidate.compareTo(BigInteger.TWO.add(BigInteger.ONE)) <= 0)	return true;
		
		if (candidate.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0 || candidate.compareTo(BigInteger.TWO.add(BigInteger.ONE)) == 0)	return false;
		
		BigInteger i = BigInteger.valueOf(5);
		for (; (i.multiply(i)).compareTo(candidate) <= 0; i = i.add(BigInteger.valueOf(6))) {
			if (candidate.mod(i).compareTo(BigInteger.ZERO) == 0 || candidate.mod(i.add(BigInteger.TWO)).compareTo(BigInteger.ZERO) == 0)
				return false;
		}
		
		return true;
	}
}