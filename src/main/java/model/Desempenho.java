package model;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR (new BigDecimal("0.03")),
    BOM (new BigDecimal("0.15")),
    OTIMO(new BigDecimal("0.20"));

    private BigDecimal percentual;

    Desempenho(BigDecimal percentual) {
        this.percentual = percentual;
    }

    public BigDecimal percentualReajuste () {return this.percentual;}

}
