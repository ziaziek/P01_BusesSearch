package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.przemo.busessearch.services.DefaultTimetablesService;
import com.przemo.busessearchinterfaces.data.Lines;
import com.przemo.busessearchinterfaces.data.Stations;
import com.przemo.busessearchinterfaces.data.Timetables;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Przemo
 */
public class TimetablesServiceTests {
    
    class TimetableServiceStub extends DefaultTimetablesService{
        
        @Override
    public List<Timetables> getTimetableForLineStations(Stations stationFrom, Stations stationTo, Lines line){
        List<Timetables> tm = getLinesListStub();
        filterOrderedTimetables(tm, stationFrom, stationTo);
        return tm;
    }

        
    }
    
    private List<Timetables> getLinesListStub() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    public TimetablesServiceTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void filterTimetablesTest(){
        TimetableServiceStub stub = new TimetableServiceStub();
        Stations st1 = new Stations(1, "Trzcianka");
        Stations st2 = new Stations(2, "Poznań");
        Lines l1 = new Lines();
        l1.setId(1);
        List<Timetables> t = stub.getTimetableForLineStations(st1, st2, l1);
        Assert.assertNotNull(t);

    }
}
