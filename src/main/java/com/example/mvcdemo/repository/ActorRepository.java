package com.example.mvcdemo.repository;

import com.example.mvcdemo.entity.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

    @Query(
            value = "SELECT a.actor_id, a.first_name, a.last_name, a.last_update FROM actor a " +
                    "WHERE (a.last_name, a.actor_id) > (:lastName, :id) " +
                    "ORDER BY a.last_name, a.actor_id " +
                    "LIMIT :rowCount",
            nativeQuery = true
    )
    List<Actor> getPageActors(
            @Param("lastName") String lastName,
            @Param("id") Integer id,
            @Param("rowCount") Integer rowCount);
}
