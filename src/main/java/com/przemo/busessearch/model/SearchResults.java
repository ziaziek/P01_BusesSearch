/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.model;

import java.io.Serializable;

/**
 *
 * @author Przemo
 */
public class SearchResults implements Serializable {
    
    private Object result;

    public SearchResults(){
        
    }
    
    public SearchResults(Object result){
        this.result=result;
    }
    
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    
}
