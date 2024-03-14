package upo20052528.trials.Model;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 20052528 e 20050038
 * La classe Record rappresenta un record di un paziente.
 * Ogni record ha un ID univoco, l'anno di nascita del paziente,la data del record e
 * una lista di visite associate.
 */
public class Record {
    private String id;


    private int annoNascita;
    private LocalDate data;

    private List<Visita> visite;

    /**
     * Collezione di ID utilizzati per garantire l'unicità.
     */
    public static List<String> ids;
    static{
        ids= new ArrayList<String>();
    }

    /**
     * Costruttore per la classe Record. Crea un nuovo record con l'ID, l'anno di nascita e la data specificati.
     * Controlla che l'ID sia unico e lancia un'eccezione se già in uso.
     *
     * @param id l'ID del record
     * @param annoNascita l'anno di nascita del paziente
     * @param data la data del record
     * @throws Exception se l'ID esiste già
     */
    public Record(String id, int annoNascita, LocalDate data) throws Exception {
        if(ids.contains(id)){
            throw new Exception("id esiste già");
        }
        this.id = id;
        ids.add(id);
        this.annoNascita = annoNascita;
        this.data = data;
        this.visite=new ArrayList<>();

    }

    /**
     * Costruttore per la classe Record. Crea un nuovo record con l'anno di nascita e la data specificati.
     * L'ID viene generato casualmente e deve essere unico.
     *
     * @param annoNascita l'anno di nascita del paziente
     * @param data la data del record
     */
    public Record( int annoNascita, LocalDate data){
        this.annoNascita = annoNascita;
        this.data = data;
        this.id= idCasuale();
        ids.add(this.id);
        this.visite=new ArrayList<>();
    }

    /**
     * Restituisce la lista delle visite associate al record.
     *
     * @return la lista delle visite associate al record
     */
    public List<Visita> getVisite() {
        return visite;
    }

    /**
     * getId restituisce l'ID del record.
     *
     * @return l'ID del record
     */
    public String getId() {
        return this.id;
    }

    /**
     * setId imposta l'ID del record.
     *
     * @param id il nuovo ID del record
     */
    public void setId(String id){
        this.id=id;
    }

    /**
     * getAnnoNascita restituisce l'anno di nascita del paziente.
     *
     * @return l'anno di nascita del paziente
     */
    public static int getAnnoNascita() {
        return annoNascita;
    }

    /**
     * idCasuale genera un ID casuale che deve essere unico.
     *
     * @return l'ID casuale
     */
    public static String idCasuale(){
        SecureRandom randomInt= new SecureRandom(); // crea generatore di numeri casuali
        String randomId;
        do{
            randomId= Integer.toString(randomInt.nextInt(0, 9000)+1000);//genera numero casuale e lo converte a stringa
        }while(ids.contains(randomId));
        return randomId; //ritorno stringa
    }

    /**
     * addVisita aggiunge una visita al record con la temperatura e la pressione specificate.
     *
     * @param temperatura la temperatura della visita
     * @param pressione la pressione della visita
     */
    public void addVisita(double temperatura, String pressione) {
        List<Visita> v = new ArrayList<>();
        v = getVisite();
        Visita v2;
        try {
            v2 = new Visita(temperatura, pressione);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        v.add(v2);
    }

    /**
     * addVisita aggiunge una visita al record.
     *
     * @param v la visita da aggiungere
     */
    public void addVisita(Visita v){
        List<Visita> r = new ArrayList<>();
        r = getVisite();
        r.add(v);
    }

    /**
     * containsVisita verifica se il record contiene una visita specificata.
     *
     * @param v la visita da cercare
     * @return true se il record contiene la visita, false altrimenti
     */
    public boolean containsVisita(Visita v){
        return visite.contains(v);
    }

    /**
     * deleteVisita rimuove una visita dal record.
     *
     * @param v la visita da rimuovere
     */
    public void deleteVisita(Visita v){
        this.visite.remove(v);
    }

    /**
     * datiVisita restituisce i dati di una visita specificata.
     *
     * @param i l'indice della visita
     * @return la visita
     */
    public Visita datiVisita(int i) {
        return visite.get(i);
    }

    /**
     * getNumVisite restituisce il numero di visite nel record.
     *
     * @return il numero di visite nel record
     */
    public int getNumVisite() {
        return visite.size();
    }

    /**

     toString restituisce una stringa che rappresenta l'oggetto corrente.
     @return una stringa che rappresenta l'oggetto corrente.
     */
    public String toString(){
        return "ID\tANNO\tRA\tRM\tRG\n" + this.id +
                "\t" + this.annoNascita + "\t" + this.data;
    }

    /**
     * equals verifica se due record sono uguali.
     *
     * @param record il record da confrontare
     * @return true se i record sono uguali, false altrimenti
     */
    public boolean equals(Record record) {
        return record.id.equals(this.id) &&
                record.annoNascita == this.annoNascita &&
                record.data.equals(this.data);
    }

}

