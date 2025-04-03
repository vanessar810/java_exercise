package com.page.service;

import com.page.dao.IDao;
import com.page.model.Medicamentos;

import java.util.List;

public class MedicamentoService {
    protected IDao<Medicamentos> medicamentosIDao;
    public MedicamentoService(IDao<Medicamentos> medicamentosIDao){this.medicamentosIDao = medicamentosIDao;}
    public Medicamentos registerMedicine(Medicamentos medicamentos){return medicamentosIDao.register(medicamentos);}
    public Medicamentos searchName(String name){return medicamentosIDao.searchField(name);}
    public Medicamentos searchId(Integer id){return medicamentosIDao.searchID(id);}
    public List<Medicamentos> searchAll(){return medicamentosIDao.searchAll();}
}
