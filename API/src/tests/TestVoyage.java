package tests;

import api.Voyage;
import org.junit.jupiter.api.Test;
import CarteEmbarquement.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestVoyage
{
    @Test
    public void testCreationListeCarteEmbarquement()
    {
        CarteEmbarquementAvion parisNewYork = new CarteEmbarquementAvion("Paris","New York City","14C","UA 142","14E","7");
        CarteEmbarquementTrain newYorkWashington = new CarteEmbarquementTrain("New York City","Washington","11A","UA 155");
        LinkedList<CarteEmbarquement> cartes = new LinkedList<>();

        cartes.add(parisNewYork);
        assertEquals(cartes.contains(parisNewYork),true);
        assertEquals(cartes.getFirst().getDepart(),"Paris");

        cartes.add(newYorkWashington);
        assertEquals(cartes.contains(newYorkWashington),true);
        assertEquals(cartes.getFirst().getDepart(),"Paris");
        assertEquals(cartes.get(1).getDepart(),"New York City");
    }

    @Test
    public void testCreationVoyage()
    {
        CarteEmbarquementAvion parisNewYork = new CarteEmbarquementAvion("Paris","New York City","14C","UA 142","14E","7");
        CarteEmbarquementTrain newYorkWashington = new CarteEmbarquementTrain("New York City","Washington","11A","UA 155");
        LinkedList<CarteEmbarquement> cartes = new LinkedList<>();
        cartes.add(parisNewYork);
        cartes.add(newYorkWashington);

        Voyage trip = new Voyage(cartes);
        assertEquals(trip.getListeCarteNonTrie().contains(parisNewYork),true);
        assertEquals(trip.getListeCarteNonTrie().contains(newYorkWashington),true);
    }

    @Test
    public void testTriVoyage()
    {
        CarteEmbarquementAvion parisNewYork = new CarteEmbarquementAvion("Paris","New York City","14C","UA 142","14E","7");
        CarteEmbarquementTrain newYorkWashington = new CarteEmbarquementTrain("New York City","Washington","11A","UA 155");
        CarteEmbarquementAvion washingtonBesancon = new CarteEmbarquementAvion("Washington","Besancon","21C","UA 187","2A","8");
        LinkedList<CarteEmbarquement> cartes = new LinkedList<>();
        cartes.add(newYorkWashington);
        cartes.add(washingtonBesancon);
        cartes.add(parisNewYork);

        Voyage trip = new Voyage(cartes);
        trip.setTravel();
        assertEquals(trip.getListeTriee().getFirst().getDepart(),"Paris");      //car si les voyages sont triés, le premier voyage devrait partir de Paris
        assertEquals(trip.getListeTriee().getLast().getArrive(),"Besancon");      //car si les voyages sont triés, le dernier voyage devrait arriver a Besancon
    }
}
