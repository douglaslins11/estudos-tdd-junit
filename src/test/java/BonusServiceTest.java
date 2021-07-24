import model.Funcionario;
import org.junit.jupiter.api.Test;
import service.BonusService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void deveRetornarExceçãoParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("15000"))));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("5000")));

        assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Douglas", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
