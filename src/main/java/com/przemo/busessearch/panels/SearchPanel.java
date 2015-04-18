/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.services.DefaultStationsService;
import com.przemo.busessearchinterfaces.data.Station;
import com.przemo.busessearchinterfaces.interfaces.IStationsService;
import java.util.Collections;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author Przemo
 */
public class SearchPanel extends Panel{

    private DropDownChoice stationTo;

    private final IStationsService stationsService;
    
    private final IModel<Station> stationsModel;
    
    public SearchPanel(String id) {
        super(id);
        
        stationsService = new DefaultStationsService();
        stationsModel = new Model<>();
        
        Form form = new Form("busesSearch");
        add(form);
        
        form.add(new DropDownChoice("stationFrom",  stationsModel, stationsService.getAllStations(), 
        new StationsChoiceRenderer()){

            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
            
            @Override
            protected void onSelectionChanged(Object StationFrom){
                if(StationFrom!=null && StationFrom instanceof Station){
                   stationTo.setChoices(stationsService.getAvailableStationsFrom((Station) StationFrom)); 
                }
            }
        });
        
        //this dropdown picks up data once the previous has selected the station from
        form.add(createStationsToDropDownChoice(Model.of(Collections.EMPTY_LIST)));
        
        form.add(new Button("submit"){

            @Override
            public void onSubmit() {
                super.onSubmit(); //To change body of generated methods, choose Tools | Templates.
            }
           
        });
    }

    private DropDownChoice createStationsToDropDownChoice(IModel model){
        stationTo = new DropDownChoice("stationTo", model, new StationsChoiceRenderer());
        return stationTo;
    }
    
    
    private class StationsChoiceRenderer implements IChoiceRenderer<Station>{

        @Override
        public Object getDisplayValue(Station object) {
            return object.getName();
        }

        @Override
        public String getIdValue(Station object, int index) {
            return String.valueOf(object.getId());
        }
        
    }
}
