package CarteEmbarquement;

public class CarteEmbarquementTrain extends CarteEmbarquement
{
    public CarteEmbarquementTrain(String depart, String arrive, String numeroSiege, String numeroTransport)
    {
        super(depart,arrive,numeroSiege,numeroTransport);
    }

    public CarteEmbarquementTrain()
    {
        super(null,null,null,null);
    }

    public String getInfos()
    {
        String toreturn = "";
        toreturn+= "Prenez le train "+this.getNumeroDuTransport()+ " depuis "+this.getDepart()+" pour aller a "+this.getArrive()+".";
        if(this.getNumeroSiege()!=null)
        {
            toreturn+= " Asseyez vous au siege "+this.getNumeroSiege()+".";
        }else{
            toreturn+= " Votre place dans le train n'est pas definie.";
        }

        return toreturn;
    }
}
