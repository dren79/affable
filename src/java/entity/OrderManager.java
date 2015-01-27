/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import cart.*;
import session.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgiunipero
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager 
{
    @EJB
    private OrderedProductFacade orderedproductFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private UserorderFacade userorderFacade;

    @PersistenceContext(unitName = "AffableBeanPU")
    private EntityManager em;
    @Resource
    private SessionContext context;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(String fname, String lname, String email, String password, ShoppingCart cart) 
    {

            User customer = addCustomer(fname, lname, email, password);
            Userorder order = addOrder(customer, cart);

            int id = order.getOrderid();
            
            return id;
       
    }

    private User addCustomer(String fname, String lname, String email, String password) 
    {

        User customer = new User();
        customer.setFname(fname);
        customer.setLname(lname);
        customer.setEmail(email);
        customer.setPassword(password);
        //customer.setAddress(address);
        userFacade.create(customer);
        em.flush();
        return customer;
    }

    private Userorder addOrder(User customer, ShoppingCart cart) 
    {
        int id = customer.getUserid();
        System.out.println(id);
        
        Userorder order = new Userorder();
        order.setUserUserid(customer);
        userorderFacade.create(order);
        em.flush();
        
        order.setAmount(cart.getTotal());
 
        Collection<OrderedProduct> orderedproduct = addOrderedItems(order, cart);
        
        order.setOrderedProductCollection(orderedproduct);
  
        em.persist(order);
        
        return order;
    }

    private Collection<OrderedProduct> addOrderedItems(Userorder order, ShoppingCart cart) 
    {
        Collection<OrderedProduct> orderedproductCollection = new ArrayList<OrderedProduct>()  ;

        List<ShoppingCartItem> items = cart.getItems();

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

             // set up primary key object
            OrderedProduct line = new OrderedProduct();
            line.setUserorder(order);
            line.setProduct(scItem.getProduct());
            int qty = scItem.getQuantity();
           
            line.setQuantity(qty);
            orderedproductFacade.create(line);
            
            em.flush();
            orderedproductCollection.add(line);
        }
        
        return orderedproductCollection;
        
    }

    
}