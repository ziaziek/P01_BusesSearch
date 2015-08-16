package com.przemo.busessearch.panels;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Przemo
 */
public class NoResultsAvailablePanel extends Panel {

    public NoResultsAvailablePanel(String id) {
        super(id);
        add(new Label("noresults", Model.of("No results available.")));
    }
    
}
