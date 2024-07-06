package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postar(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico, @AuthenticationPrincipal UserDetails userDetails) {
        Topico topico = new Topico(dadosCadastroTopico);
        topicoRepository.save(topico);
        return ResponseEntity.ok(new DadosListagemTopicos(topico));
    }

    @GetMapping
    public List<DadosListagemTopicos> listar() {
        return topicoRepository.findAll().stream().map(DadosListagemTopicos::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DadosListagemTopicos(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        var topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            topico.get().atualizarInformacoes(dadosAtualizacaoTopico);
            return ResponseEntity.ok(new DadosListagemTopicos(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = topicoRepository.getReferenceById(id);
        paciente.excluir();
    }
}
