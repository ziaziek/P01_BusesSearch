/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.data.helpers.QueryHelper;
import com.przemo.busessearchinterfaces.interfaces.ILinesService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemo
 */
@Service
public class DefaultLinesService implements ILinesService{

    @Override
    public List<Lines> getLinesForStations(Stations stationFrom, Stations stationTo) {
        return QueryHelper.getListFromSQLQuery(Stations.class, "select pr_get_line_for_stations("+stationFrom.getId()+","+stationTo.getId()+")");
    }
    
}
