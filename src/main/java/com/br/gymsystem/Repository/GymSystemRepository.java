package com.br.gymsystem.Repository;

import com.br.gymsystem.Model.Gym_System_Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GymSystemRepository extends JpaRepository<Gym_System_Model, UUID> {
/*add métodos não pode ter nomes iguais e depois colocar validação no post*/
}
