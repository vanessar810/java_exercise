package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.dao.IDao;
import com.dentalclinic.clinic.model.Odontologist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologistService implements IOdontologistService{
    private IDao<Odontologist> odontologistIDao;

    public OdontologistService(IDao<Odontologist> odontologistIDao) {
        this.odontologistIDao = odontologistIDao;
    }
    public Odontologist createOdontologist(Odontologist odontologist) {
        return odontologistIDao.create(odontologist);
    }
    public Odontologist readId(Integer id) {return odontologistIDao.readbyId(id);}
    public List<Odontologist> readAll() {
        return odontologistIDao.readAll();
    }
}
