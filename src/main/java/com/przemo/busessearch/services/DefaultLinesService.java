/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Line;
import com.przemo.busessearchinterfaces.data.Station;
import com.przemo.busessearchinterfaces.interfaces.ILinesService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemo
 */
@Service
public class DefaultLinesService implements ILinesService{

    @Override
    public Line getLineForStations(Station stationFrom, Station stationTo) {
        Line ret = null;
        if(stationFrom!=null && stationTo!=null && stationFrom.getName().equalsIgnoreCase("trzcianka") && stationTo.getName().equalsIgnoreCase("Piła")){
           ret = new Line();
           ret.setIdBus(1);
           ret.setDescription("Trzcianka-Piła");
        }
        return ret;
    }
    
}
