package br.com.senac.Prova_API.repositorios;

import br.com.senac.Prova_API.entidades.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvaRepositorio extends JpaRepository<Prova, Long> {

    List<Prova> findByTitulo(String titulo);

}