package com.petclinic.web;

import com.petclinic.core.Visit;
import com.petclinic.core.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/{id}")
    public Visit findById(@PathVariable Integer id){
        return visitService.findById(id);
    }


}
