package com.te.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.User;

@Repository
public class UserRepo {
	public void saveUser(User user) {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
      EntityManager createEntityManager = factory.createEntityManager();
      EntityTransaction transaction = createEntityManager.getTransaction();
      transaction.begin();
      createEntityManager.persist(user);
      createEntityManager.find(null, transaction);
      transaction.commit();
	}
}
