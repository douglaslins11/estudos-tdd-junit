import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.BonusService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private BonusService bonusService;

    @BeforeEach
    public void setup(){
        this.bonusService = new BonusService();
    }

    @Test
    public void deveRetornarExceçãoParaFuncionarioComSalarioMuitoAlto(){

        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("15000"))));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("5000")));

        assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
