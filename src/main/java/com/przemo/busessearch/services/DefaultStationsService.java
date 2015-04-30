/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.interfaces.IStationsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemo
 */
@Service
public class DefaultStationsService implements IStationsService, Serializable{

    @Override
    public List<Stations> getAllStations() {
         List<Stations> stations = new ArrayList<>();
        stations.add(new Stations(1, "Trzcianka"));
        stations.add(new Stations(2, "Poznań"));
        stations.add(new Stations(3, "Piła"));
        return stations;
    }

    @Override
    public List<Stations> getAvailableStationsFrom(Stations stationFrom) {
        List<Stations> stations = getAllStations();
        for(Stations s: stations){
            if(s.getName().equals(stationFrom.getName())){
                stations.remove(s);
                break;
            }
        }
        return stations;
    }

    @Override
    public List<Stations> getAvailableStationsTo(Stations stationTo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
