/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Station;
import com.przemo.busessearchinterfaces.interfaces.IStationsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Przemo
 */
public class DefaultStationsService implements IStationsService, Serializable{

    @Override
    public List<Station> getAllStations() {
         List<Station> stations = new ArrayList<>();
        stations.add(new Station(1, "Trzcianka"));
        stations.add(new Station(2, "Poznań"));
        stations.add(new Station(3, "Piła"));
        return stations;
    }

    @Override
    public List<Station> getAvailableStationsFrom(Station stationFrom) {
        List<Station> stations = getAllStations();
        for(Station s: stations){
            if(s.getName().equals(stationFrom.getName())){
                stations.remove(s);
                break;
            }
        }
        return stations;
    }

    @Override
    public List<Station> getAvailableStationsTo(Station stationTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
