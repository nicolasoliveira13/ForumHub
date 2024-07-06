package br.com.alura.forumhub.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,

        String mensagem
) {}