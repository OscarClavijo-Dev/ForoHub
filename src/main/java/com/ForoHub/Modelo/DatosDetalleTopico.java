package com.ForoHub.Modelo;

import java.time.LocalDateTime;

public record DatosDetalleTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso

) {

    public DatosDetalleTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
