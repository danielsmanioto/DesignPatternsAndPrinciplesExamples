package com.mediator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MediatorTest {
    
    private Tower tower;
    private Airplane airplane1;
    private Airplane airplane2;
    
    @Before
    public void setUp() {
        tower = new Tower("Test Tower");
        airplane1 = new Airplane("AA100");
        airplane2 = new Airplane("AA200");
    }
    
    @Test
    public void testRegisterAirplane() {
        tower.registerAirplane(airplane1);
        assertTrue(tower.isRunwayFree());
    }
    
    @Test
    public void testSingleAirplaneLanding() {
        tower.registerAirplane(airplane1);
        airplane1.requestLanding();
        assertEquals(Airplane.Status.LANDED, airplane1.getStatus());
    }
    
    @Test
    public void testMultipleAirplanesQueue() {
        tower.registerAirplane(airplane1);
        tower.registerAirplane(airplane2);
        
        airplane1.requestLanding();
        assertEquals(0, tower.getQueueSize());
        
        airplane2.requestLanding();
        assertEquals(1, tower.getQueueSize());
    }
    
    @Test
    public void testRunwayStatus() {
        tower.registerAirplane(airplane1);
        assertTrue(tower.isRunwayFree());
        
        tower.requestLanding(airplane1);
        assertFalse(tower.isRunwayFree());
    }
}
