package com.sctpl.admin.g1.crud.service;

import com.sctpl.admin.g1.crud.dto.CrudDto;

public interface CrudService {

    CrudDto save(CrudDto crudDto);

    CrudDto update(CrudDto crudDto);


    CrudDto deleteById(Integer crudId);

    CrudDto fetchById(Integer crudId) ;
}
