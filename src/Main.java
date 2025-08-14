import javax.swing.plaf.metal.MetalIconFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();




        // Criando objetos e inserindo na lista
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.04), "Operador");
        funcionarios.add(maria);
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador");
        funcionarios.add(joao);
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5,2), BigDecimal.valueOf(9836.14), "Coordenador");
        funcionarios.add(caio);
        Funcionario miguel = new Funcionario("Migual", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
        funcionarios.add(miguel);
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista");
        funcionarios.add(alice);
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
        funcionarios.add(heitor);
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador");
        funcionarios.add(arthur);
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente");
        funcionarios.add(laura);
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista");
        funcionarios.add(heloisa);
        Funcionario elena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente");
        funcionarios.add(elena);


        // Remove o funcionario "João" da lista de funcionários
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // Mostra todos os funcionários
//        funcionarios.forEach(System.out::println);

        // Aumento de 10% do salário dos funcionários
        BigDecimal percentual = new BigDecimal("0.10");
        funcionarios.forEach(f -> f.aumento(percentual, f.getSalario()));

        funcionarios.forEach(System.out::println);

        // Método para agrupar funcionários por função
        Map<String, List<Funcionario>> agruparPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));


        agruparPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            System.out.println("Funcionários: ");
            lista.forEach(System.out::println);
        });

    }

}