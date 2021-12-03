package CarteEmbarquement;

public class CarteEmbarquementAvion extends CarteEmbarquement implements ICarteEmbarquement
{
    private String porteEmbarquement;
    private String guichetBagages;

    public CarteEmbarquementAvion(String depart, String arrive, String numeroSiege,String numeroTransport, String porteEmbarquement, String guichetBagages)
    {
        super(depart, arrive, numeroSiege, numeroTransport);
        this.porteEmbarquement=porteEmbarquement;
        this.guichetBagages=guichetBagages;
    }

    public String getPorteEmbarquement() {
        return porteEmbarquement;
    }

    public void setPorteEmbarquement(String porteEmbarquement) {
        this.porteEmbarquement = porteEmbarquement;
    }

    public String getGuichetBagages() {
        return guichetBagages;
    }

    public void setGuichetBagages(String guichetBagages) {
        this.guichetBagages = guichetBagages;
    }

    public String getInfos()
    {
        String toreturn = "";
        toreturn+= "Prenez l'avion "+this.getNumeroDuTransport()+ " depuis "+this.getDepart()+" pour aller a "+this.getArrive()+". Embarquement porte "+this.getPorteEmbarquement();
        if(this.getGuichetBagages()!=null)
        {
            toreturn+=", depose des bagages au guichet "+this.getGuichetBagages()+".";
        }else{
            toreturn+=" vos bagages seront directement tranférés a votre prochaine destination.";
        }

        if(this.getNumeroSiege()!=null)
        {
            toreturn+=" Asseyez vous au siege "+this.getNumeroSiege()+".";
        }else{
            toreturn+=" Votre place n'est pas définie dans l'avion.";
        }
        return toreturn;
    }
}
