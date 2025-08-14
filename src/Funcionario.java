import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa{

    private BigDecimal salario;
    private String funcao;


    public Funcionario(BigDecimal salario, String funcao) {
        super();
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(String nome, LocalDate data, BigDecimal salario, String funcao) {
        super(nome, data);
        this.salario = BigDecimal.valueOf(salario.doubleValue());
        this.funcao = funcao;
    }

    public void aumento(BigDecimal percentual, BigDecimal salario){
        BigDecimal aumento = salario.multiply(percentual);
        this.salario = salario.add(aumento);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols(new Locale("pt", "BR"));
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,##0.00", simbolo);

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dtformatada = dtNascimento.format(formatterData);
        return
                "nome='" + nome + '\'' +
                ", dtNascimento=" + dtformatada +
                ", salario=" + formatter.format(salario) +
                ", funcao='" + funcao + '\'';
    }
}
