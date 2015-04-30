/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Buses;
import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.interfaces.ILinesService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemo
 */
@Service
public class DefaultLinesService implements ILinesService{

    @Override
    public Lines getLineForStations(Stations stationFrom, Stations stationTo) {
        Lines ret = null;
        if(stationFrom!=null && stationTo!=null && stationFrom.getName().equalsIgnoreCase("trzcianka") && stationTo.getName().equalsIgnoreCase("Piła")){
           ret = new Lines();
           Buses b = new Buses();
           b.setId(1);
           ret.setBuses(b);
           ret.setDecription("Trzcianka-Piła");
        }
        return ret;
    }
    
}
