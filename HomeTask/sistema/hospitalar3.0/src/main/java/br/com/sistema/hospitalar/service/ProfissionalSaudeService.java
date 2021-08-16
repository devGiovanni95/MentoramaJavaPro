package br.com.sistema.hospitalar.service;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.exceptions.ObjectNotFoundException;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import br.com.sistema.hospitalar.repositories.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalSaudeService {


        @Autowired//serve para intanciar automaticamente pela jpa
        private ProfissionalSaudeRepository profissionalSaudeRepository;

//        public ProfissionalSaudeEntity busca(Long id){
//            Optional<ProfissionalSaudeEntity> obj = profissionalSaudeRepository.findById(id);
//            return obj.orElseThrow(() -> new ObjectNotFoundException(
//                    "Object not found! Id: " + id + ", Tipo: " + PacienteEntity.class.getName()
//            ));
//        }

        public List<ProfissionalSaudeEntity> findAll(){
            return profissionalSaudeRepository.findAll();
        }

//        public List<ProfissionalSaudeEntity> findByNumberMedicByDepartament(){
//            return profissionalSaudeRepository.findAll();
//        }

    }

