<%--
    Document   : checkout
    Created on : May 21, 2010, 12:20:23 AM
    Author     : tgiunipero
--%>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <br>
        <span class="label label-success label-as-badge" id="checkout_badge">checkout</span>
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
                <th>description</th>
                <th><span class="glyphicon glyphicon-euro"></span></th>
            </tr>
          </thead>
          <tbody>
            <tr>
                <td>subtotal:</td>
                <td class="checkoutPriceColumn">
                    &euro; ${cart.subtotal}</td>
            </tr>
            <tr>
                <td>delivery surcharge:</td>
                <td class="checkoutPriceColumn">
                    &euro; ${initParam.deliverySurcharge}</td>
            </tr>
            <tr>
                <td class="total">total:</td>
                <td class="total checkoutPriceColumn">
                    &euro; ${cart.total}</td>
            </tr>
          </tbody>
        </table>
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
    <div class="col-md-6 col-xs-12">
        

        
    </div>
            
    <div class="col-md-6 col-xs-12">
        <p>To order, please provide us with the following information:</p>
    </div>
            
            <div class="row" id="check_row">
        <div class="col-lg-12">  
    <form action="<c:url value='purchase'/>" method="post">
        <table class="col-md-12 col-lg-12">
            
            <tbody class="col-md-4 col-sm-6" id="check1">
            <tr>
                <td><label for="fname">forename:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                           
                           id="fname"
                           name="fname"
                           value="${param.fname}">
                </td>
            </tr>
            <tr>
                <td><label for="lname">surname:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                          
                           id="lname"
                           name="lname"
                           value="${param.lname}">
                </td>
            </tr>
            <tr>
                <td><label for="name">password:</label></td>
                <td class="input-group">
                    <input type="text"
                          class="form-control input-group-lg"
                          
                           id="pass"
                           name="pass"
                           value="${param.pass}">
                </td>
            </tr>
            <tr>
                <td><label for="email">email:</label></td>
                <td class="input-group">
                    <input type="text"
                           class="form-control input-group-lg"
                       
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            </tbody>
            <tbody class="col-md-4 col-sm-6" id="check2">
            
            <tr>
                <td><label for="addresstype">address type:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="addresstype"
                           name="addresstype"
                           value="${param.addresstype}">
                </td>
            </tr>
            <tr>
                <td><label for="address1">address line 1:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="address1"
                           name="address1"
                           value="${param.address1}">
                </td>
            </tr>
            <tr>
                <td><label for="address2">address line 2:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="address2"
                           name="address2"
                           value="${param.address2}">
                </td>
            </tr>
            <tr>
                <td><label for="towncity">town or city:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="towncity"
                           name="towncity"
                           value="${param.towncity}">
                </td>
            </tr>
            <tr>
                <td><label for="county">county:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="county"
                           name="county"
                           value="${param.county}">
                </td>
            </tr>
            </tbody>
            <tbody class="col-md-4 col-sm-6" id="check3">
            
            <tr>
                <td><label for="creditcardNo">cc-num:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="creditcardNo"
                           name="creditcardNo"
                           value="${param.creditcardNo}">
                </td>
            </tr>
            <tr>
                <td><label for="ccExp">cc-exp:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccExp"
                           name="ccExp"
                           value="${param.ccExp}">
                </td>
            </tr>
            <tr>
                <td><label for="ccCvv">cc-cvv:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccCvv"
                           name="ccCvv"
                           value="${param.ccCvv}">
                </td>
            </tr>
            <tr>
                <td><label for="ccName">name:</label></td>
                <td class="inputField">
                    <input type="text"
                           class="form-control input-group-lg"
                           id="ccName"
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
    </div>
</div>
