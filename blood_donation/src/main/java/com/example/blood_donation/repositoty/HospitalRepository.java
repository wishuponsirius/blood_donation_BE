package com.example.blood_donation.repositoty;

import com.example.blood_donation.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
