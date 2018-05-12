package com.tmays.prime;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
public class PrimeInOut {
    private Integer initial;
    private Set<Integer> primes;

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public Set<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(Set<Integer> primes) {
        this.primes = primes;
    }
}
