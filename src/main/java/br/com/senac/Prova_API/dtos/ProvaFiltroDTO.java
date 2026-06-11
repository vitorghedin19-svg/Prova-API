package br.com.senac.Prova_API.dtos;

import java.time.LocalDate;

public class ProvaFiltroDTO {

    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public ProvaFiltroDTO(String titulo) {
        this.titulo = titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
