package br.com.sistema.hospitalar.service;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.exceptions.ObjectNotFoundException;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {


        @Autowired//serve para intanciar automaticamente pela jpa
        private PacienteRepository pacienteRepository;

        public PacienteEntity busca(Long id){
            Optional<PacienteEntity> obj = pacienteRepository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException(
                    "Object not found! Id: " + id + ", Tipo: " + PacienteEntity.class.getName()
            ));
        }

        public List<PacienteEntity> findAll(){
            return pacienteRepository.findAll();
        }

    }

