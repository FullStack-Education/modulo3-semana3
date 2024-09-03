import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @BeforeEach
    public void antesDeCadaMetodo(){
        System.out.println("Antes do metodo");;
    }

    @AfterEach
    public void aposCadaMetodo(){
        System.out.println("Após método");
    }

    @BeforeAll
    public static void antesDeTodosMetodo(){
        System.out.println("Antes dos testes da classe");;
    }

    @AfterAll
    public static void aposTodosMetodo(){
        System.out.println("Após todos os testes da classe");
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
        assertNotEquals(3.0, resultado);

        assertTrue(resultado > 2.0);
        assertFalse(resultado==3.0);
    }

    @Test
    void divisao() {
        Calculadora calculadora = new Calculadora();

        assertThrows( ArithmeticException.class,
                () -> calculadora.divisao(3.0,0.0)
        );
    }

    @Test
    void multipicacao(){
        Calculadora calculadora = new Calculadora();

        Double resultado = calculadora.multiplica(2.0, 3.0, 4.0);

        assertEquals(24.0, resultado);
    }


}