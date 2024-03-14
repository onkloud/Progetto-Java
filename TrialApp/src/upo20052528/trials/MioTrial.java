package upo20052528.trials;

import upo20052528.trials.View.View;

import java.security.Key;
import java.time.LocalDate;
import java.util.*;
import java.lang.Math;

/**

 Rappresenta i dati dei pazienti come degli array,
 a cui ogni indice corrisponde un record
 */

public class MioTrial {

    public static void esegui(int scelta) {
        System.out.println("Hai scelto: " + scelta);
        switch (scelta) {
            case 1:
               View.inserisci();
                break;
            case 2:
                View.ricerca();
                break;
            case 3:
                View.ricercaEta();
                break;
            case 4:
                View.aggiungiVisita();
                break;
            case 5:
                View.statisticheTemperatura();
                break;
            case 6:
                View.statistichePressione();
                break;
        }
    }

    static Scanner tastiera = new Scanner(System.in);

    public static void main (String[]args){
        System.out.println("Benvenuto nel software EDC dell'UPO");
        int scelta = -1;
        while (scelta != 100) {
            View.menu();
            scelta = tastiera.nextInt();
            esegui(scelta);
        }
    }
}







