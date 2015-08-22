/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearchinterfaces.data.Lines;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Przemo
 */
public class TimetablesPanel extends Panel {

    public TimetablesPanel(String id, IModel<Lines> model) {
        super(id, model);
        add(new Label("decription"));
    }
    
}
