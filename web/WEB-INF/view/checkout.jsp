<%--
    Document   : checkout
    Created on : May 21, 2010, 12:20:23 AM
    Author     : tgiunip
--%>


<div class="row">
<<<<<<< HEAD
    <div class="col-md-6 col-xs-12">
        <br>
        <span class="label label-success label-as-badge" id="checkout_badge">checkout</span>
    </div>
    
    <div class="col-md-6 col-xs-12">
            <br>
        <ul>
            
            <li>Next-day delivery is guaranteed</li>
            <li>A &euro; ${initParam.deliverySurcharge}
                delivery surcharge is applied to all purchase orders</li>
        </ul>

        <table class="table table-striped table-bordered" cellspacing="0" width="80%">
          <thead>
            <tr>      
                <th>description</th>
=======
    <div class="col-md-6 col-xs-12 col-lg-offset-1" align="left">
        <br>
        <span class="label label-success label-as-badge" id="checkout_badge">Checkout</span>
    </div>
</div>
    <div id="myModal" class="modal fade">
    <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Checkout</h4>
                </div>
                <div class="modal-body">
                    <h2>Here's the damage!!</h2>
            <table class="table table-striped table-bordered" cellspacing="0" width="80%">
          <thead>
            <tr>      
                <th>Description</th>
>>>>>>> origin/Dev3
                <th><span class="glyphicon glyphicon-euro"></span></th>
            </tr>
          </thead>
          <tbody>
            <tr>
<<<<<<< HEAD
                <td>subtotal:</td>
=======
                <td>Subtotal:</td>
>>>>>>> origin/Dev3
                <td class="checkoutPriceColumn">
                    &euro; ${cart.subtotal}</td>
            </tr>
            <tr>
<<<<<<< HEAD
                <td>delivery surcharge:</td>
=======
                <td>Delivery Surcharge:</td>
>>>>>>> origin/Dev3
                <td class="checkoutPriceColumn">
                    &euro; ${initParam.deliverySurcharge}</td>
            </tr>
            <tr>
<<<<<<< HEAD
                <td class="total">total:</td>
=======
                <td class="total">Total:</td>
>>>>>>> origin/Dev3
                <td class="total checkoutPriceColumn">
                    &euro; ${cart.total}</td>
            </tr>
          </tbody>
        </table>
<<<<<<< HEAD
    </div>
            
    <div class="col-md-6 col-xs-12">
        <p>To order, please provide us with the following information:</p>
    </div>
            
    <div class="col-md-12">
        
=======
            <br><br>
            <p>  Thank you for shopping at the UniStore! </p>
       
                    <p class="text-warning"><small>Close this window to print confirmation receipt</small></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
     
            
   <div class="row>">         
    <div class="col-md-12 col-xs-12">
        <strong>To order, please provide us with the following information:</strong>
    </div>
</div>  
            <div class="row" id="check_row">
        <div class="col-lg-12">  
>>>>>>> origin/Dev3
    <form action="<c:url value='purchase'/>" method="post">
        <table class="col-md-12 col-lg-12">
            
            <tbody class="col-md-4 col-sm-6" id="check1">
            <tr>
                <td><label for="fname">First Name:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                           placeholder="Enter First Name"
                           id="fname"
                           name="fname"
                           value="${param.fname}">
                </td>
            </tr>
            <tr>
                <td><label for="lname">Surname:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                           placeholder="Enter Last Name"
                           id="lname"
                           name="lname"
                           value="${param.lname}">
                </td>
            </tr>
            <tr>
                <td><label for="name">Password:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                           placeholder="Enter Password"
                           id="pass"
                           name="pass"
                           value="${param.pass}">
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                           placeholder="Enter Email Address"
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            </tbody>
            <tbody class="col-md-4 col-sm-6" id="check2">
            
            <tr>
                <td><label for="addresstype">Address Type:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="addresstype"
                           placeholder="Enter Residential Address"
                           name="addresstype"
                           value="${param.addresstype}">
                </td>
            </tr>
            <tr>
                <td><label for="address1">Address Line 1:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="address1"
                           name="address1"
                           value="${param.address1}">
                </td>
            </tr>
            <tr>
                <td><label for="address2">Address Line 2:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="address2"
                           name="address2"
                           value="${param.address2}">
                </td>
            </tr>
            <tr>
                <td><label for="towncity">Town or City:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="towncity"
                           placeholder="Enter Name of Town/City"
                           name="towncity"
                           value="${param.towncity}">
                </td>
            </tr>
            <tr>
                <td><label for="county">Country:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="county"
                           placeholder="Enter Residential Country"
                           name="county"
                           value="${param.county}">
                </td>
            </tr>
            </tbody>
            <tbody class="col-md-4 col-sm-6" id="check3">
            
            <tr>
                <td><label for="creditcardNo">Credit Card Number:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="creditcardNo"
                           placeholder="Enter Credit Card Number"
                           name="creditcardNo"
                           value="${param.creditcardNo}">
                </td>
            </tr>
            <tr>
                <td><label for="ccExp">Credit Card Expiry:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccExp"
                           placeholder="Enter Credit Card Expiry"
                           name="ccExp"
                           value="${param.ccExp}">
                </td>
            </tr>
            <tr>
                <td><label for="ccCvv">Credit Card CCV Number:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccCvv"
                           placeholder="See Reverse of Card"
                           name="ccCvv"
                           value="${param.ccCvv}">
                </td>
            </tr>
            <tr>
                <td><label for="ccName">Name of Cardholder:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccName"
                           placeholder="Enter Name on Card"
                           name="ccName"
                           value="${param.ccName}">
                </td>
            </tr>
            </tbody>
            <tbody class="col-md-2 col-md-offset-10">
            <tr>
                <td colspan="12">
                    <input type="submit" value="submit purchase">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    </div>
<<<<<<< HEAD
=======
    </div>
>>>>>>> origin/Dev3
</div>
