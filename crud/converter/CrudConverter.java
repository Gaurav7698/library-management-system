package com.sctpl.admin.g1.crud.converter;

import com.sctpl.admin.g1.crud.domain.Crud;
import com.sctpl.admin.g1.crud.dto.CrudDto;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CrudConverter {

    public Crud convertFrom(CrudDto crudDto){
       if(Objects.isNull(crudDto)){
         return null;
       }
       return Crud.Builder.crud()
               .withCrudId(crudDto.getCrudId())
               .withUserName(crudDto.getUserName())
               .withAge(crudDto.getAge())
               .withPhoneNumber(crudDto.getPhoneNumber())
               .withAddress(crudDto.getAddress())
               .build();
    }
    public CrudDto convertTo(Crud crud){
     if(Objects.isNull(crud)){
        return null;
     }
     return CrudDto.Builder.crudDto()
             .withCrudId(crud.getCrudId())
             .withUserName(crud.getUserName())
             .withAge(crud.getAge())
             .withPhoneNumber(crud.getPhoneNumber())
             .withAddress(crud.getAddress())
             .build();
    }
}
