package upo20052528.trials.Model;

import java.time.LocalDate;
import java.util.*;
import static upo20052528.trials.Model.Parametro.*;
import upo20052528.trials.View.View;


/**
 @author 20052528 e 20050038
 Una visita è rappresentata da una data, una temperatura e una pressione,
 la quale assume un valore di LivelliP, ovvero MINIMA, BASSA, MEDIA, ALTA
 o MASSIMA.

 */
public class Visita {
    private LocalDate data;

    private Map<Parametro, Object> valori;

    public Map<Parametro, Object> getValori() {

        return valori;
    }

    public void inserisciValori(Parametro parametro, Object type){
        if(parametro.getType().equals("NUMERIC")){
            if(!(type instanceof Number)) {
                throw new IllegalArgumentException("L'oggetto inserito non è di tipo numerico");
            }
        }
        else if(parametro.getType().equals("SCALAR")){
            if(!(type instanceof Parametro.LivelliP)){
                throw new IllegalArgumentException("L'oggetto inserito non è di tipo scalare");

            }
        }
        valori.put(parametro, type);
    }

    public void setValori(Map<Parametro, Object> valori) {
        this.valori = valori;
    }

    public Visita(LocalDate data) {
        this.data = data;
        this.valori = new HashMap<Parametro, Object>();

    }


    /**
     getData restituisce la data della visita
     @return La data della visita
     */
    public LocalDate getData(){
        return data;
    }




    /**
     Metodo statico minTemperatura che restituisce il valore minimo tra quelli delle
     temperature ottenute durante le varie visite
     @return Il valore minimo delle temperature
     */
    public static double[] statisticheTemperatura(List < Record > pazienti, Scanner tastiera) {
        double somma = 0;
        double conta = 0;
        double min = 42;
        double max = 36;
        double[] array = new double[4];
        if (!pazienti.isEmpty()) {
            for (Record r : pazienti) {
                for (Visita visita : r.getVisite()) {
                    double valoreTemperatura = Double.parseDouble(visita.getValori(Parametro.TEMPERATURA));
                    somma += valoreTemperatura;
                    conta++;
                    if (valoreTemperatura > max)
                        max = valoreTemperatura;
                    if (valoreTemperatura < min)
                        min = valoreTemperatura;
                }
            }
        }
        array[0]= Double.parseDouble(String.valueOf(min));
        array[1] = Double.parseDouble(String.valueOf(max));
        if (conta > 0) {
            double mediaCapacita = somma / conta;
            array[2] = Double.parseDouble(String.valueOf(mediaCapacita));
            View.stampa("La temperatura media nelle visite è di: " + mediaCapacita);
            View.stampa("La temperatura minima nelle visite è di: " + min);
            View.stampa("La temperatura massima nelle visite è di: " + max);
        } else {
            View.stampa("Nessuna visita registrata");
        }
        // Creare una lista di tutte le visite di tutti i record
        List<Visita> tutteLeVisite = new ArrayList<>();
        for (Record record : pazienti) tutteLeVisite.addAll(record.getVisite());

        View.MetodiDiStampa(tutteLeVisite, 3,tastiera);

        return array;
    }

    public static double[] statistichePeso(List < Record > pazienti, Scanner tastiera){
        double somma = 0;
        double conta = 0;
        double min = 42;
        double max = 36;
        int annoCorrente = LocalDate.now().getYear();
        int eta = annoCorrente - Record.getAnnoNascita();

        if
        
        }
    }




    /**
     Metodo statico minPressione che restituisce il valore minimo tra quelli delle
     pressioni ottenute durante le varie visite
     @return Il valore minimo delle pressioni
     */
    public static LivelliP minPressione() {
        return Collections.min(pressioni);
    }

    /**
     Metodo statico maxPressione che restituisce il valore massimo tra quelli delle
     pressioni ottenute durante le varie visite
     @return Il valore massimo delle pressioni */
    public static LivelliP maxPressione() {
        return Collections.max(pressioni);
    }

}






