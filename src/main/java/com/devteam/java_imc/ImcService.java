/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devteam.java_imc;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author momo
 */
@Service
public class ImcService {

    public Map<String, String> calculate(ImcDTO data) {
        double imc = data.poids() / Math.pow(data.taille(), 2);
        imc = Math.round(imc * 100 / 100);
        String advise = this.analyse(imc);
        return Map.of(
                "imc", String.valueOf(imc),
                "avis", advise
        );
    }

    private String analyse(double imc) {
        if (imc < 16.5) {
            return "HIGH";
        }
        if (imc >= 16.5 && imc < 18.5) {
            return "ACCRU";
        }
        if (imc >= 18.5 && imc < 25) {
            return "NORMALE";
        }
        if (imc >= 25 && imc < 30) {
            return "SURPOIDS";
        }
        if (imc >= 30 && imc < 36) {
            return "ELEVE";
        }
        if (imc >= 36 && imc < 40) {
            return "TRES ELEVE";
        }
        if (imc >= 40) {
            return "OBESE";
        }
        return "RAS";
    }
    
}
