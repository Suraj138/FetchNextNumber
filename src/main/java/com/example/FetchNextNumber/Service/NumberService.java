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
        Integer oldValue = number.getValue();
        Integer newValue = calculateNextNumber(oldValue);
        Numbers newNumber = new Numbers();
        newNumber.setCategoryCode(categoryCode);
        newNumber.setValue(newValue);
        numberRepository.save(newNumber);
        Map<String, Integer> result = new HashMap<>();
        result.put("oldValue", oldValue);
        result.put("newValue", newValue);
        return result;
    }


    private Integer calculateNextNumber(Integer oldValue) {
    	int n = oldValue+1;
    	int sum;
    	int temp;
    	boolean flag =false;
    	while(!flag) {
    		sum=0;
    		temp=n;
    		while(n!=0) {
    			sum+=n%10;
    			n/=10;
    			if(sum>9) {
    				n=sum;
    				sum = 0;
    				continue;
    			}
    		}
    		if(sum==1) {
    			flag =true;
    			return temp;
    		}
    		else {
    			temp++;
    			n = temp;
    		}
    	}
    	return n;
    }
    
}
