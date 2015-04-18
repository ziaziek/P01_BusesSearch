/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.panels;

import com.przemo.busessearch.AdminPage;
import com.przemo.busessearch.HomePage;
import com.przemo.busessearch.SearchPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Przemos
 */
public class MenuPanel extends Panel {

    public MenuPanel(String id) {
        super(id);
        add(new Link("linkHome"){

            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
            
        });
        add(new Link("linkSearch"){

            @Override
            public void onClick() {
                setResponsePage(SearchPage.class);
            }
            
        });
        
        add(new Link("linkAdmin"){

            @Override
            public void onClick() {
                setResponsePage(AdminPage.class);
            }
            
        });
    }
    
}
