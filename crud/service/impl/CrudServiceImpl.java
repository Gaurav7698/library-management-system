package com.sctpl.admin.g1.crud.service.impl;

import com.sctpl.admin.g1.crud.converter.CrudConverter;
import com.sctpl.admin.g1.crud.domain.Crud;
import com.sctpl.admin.g1.crud.dto.CrudDto;
import com.sctpl.admin.g1.crud.repository.CrudRepository;
import com.sctpl.admin.g1.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepository crudRepository;
    @Autowired
    private CrudConverter crudConverter;
    @Override
    public CrudDto save(CrudDto crudDto) {
           Crud crud = crudConverter.convertFrom(crudDto);
           Crud crud1=crudRepository.save(crud);;
           return crudConverter.convertTo(crud1);
    }

    @Override
    public CrudDto update(CrudDto crudDto) {
        Crud crud = crudRepository.findByCrudId(crudDto.getCrudId());


        if (crud == null) {
            crud = crudConverter.convertFrom(crudDto);
        } else {

            if (crudDto.getUserName() != null) {
                crud.setUserName(crudDto.getUserName());
            }
            if (crudDto.getAge() != null) {
                crud.setAge(crudDto.getAge());
            }
            if (crudDto.getAddress() != null) {
                crud.setAddress(crudDto.getAddress());
            }
            if (crudDto.getPhoneNumber() != null) {
                crud.setPhoneNumber(crudDto.getPhoneNumber());
            }
        }

        crud = crudRepository.save(crud);
        return crudConverter.convertTo(crud);
    }


    @Override
    public CrudDto deleteById(Integer crudId)  {
        crudRepository.deleteByCrudId(crudId);
        return null; // or some other indication of success
    }


    @Override
    public CrudDto fetchById(Integer crudId) {
        Crud crud = crudRepository.findByCrudId(crudId);
            return crudConverter.convertTo(crud);
    }

}
