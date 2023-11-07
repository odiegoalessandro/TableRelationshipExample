package com.relationship.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "POSTAGEM_TB")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String texto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postagem")
    private List<Comentario> comentarios;

}
