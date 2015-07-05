/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Lines;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Przemo
 */
public class SearchResultsPanel extends Panel {
    
    private IModel<Lines> model;
    
    public SearchResultsPanel(String id, IModel<Lines> model) {
        super(id, model);
        this.model=model;
        setDefaultModel(model);
        buildPanel();
    }
    
    public SearchResultsPanel(String id){
        super(id, null);
        buildPanel();
    }
    
    private void buildPanel(){
                 add(new Label("id"));
                add(new Label("decription"));
           
    }
    
}
