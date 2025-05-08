package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {
    //HOLA MUNDOOOOO//
    //declaración de lista de libros con List
    private List<Libro> listaLibros = new ArrayList<>();

    //método que retorna todos los libros
    public List<Libro> obtenerLibro(){
        return this.listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if (libro.getId()==id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        this.listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        
        int id = 0;
        int idPosicion = 0;
        
        for (int i = 0; i < listaLibros.size(); i++) {
            
            if (listaLibros.get(i).getId()== lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;

    }

    public void eliminar(int id){
        Libro libro = this.buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }

    }

}
