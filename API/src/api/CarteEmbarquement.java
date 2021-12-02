package api;

public class CarteEmbarquement
{
    private String depart;
    private String arrive;
    private String typeDeTransport;
    private String numeroDuTransport;
    private String numeroSiege;
    private String porteEmbarquement;
    private String guichetBagages;

    /*
    Constructeur pour une CarteEmbarquement d'avion
     */
    public CarteEmbarquement(String depart, String arrive, String typeDeTransport, String numeroDuTransport, String numeroSiege, String porteEmbarquement, String guichetBagages)
    {
        this.depart=depart;
        this.arrive=arrive;
        this.typeDeTransport=typeDeTransport;
        this.numeroDuTransport=numeroDuTransport;
        this.numeroSiege=numeroSiege;
        this.porteEmbarquement=porteEmbarquement;
        this.guichetBagages=guichetBagages;
    }
    /*
    Constructeur pour un voyage de train
     */
    public CarteEmbarquement(String depart, String arrive, String typeDeTransport, String numeroDuTransport, String numeroSiege)
    {
        this.depart=depart;
        this.arrive=arrive;
        this.typeDeTransport=typeDeTransport;
        this.numeroDuTransport=numeroDuTransport;
        this.numeroSiege=numeroSiege;
    }
    /*
    Getter pour le depart
     */
    public String getDepart() {
        return depart;
    }
    /*
        Setter pour le depart
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }
    /*
        Getter pour l'arrivee
     */
    public String getArrive() {
        return arrive;
    }
    /*
        Setter pour l'arrivee
    */
    public void setArrive(String arrive) {
        this.arrive = arrive;
    }
    /*
        Getter pour le type de transport, avec retour adapte pour l'affichage
     */
    public String getTypeDeTransport() {
        if(this.typeDeTransport.toUpperCase().equals("AVION"))
        {
            return "l'avion";
        }else if(typeDeTransport.toUpperCase().equals("TRAIN"))
        {
            return "le train";
        }
        else return "Mode de transport inconnu";
    }
    /*
        Setter pour le type de transport
     */
    public void setTypeDeTransport(String typeDeTransport) {
        this.typeDeTransport = typeDeTransport;
    }
    /*
        Getter pour le numero de transport
     */
    public String getNumeroDuTransport() {
        return numeroDuTransport;
    }
    /*
        Setter pour le numero de transport
     */
    public void setNumeroDuTransport(String numeroDuTransport) {
        this.numeroDuTransport = numeroDuTransport;
    }
    /*
        Getter pour le numero de siege
     */
    public String getNumeroSiege() {
        return numeroSiege;
    }
    /*
        Setter pour le numero de siege
     */
    public void setNumeroSiege(String numeroSiege) {
        this.numeroSiege = numeroSiege;
    }
    /*
        Getter pour la porte d'embarquement
     */
    public String getPorteEmbarquement() {
        return porteEmbarquement;
    }
    /*
        Setter pour la porte d'embarquement
     */
    public void setPorteEmbarquement(String porteEmbarquement) {
        this.porteEmbarquement = porteEmbarquement;
    }
    /*
        Getter pour le numero du guichet de depose des bagages
     */
    public String getGuichetBagages() {
        return guichetBagages;
    }
    /*
        Setter pour le numero du guichet de depose des bagages
     */
    public void setGuichetBagages(String guichetBagages) {
        this.guichetBagages = guichetBagages;
    }
}
