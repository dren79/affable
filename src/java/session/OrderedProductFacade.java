/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Orderedproduct;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class OrderedProductFacade extends AbstractFacade<Orderedproduct> {
    @PersistenceContext(unitName = "AffableBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderedProductFacade() {
        super(Orderedproduct.class);
    }
    public List<Orderedproduct> findByUserOrderOrderid(Object id) {
        return em.createNamedQuery("Orderedproduct.findByUserOrderOrderid").setParameter("userOrderOrderid", id).getResultList();
    }
    
}
