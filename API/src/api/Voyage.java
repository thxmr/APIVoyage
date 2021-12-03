package api;

import CarteEmbarquement.*;

import java.util.LinkedList;


public class Voyage
{
    private final LinkedList<CarteEmbarquement> listeCarteNonTrie;
    private final LinkedList<CarteEmbarquement> listeTriee;

    public Voyage(LinkedList<CarteEmbarquement> listeCarte) {
        this.listeCarteNonTrie = listeCarte;
        this.listeTriee = new LinkedList<CarteEmbarquement>();
    }

    public LinkedList<CarteEmbarquement> getListeCarteNonTrie() {
        return listeCarteNonTrie;
    }

    public LinkedList<CarteEmbarquement> getListeTriee() {
        return listeTriee;
    }
/*
        Cette fonction récupère la premiere carte d'embarquement qui sera utilisé au début du voyage et l'ajoute dans la liste triée. Elle disparait de la liste non-triée.

        D'après l'énoncé, on part et arrive dans deux destinations différentes.
        Etant donné qu'il ne peut y avoir de "boucle" dans la destination (Départ de Paris vers Madrid, Départ de madrid vers Paris (IMPOSSIBLE)), toujours d'après l'énoncé,
        on peut partir du postulat suivant :
        Si une carte d'embarquement possède une ville de départ différente de toutes les villes d'arrivés, alors c'est la première carte d'embarquement.
     */

    public void getTripDeparture()
    {
        for (CarteEmbarquement carte : listeCarteNonTrie)
        {
            int cpt=0;
            for(CarteEmbarquement cartes : listeCarteNonTrie)
            {
                if(carte.getDepart()!=cartes.getArrive())
                {
                    cpt++;
                }
            }
            if(cpt==listeCarteNonTrie.size())
            {
                listeTriee.add(carte);
                listeCarteNonTrie.remove(carte);
                break;
            }
        }
    }
    /*
        Cette fonction ajoute a la liste de carte triée la carte suivante en comparant la destination d'arrivée de la précédente et la destination de départ d'une autre.
        De plus, cette même carte, une fois ajoutée a la liste des cartes triées est retiré de la liste des cartes non-triés.
     */
    public void setNextCard()
    {
        for(CarteEmbarquement carte : listeCarteNonTrie)
        {
            if((listeTriee.getLast().getArrive()==carte.getDepart()) && (listeCarteNonTrie.contains(carte)))
            {
                listeTriee.add(carte);
                listeCarteNonTrie.remove(carte);
            }
        }
    }
    /*
        Cette fonction met en place le voyage.
        Elle commence par déterminer le départ de ce voyage en utilisant getTripDeparture()
        Elle cherche ensuite toutes les cartes suivantes une par une en utilisant setNextCard()2
        Et pour finir, elle affiche la description de ce voyage, une fois construit
    */
    public void setTravel()
    {
        this.getTripDeparture();
        while(!this.listeCarteNonTrie.isEmpty())
        {
            this.setNextCard();
        }
    }

    /*
        Cette fonction créé un affichage qui détaille les étapes et détails du voyage, et ce pour chaque escale.
     */
    public String descriptionTravel() {
        String desc = "";
        if (!this.listeTriee.isEmpty()) {
            for (CarteEmbarquement carte : listeTriee) {
                desc+=carte.getInfos()+"\n";
            }
            desc+="\nVous voila arrive a votre destination !";
            return desc;
        }else{
            return "";
        }
    }


    public static void main(String[] args) {
        CarteEmbarquementTrain niceMarseille =  new CarteEmbarquementTrain("Nice","Marseille","14E","SNCF3442");
        CarteEmbarquementAvion marseilleParis = new CarteEmbarquementAvion("Marseille","Paris","45C","AF1254","4D","8");
        LinkedList<CarteEmbarquement> listeCarte = new LinkedList<>();
        listeCarte.add(niceMarseille);
        listeCarte.add(marseilleParis);
        Voyage voyage = new Voyage(listeCarte);
        voyage.setTravel();
        System.out.println(voyage.descriptionTravel());
    }
}
