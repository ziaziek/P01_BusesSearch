/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.model.SearchResults;
import com.przemo.busessearchinterfaces.data.Lines;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Przemo
 */
public class SearchResultsPanel extends Panel {
    
    private ModalWindow modal;
    private static final String modalId = "modal";
    
    public SearchResultsPanel(String id, IModel<SearchResults> model) {
        super(id);
        setDefaultModel(new CompoundPropertyModel<>(model));
        buildPanel();
    }
    
    private void buildPanel() {
        
        ListView<Lines> lv = new ListView<Lines>("result") {
            
            @Override
            protected void populateItem(ListItem item) {
                Lines line = (Lines) item.getModelObject();
                AjaxLink link = new ShowResultsLink("link", new CompoundPropertyModel<>(line), null);
                link.add(new Label("id", line.getId()));
                item.add(new Label("decription", line.getDecription()));
                item.add(link);
                
            }
            
        };
        add(lv);
        add(buildModal(null, null));
    }
    
    private ModalWindow buildModal(String id, IModel model) {
        ModalWindow m = new ModalWindow(modalId, model);
        m.setContent(new TimetablesPanel("content", model));
        m.setTitle("Timetables result.");        
        return m;
    }
    
    private class ShowResultsLink<T> extends AjaxLink<T> {
        
        private final WebMarkupContainer comp;
        
        public ShowResultsLink(String id, IModel<T> model, WebMarkupContainer targetComponent) {
            super(id, model);
            this.comp = targetComponent;
        }
        
        @Override
        public void onClick(AjaxRequestTarget target) {
            modal = buildModal(null, getDefaultModel());
            SearchResultsPanel.this.addOrReplace(modal);
            modal.show(target);
        }
        
    }
}
