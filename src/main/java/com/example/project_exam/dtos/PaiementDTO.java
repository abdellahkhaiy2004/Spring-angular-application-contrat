package com.example.project_exam.dtos;

import com.example.project_exam.enums.TypePaiement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDTO {
    private Long id;
    private Date date;
    private double montant;
    private TypePaiement type;
    private Long contratId;
}
