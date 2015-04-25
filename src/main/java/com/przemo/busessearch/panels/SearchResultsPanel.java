/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Line;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Przemo
 */
public class SearchResultsPanel extends Panel {
    
    private IModel<Line> model;
    
    public SearchResultsPanel(String id, IModel<Line> model) {
        super(id, model);
        this.model=model;
        buildPanel();
    }

    @Override
    protected void onConfigure() {
        super.onConfigure(); //To change body of generated methods, choose Tools | Templates.
        if(model==null || model.getObject()==null){
            setVisible(false);
        }
    }
    
    public SearchResultsPanel(String id){
        super(id, null);
        buildPanel();
    }
    
    private void buildPanel(){
                 add(new Label("idBus"));
                add(new Label("description"));
           
    }
    
}