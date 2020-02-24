package com.example.mvcdemo.web;

import com.example.mvcdemo.entity.Actor;
import com.example.mvcdemo.repository.ActorRepository;
import com.example.mvcdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private ActorService actorService;

    @GetMapping(path = "/all")
    String getAllActors(Model model) {
        model.addAttribute("actors", actorRepository.findAll());
        return "actor/allActors";
    }

    @GetMapping(path = "/paginated")
    String getPageActors(Model model) {
        return "actor/pageActors";
    }

    @GetMapping(path = "/bunchActors")
    @ResponseBody
    List<Actor> getBunchActors(Actor lastActor, @RequestParam(value = "rowCount", required = false) Integer rowCount) {
        return actorService.getBunchActors(lastActor, rowCount);
    }

}