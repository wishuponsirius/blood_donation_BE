package com.example.blood_donation.dto;

import lombok.Data;

import java.util.List;
@Data
public class BloodRequestDTO {
    private String isEmergency;
    private Long medId;
    private List<BloodRequestDetailDTO> details;
}
