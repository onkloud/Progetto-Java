package upo20052528.trials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upo20052528.trials.Model.Record;
import upo20052528.trials.Model.Visita;

import java.time.LocalDate;

public class RecordTest {
        Record r;

        @BeforeEach //eseguito ogni volta prima degli altri metodi
        void beforeEach(){
          r = new Record(2003, LocalDate.of(2021, 12, 23));

        }

        @Test
        void creaRecordNotNull() {
            Assertions.assertNotNull(r);
        }

        @Test
        void TestSetId(){
            r.setId("0000");
            Assertions.assertEquals("0000", r.getId());
        }


        @Test
        void testIdCasuale(){
            String id = Record.idCasuale();
            Assertions.assertEquals(4, id.length());
            Assertions.assertFalse(Record.ids.contains(id));
        }

        @Test
        void testAddVisite() throws Exception {
            int oldNum = r.getNumVisite();

            r.addVisita(37, "ALTA");

            int newNum = r.getNumVisite();
            Assertions.assertEquals(oldNum, newNum-1);
            Assertions.assertEquals(37, r.datiVisita(newNum-1).getTemperatura());
            Assertions.assertEquals(Visita.LivelliP.ALTA, r.datiVisita(newNum-1).getPressione());
        }

        @Test
        void testContainsVisita(){
            r= new Record (2006, LocalDate.of(2022,12,27));
            Visita v=new Visita(LocalDate.of(2004,12,22), 37,"ALTA");
            r.addVisita(v);
            Assertions.assertTrue(r.containsVisita(v));
        }

        @Test
        void deleteVisita(){
            r=new Record(2006,LocalDate.of(2022,12,27));
            Visita v= new Visita(LocalDate.of(2004,12,22),37, "ALTA");
            r.addVisita(v);
            Assertions.assertTrue(r.containsVisita(v));
            Assertions.assertDoesNotThrow(()->r.deleteVisita(v));

        }





}



