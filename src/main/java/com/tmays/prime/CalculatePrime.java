package com.tmays.prime;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Calculate Prime numbers
 */
public class CalculatePrime {

    private static NavigableSet<Integer> primesCache= new ConcurrentSkipListSet<>();
    static{
        primesCache.add(2);
        primesCache.add(3);

    }

    /**
     * Calculates and returns all the prime numbers up to and including a number provided.
     * @param number number provided
     * @return all the prime numbers up to and including a number provided
     */
    public static NavigableSet<Integer> calculate(int number) {

        if (primesCache.last() < number) {
            for (int i = primesCache.last(); i <= number; i += 2) {
                if (isPrime(i)) {
                    primesCache.add(i);
                }
            }
        }
        return primesCache.headSet(number, true);
    }


    private static boolean isPrime(int number) {
        double maxNumberToCheck = Math.sqrt(number);

        for(Integer prime: primesCache){
            if (prime <=  maxNumberToCheck && number % prime == 0) {
                return false;
            }
        }

        for (int i =  primesCache.last();  i <=  maxNumberToCheck; i += 2) {
                if (number % i == 0) {
                    return false;
                }

        }
        return true;
    }

}
