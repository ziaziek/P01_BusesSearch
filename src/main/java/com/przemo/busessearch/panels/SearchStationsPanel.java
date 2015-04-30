/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.interfaces.IStationsService;
import java.util.Collections;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author Przemo
 */
public class SearchStationsPanel extends Panel {

    @SpringBean
    private IStationsService stationsService;
    
    private DropDownChoice stationTo;

    private final IModel<Stations> modelStationFrom, modelStationTo;
    
    public SearchStationsPanel(String id, IModel<Stations> modelStationFrom, IModel<Stations> modelStationTo) {
        super(id);
        this.modelStationFrom=modelStationFrom;
        this.modelStationTo=modelStationTo;
        buildPanel();  
    }

    private void buildPanel() {
        Form<Stations> form = new Form<>("form");
        form.add(new DropDownChoice("stationFrom", modelStationFrom, stationsService.getAllStations(),
                new StationsChoiceRenderer()) {

                    @Override
                    protected boolean wantOnSelectionChangedNotifications() {
                        return true;
                    }

                    @Override
                    protected void onSelectionChanged(Object StationFrom) {
                        if (StationFrom != null && StationFrom instanceof Stations) {
                            stationTo.setChoices(stationsService.getAvailableStationsFrom((Stations) StationFrom));
                        }
                    }
                }
        );

        //this dropdown picks up data once the previous has selected the station from.
        //Initially fill it up with an empty list
        form.add(createStationsToDropDownChoice(Model.of(Collections.EMPTY_LIST)));
        
        add(form);

    }
    
    private DropDownChoice createStationsToDropDownChoice(final IModel<Stations> model) {
        stationTo = new DropDownChoice("stationTo", modelStationTo, Collections.EMPTY_LIST, new StationsChoiceRenderer()) {
        };
        return stationTo;
    }

    class StationsChoiceRenderer implements IChoiceRenderer<Stations> {

        @Override
        public Object getDisplayValue(Stations object) {
            return object.getName();
        }

        @Override
        public String getIdValue(Stations object, int index) {
            return String.valueOf(object.getId());
        }

    }
   
}


