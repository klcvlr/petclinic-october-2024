package com.petclinic.web;

import com.petclinic.core.Owner;
import com.petclinic.core.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping("/{id}")
    public Owner findById(@PathVariable Integer id){
        return ownerService.findById(id).orElseThrow();
    }

    @GetMapping("/search")
    public Owner findByFirstName(@RequestParam String firstName){
        return ownerService.findByFirstName(firstName);
    }

    @PostMapping
    public Owner save(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

}
