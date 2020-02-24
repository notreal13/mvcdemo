package com.example.mvcdemo.service;

import com.example.mvcdemo.entity.Actor;
import com.example.mvcdemo.repository.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ActorService {
    private final Logger log = LoggerFactory.getLogger(ActorService.class);

    final private List<Actor> actors = new ArrayList<>();

    @Autowired
    private ActorRepository actorRepository;

    public Page<Actor> findPaginated(Pageable pageable) {
        if (actors.isEmpty()) {
            for (Actor actor : actorRepository.findAll()) {
                actors.add(actor);
            }
        }
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actor> list;

        if (actors.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, actors.size());
            list = actors.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actors.size());

    }

    public List<Actor> getBunchActors(Actor lastActor, Integer rowCount) {
        String lastName = StringUtils.isEmpty(lastActor.getLastName()) ? "" : lastActor.getLastName();
        Integer id = lastActor.getActorId() == null ? 0 : lastActor.getActorId();
        log.info("Getting actors with lastName: {}, id: {}, rowCount: {}", lastActor, id, rowCount);

        return actorRepository.getPageActors(lastName, id, rowCount);
    }
}
