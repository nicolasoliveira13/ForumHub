package br.com.alura.forumhub.topico;

import br.com.alura.forumhub.usuario.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;
    private Boolean status;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private LocalDate localDate;

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Topico(DadosCadastroTopico dadosCadastroTopico) {
        this.autor = dadosCadastroTopico.autor();
        this.mensagem = dadosCadastroTopico.mensagem();
        this.titulo = dadosCadastroTopico.titulo();
        this.curso = dadosCadastroTopico.curso();
        this.status = (dadosCadastroTopico.status() != null) ? dadosCadastroTopico.status() : true;
        this.localDate = (dadosCadastroTopico.localDate() != null) ? dadosCadastroTopico.localDate() : LocalDate.now();
    }

    public void  atualizarInformacoes(DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        if (dadosAtualizacaoTopico.mensagem() != null) {
            this.mensagem = dadosAtualizacaoTopico.mensagem();
        }
    }

    public void excluir() {
        this.status = false;
    }
}