package com.letscode.starwarsresistancenetwork.services;

import com.letscode.starwarsresistancenetwork.Enums.RebelStatus;
import com.letscode.starwarsresistancenetwork.exceptions.BusinessException;
import com.letscode.starwarsresistancenetwork.models.Location;
import com.letscode.starwarsresistancenetwork.models.Rebel;
import com.letscode.starwarsresistancenetwork.models.RebelRequest;
import com.letscode.starwarsresistancenetwork.models.RebelResponse;
import com.letscode.starwarsresistancenetwork.repositories.impl.RebelRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RebelService {

    private final RebelRepositoryImp rebelRepositoryImp;

    public RebelResponse save(RebelRequest request) {
        Rebel newRebel = Rebel.of(request);
        Rebel savedRebel = rebelRepositoryImp.save(newRebel);
        return RebelResponse.of(savedRebel);

    }

    public RebelResponse save(Rebel rebel) {
        Rebel updateRebel = rebelRepositoryImp.save(rebel);
        return RebelResponse.of(updateRebel);
    }

    public List<Rebel> findAll() {
        return rebelRepositoryImp.findAll();
    }

    public Rebel findById(Long id) {
        Optional<Rebel> rebelOptional = rebelRepositoryImp.findById(id);

        if (rebelOptional.isEmpty()) {
            throw new BusinessException("Rebel not found with id: " + id);
        }
        return rebelOptional.get();
    }

    public RebelResponse updateLocation(Long id, Location location) {
        Rebel rebel = findById(id);
        rebel.setLocation(location);
        Rebel updatedRebel = rebelRepositoryImp.save(rebel);
        return RebelResponse.of(updatedRebel);
    }

    public void updateStatus(Long id) {
        Rebel rebel = findById(id);
        rebel.setStatus(RebelStatus.TRAITOR);
        Rebel updatedRebel = rebelRepositoryImp.save(rebel);
        RebelResponse.of(updatedRebel);
    }
}

