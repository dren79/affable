/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import cart.*;
import entity.Address;
import entity.CreditCard;
import entity.Orderedproduct;
import entity.OrderedproductPK;
import entity.User;
import entity.UserOrder;
import entity.Product;
import session.*;
import java.sql.Timestamp;
import static java.time.Instant.now;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
    private ProductFacade productFacade;
    @EJB
    private AddressFacade addressFacade;
    @EJB
    private CreditCardFacade creditcardFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private UserOrderFacade userorderFacade;

    @PersistenceContext(unitName = "AffableBeanPU")
    private EntityManager em;
    @Resource
    private SessionContext context;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    
    public int placeOrder(String fname, 
                            String lname, 
                            String pass, 
                            String email,
                            String addresstype, 
                            String address1, 
                            String address2, 
                            String towncity, 
                            String county,
                            String ccNumber,
                            String ccExp,
                            String ccCvv,
                            String ccName, 
                            ShoppingCart cart) 
    {

        try {    
            

        Address addr = addAddress(addresstype, address1, address2, towncity, county); 
        CreditCard cc = addCreditcard(ccNumber, ccExp, ccCvv,ccName);     
        User customer = addCustomer(fname, lname, pass ,email, addr, cc);
            
            UserOrder order = addOrder(customer, cart);
            addOrderedItems(order, cart);
         //System.out.println("this is an order user id"+ order.getUserUserid());
            return order.getOrderid();
       
    }
    
     catch (Exception e) {
            context.setRollbackOnly();
            return -1;
     }
    }     
    private User addCustomer(String fname,String lname, String pass, String email ,Address add, CreditCard cc) {

        User customer = new User();
        customer.setFname(fname);
        customer.setLname(lname);
        customer.setPassword(pass);
        customer.setEmail(email);
        customer.setAddressAddressid(add);
        customer.setCreditCardccid(cc);
        userFacade.create(customer);
        em.flush();
        return customer;
    }
    
    private Address addAddress(String addresstype, String line1, String line2, String towncity, String county){
        Address addr = new Address();
        addr.setAddresstype(addresstype);
        addr.setLine1(line1);
        addr.setLine2(line2);
        addr.setTowncity(towncity);
        addr.setCounty(county);
        addressFacade.create(addr); 
        em.flush();        
        return addr;
    }
    
    private CreditCard addCreditcard(String ccNumber,String ccExp,String ccCvv,String ccName){
        CreditCard cc = new CreditCard();
        
        cc.setCcNumber(ccNumber);
        cc.setCcExp(ccExp);
        cc.setCcCvv(ccCvv);
        cc.setCcName(ccName);
        creditcardFacade.create(cc);
        em.flush();
        return cc;
    }

    private UserOrder addOrder(User customer, ShoppingCart cart) 
    {

        UserOrder order = new UserOrder();
        order.setUserUserid(customer);
        order.setAmount(cart.getSubtotal());
        //order.setDate(currentTimestamp);
        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        order.setReciept(i);

        userorderFacade.create(order);
        //em.persist(order);
        em.flush();
        //int t = order.getOrderid();
        //System.out.println("order id"+t);
        return order;
    }

    private void addOrderedItems(UserOrder order, ShoppingCart cart) 
    {
        //Collection<Orderedproduct> orderedproductCollection = new ArrayList<Orderedproduct>()  ;
        em.flush();
        List<ShoppingCartItem> items = cart.getItems();

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

             // set up primary key object
//            Orderedproduct line = new Orderedproduct();
//            line.setUserOrder(order);
//            line.setProduct(scItem.getProduct());
//            int qty = scItem.getQuantity();
//           
//            line.setQuantity(qty);
//            orderedproductFacade.create(line);
//            
//            
//            orderedproductCollection.add(line);
            int productId = scItem.getProduct().getProductid();

        // set up primary key object
        OrderedproductPK orderedProductPK = new OrderedproductPK();
        orderedProductPK.setUserOrderOrderid(order.getOrderid());
        orderedProductPK.setProductProductid(productId);

        // create ordered item using PK object
        Orderedproduct orderedItem = new Orderedproduct(orderedProductPK);

        // set quantity
        orderedItem.setQuantity(scItem.getQuantity());
        em.persist(orderedItem);
        //em.flush();
        }
        
        //return orderedproductCollection;
        
    }
    public Map getOrderDetails(int orderId) {

        Map orderMap = new HashMap();

        // get order
        UserOrder order = userorderFacade.find(orderId);

        // get customer
        User customer = order.getUserUserid();
        
        Address addr = customer.getAddressAddressid();
        
        // get all ordered productsfindByOrderId(orderId)
        List<Orderedproduct> orderedProducts = orderedproductFacade.findByUserOrderOrderid(orderId);

        // get product details for ordered items
        List<Product> products = new ArrayList<Product>();

        for (Orderedproduct op : orderedProducts) {

            Product p = (Product) productFacade.find(op.getOrderedproductPK().getProductProductid());
            products.add(p);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", order);
        orderMap.put("customer", customer);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", products);
        orderMap.put("address", addr);

        return orderMap;
    }

    

    
}