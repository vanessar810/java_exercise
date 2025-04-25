package com.dentalclinic.clinic.repository;

import com.dentalclinic.clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    //Search appointment between dates
    @Query("Select a from Appointment a where a.date BETWEEN :startDate and :endDate")
    List<Appointment> findByDates (@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate);
}
