package com.example.blood_donation.repositoty;

import com.example.blood_donation.entity.Appointment;
import com.example.blood_donation.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
