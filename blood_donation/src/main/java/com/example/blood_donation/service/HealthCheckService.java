package com.example.blood_donation.service;

import com.example.blood_donation.dto.HealthCheckRequest;
import com.example.blood_donation.entity.DonationDetail;
import com.example.blood_donation.entity.DonationProgram;
import com.example.blood_donation.entity.HealthCheck;
import com.example.blood_donation.repositoty.DonationProgramRepository;
import com.example.blood_donation.repositoty.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {
    @Autowired
    DonationProgramRepository donationProgramRepository;
    @Autowired
    HealthCheckRepository healthCheckRepository;

    public HealthCheck createHealthCheckFromRequest(HealthCheckRequest request) {
        HealthCheck hc = new HealthCheck();
        hc.setCheckDate(request.getCheckDate());
        hc.setWeight(request.getWeight());
        hc.setHemoglobinLevel(request.getHemoglobinLevel());
        hc.setBloodPressure(request.getBloodPressure());
        hc.setTemperature(request.getTemperature());
        hc.setEligible(request.getEligible());
        hc.setNote(request.getNote());

         DonationProgram dp = donationProgramRepository.findById(request.getDonationProgramId())
                .orElseThrow(() -> new RuntimeException("DonationProgram not found"));

        hc.setDonationProgram(dp);
        return healthCheckRepository.save(hc);
    }

    public HealthCheck updateHealthCheckFromRequest(Long id, HealthCheckRequest request) {
        HealthCheck hc = healthCheckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HealthCheck not found"));

        hc.setCheckDate(request.getCheckDate());
        hc.setWeight(request.getWeight());
        hc.setHemoglobinLevel(request.getHemoglobinLevel());
        hc.setBloodPressure(request.getBloodPressure());
        hc.setTemperature(request.getTemperature());
        hc.setEligible(request.getEligible());
        hc.setNote(request.getNote());

        // Cập nhật lại DonationProgram nếu cần
        if (!hc.getDonationProgram().getId().equals(request.getDonationProgramId())) {
            DonationProgram dp = donationProgramRepository.findById(request.getDonationProgramId())
                    .orElseThrow(() -> new RuntimeException("DonationProgram not found"));
            hc.setDonationProgram(dp);
        }

        return healthCheckRepository.save(hc);
    }
}
