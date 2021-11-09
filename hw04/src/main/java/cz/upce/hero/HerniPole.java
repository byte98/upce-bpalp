/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.hero;

public class HerniPole {
    // konstanty
    public static final int Hranice = 0;
    public static final int Louka = 1;
    public static final int Les = 2;
    public static final int Reka = 3;
    public static final int Most = 4;
    
    // promennych instance
    private int teren;
    private char terenZnak;
    private String popis;
    
    // promenna tridy
    private static int pocetPoliVeHre=0;

    // konstruktor
    public HerniPole (int teren) {
  	pocetPoliVeHre++;         // proměnná třídy
        this.teren = teren;       // proměnná instance
        setTeren(teren);	  // volání další metody
    }

    public int getTeren() {
        return teren;
    }

    public void setTeren(int teren) {
        this.teren = teren;
        switch (teren) {
            case Hranice : 
                 this.terenZnak = '#'; 
                 this.popis = "hranice";
                 break;
            case Louka : 
                this.terenZnak = ' '; 
                this.popis="louka";
                break;
            case Les : 
                this.terenZnak = '|'; 
                this.popis = "les";
                break;
            case Reka : 
                this.terenZnak = '*' ; 
                this.popis = "reka";
                break;
            case Most : 
                this.terenZnak = '='; 
                this.popis="most";
                break;
        } 
    }

    public char getTerenZnak() {
        return terenZnak;
    }

    public void setTerenZnak(char terenZnak) {
        this.terenZnak = terenZnak;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
    
    public boolean jeProstupny () {
        boolean jeProtupny = false;
        switch (this.teren) {
            case Hranice : jeProtupny=false; break;
            case Louka : jeProtupny=true;  break;
            case Les : jeProtupny=false; break; 
            case Reka : jeProtupny=false; break; 
            case Most : jeProtupny=true;  break;
        }
        return jeProtupny;
    }
   
}
