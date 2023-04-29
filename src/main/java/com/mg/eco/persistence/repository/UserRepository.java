package com.mg.eco.persistence.repository;

import com.mg.eco.persistence.Database;
import com.mg.eco.persistence.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User>{
    public UserRepository() {
        super(User.class);
    }

    public boolean login(String email, String password) {
        return Database.doInTransaction(entityManager -> entityManager.createQuery("From User where email = ?1 and password =?2")
                .setParameter(1, email)
                .setParameter(2, password)
                .getSingleResult() !=null);
    }
}
