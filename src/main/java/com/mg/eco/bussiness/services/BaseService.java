package com.mg.eco.bussiness.services;



import com.mg.eco.bussiness.dtos.Message;
import com.mg.eco.bussiness.mappers.BaseMapper;
import com.mg.eco.persistence.Database;
import com.mg.eco.persistence.dao.BaseDao;

import java.util.List;

public class BaseService<E, D> implements Service<E, D> {

    private final BaseDao<E> repository;

    private final BaseMapper<E, D> baseMapper;

    public BaseService(BaseDao<E> repository, BaseMapper<E, D> baseMapper) {
        this.repository = repository;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<D> getAll(int page) {
        return Database.doInTransaction(entityManager -> baseMapper.toDtoList(repository.getAll(page, entityManager)));
    }

    @Override
    public Message insert(D object) {
        return Database.doInTransaction(entityManager -> {
            E entity = baseMapper.toEntity(object);
            E insertedEntity = repository.insert(entity, entityManager);
            return generateMessage(baseMapper.toDto(insertedEntity));
        });
    }

    @Override
    public Message update(D dto, int id) {
        return Database.doInTransaction(entityManager -> {
            boolean isUpdated = repository.update(baseMapper.toEntity(dto), id, entityManager);
            if (!isUpdated)
                throw new RuntimeException("Can't update item with id = " + id + " check the id and try again later.");
            else
                return generateMessage(dto);
        });
    }

    @Override
    public Message delete(int id) {
        return Database.doInTransaction(entityManager -> {
            boolean isDeleted = repository.delete(id, entityManager);
            if (!isDeleted)
                throw new RuntimeException("Can't delete item with id = " + id + " check the id and try again later.");
            else
                return generateMessage(id);
        });
    }

    @Override
    public D findById(int id) {
        return Database.doInTransaction(entityManager -> {
            E entity = repository.findById(id, entityManager);
            return baseMapper.toDto(entity);
        });
    }

    @Override
    public List<D> findByName(String name, String fieldName, int page) {
        return Database.doInTransaction(entityManager -> baseMapper.toDtoList(repository.findByName(name, fieldName, page, entityManager)));
    }

    @Override
    public E isExist(String name, String fieldName) {
        return Database.doInTransaction(entityManager -> repository.isExist(name, fieldName, entityManager));
    }

    public Message generateMessage(Object object) {
        return  Message.messageBuilder(200)
                .setMessage("Successfull operation")
                .setObject(object)
                .build();
    }
}
