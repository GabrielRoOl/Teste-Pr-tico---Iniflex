import javax.swing.plaf.metal.MetalIconFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
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
        System.out.println("\nINICIANDO...");
        System.out.println("\n===---====---===---===---===---===---===---===---==\n");

        // Remove o funcionario "João" da lista de funcionários
        System.out.println("Removendo 'João'");
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));


        System.out.println("\n===---====---===---===---===---===---===---===---==\n");

        System.out.println("Mostra todos os funcionários...\n");
        funcionarios.forEach(System.out::println);


        System.out.println("\n===---====---===---===---===---===---===---===---==\n");
        // Aumento de 10% do salário dos funcionários
        System.out.println("Aumentando o salário...");
        BigDecimal percentual = new BigDecimal("0.10");
        funcionarios.forEach(f -> f.aumento(percentual, f.getSalario()));

        System.out.println("\n===---====---===---===---===---===---===---===---==\n");
        System.out.println("Agrupando funcionários...\n");
        // Método para agrupar funcionários por função
        Map<String, List<Funcionario>> agruparPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        agruparPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            System.out.println("Funcionários: ");
            lista.forEach(System.out::println);
        });

        System.out.println("\n===---====---===---===---===---===---===---===---==\n");
        // Funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("Aniversáriantes no mês 10 e 12\n");
        funcionarios.stream().filter(f -> {
                    int mes = f.getDtNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                }).forEach(System.out::println);

        System.out.println("\n===---====---===---===---===---===---===---===---==\n");
        System.out.println("Funcionário com a maior idade...");

        var funcionario = funcionarios.stream().min(Comparator.comparing(Funcionario::getDtNascimento)).orElse(null);
        if(funcionario != null){
            int idade = Period.between(funcionario.getDtNascimento(), LocalDate.now()).getYears();
            System.out.println("Nome: " + funcionario.getNome() +
                    "\nIdade: " + idade + " anos");
        }

        System.out.println("\n===---====---===---===---===---===---===---===---==\n");

        // Ordena a lista de Funcionários pelo nome
        System.out.println("Ordenando a lista pelo nome...\n");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);


        System.out.println("\n===---====---===---===---===---===---===---===---==\n");


        System.out.println("FIM DO PROGRAMA...");

    }
}