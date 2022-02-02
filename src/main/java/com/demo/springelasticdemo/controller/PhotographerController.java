package com.demo.springelasticdemo.controller;

import com.demo.springelasticdemo.data.es.repository.PhotographerRepository;
import com.demo.springelasticdemo.data.model.Photographer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "/api/photographers")
@Slf4j
@AllArgsConstructor
public class PhotographerController {

    private PhotographerRepository photographerRepository;
    @GetMapping(params = {"page", "size"})
    public ResponseEntity<List<Photographer>> getPhotographers(@RequestParam("page") int page,
                                                               @RequestParam("size") int size) {
        return new ResponseEntity<>(photographerRepository.findAll(PageRequest.of(page, size)).getContent(), HttpStatus.OK);
    }

    @GetMapping(path = "{photographerID}", params = {"page", "size"})
    public ResponseEntity<List<Photographer>> getPhotographer(@RequestParam("page") int page,
                                                              @RequestParam("size") int size, @PathVariable(required = true) int photographerID) {
        Page<Photographer> photographers = photographerRepository.findAllById(photographerID, PageRequest.of(page, size));
        return new ResponseEntity<>(photographers.getContent(), HttpStatus.OK);
    }

    @GetMapping(path = "/eventType/{eventType}", params = {"page", "size"})
    public ResponseEntity<List<Photographer>> getPhotographersByEvent(@RequestParam("page") int page,
                                                                      @RequestParam("size") int size, @PathVariable(required = true) String eventType) {

        Page<Photographer> photographers = photographerRepository.findAllByEventType_TypeIn(new String[]{eventType}, PageRequest.of(page, size));
        return new ResponseEntity<>(photographers.getContent(), HttpStatus.OK);
    }


    @GetMapping(path = "/firstName/{firstName}")
    public ResponseEntity<Photographer> getPhotographerByFirstName(@PathVariable(required = true) String firstName) {

        return new ResponseEntity<>(photographerRepository.findByFirstName(firstName), HttpStatus.OK);
    }

}
