package com.projetojudo.judotexeira.infrastructure.presentation;
import com.projetojudo.judotexeira.core.dtos.request.EventoRequest;
import com.projetojudo.judotexeira.core.entities.Evento;
import com.projetojudo.judotexeira.core.usecases.EventoUseCase;
import com.projetojudo.judotexeira.infrastructure.util.ResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoUseCase eventoUseCase;

    @PostMapping
    public ResponseEntity<?> criarEvento(@RequestBody EventoRequest eventoRequest) {
        Evento eventoSalvo = eventoUseCase.salvar(eventoRequest);
        return ResponseEntity.ok(new ResponseController<>("Evento criado com sucesso", eventoSalvo).getResponseMessage());
    }

    @GetMapping
    public ResponseEntity<?> listarEventos() {
        List<Evento> eventos = eventoUseCase.findAll();
        return ResponseEntity.ok(new ResponseController<>("Lista de eventos", eventos).getResponseMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id) {
        eventoUseCase.deletar(id);
        return ResponseEntity.ok(new ResponseController<>("Evento deletado com sucesso", null).getResponseMessage());
    }
}
