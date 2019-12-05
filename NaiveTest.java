import java.math.BigInteger;
import java.util.List;

public class NaiveTest
{
	
	private static List<BigInteger> coefficients;
	
	// Deterministic prime numbers : AKS Algorithm
	public static boolean isPrime(BigInteger candidate)
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
	}
	
	public static void calculateCoefficients(BigInteger n) {
		coefficients.clear();
		coefficients.add(BigInteger.ONE);
		for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; coefficients.get(0).negate(), i.add(BigInteger.ONE)) {
			
		}
	}
}