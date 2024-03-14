package upo20052528.trials.Controller;

import java.time.LocalDate;

public class Controller {
    public static void inserisciCM(String idLetto, int nascitaLetta, int registrazioneALetta, int registrazioneMLetta, int registrazioneGLetta){
        if(idLetto.isEmpty()){
            records.add(new Record(nascitaLetta, LocalDate.of(registrazioneALetta, registrazioneMLetta,registrazioneGLetta)));
        }
        else{
            try {
                records.add(new Record(idLetto, nascitaLetta, LocalDate.of(registrazioneALetta, registrazioneMLetta, registrazioneGLetta)));
            } catch (Exception e) {
                System.out.println("Id già usato");
            }
        }
    }
    public static void aggiungiVisitaCM(int x, double temperatura, String pressione) {
        try {
            records.get(x).addVisita(temperatura, pressione);
        }
        catch (Exception e){
            System.out.println("impossibile aggiungere visita");
        }

    }
    public static int ricercaCM(String idScelto) {
        if (idScelto.isEmpty()) {
            return -1;
        }

        for (Record r : records) {
            if (r.getId().equals(idScelto)) {
                return records.indexOf(r);
            }
        }

        return -1;
    }



}
