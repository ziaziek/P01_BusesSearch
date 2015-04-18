/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch;

import org.apache.wicket.markup.html.basic.Label;

/**
 *
 * @author Przemo
 */
public class HomePage extends BasePage {

    @Override
    protected void initialisePaageContent() {
        add(new Label("homeLabel", "This is Home contents"));
    }
    
}
