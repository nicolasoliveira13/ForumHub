package br.com.alura.forumhub.topico;

import br.com.alura.forumhub.usuario.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTopico(
        @NotBlank
        String autor,

        @NotBlank
        String mensagem,

        @NotBlank
        String titulo,

        @NotNull
        Curso curso,

        Boolean status,

        LocalDate localDate) {

        public DadosCadastroTopico {
                if (localDate == null) {
                        localDate = LocalDate.now();
                }
                if (status == null) {
                        status = true;
                }
        }
}