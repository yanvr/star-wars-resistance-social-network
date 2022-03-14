package com.letscode.starwarsresistancenetwork.repositories.impl;

import com.letscode.starwarsresistancenetwork.models.Rebel;
import com.letscode.starwarsresistancenetwork.repositories.RebelRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RebelRepositoryImp {

    private final RebelRepository repository;

    public Rebel save(Rebel rebel) {
        repository.save(rebel);
        return rebel;
    }

    public List<Rebel> findAll() {
        return repository.findAll();
    }

    public Optional<Rebel> findById(Long id) {
        return repository.findById(id);
    }

}
