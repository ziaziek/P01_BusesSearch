/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.interfaces.ILinesService;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author Przemo
 */
public class SearchPanel extends Panel {

    @SpringBean
    private ILinesService lineService;
    
    private Stations[] stations = new Stations[2];

    private static final String resultsComponentId = "results";

    final WebMarkupContainer resPanel;

    public SearchPanel(String id) {
        super(id);
        Form form = new Form("busesSearch");
        resPanel = new WebMarkupContainer(resultsComponentId);
        final SearchStationsPanel stationsPanel = new SearchStationsPanel("stations", new PropertyModel<Stations>(this, "stations.0"), new PropertyModel<Stations>(this, "stations.1"));
        form.add(stationsPanel);
        add(form);
        add(resPanel);

        form.add(new Button("submit") {
            
            @Override
            public void onSubmit() {
                resPanel.replaceWith(new SearchResultsPanel(resultsComponentId,lineService.getLinesForStations(stations[0], stations[1] )));
            }

        });
    }
}
