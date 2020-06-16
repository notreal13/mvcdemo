package com.example.mvcdemo.service;

import com.example.mvcdemo.entity.Actor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ActorServiceTest {

    @Autowired
    private ActorService actorService;

    @Test
    void shouldGetBatchOfActors() {
        List<Actor> actors = new ArrayList<>(actorService.getBunchActors(new Actor(), 3));
        assertThat(actors).hasSize(3);

        actors.addAll(actorService.getBunchActors(actors.get(2), 2));
        assertThat(actors).hasSize(5);

        Comparator<Actor> actorComparator = Comparator.comparing(Actor::getLastName).thenComparing(Actor::getActorId);
        assertThat(actors).isSortedAccordingTo(actorComparator);
        assertThat(actors).doesNotHaveDuplicates();
    }

}