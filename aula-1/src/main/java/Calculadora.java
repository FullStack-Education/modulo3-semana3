public class Calculadora {

    public Double soma(Double n1, Double n2) {
        return n1 + n2;
    }

    public Double divisao(Double n1, Double n2) {
        if(n2 == 0){
            throw new ArithmeticException();
        }
        return n1 / n2;
    }

    public Double multiplica(double n1, double n2, double n3) {
        return n1 * n2 * n3;
    }
}
