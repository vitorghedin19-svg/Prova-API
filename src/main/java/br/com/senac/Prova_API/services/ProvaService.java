package br.com.senac.Prova_API.services;
import br.com.senac.Prova_API.dtos.ProvaDTO;
import br.com.senac.Prova_API.dtos.ProvaFiltroDTO;
import br.com.senac.Prova_API.entidades.Prova;
import br.com.senac.Prova_API.repositorios.ProvaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProvaService {
    private ProvaRepositorio provaRepositorio;

    public ProvaService(ProvaRepositorio provaRepositorio) {this.provaRepositorio = provaRepositorio;}


    public List<Prova> listar(ProvaFiltroDTO filtro) {

        if (filtro != null && filtro.getTitulo() != null) {
            return provaRepositorio.findByTitulo(filtro.getTitulo());
        }

        return provaRepositorio.findAll();
    }

    public Prova criar(ProvaDTO prova) {
        Prova provaPersist = this.provaResquestDtoParaProva(prova);

        return provaRepositorio.save(provaPersist);
    }

    public Prova atualizar(Long id, ProvaDTO prova) {
        if(provaRepositorio.existsById(id)) {
            Prova provaPersist =
                    this.provaResquestDtoParaProva(prova);
            provaPersist.setId(id);

            return provaRepositorio.save(provaPersist);
        }

        throw new RuntimeException("Prova não encontrada");
    }

    public void deletar(Long id) {
        if(provaRepositorio.existsById(id)) {
            provaRepositorio.deleteById(id);
            return;
        }

        throw new RuntimeException("Prova não encontrada");
    }

    private Prova provaResquestDtoParaProva(
            ProvaDTO entrada) {
        Prova saida = new Prova();
        saida.setTitulo(entrada.getTitulo());
        saida.setMateria(entrada.getMateria());
        saida.setData(entrada.getData());

        return saida;
    }
}