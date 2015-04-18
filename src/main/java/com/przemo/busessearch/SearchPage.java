/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch;

import com.przemo.busessearch.panels.SearchPanel;

/**
 *
 * @author Przemo
 */
public class SearchPage extends BasePage {

    @Override
    protected void initialisePaageContent() {
        add(new SearchPanel("searchPanel"));
    }
    
    
}
