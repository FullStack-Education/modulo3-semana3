import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @BeforeEach
    public void antesDeCadaMetodo(){
        System.out.println("Antes do metodo");;
    }

    @BeforeAll
    public static void antesDeTodosMetodo(){
        System.out.println("Antes de tudo");;
    }

    @Test
    void soma() {
        Calculadora calculadora = new Calculadora();

        Double resultado = calculadora.soma(3.1,4.4);

        // valida se os parametros são iguas
        assertEquals(7.5, resultado);
    }

    @Test
    void soma2() {
        Calculadora calculadora = new Calculadora();

        Double resultado = calculadora.soma(2.0,2.0);

        // valida se os parametros são iguas
        assertEquals(4.0, resultado);
    }
}