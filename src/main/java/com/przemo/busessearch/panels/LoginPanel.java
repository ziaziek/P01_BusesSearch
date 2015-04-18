package com.przemo.busessearch.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.value.ValueMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Przemo
 */
public class LoginPanel extends Panel{

    private final ValueMap map = new ValueMap();
    
    private final Label linfo = new Label("loggedInInfo");
    
    public LoginPanel(String id) {
        super(id);
        if(getSession().getAttribute("auth")==null || getSession().getAttribute("auth").equals(0)){
            add(new LoginForm("signInForm", map));
            linfo.setDefaultModel(new org.apache.wicket.model.Model<String>(""));
            add(linfo);
        } else {
            linfo.setDefaultModel(new org.apache.wicket.model.Model<String>("You are already logged in."));
            add(linfo);
        }
    }
    
}
