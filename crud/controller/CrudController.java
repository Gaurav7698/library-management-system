package com.sctpl.admin.g1.crud.controller;

import com.sctpl.admin.g1.crud.dto.CrudDto;
import com.sctpl.admin.g1.crud.service.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/crud")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @PostMapping("/save")
    public CrudDto saveData(@RequestBody CrudDto crudDto) {
        return crudService.save(crudDto);
    }

    @PutMapping("/update")
    public CrudDto updateData(@RequestBody CrudDto crudDto) {
        return crudService.update(crudDto);
    }

    @DeleteMapping("/d")
    @Transactional
    public CrudDto deleteById(@RequestParam Integer crudId) {
        return crudService.deleteById(crudId);
    }

    @GetMapping("/fetch")
    public CrudDto fetchByCrudId(@RequestParam Integer crudId) {
        return crudService.fetchById(crudId);
    }
}



