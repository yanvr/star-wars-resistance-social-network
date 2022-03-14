package com.letscode.starwarsresistancenetwork.controllers;

import com.letscode.starwarsresistancenetwork.models.*;
import com.letscode.starwarsresistancenetwork.services.RebelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebels")
@RequiredArgsConstructor
@Slf4j
public class RebelController {

    private final RebelService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RebelResponse save(@RequestBody RebelRequest request) {
        log.info("Creating rebel: {}", request);
        RebelResponse rebelResponse = service.save(request);
        log.info("Rebel created: {}", rebelResponse);
        return rebelResponse;
    }

    @PatchMapping(value = "/{id}")
    public RebelResponse updateLocation(@PathVariable("id") Long id, @RequestBody Location location) {
        log.info("Updating Rebel: {}", id);
        RebelResponse rebelReponse = service.updateLocation(id, location);
        log.info("Rebel updated: {}", rebelReponse);
        return rebelReponse;
    }

    @GetMapping
    public List<Rebel> listAll() {
        return service.findAll();
    }
}
