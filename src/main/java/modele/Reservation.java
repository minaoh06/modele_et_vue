package modele;

public class Reservation implements Comparable<Reservation>
{
    private String intitule;
    private Date dateReserve;
    private PlageHoraire plageReserve;
    private String dificulte;
    
    //accesseur
    public String getIntitule() { return intitule; }
    public Date getDate() { return dateReserve; }
    public PlageHoraire getPlageHoraire() { return plageReserve; }
    public String getDificulte() { return dificulte; }

    public Reservation(String argIntitule, Date argDateReserve, PlageHoraire argPlageReserve, String argDificulte)
    {
        intitule = argIntitule;
        dateReserve = argDateReserve;
        plageReserve = argPlageReserve;
        dificulte = argDificulte;
    }

    public String toString()
    {
        return intitule + ", " + dateReserve.toString() + ", " + plageReserve.toString(); 
    }

    public boolean estValide() 
    {
        return dateReserve.estValide() && plageReserve.estValide();
    }

    //Vaut  1 quand this est superieur à l'argument
    //vaut -1 quand this est inferieur à l'argument
    public int compareTo(Reservation reserve) 
    {
        if (dateReserve.compareTo(reserve.dateReserve) < 0) {return -1;}
        if (dateReserve.compareTo(reserve.dateReserve) > 0) {return 1;}
        if (plageReserve.compareTo(reserve.plageReserve) < 0 ) {return -1;} 
        if (plageReserve.compareTo(reserve.plageReserve) > 0 ) {return 1;}
        return 0; 
    }
}