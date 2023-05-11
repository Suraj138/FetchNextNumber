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
        Integer categoryCode = Integer.parseInt(request.get("CategoryCode"));
        Map<String, Integer> initialResponse = numberService.getNextNumber(categoryCode);
        Map<String, Integer> response = new HashMap<>();
        response.put("OldValue", initialResponse.get("oldValue"));
        response.put("NewValue", initialResponse.get("newValue"));
        Thread.sleep(5000); // introducing a delay of 5 seconds
        return ResponseEntity.ok(response);
    }
}
