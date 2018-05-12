import com.tmays.prime.CalculatePrime;
import org.junit.Test;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

import static org.junit.Assert.assertEquals;

public class CalculatePrimeTest {

    @Test
    public void calculatePrimeOneTest(){
        NavigableSet<Integer> primes = new ConcurrentSkipListSet<>();
        assertEquals(primes, CalculatePrime.calculate(1));
    }

    @Test
    public void calculatePrimeTwoTest(){
        NavigableSet<Integer> primes = new ConcurrentSkipListSet<>(Arrays.asList(2));
        assertEquals(primes, CalculatePrime.calculate(2));
    }

    @Test
    public void calculatePrimeThreeTest(){
        NavigableSet<Integer> primes = new ConcurrentSkipListSet<>(Arrays.asList(2,3));
        assertEquals(primes, CalculatePrime.calculate(3));
    }

    @Test
    public void calculatePrimeOneHundreedTest(){
        NavigableSet<Integer> primes = new ConcurrentSkipListSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        assertEquals(primes, CalculatePrime.calculate(100));
    }


    @Test
    public void calculatePrimeCacheTest(){
        NavigableSet<Integer> primes = new ConcurrentSkipListSet<>(Arrays.asList(2,3));
        assertEquals(primes, CalculatePrime.calculate(3));
        primes = new ConcurrentSkipListSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        assertEquals(primes, CalculatePrime.calculate(97));
        primes = new ConcurrentSkipListSet<>(Arrays.asList(2, 3, 5, 7));
        assertEquals(primes, CalculatePrime.calculate(10));
    }
}
