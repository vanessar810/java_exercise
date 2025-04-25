package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.entity.Odontologist;
import com.dentalclinic.clinic.repository.IOdontologistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologistService implements IOdontologistService{
    private IOdontologistRepository odontologistRepository;

    public OdontologistService(IOdontologistRepository odontologistRepository) {
        this.odontologistRepository = odontologistRepository;
    }

    public Odontologist createOdontologist(Odontologist odontologist) {

        return odontologistRepository.save(odontologist);
    }
    public Optional<Odontologist> readId(Integer id) {

        return odontologistRepository.findById(id);}

    public List<Odontologist> readAll() {

        return odontologistRepository.findAll();
    }

    @Override
    public void update(Odontologist odontologist) {

        odontologistRepository.save(odontologist);
    }

    @Override
    public void delete(Integer id) {
        odontologistRepository.deleteById(id);
    }

    @Override
    public List<Odontologist> searchByLastname(String lastname) {
        return odontologistRepository.searchByLastname(lastname);
    }
    @Override
    public List<Odontologist> findByNameLike(String name){
        return odontologistRepository.findByNameLike(name);
    }

}
