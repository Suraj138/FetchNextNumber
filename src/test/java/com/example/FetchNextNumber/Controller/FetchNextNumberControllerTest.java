package com.example.FetchNextNumber.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.FetchNextNumber.Service.NumberService;

public class FetchNextNumberControllerTest {

    @Mock
    private NumberService numberService;

    @InjectMocks
    private FetchNextNumberController fetchNextNumberController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchNextNumber() throws InterruptedException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("CategoryCode", "1");

        Map<String, Integer> response = new HashMap<>();
        response.put("oldValue", 10);
        response.put("newValue", 19);
        when(numberService.getNextNumber(anyInt())).thenReturn(response);

        ResponseEntity<Map<String, Integer>> actualResponse = fetchNextNumberController.fetchNextNumber(requestBody);

        Map<String, Integer> expectedResponse = new HashMap<>();
        expectedResponse.put("OldValue", 10);
        expectedResponse.put("NewValue", 19);
        ResponseEntity<Map<String, Integer>> expected = new ResponseEntity<>(expectedResponse, HttpStatus.OK);

        assertEquals(expected, actualResponse);
    }
}
