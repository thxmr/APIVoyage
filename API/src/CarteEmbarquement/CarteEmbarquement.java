package CarteEmbarquement;

public abstract class CarteEmbarquement implements ICarteEmbarquement
{
    private String depart;
    private String arrive;
    private String numeroSiege;
    private String numeroDuTransport;

/*
Constructeur pour une CarteEmbarquement
 */
    public CarteEmbarquement(String depart, String arrive, String numeroSiege, String numeroTransport) {
        this.depart = depart;
        this.arrive = arrive;
        this.numeroSiege = numeroSiege;
        this.numeroDuTransport = numeroTransport;
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

}
