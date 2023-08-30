package unit.java.com.testingOnJava.component;

import static org.junit.jupiter.api.Assertions.*;

import com.testingOnJava.component.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test // TESTE COMPLETO
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(3, 2)); // Valida o retorno no método, garantindo a lógica da execução.
    }

    @Test // TESTE COMPLETO
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(3, 2)); // Valida o retorno no método, garantindo a lógica da execução.
    }

//    @Test // TESTE INCOMPLETO
//    public void testAdd() {
//        Calculator calc = new Calculator();
//        assertInstanceOf(Integer.class, calc.add(1,1)); // Valida somente a execução do método.
//    }
}