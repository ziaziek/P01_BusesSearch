/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Lines;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Przemo
 */
public class SearchResultsPanel extends Panel {
    
    private final List<Lines> lines;
    
    public SearchResultsPanel(String id, List<Lines> lines) {
        super(id);
        this.lines=lines;    
        buildPanel();
    }
    
    private void buildPanel(){
        ListView<Lines> lv = new ListView<Lines>("listLines", lines) {
            
            @Override
            protected void populateItem(ListItem item) {
                Lines line = (Lines)item.getModelObject();
                item.add(new Label("id", line.getId()));
                item.add(new Label("decription", line.getDecription()));
            }
        };
         
        add(lv);
           
    }
    
}
