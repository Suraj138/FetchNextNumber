package com.example.FetchNextNumber.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FetchNextNumber.Model.Numbers;

public interface NumberRepository extends JpaRepository<Numbers, Long> {
    Numbers findByCategoryCode(Integer categoryCode);
    
    

}
