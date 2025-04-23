package com.dentalclinic.clinic.service;

import com.dentalclinic.clinic.Dto.request.AppointmentRequestDto;
import com.dentalclinic.clinic.Dto.response.AppointmentResponseDto;
import com.dentalclinic.clinic.entity.Appointment;


import java.util.List;

public interface IAppointmentService {
    AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto);
    AppointmentResponseDto readId(Integer id);
    List<AppointmentResponseDto> readAll();
    void update(Integer id,AppointmentRequestDto appointmentRequestDto);
    void delete(Integer id);
}
