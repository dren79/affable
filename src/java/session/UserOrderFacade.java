/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UserOrder;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class UserOrderFacade extends AbstractFacade<UserOrder> {
    @PersistenceContext(unitName = "AffableBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserOrderFacade() {
        super(UserOrder.class);
    }
    public UserOrder find(Object id) {
        UserOrder order = em.find(UserOrder.class, id);
        em.refresh(order);
        return order;
    }
    
    @RolesAllowed("UnistoreAdmin")
    public UserOrder findByUser(Object User) {
        return (UserOrder) em.createNamedQuery("UserOrder.findByUser").setParameter("User", User).getSingleResult();
    }
    
}
