package com.br.gymsystem.Controller;

import com.br.gymsystem.DTO.Gym_System_DTO;
import com.br.gymsystem.Model.Gym_System_Model;
import com.br.gymsystem.Service.GymSystemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/gymsystem")
public class GymSystemController {

    @Autowired
    public GymSystemService gymSystemService;

    public GymSystemController(GymSystemService gymSystemService) {
        this.gymSystemService = gymSystemService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Gym_System_Model>> getAllGymMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(gymSystemService.findAll());
    }

    @GetMapping("/getOne{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(gymSystemService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> saveGymMembers(@RequestBody Gym_System_DTO gym_system_dto) {
        Gym_System_Model gymSystemModel = new Gym_System_Model();

        /*convertation DTO to model*/
        BeanUtils.copyProperties(gym_system_dto, gymSystemModel);

        gymSystemModel.setGym_member_registrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(gymSystemService.save(gymSystemModel));
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody Gym_System_DTO gym_system_dto) {
        Optional<Gym_System_Model> gymSystemModelOptional = gymSystemService.findOne(id);

        if (!gymSystemModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gym member not exists!");
        }
        Gym_System_Model gymSystemModel = new Gym_System_Model();

        /*convertation DTO to model*/
        BeanUtils.copyProperties(gym_system_dto, gymSystemModel);

        gymSystemModel.setId(gymSystemModelOptional.get().getId());
        gymSystemModel.setGym_member_registrationDate(gymSystemModelOptional.get().getGym_member_registrationDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(gymSystemService.save(gymSystemModel));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Gym_System_Model> gymSystemModelOptional = gymSystemService.findOne(id);

        if (!gymSystemModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gym member not exists!");
        }

        gymSystemService.delete(gymSystemModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
    }
}

