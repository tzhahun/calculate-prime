import com.tmays.prime.PrimeNumberController;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



public class PrimeControllerTests {


    private MockMvc mockMvc;

   @InjectMocks
    private PrimeNumberController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void controllerShouldReturnClientError() throws Exception {

        this.mockMvc.perform(get("/primes"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void controllerShouldReturnOnePrimeNumber100() throws Exception {
        List<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));

        this.mockMvc.perform(get("/primes/100")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.initial").value("100"))
                .andExpect(jsonPath("$.primes").value(primes));

    }

    @Test
    public void controllerShouldReturnOnePrimeNumber() throws Exception {
        List<Integer> primes = new ArrayList<>(Arrays.asList(2));

        this.mockMvc.perform(get("/primes/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.initial").value("2"))
                .andExpect(jsonPath("$.primes").value(primes));

    }

    @Test
    public void controllerShouldReturnPrimeNumbersUpTo20Xml() throws Exception {
        List<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        this.mockMvc.perform(get("/primes/20")
                .contentType(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(xpath("//primeInOut/initial").string("20"))
                .andExpect(xpath("//primeInOut/primes").nodeCount(primes.size()));

    }

}
