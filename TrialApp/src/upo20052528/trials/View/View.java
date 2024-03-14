package upo20052528.trials.View;
import upo20052528.trials.Controller.Controller;

import java.time.LocalDate;
import java.util.*;

import upo20052528.trials.Model.Record;
import upo20052528.trials.Model.Visita;
import static upo20052528.trials.Controller.Controller.inserisciCM;

public class View {
    /**

     Rappresenta i dati dei pazienti come degli array,
     a cui ogni indice corrisponde un record
     */
        private static List<Record> records;


        static Scanner tastiera = new Scanner(System.in);

        /**
         * Stampa il menu con le possibili azioni dell'utente
         */
        public static void menu() {
            System.out.println("""
        Cosa vuoi fare?
        1 - Cerca un paziente
        2 - Inserisci range età di pazienti
        3 - Aggiungi visita
        4 - Inserisci range età di pazienti
        5 - Statistiche temperatura
        6 - Statistiche pressione
        100 - Termina
        """);
        }

        /**
         Metodo esegui richiama altri metodi in base alla scelta dell'utente
         @param scelta la scelta dell'utente
         */


        /**
         Chiede all'utente di inserire dati di un nuovo paziente: id, data di nascita,
         anno, mese e giorno di registrazione del paziente.
         */
        public static void inserisci() {
            System.out.print("Identificativo del paziente: ");
            String idLetto = tastiera.next();

            System.out.print("Anno di nascita del paziente: ");
            int nascitaLetta = tastiera.nextInt();

            System.out.print("Anno di registrazione del paziente: ");
            int registrazioneALetta = tastiera.nextInt();

            System.out.print("Mese di registrazione del paziente: ");
            int registrazioneMLetta = tastiera.nextInt();

            System.out.print("Giorno di registrazione del paziente: ");
            int registrazioneGLetta = tastiera.nextInt();
            inserisciCM(idLetto, nascitaLetta, registrazioneALetta, registrazioneMLetta, registrazioneGLetta);
        }




        /**
         Metodo ricerca, richiede all'utente di inserire l'id del record per trovare i pazienti
         corrispondenti e poi stampare un riepilogo con id, età e data di registrazione.
         */
        public static void ricerca() {
            System.out.println("Scegli id");
            String idScelto = tastiera.next();
            int pos = Controller.ricercaCM(idScelto);
            System.out.println(records.get(pos));
        }



        /**

         Metodo ricerca età, richiede all'utente di inserire l'età minima e massima e poi stampa gli id di tutti i record
         inclusi nella fascia d'età.
         */
        public static void ricercaEta() {
            // stampa tutti i pazienti con l'età inserita da tastiera
            System.out.print("l'età minima é: ");
            int etaMin = tastiera.nextInt();
            System.out.print("l'età massima é: ");
            int etaMax = tastiera.nextInt();
            for (Record r : records) {
                int eta = LocalDate.now().getYear() - r.getAnnoNascita();
                if (eta >= etaMin && eta <= etaMax) {
                    System.out.println(r);
                }
            }
        }

        /**
         Metodo aggiungiVisita, richiede all'utente di inserire l'id del paziente di cui si vuole creare una visita.
         L'utente inserisce temperatura e pressione.
         */
        public static void aggiungiVisita() {
            System.out.println("Inserisci Id del paziente: ");
            String idPaz = tastiera.next();
            int x = Controller.ricercaCM(idPaz);
            System.out.print("Temperatura misurata: ");
            double temperatura = tastiera.nextDouble();
            System.out.print("Pressione misurata: ");
            String pressione = tastiera.nextLine();
            Controller.aggiungiVisitaCM(x, temperatura, pressione);
            System.out.print("Capacità polmonare misurata");

        }




        /**
         Metodo statisticheTemperatura, stampa valore massimo minimo e
         media della temperatura, in ordine crescente
         */
        public static void statisticheTemperatura() {
            List<Double> tempVisita = new ArrayList<>();

            System.out.println("la temperatura massima è:" + Visita.maxTemperatura());
            System.out.println("la temperatura minima è:" + Visita.minTemperatura());
            System.out.println("la media della temperatura è:" + Visita.avgTemperatura());

            System.out.print("Digita il numero della visita con temperatura ordinata: ");
            int x = tastiera.nextInt();
            for (Record r : records) {
                if (x <= r.getNumVisite()) {
                    tempVisita.add(r.datiVisita(x).getTemperatura());
                }
            }

            Collections.sort(tempVisita);
            System.out.println(tempVisita);
        }
        /**
         * Metodo statistichePressione, stampa massimo e minimo della pressione, in ordine crescente
         */
        public static void statistichePressione() {
            List<String> pressVisita = new ArrayList<>();

            System.out.println("la pressione massima è:" + Visita.maxPressione());
            System.out.println("la pressione minima è:" + Visita.minPressione());

            System.out.print("Digita il numero della visita con pressione ordinata: ");
            int x = tastiera.nextInt();
            for (Record r : records) {
                if (r.getNumVisite() >= x) {
                    pressVisita.add(String.valueOf(r.datiVisita(x).getPressione()));
                }
            }

            Collections.sort(pressVisita);
            System.out.println(pressVisita);
        }


    }









