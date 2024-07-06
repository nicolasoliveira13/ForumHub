package br.com.alura.forumhub.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,

        @NotNull
        @Email
        String login
) {}
