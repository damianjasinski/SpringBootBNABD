package com.ZAI.demo.services;

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

    public void addSeance(Seance seance){
        seanceRepository.save(seance);
    }

    public void modifySeance(Seance seance){
        Optional <Seance> seances = seanceRepository.findById(seance.getId());
        if(seances.isPresent()){
            seances.get().setRoom(seance.getRoom());
            seances.get().setAdvertisement_time(seance.getAdvertisement_time());
            seances.get().setTitles(seance.getTitles());
            seances.get().setSeance_date(seance.getSeance_date());
        }else{
            //todo co robimy?
        }
    }

    public List<Seance> displayAll() {return seanceRepository.findAll();}

}
