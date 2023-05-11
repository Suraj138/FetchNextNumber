package com.example.FetchNextNumber.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number")
public class Numbers {
    
    @Id
    @Column(name = "category_code")
    private Integer categoryCode;
    
    @Column(name = "value")
    private Integer value;
    
    // constructors, getters, and setters
    
    public Numbers() {
    }

    public Numbers(Integer categoryCode, Integer value) {
        this.categoryCode = categoryCode;
        this.value = value;
    }
    
    
    public Integer getCategoryCode() {
        return categoryCode;
    }
    
    public void setCategoryCode(Integer categoryCode2) {
        this.categoryCode = categoryCode2;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
    
}
