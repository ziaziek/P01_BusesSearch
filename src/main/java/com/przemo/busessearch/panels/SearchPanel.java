/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.model.SearchResults;
import com.przemo.busessearch.model.StationsSearchCriteria;
import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.interfaces.ILinesService;
import java.util.List;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 *
 * @author Przemo
 */
public class SearchPanel extends Panel {

    @SpringBean
    private ILinesService lineService;

    private final IModel<SearchResults> resultsModel;
    
    private static final String resultsComponentId = "results";
    
    final WebMarkupContainer resPanel;

    public SearchPanel(String id) {
        super(id);   
        resultsModel = new Model<>(buildModelObject());
        Form<Void> form = new Form<>("busesSearch");
        resPanel = new WebMarkupContainer("resultsContainer");
        resPanel.add(new WebMarkupContainer(resultsComponentId));
        final SearchStationsPanel stationsPanel = new SearchStationsPanel("stations", new CompoundPropertyModel<>((StationsSearchCriteria)resultsModel.getObject().getCriteria()));
        form.add(stationsPanel); 
        stationsPanel.setOutputMarkupId(true);
        form.setOutputMarkupId(true);
        resPanel.setOutputMarkupId(true);
        form.add(new AjaxButton("submit", form) {
            
            @Override
            public void onSubmit(AjaxRequestTarget target, Form<?> form) {
                
            }
        }.add(new AjaxEventBehavior("click") {
            
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                StationsSearchCriteria crit = (StationsSearchCriteria)resultsModel.getObject().getCriteria();
                List<Lines> res = lineService.getLinesForStations(crit.getSfrom(), crit.getSto());
                if (!res.isEmpty() && res.get(0)!=null) {
                    resultsModel.getObject().setResult(res);
                    resPanel.addOrReplace(new SearchResultsPanel(resultsComponentId, resultsModel));                 
                } else {
                    resPanel.addOrReplace(new NoResultsAvailablePanel(resultsComponentId));
                }
                target.add(resPanel);
            }
        }));
        add(resPanel);
        add(form);
        
    }
    
    private SearchResults buildModelObject(){
        SearchResults modelObject = new SearchResults<>();
        modelObject.setCriteria(new StationsSearchCriteria(null, null));
        return modelObject;
    }
}
