package com.ZAI.demo.services;

import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.RoomRepository;
import com.ZAI.demo.repository.SeanceRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;
    private final RoomService roomService;

    public Seance addSeance(Seance seance) {
        roomService.addSeanceToRoom(seance);
        return seanceRepository.save(seance);
    }

    public Seance modifySeance(Seance seance){
        Optional <Seance> seances = seanceRepository.findById(seance.getId());
        if(seances.isPresent()){
            seances.get().setAdvertisementTime(seance.getAdvertisementTime());
            seances.get().setTitles(seance.getTitles());
            seances.get().setSeanceDate(seance.getSeanceDate());
            return seance;
        }else{
            throw new NotFoundException("Seance number not found");
        }
    }

    public List<Seance> displayCurrent() {
        return seanceRepository.findAll()
                .stream()
                .filter((x) -> x.getSeanceDate().isAfter(LocalDateTime.now().minusDays(1)))
                .collect(Collectors.toList());
    }

    public List<Seance> displayAll(long order) {
        if (order == -1){
            return seanceRepository.findAll(Sort.by(Sort.Direction.DESC, "seanceDate"));
        }else if(order == 1){
            return seanceRepository.findAll(Sort.by(Sort.Direction.ASC, "seanceDate"));
        }else{
            throw new NotFoundException("Not found this kind of sorting");
        }

    }

}
