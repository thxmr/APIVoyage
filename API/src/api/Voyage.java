package api;

import java.util.LinkedList;


public class Voyage
{
    private LinkedList<CarteEmbarquement> listeCarteNonTrie;
    private LinkedList<CarteEmbarquement> listeTriee;

    public Voyage(LinkedList<CarteEmbarquement> listeCarte) {
        this.listeCarteNonTrie = listeCarte;
        this.listeTriee = new LinkedList<CarteEmbarquement>();
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
        System.out.println(this.descriptionTravel());
    }

    /*
            Cette fonction créé un affichage qui détaille les étapes et détails du voyage, et ce pour chaque escale.
     */
    public String descriptionTravel()
    {
        String desc = "";
        if(!this.listeTriee.isEmpty()){
            for(CarteEmbarquement carte :listeTriee){
                desc+= "- Prenez "+carte.getTypeDeTransport()+" "+carte.getNumeroDuTransport()+" depuis "+carte.getDepart()+" pour aller a "+carte.getArrive();
                if(carte.getTypeDeTransport()=="l'avion")   //il existe donc une porte d'embarquement
                {
                    desc+=". Embarquement porte "+carte.getPorteEmbarquement();
                    if(carte.getGuichetBagages()!=null)
                    {
                        desc+=", depose des bagages au guichet "+carte.getGuichetBagages();
                    }else{
                        desc+=", vos bagages seront directement transférés a votre prochaine destination";
                    }
                }
                if(carte.getNumeroSiege()!=null)
                {
                    desc+=". Asseyez vous au siege "+carte.getNumeroSiege();
                }else{
                    desc+=". Votre siege n'est pas determine";
                }
                desc+=".\n";
            }
            desc+="Vous etes arrives a votre destination !";
        }else{
            return "Voyage inexistant";
        }
        return desc;
    }


    public static void main(String[] args) {
        CarteEmbarquement NiceMarseille =  new CarteEmbarquement("Nice","Marseille","Avion","AF3442","14E","D4",null);
        CarteEmbarquement MarseilleParis =  new CarteEmbarquement("Marseille","Paris","Avion","AF9887","4C","A8","47");
        CarteEmbarquement LillePuntacana =  new CarteEmbarquement("Lille","Puntacana","Avion","AF9357","62C","A11","37");
        CarteEmbarquement ParisLille =  new CarteEmbarquement("Paris","Lille","Train","SNCF447","88E");
        LinkedList<CarteEmbarquement> listeCarte = new LinkedList<CarteEmbarquement>();
        listeCarte.add(LillePuntacana);
        listeCarte.add(NiceMarseille);
        listeCarte.add(ParisLille);
        listeCarte.add(MarseilleParis);
        Voyage voyage = new Voyage(listeCarte);
        voyage.setTravel();
    }
}
