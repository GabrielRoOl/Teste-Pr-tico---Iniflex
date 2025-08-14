import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected LocalDate dtNascimento;



    public Pessoa(String nome, LocalDate dtNascimento) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
