/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.model;

import com.przemo.busessearchinterfaces.data.Stations;

/**
 *
 * @author Przemo
 */
public class StationsSearchCriteria implements SearchCriteria<Stations>{
    
    private final Stations sfrom, sto;

    public Stations getSfrom() {
        return sfrom;
    }

    public Stations getSto() {
        return sto;
    }
    
    public StationsSearchCriteria(Stations stationFrom, Stations stationTo){
        sfrom = stationFrom;
        sto=stationTo;
    }
    
}
