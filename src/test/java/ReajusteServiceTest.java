import model.Desempenho;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import service.ReajusteService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private Funcionario funcionario;
    private ReajusteService reajusteService;

    @BeforeEach
    public void setup(){
        this.funcionario = new Funcionario("Douglas", LocalDate.now(), new BigDecimal("1000"));
        this.reajusteService = new ReajusteService();
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADESEJAR (){
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBOM (){
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOTIMO (){
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
