package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;
    
    
    @GetMapping
    public List<Libro> listaLibros(){
        return libroService.getLibros();
    }
    
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id)
    {
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id,@RequestBody Libro libro){
        return libroService.updateLibro(libro);

    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteString(id);
    }

    
}
