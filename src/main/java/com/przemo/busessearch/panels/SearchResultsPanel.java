/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.model.SearchResults;
import com.przemo.busessearchinterfaces.data.Lines;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author Przemo
 */
public class SearchResultsPanel extends Panel {
  
    private ModalWindow modal;
    private static final String modalId = "modal";
    private final IModel<SearchResults> model;
    
    public SearchResultsPanel(String id, IModel<SearchResults> model) {
        super(id);
        this.model=model;
        buildPanel();
    }
    
    private void buildPanel() {
        ListView<Lines> lv = new ListView<Lines>("result", (List<? extends Lines>) model.getObject().getResult()) {
            
            @Override
            protected void populateItem(ListItem item) {
                Lines line = (Lines) item.getModelObject();
                AjaxLink link = new ShowResultsLink("link", Model.of(line));
                link.add(new Label("id", line.getId()));
                item.add(new Label("decription", line.getDecription()));
                item.add(link);
                
            }
            
        };
        add(lv);
        //empty modal not shown at the start
        add(new WebMarkupContainer(modalId).setOutputMarkupId(true));
    }
    
    private ModalWindow buildModal(String id, String title, IModel<Lines> linesModel) {
        ModalWindow m = new ModalWindow(modalId, model);
        m.setContent(new TimetablesPanel("content", title, model,  linesModel));
        m.setTitle("Timetables result.");        
        return m;
    }
    
    private class ShowResultsLink<T> extends AjaxLink<T> {
        
        public ShowResultsLink(String id, IModel<T> model) {
            super(id, model);
        }
        
        @Override
        public void onClick(AjaxRequestTarget target) {
            modal = SearchResultsPanel.this.buildModal(null, "Line timetable", (IModel<Lines>) this.getDefaultModel());
            SearchResultsPanel.this.addOrReplace(modal);
            modal.show(target);
        }
        
    }
}
