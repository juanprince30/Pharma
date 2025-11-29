package com.prince;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class VenteRepository {
	private final EntityManager em;

    public VenteRepository(EntityManager em) {
        this.em = em;
    }

    // CREATE
    public void create(Vente u) {
        em.persist(u);
    }

    // READ by id
    public Vente find(int id) {
        return em.find(Vente.class, id);
    }
    
    // READ by User_id
    public List<Vente> findById_user(int id_user) {
        try {
            return em.createQuery("SELECT u FROM Vente u WHERE u.user.id = :u", Vente.class)
                     .setParameter("u", id_user)
                     .getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
}
