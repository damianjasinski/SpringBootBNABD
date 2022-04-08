package com.ZAI.demo.services;

import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.SeanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public Seance addSeance(Seance seance){
        return seanceRepository.save(seance);
    }

    public Seance modifySeance(Seance seance){
        Optional <Seance> seances = seanceRepository.findById(seance.getId());
        if(seances.isPresent()){
            seances.get().setRoom(seance.getRoom());
            seances.get().setAdvertisementTime(seance.getAdvertisementTime());
            seances.get().setTitles(seance.getTitles());
            seances.get().setSeanceDate(seance.getSeanceDate());
            return seance;
        }else{
            throw new NotFoundException("Seance number not found");
        }
    }

    //TODO display current
    public List<Seance> displayAll() {return seanceRepository.findAll();}

}
