/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Routes;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.interfaces.IRoutesService;

/**
 *
 * @author Przemo
 */
public class DefaultRoutesService implements IRoutesService{

    @Override
    public Routes findRoutesBetween(Stations stationFrom, Stations stationTo) {
        return null;
    }
    
}
