/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import entity.Category;
import session.OrderManager;
import entity.Product;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.CategoryFacade;
import session.ProductFacade;
import javax.servlet.ServletConfig;

/**
 *
 * @author david
 */
@WebServlet(name = "Controller", loadOnStartup = 1, urlPatterns = {"/category",
                                                                    "/addToCart",
                                                                    "/viewCart",
                                                                    "/updateCart",
                                                                    "/checkout",
                                                                    "/purchase",
                                                                    "/chooseLanguage"})

public class ControllerServlet extends HttpServlet {
    
    private String surcharge;
    
    @EJB
    private CategoryFacade categoryFacade;
    
    @EJB
    private OrderManager orderManager;
    @EJB
    private ProductFacade productFacade;
    
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        
        super.init(servletConfig);
        
        surcharge = servletConfig.getServletContext().getInitParameter("deliverySurcharge");
        
        // store category list in servlet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Category selectedCategory;
        Collection<Product> categoryProducts;

        // if category page is requested
        if (userPath.equals("/category")) {

            // get categoryId from request
            String categoryId = request.getQueryString();

            if (categoryId != null) {

                // get selected category
                selectedCategory = categoryFacade.find(Integer.parseInt(categoryId));

                // place selected category in session scope
                session.setAttribute("selectedCategory", selectedCategory);

                // get all products for selected category
                categoryProducts = selectedCategory.getProductCollection();

                // place category products in session scope
                session.setAttribute("categoryProducts", categoryProducts);
            }


        // if cart page is requested
        } else if (userPath.equals("/viewCart")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {

                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
            }

            userPath = "/cart";


        // if checkout page is requested
        } else if (userPath.equals("/checkout")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            // calculate total
            cart.calculateTotal(surcharge);

            // forward to checkout page and switch to a secure channel


        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // get language choice
            String language = request.getParameter("language");

            // place in request scope
            request.setAttribute("language", language);

            String userView = (String) session.getAttribute("view");

            if ((userView != null) &&
                (!userView.equals("/index"))) {     // index.jsp exists outside 'view' folder
                                                    // so must be forwarded separately
                userPath = userView;
            } else {

                // if previous view is index or cannot be determined, send user to welcome page
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;
            }

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        // if addToCart action is called
        if (userPath.equals("/addToCart")) {

            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            if (cart == null) {

                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            // get user input from request
            String productId = request.getParameter("productId");

            if (!productId.isEmpty()) {

                Product product = productFacade.find(Integer.parseInt(productId));
                cart.addItem(product);
            }

            userPath = "/category";


        // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {

            // get input from request
            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");

            Product product = productFacade.find(Integer.parseInt(productId));
            cart.update(product, quantity);

            userPath = "/cart";


        // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action
            
            if (cart != null) {  //TODO: all these need to be changed to our ones
                // extract user data from request
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String pass = request.getParameter("pass");
                String email = request.getParameter("email");
                String addresstype = request.getParameter("addresstype");
                String address1 = request.getParameter("address1");
                String address2 = request.getParameter("address2");
                String towncity = request.getParameter("towncity");
                String county = request.getParameter("county");
                String ccNumber = request.getParameter("creditcardNo");
                String ccExp = request.getParameter("ccExp");
                String ccCvv = request.getParameter("ccCvv");
                String ccName = request.getParameter("ccName");
                
                int orderId = orderManager.placeOrder(fname,
                                                        lname,
                                                        pass, 
                                                        email,
                                                        addresstype, 
                                                        address1, 
                                                        address2, 
                                                        towncity,
                                                        county,
                                                        ccNumber, 
                                                        ccExp, 
                                                        ccCvv,
                                                        ccName, 
                                                        cart);
                if (orderId != -1) {

                        // dissociate shopping cart from session
                        cart = null;

                        // end session
                        session.invalidate();

                        // get order details
                        Map orderMap = orderManager.getOrderDetails(orderId);

                        // place order details in request scope
                        request.setAttribute("customer", orderMap.get("customer"));
                        request.setAttribute("products", orderMap.get("products"));
                        request.setAttribute("orderRecord", orderMap.get("orderRecord"));
                        request.setAttribute("orderedProducts", orderMap.get("orderedProducts"));
                        request.setAttribute("address", orderMap.get("address"));
                        
                        userPath = "/confirmation";

                    // otherwise, send back to checkout page and display error
                    } else {
                        userPath = "/checkout";
                        request.setAttribute("orderFailureFlag", true);
                    }
            }
            
            userPath = "/confermation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
