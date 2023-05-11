package com.example.FetchNextNumber.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {
    Number findByCategoryCode(String categoryCode);
}
