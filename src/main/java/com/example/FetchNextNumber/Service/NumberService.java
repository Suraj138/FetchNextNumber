package com.example.FetchNextNumber.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FetchNextNumber.Model.Numbers;
import com.example.FetchNextNumber.Repository.NumberRepository;

@Service
public class NumberService {

    @Autowired
    private NumberRepository numberRepository;

    public Map<String, Integer> getNextNumber(Integer categoryCode) throws InterruptedException {
        Numbers number = numberRepository.findByCategoryCode(categoryCode);
        Integer oldValue = Optional.ofNullable(number.getValue()).get();
        Integer newValue = getNewValue(oldValue);
        Numbers newNumber = new Numbers();
        newNumber.setCategoryCode(categoryCode);
        newNumber.setValue(newValue);
        numberRepository.save(newNumber);
        Map<String, Integer> result = new HashMap<>();
        result.put("oldValue", oldValue);
        result.put("newValue", newValue);
        return result;
    }


    private int getNewValue(int value) throws InterruptedException {
        while (!isSumOfDigitsOne(value)) {
            Thread.sleep(1000);
            value++;
        }
        return value;
    }

    private boolean isSumOfDigitsOne(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum == 1;
    }
}
