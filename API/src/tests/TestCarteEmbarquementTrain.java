package tests;

import CarteEmbarquement.CarteEmbarquement;
import org.junit.jupiter.api.Test;
import CarteEmbarquement.CarteEmbarquementTrain;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarteEmbarquementTrain
{
    @Test
    public void testCreationCarteEmbarquementTrain()
    {
        CarteEmbarquementTrain parisNewYork = new CarteEmbarquementTrain("Paris","New York City","14C","AAC11");
        assertEquals(parisNewYork.getDepart(),"Paris");
        assertEquals(parisNewYork.getArrive(),"New York City");
        assertNotEquals(parisNewYork.getArrive(),"NewYorkCity");
    }
}
