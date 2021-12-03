package tests;

import CarteEmbarquement.CarteEmbarquement;
import org.junit.jupiter.api.Test;
import CarteEmbarquement.CarteEmbarquementAvion;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarteEmbarquementAvion
{
    @Test
    public void testCreationCarteEmbarquementAvion()
    {
        CarteEmbarquementAvion parisNewYork = new CarteEmbarquementAvion("Paris","New York City","14C","AAC11","14E","7");
        assertEquals(parisNewYork.getDepart(),"Paris");
        assertEquals(parisNewYork.getArrive(),"New York City");
        assertNotEquals(parisNewYork.getArrive(),"NewYorkCity");
    }
}
