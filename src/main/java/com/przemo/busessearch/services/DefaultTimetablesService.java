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
            if (tm.contains(stationFrom) && tm.contains(stationTo)) {
                filterOrderedTimetables(tm, stationFrom, stationTo);
            } else {
                return Collections.emptyList();
            }
            return tm;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    protected final void filterOrderedTimetables(List<Timetables> tm, Stations stationFrom, Stations stationTo) {
        List<Timetables> aux = new ArrayList<>(tm);
        boolean fromToSwitch = true;
        for (Timetables t : aux) {
            if (fromToSwitch) {
                if (t.getStationsByNodeFrom() != stationFrom) {
                    tm.remove(t);
                } else {
                    fromToSwitch = false;
                }
            } else {
                if (t.getStationsByNodeTo() != stationTo) {
                    tm.remove(t);
                }
            }
        }
    }

}
