/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.model.SearchResults;
import com.przemo.busessearch.model.StationsSearchCriteria;
import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Timetables;
import com.przemo.busessearchinterfaces.interfaces.ITimetablesService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author Przemo
 */
public class TimetablesPanel extends Panel {

    @SpringBean
    ITimetablesService timetablesService;
   
    private final IModel<SearchResults> model;
    private final IModel<Lines> linesModel;
    
    public TimetablesPanel(String id, String title, IModel<SearchResults> model, IModel<Lines> linesModel) {
        super(id, model);
        this.model=model;
        this.linesModel = linesModel;
        add(new Label("title", Model.of(title)));
        buildTimetables();
    }

    private void buildTimetables() {
        ListView<Timetables> lv = new ListView<Timetables>("timetable", timetablesService.getTimetableForLineStations(((StationsSearchCriteria)model.getObject().getCriteria()).getSfrom(),
                                ((StationsSearchCriteria)model.getObject().getCriteria()).getSto(), linesModel.getObject())) {
            
            @Override
            protected void populateItem(ListItem<Timetables> item) {
                item.add(new Label("station", Model.of(item.getModelObject().getStationsByNodeFrom().getName())));
                item.add(new Label("arrival", Model.of(item.getModelObject().getArriveAtNodeFrom().toString())));
                item.add(new Label("departure", Model.of(item.getModelObject().getDepartToNodeTo().toString())));
            }
        };
        
        add(lv);
    }
    
}
