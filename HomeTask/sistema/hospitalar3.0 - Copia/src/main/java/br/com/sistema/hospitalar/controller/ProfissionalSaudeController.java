package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.dto.ProfissionalSaudeDTO;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.service.ProfissionalSaudeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/profissionalSaude")
public class ProfissionalSaudeController {

//    private final ProfissionalSaudeRepository profissionalSaudeRepository;
//
//    public ProfissionalSaudeController(ProfissionalSaudeRepository profissionalSaudeRepository) {
//        this.profissionalSaudeRepository = profissionalSaudeRepository;
//    }

    private ProfissionalSaudeService profissionalSaudeService;

    @GetMapping
    @RequestMapping
    public ResponseEntity<List<ProfissionalSaudeDTO>> findAll(){
        List<ProfissionalSaudeEntity> lista = profissionalSaudeService.findAll();
        List<ProfissionalSaudeDTO> listaDTO = lista.stream().map(obj -> new ProfissionalSaudeDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }
//
//    @GetMapping
//    @RequestMapping
//    public ResponseEntity<List<ProfissionalSaudeEntity>> findAll(){
//        List<ProfissionalSaudeEntity> lista = profissionalSaudeService.findAll();
//        return ResponseEntity.ok().body(lista);
//    }

//    @GetMapping("/{id}")
//    public ProfissionalSaudeEntity findyById(@PathVariable("id") final  Long id){
//        return this.profissionalSaudeService.findById(id).orElse(null);
//    }
//
//    @GetMapping("/{quantidadePorDepartamento}")
//    public Object findByNumberMedicByDepartament(@PathVariable("quantidadePorDepartamento") final  String departament){
//        return this.profissionalSaudeService.findByNumberMedicByDepartament(departament);
//    }
//
//    @PostMapping
//    public void createNew(@RequestBody final ProfissionalSaudeEntity profissional){
//        this.profissionalSaudeService.save(profissional);
//    }
//
//    @PutMapping
//    public void update(@RequestBody final ProfissionalSaudeEntity profissionalSaudeEntity){
//        this.profissionalSaudeService.save(profissionalSaudeEntity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") final Long id){
//        this.profissionalSaudeService.deleteById(id);
//    }

}
