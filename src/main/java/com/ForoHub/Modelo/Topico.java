package com.ForoHub.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;
    private String autor;
    private String curso; // 👈 esto debe coincidir

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    //Setters
    public void setAutor(String autor) { this.autor = autor; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setStatus(String status) { this.status = status; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }


    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now(); // Fecha automática
        this.status = datos.status();
        this.autor = datos.autor();
        this.curso = datos.curso();
    }


}
