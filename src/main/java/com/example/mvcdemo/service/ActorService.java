package com.example.mvcdemo.service;

import com.example.mvcdemo.entity.Actor;
import com.example.mvcdemo.repository.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ActorService {
    private final Logger log = LoggerFactory.getLogger(ActorService.class);

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getBunchActors(Actor lastActor, Integer rowCount) {
        String lastName = StringUtils.isEmpty(lastActor.getLastName()) ? "" : lastActor.getLastName();
        Integer id = lastActor.getActorId() == null ? 0 : lastActor.getActorId();
        log.info("Getting actors with lastName: {}, id: {}, rowCount: {}", lastName, id, rowCount);

        return actorRepository.getPageActors(lastName, id, rowCount);
    }
}
