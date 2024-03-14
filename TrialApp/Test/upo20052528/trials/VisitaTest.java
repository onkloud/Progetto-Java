package upo20052528.trials;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import upo20052528.trials.Model.Visita;

import java.time.LocalDate;

public class VisitaTest {
    Visita v;

    @BeforeEach
    void beforeEach() throws Exception {
        v = new Visita(37.0, "ALTA");
    }

    @Test
    void testVisitaNotNull() {
        Assertions.assertNotNull(v);
    }

    @Test
    void testGetTemperatura(){Assertions.assertEquals(37.0, v.getTemperatura());}

    @Test
    void TestGetPressione(){
        Assertions.assertEquals(Visita.LivelliP.ALTA, v.getPressione());}

    @Test
    void testGetData(){
        Assertions.assertEquals(LocalDate.now(),v.getData());}

    @Test
    void testCostruttore(){
        Assertions.assertNotNull(v);
    }

    @Test
    void testToString(){
        String s= "2023-12-22 Temperatura: 37.0 Pressione: ALTA";
        Assertions.assertEquals(s, v.toString());
    }




}







