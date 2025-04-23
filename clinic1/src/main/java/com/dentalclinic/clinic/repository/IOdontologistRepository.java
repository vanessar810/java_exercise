package com.dentalclinic.clinic.repository;

import com.dentalclinic.clinic.entity.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologistRepository extends JpaRepository<Odontologist, Integer> {
}
