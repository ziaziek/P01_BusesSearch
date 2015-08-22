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
 * @param <C>
 * @param <T>
 */
public class SearchResults<C, T> implements Serializable {
    
    private SearchCriteria<C> criteria;

    public SearchCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }
    
    private T result;

    public SearchResults(){
        
    }
    
    public SearchResults(T result){
        this.result=result;
    }
    
    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    
}
