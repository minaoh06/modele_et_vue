package modele;

public class PlageHoraire implements Comparable<PlageHoraire>
{
    final static int DUREE_MIN = 15;
    private Horaire horaireDebut;
    private Horaire horaireFin;

    public PlageHoraire(Horaire hdebut, Horaire hFin)
    {
        horaireDebut = hdebut;
        horaireFin = hFin;
    }

    public void setHoraireDebut(Horaire nHoraire) 
    {
        horaireDebut = nHoraire;
    }
    
    public void setHoraireFin(Horaire nHoraire) 
    {
        horaireFin = nHoraire;
    }
    
    public Horaire getHoaraireDebut() 
    {
        return horaireDebut;
    }
    
    public Horaire getHoaraireFin() 
    {
        return horaireFin;
    }

    public int duree() 
    {
        return horaireFin.toMinutes() - horaireDebut.toMinutes();
    }

    public String dureeToString()
    {
        return "" + (this.duree() / 60) + "h" + (this.duree() % 60) + "min";
    }

    public boolean estValide() 
    {
        if (this.duree() >= DUREE_MIN)
            return true;
        return false;
    }

    public String toString() 
    {
        return "" + horaireDebut.getHeure() + "h" + horaireDebut.getQuartHeure() + " - " +
               horaireFin.getHeure() + "h" + horaireFin.getQuartHeure() + ", " + 
               "durée : " + this.dureeToString();
    }

    public int compareTo(PlageHoraire plage) 
    {
        if(this.horaireFin.toMinutes() <= plage.horaireDebut.toMinutes())
        {
            return -1;
        }
        if(this.horaireDebut.toMinutes() >= plage.horaireFin.toMinutes())
        {
            return 1;
        }
        return 0;
    }

    public int compareTo2(PlageHoraire plage)
    {
        /**
         * Cette focntion retourne une valeur en fonction des position des plage horaires.
         * La valeur retourné est :
         *      0    si les plage horaire sont les même
         * 
         *      -1    si this commence avant plage mais que les horaires de fin sont les meme
         *      1     si this commence après plage mais que les horaires de fin sont les meme
         *      -10   si this fini avant plage mais que les horaires de commencement sont les meme
         *      10    si this fini après plage mais que les horaires de commencement sont les meme
         *      
         *      -11   si this commence avant plage et fini avant plage
         *      9     si this commence avant plage et fini après plage
         *      -9    si this commence après plage et fini avant plage
         *      11    si this commence après plage et fini après plage
         */

        int COMMENCE_AVANT = -1;
        int COMMENCE_APRES = 1;
        int FIN_AVANT = -10;
        int FIN_APRES = 10;

        int valeurRetour = 0;

        if (this.getHoaraireDebut().toMinutes() < plage.getHoaraireDebut().toMinutes())
        {
            //this commence avant plage
            valeurRetour += COMMENCE_AVANT;
        }
        else if (this.getHoaraireDebut().toMinutes() > plage.getHoaraireDebut().toMinutes())
        {
            //this commence apres plage
            valeurRetour += COMMENCE_APRES;
        }

        if (this.getHoaraireFin().toMinutes() < plage.getHoaraireFin().toMinutes())
        {
            //this fini avant plage
            valeurRetour += FIN_AVANT;
        }
        else if (this.getHoaraireFin().toMinutes() > plage.getHoaraireFin().toMinutes())
        {
            //this fini après plage
            valeurRetour += FIN_APRES;
        }
        return valeurRetour;
    }
}