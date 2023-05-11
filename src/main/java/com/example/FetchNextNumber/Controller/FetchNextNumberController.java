package com.example.FetchNextNumber.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FetchNextNumber.Service.NumberService;

@RestController
@RequestMapping("/FetchNextNumber")
public class FetchNextNumberController {

    @Autowired
    private NumberService numberService;

    @PostMapping
    public ResponseEntity<Map<String, Integer>> fetchNextNumber(@RequestBody Map<String, String> request) throws InterruptedException {
        String categoryCode = request.get("CategoryCode");
        int fetchedValue = fetchNextNumberService.fetchNumber(categoryCode);
        int nextValue = fetchNextNumberService.calculateNextNumber(fetchedValue);
        numberService.updateNumber(categoryCode, nextValue);
        Map<String, Integer> response = new HashMap<>();
        response.put("OldValue", fetchedValue);
        response.put("NewValue", nextValue);
        Thread.sleep(5000); // introducing a delay of 5 seconds
        return ResponseEntity.ok(response);
    }
}
