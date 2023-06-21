package com.br.gymsystem.Service;

import com.br.gymsystem.Model.Gym_System_Model;
import com.br.gymsystem.Repository.GymSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GymSystemService {

    @Autowired
    public GymSystemRepository gymSystemRepository;

    public GymSystemService(GymSystemRepository gymSystemRepository){
        this.gymSystemRepository = gymSystemRepository;
    }

    /*Read getAll*/
    public List<Gym_System_Model> findAll(){
        return gymSystemRepository.findAll();
    }
}
