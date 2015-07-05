/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.model;

import com.przemo.busessearchinterfaces.data.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Przemo
 */
@Configuration
public class SessionFactoryBean {
    
    @Bean
    public SessionFactory getSessionFactory(){
        return com.przemo.busessearchinterfaces.data.HibernateUtil.getSessionFactory();
    }
    
    @Bean
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public org.hibernate.Session getNewSession(){
        return HibernateUtil.openNewSession(); 
    }
    
    
}
