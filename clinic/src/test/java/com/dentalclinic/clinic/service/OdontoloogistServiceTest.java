package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.Impl.OdontologistIDao;
import com.dentalclinic.clinic.model.Odontologist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OdontoloogistServiceTest extends DBTestConfig{

    private static OdontologistService odontologistService = new OdontologistService(new OdontologistIDao());

    @Test
    @DisplayName("Create odont in DB")
    void testOdontDB(){
        Odontologist odontologist1 = new Odontologist("Leonard","Dupont","10001");
        Odontologist odontologist = new Odontologist("Edmé","Lambert","10002");
        OdontologistService odontologistService = new OdontologistService(new OdontologistIDao());
        Odontologist odotDB1 = odontologistService.createOdontologist(odontologist1);
        Odontologist odotDB = odontologistService.createOdontologist(odontologist);
        assertNotNull(odotDB);
    }
    @Test
    @DisplayName("read odont by Id")
    void testOdontId(){
     Integer id =1;
     Odontologist odontFound = odontologistService.readId(id);
        assertEquals(id,odontFound.getId());
    }

    @Test
    @DisplayName("search all odont")
    void testSearchAllOdontDB(){
        Odontologist odontologist = new Odontologist("Étienne","Dubois","10003");
        odontologistService.createOdontologist(odontologist);
        List<Odontologist>odontologists = odontologistService.readAll();
        assertEquals(3,odontologists.size());
    }
}
