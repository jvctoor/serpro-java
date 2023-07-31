package mysql;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private int idade;
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    public Usuario() {

    }

    // Construtor
    public Usuario(int id, String nome, String email, int idade, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
