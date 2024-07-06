package br.com.alura.forumhub.topico;

import br.com.alura.forumhub.usuario.Curso;

import java.time.LocalDate;

public record DadosListagemTopicos(String autor, String mensagem, String titulo, Boolean status, Curso curso, LocalDate localDate) {

    public DadosListagemTopicos(Topico topico) {
        this(topico.getAutor(), topico.getMensagem(), topico.getTitulo(), topico.getStatus(), topico.getCurso(), topico.getLocalDate());
    }

}