/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.przemo.busessearch.services;

import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.data.Timetables;
import com.przemo.busessearchinterfaces.data.helpers.QueryHelper;
import com.przemo.busessearchinterfaces.interfaces.ITimetablesService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Przemo
 */
@Service
public class DefaultTimetablesService implements ITimetablesService {

    @Override
    public List<Timetables> getTimetableForLineStations(Stations stationFrom, Stations stationTo, Lines line) {
        if (stationFrom != null && stationTo != null && line != null) {
            List<Timetables> tm = QueryHelper.getListFromHQLQuery("from Timetables t where t.lines.id=" + line.getId()
                    + " order by coalesce(t.arriveAtNodeFrom, '00:00:00')");
                    if(tm.stream().anyMatch(x -> x.getStationsByNodeFrom().getId()==stationFrom.getId()) && 
                            tm.stream().anyMatch(y->y.getStationsByNodeTo().getId()==stationTo.getId())){
                        return filterOrderedTimetables(tm, stationFrom, stationTo);
                    } else {
                        return Collections.EMPTY_LIST;
                    }           
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    protected List<Timetables> filterOrderedTimetables(List<Timetables> tm, Stations stationFrom, Stations stationTo) {
        List<Timetables> aux = new ArrayList<>(tm);
        int ix0=0; boolean fromFound=false;
        int ix1=0; boolean toFound=false;
        Iterator<Timetables> it = tm.iterator();
        while(it.hasNext() && (!fromFound || !toFound)){
            Timetables t = it.next();
            if (!fromFound && t.getStationsByNodeFrom().getId() != stationFrom.getId()) {
                    ix0++;
                } else {
                    fromFound=true;
                }
                if (!toFound && t.getStationsByNodeFrom().getId() != stationTo.getId()) {
                    ix1++;
                } else {
                    toFound=true;
                }
        }
        if(ix1>=ix0){
            return  aux.subList(ix0, ix1+1);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

}
