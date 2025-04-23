package com.dentalclinic.clinic.repository;

import com.dentalclinic.clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
