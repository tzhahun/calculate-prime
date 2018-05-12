package com.tmays.prime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to provide prime numbers in JSON and XML format
 */
@RestController
public class PrimeNumberController {


    /**
     * RESTfull service which calculates and returns all the prime numbers up to and including a number provided.
     * @param number number for which to calculate prime numbers
     * @return an object that  contains all the prime numbers up to and including a number provided and the original number passed from the client
     */
    @RequestMapping(value = "/primes/{number}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody PrimeInOut primes( @PathVariable("number") String number) {
        Integer numberInteger = Integer.parseInt(number);
        PrimeInOut outObject = new PrimeInOut();
        outObject.setInitial(numberInteger);
        outObject.setPrimes(CalculatePrime.calculate(numberInteger));
        return outObject;

    }


}
