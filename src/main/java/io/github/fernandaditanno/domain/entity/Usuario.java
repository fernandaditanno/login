package io.github.fernandaditanno.domain.entity;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", confirmaSenha='" + confirmaSenha + '\'' +
                '}';
    }

    public Usuario(String nome, String email, String senha, String confirmaSenha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false, length = 20)
    private String senha;

    @Column(name = "confirmaSenha", length = 20)
    private String confirmaSenha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
