/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.model;

import com.przemo.busessearchinterfaces.data.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Session getCurrentSession(){
        if(HibernateUtil.getSessionFactory().getCurrentSession()==null || !HibernateUtil.getSessionFactory().getCurrentSession().isOpen()){
            return HibernateUtil.getSessionFactory().openSession();
        } else {
           return HibernateUtil.getSessionFactory().getCurrentSession(); 
        }      
    }
    
    
}
