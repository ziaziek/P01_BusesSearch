/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch;

import com.przemo.busessearch.panels.MenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 *
 * @author Przemo
 */
public abstract class BasePage extends WebPage {
    
    public BasePage(){
        super(); 
        add(new Label("bannerLabel", "Buses searcher"));      
        add(new MenuPanel("menuPanel"));
        initialisePaageContent();
    }
    
    protected abstract void  initialisePaageContent();
    
//    @Override
//    public void renderHead(IHeaderResponse resp){
//        PackageResourceReference cssFile = new PackageResourceReference("css/templatemo_style.css");
//        CssHeaderItem cssItem = CssHeaderItem.forReference(cssFile);
//         
//        resp.render(cssItem);
//    }
}
