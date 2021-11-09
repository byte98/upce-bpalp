/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.hero;

/**
 *
 * @author mpozd
 */
public class HerniPlan {
    private int sirka=10;	// šírka plánu
    private int vyska=10;       // výška plánu
    private int pocetLesu=4;	// počet lesů pro generování
    
    // dvourozměrné pole herních polí
    // první index určuje řádek, druhý index sloupec v řádku
    private HerniPole herniPlan[][];
    
    public HerniPlan() {
        // generuje herní plán výchozích rozměrů
        generujHerniPlan();
    }
    
    public HerniPlan (int sirka, int vyska) {
        // generuje herní plán zadaných rozměrů
        this.sirka=sirka;
        this.vyska=vyska;
        generujHerniPlan();
    }
    
    public int nahodnaPoziceSirka() {
        // negenerují se hranice
        return (int)(Math.random()*(sirka -2) +1);
    }
    
    public int nahodnaPoziceVyska() {
        return (int)(Math.random()*(vyska -2) +1);
    }
    
    public void vypis () {
        // vnořené cykly pro výpis dvourozměrného pole
        // volání metody pro zjištění znaku odpovídajícího terénu 
        for (int i = 0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                System.out.print (herniPlan[i][j].getTerenZnak()+" ");
            }
            System.out.println("");
        }
    }
    
    private void generujHerniPlan() {
        int rekaSloupec;
        int mostRadek;
        int poziceSirka;
        int poziceVyska;
        
        // vytvoření instance dvourozměrného pole
        herniPlan=new HerniPole[vyska][sirka];

        // vytvoreni hranic
        for (int i=0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                if (i == 0 || j ==0 || i == vyska-1 || j == sirka -1) {
                    herniPlan[i][j]=new HerniPole(HerniPole.Hranice);
                }
            }  
        }
        
        // vygenerovani nahodne pozice reky a mostu
        rekaSloupec=(int) (Math.random() * (sirka - 4) + 2);
        mostRadek=(int) (Math.random() * (vyska - 2) + 1);
        
        for (int i=1; i< vyska - 1; i++) {
            if (i==mostRadek) {
                herniPlan[i][rekaSloupec]=new HerniPole(HerniPole.Most);
            } else {
                herniPlan[i][rekaSloupec] = new HerniPole(HerniPole.Reka);
            }
        }

        // vygenerovani lesu
        int pocetVygenerovanychLesu = 0;
        while (pocetVygenerovanychLesu < this.pocetLesu)
        {
            // mozne pozice pro les
            int lesSirka = this.nahodnaPoziceSirka();
            int lesVyska = this.nahodnaPoziceVyska();
            
            if (herniPlan[lesSirka][lesVyska] == null) // misto pro les je prazdne
            {
                herniPlan[lesSirka][lesVyska] = new HerniPole(HerniPole.Les);
                pocetVygenerovanychLesu ++;
                // vygenerovani lesa v okoli
                if (lesVyska - 1 >= 0 && herniPlan[lesSirka][lesVyska - 1] == null) // severni pozice je v planu a je prazdna
                {
                    herniPlan[lesSirka][lesVyska - 1] = new HerniPole(HerniPole.Les);
                }
                if (lesVyska + 1 < this.vyska && herniPlan[lesSirka][lesVyska + 1] == null) // jizni pozice je v planu a je prazdna
                {
                    herniPlan[lesSirka][lesVyska + 1] = new HerniPole(HerniPole.Les);
                }
                if (lesSirka - 1 >= 0 && herniPlan[lesSirka - 1][lesVyska] == null) // zapadni pozice je v planu a je prazdna
                {
                    herniPlan[lesSirka - 1][lesVyska] = new HerniPole(HerniPole.Les);
                }
                if (lesSirka + 1 < this.sirka && herniPlan[lesSirka + 1][lesVyska] == null) // vychodni pozice je v planu a je prazdna
                {
                    herniPlan[lesSirka + 1][lesVyska] = new HerniPole(HerniPole.Les);
                }
                
                //??? Co kdyz se vytvori les tesne vedle mostu? (v zadani nespecifikovano)
            }
        }
        
        
        // dopleni loukami na prazdna pole
        for (int i=0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                if (herniPlan[i][j] == null) {
                    herniPlan[i][j]=new HerniPole(HerniPole.Louka);
                }
            }  
        }
        
    }

}
