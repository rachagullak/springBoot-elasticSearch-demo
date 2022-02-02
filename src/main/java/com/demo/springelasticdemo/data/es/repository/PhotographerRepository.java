package com.demo.springelasticdemo.data.es.repository;

import com.demo.springelasticdemo.data.model.Photographer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerRepository extends ElasticsearchRepository<Photographer, Integer> {

    Page<Photographer> findAllById(int id, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"event_type\": \"?0\" }}}}")
    Page<Photographer> findByFilteredEventTypeQuery(String eventType, Pageable pageable);

    Page<Photographer> findAllByEventType_TypeIn(String[] eventType_type, Pageable pageable);
    Photographer findByFirstName(String firstName);
}
