package com.prince;

import jakarta.persistence.*;
import java.util.List;

public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    // CREATE
    public void create(User u) {
        em.persist(u);
    }

    // READ by id
    public User find(int id) {
        return em.find(User.class, id);
    }

    // READ by email
    public User findByEmail(String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :u", User.class)
                     .setParameter("u", email)
                     .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
    // READ by telephone
    public User findByTelephone(String numeroTelephone) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.numeroTelephone = :u", User.class)
                     .setParameter("u", numeroTelephone)
                     .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    // UPDATE (merge)
    public User update(User u) {
        return em.merge(u);
    }

    // DELETE
    public void delete(User u) {
        User managed = em.contains(u) ? u : em.merge(u);
        em.remove(managed);
    }

    // SEARCH par nom (LIKE) + pagination
    public List<User> searchByName(String q, int page, int pageSize) {
        return em.createQuery("SELECT u FROM User u WHERE LOWER(u.fullname) LIKE :q", User.class)
                 .setParameter("q", "%" + q.toLowerCase() + "%")
                 .setFirstResult((page-1)*pageSize)
                 .setMaxResults(pageSize)
                 .getResultList();
    }
}
