package br.com.senac.Prova_API.controllers;

import br.com.senac.Prova_API.dtos.ProvaDTO;
import br.com.senac.Prova_API.dtos.ProvaFiltroDTO;
import br.com.senac.Prova_API.entidades.Prova;
import br.com.senac.Prova_API.services.ProvaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prova")
@CrossOrigin

public class ProvaController {
    private ProvaService provaService;

    public ProvaController(ProvaService provaService) {
        this.provaService = provaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Prova>> listar(ProvaFiltroDTO filtro) {
        return ResponseEntity.ok(provaService.listar(filtro));
    }

    @PostMapping("/criar")
    public ResponseEntity<Prova> criar(
            @RequestBody ProvaDTO prova) {
        try {
            return ResponseEntity.ok(provaService.criar(prova));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Prova> atualizar(@RequestBody ProvaDTO prova, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(provaService.atualizar(id, prova));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {provaService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Prova> ListarById (@PathVariable Long id
    ) {
        try {
            return ResponseEntity.ok(provaService.ListarById(id));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }
}