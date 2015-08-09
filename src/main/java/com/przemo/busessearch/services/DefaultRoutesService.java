/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Routes;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.data.helpers.QueryHelper;
import com.przemo.busessearchinterfaces.interfaces.IRoutesService;
import java.util.List;

/**
 *
 * @author Przemo
 */
public class DefaultRoutesService implements IRoutesService{

    @Override
    public List<Routes> findRoutesForLineBetween(Stations stationFrom, Stations stationTo, Lines line) {
        return QueryHelper.getListFromHQLQuery("from Routes r where r.idLines="+line.getId());
    }
    
}
