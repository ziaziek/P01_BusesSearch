/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.model.SearchResults;
import com.przemo.busessearchinterfaces.data.Lines;
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
                    item.add(new Label("id", line.getId()));
                    item.add(new Label("decription", line.getDecription()));
                }

            };
            add(lv);
    }
}
