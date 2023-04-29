package com.mg.eco.bussiness.mappers;


import org.mapstruct.*;


import java.util.List;

public interface BaseMapper<E,D>{
    List<D> toDtoList(List<E> list);
    E toEntity(D dto);
    @InheritInverseConfiguration(name = "toEntity")
    D toDto(E entity);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E partialUpdate(D dto, @MappingTarget E entity);


}
