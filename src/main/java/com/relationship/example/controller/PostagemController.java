package com.relationship.example.controller;

import com.relationship.example.model.Comentario;
import com.relationship.example.model.Postagem;
import com.relationship.example.repository.ComentarioRepository;
import com.relationship.example.repository.PostagemRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("postagem")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping
    public Postagem createPostagem(@RequestBody Postagem postagem){
        return postagemRepository.save(postagem);
    }

    @GetMapping("/{id}")
    public Optional<Postagem> getPostagens(@PathVariable(value = "id") Long id){
        return postagemRepository.findById(id);
    }

    @PostMapping("/{id}/comentarios")
    public Comentario createComentarios(@PathVariable(value = "id") Long id, @RequestBody Comentario comentario){
        Optional<Postagem> postagem = postagemRepository.findById(id);

        if(!postagem.isEmpty()){
            comentario.setPostagem(postagem.get());
            return comentarioRepository.save(comentario);
        }

        return null;
    }

    @GetMapping("/{id}/comentarios")
    public List<Comentario> getAllComentariosByPostagemId(@PathVariable(value = "id") Long id){
        return postagemRepository.findById(id).get().getComentarios();
    }
}
