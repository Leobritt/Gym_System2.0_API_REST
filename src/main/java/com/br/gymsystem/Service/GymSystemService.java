package com.br.gymsystem.Service;

import com.br.gymsystem.Model.Gym_System_Model;
import com.br.gymsystem.Repository.GymSystemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GymSystemService {

    @Autowired
    public GymSystemRepository gymSystemRepository;

    public GymSystemService(GymSystemRepository gymSystemRepository) {
        this.gymSystemRepository = gymSystemRepository;
    }

    /*Read getAll*/
    public List<Gym_System_Model> findAll() {
        return gymSystemRepository.findAll();
    }

    public Optional<Gym_System_Model> findOne(UUID id) {
        return gymSystemRepository.findById(id);
    }

    @Transactional
    public Gym_System_Model save(Gym_System_Model gymSystemModel) {
        return gymSystemRepository.save(gymSystemModel);
    }

    @Transactional
    public void delete(Gym_System_Model gymSystemModel) {
        gymSystemRepository.delete(gymSystemModel);
    }
}
