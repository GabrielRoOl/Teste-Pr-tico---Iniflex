import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    protected String nome;
    protected LocalDate dataNascimento;



    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
