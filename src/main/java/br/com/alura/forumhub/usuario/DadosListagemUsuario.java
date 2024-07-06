package br.com.alura.forumhub.usuario;

public record DadosListagemUsuario(String login, String password) {

    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getLogin(), usuario.getPassword());
    }

}
