/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.BasePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;

/**
 *
 * @author Przemo
 */
public class LoginForm extends Form {
    
    ValueMap m;
    
    public LoginForm(String id, ValueMap map) {
        super(id);
        add(new TextField("username", new PropertyModel(map, "username")));
        add(new PasswordTextField( "password", new PropertyModel<String>(map, "password")));
        this.m=map;
    }
    
    @Override
    public final void onSubmit(){
        if(m.getString("password").equals("derek") && m.getString("username").equals("test")){
            getSession().setAttribute("auth", 1);
            setResponsePage(BasePage.class);
        } else {
            getSession().setAttribute("auth", 0);
        }
    }
    
}
