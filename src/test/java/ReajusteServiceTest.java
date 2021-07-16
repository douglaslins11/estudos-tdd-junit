import model.Desempenho;
import model.Funcionario;
import service.ReajusteService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADESEJAR (){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Douglas", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBOM (){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Douglas", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOTIMO (){
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Douglas", LocalDate.now(), new BigDecimal("1000"));
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
