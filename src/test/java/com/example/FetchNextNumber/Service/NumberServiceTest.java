package com.example.FetchNextNumber.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.FetchNextNumber.Model.Numbers;
import com.example.FetchNextNumber.Repository.NumberRepository;



class NumberServiceTest {

    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private NumberService numberService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetNextNumber() throws InterruptedException {
        // Create a mock object for Numbers class
        Numbers number = new Numbers();
        number.setCategoryCode(123);
        number.setValue(10);

        // Define the expected output
        Integer expectedOldValue = 10;
        Integer expectedNewValue = 19;

        // Configure the mock object to return the above number object
        when(numberRepository.findByCategoryCode(123)).thenReturn(number);

        // Invoke the method to be tested
        Map<String, Integer> result = numberService.getNextNumber(123);

        // Verify the output
        assertEquals(expectedOldValue, result.get("oldValue"));
        assertEquals(expectedNewValue, result.get("newValue"));
    }

    @Test
    void testCalculateNextNumber() {
        // Define the input and expected output
        Integer inputValue = 10;
        Integer expectedOutput = 19;

        // Invoke the method to be tested
        Integer result = numberService.calculateNextNumber(inputValue);

        // Verify the output
        assertEquals(expectedOutput, result);
    }

}
