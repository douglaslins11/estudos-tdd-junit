package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            valor = BigDecimal.ZERO;
        }
        return valor;
    }
}