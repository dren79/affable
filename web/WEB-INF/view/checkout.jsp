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
    </div>
            
    <div class="col-md-6 col-xs-12">
        <p>To order, please provide us with the following information:</p>
    </div>
            
    <div class="col-md-12">
        
    <form action="<c:url value='purchase'/>" method="post">
        <table id="checkoutTable">
            <tr>
                <td><label for="fname">first name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="fname"
                           name="fname"
                           value="${param.fname}">
                </td>
            </tr>
            <tr>
                <td><label for="lname">last name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="lname"
                           name="lname"
                           value="${param.lname}">
                </td>
            </tr>
            <tr>
                <td><label for="name">password:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="pass"
                           name="pass"
                           value="${param.pass}">
                </td>
            </tr>
            <tr>
                <td><label for="email">email:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
                </td>
            </tr>
            <tr>
                <td><label for="addresstype">address type:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="addresstype"
                           name="addresstype"
                           value="${param.addresstype}">
                </td>
            </tr>
            <tr>
                <td><label for="address1">address line 1:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address1"
                           name="address1"
                           value="${param.address1}">
                </td>
            </tr>
            <tr>
                <td><label for="address2">address line 1:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address2"
                           name="address2"
                           value="${param.address2}">
                </td>
            </tr>
            <tr>
                <td><label for="towncity">town or city:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="towncity"
                           name="towncity"
                           value="${param.towncity}">
                </td>
            </tr>
            <tr>
                <td><label for="county">county:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="county"
                           name="county"
                           value="${param.county}">
                </td>
            </tr>
            <tr>
                <td><label for="creditcardNo">credit card number:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="creditcardNo"
                           name="creditcardNo"
                           value="${param.creditcardNo}">
                </td>
            </tr>
            <tr>
                <td><label for="ccExp">credit card expiry:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="ccExp"
                           name="ccExp"
                           value="${param.ccExp}">
                </td>
            </tr>
            <tr>
                <td><label for="ccCvv">credit card cvv:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="ccCvv"
                           name="ccCvv"
                           value="${param.ccCvv}">
                </td>
            </tr>
            <tr>
                <td><label for="ccName">credit card name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="19"
                           id="ccName"
                           name="ccName"
                           value="${param.ccName}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="submit purchase">
                </td>
            </tr>
        </table>
    </form>
    </div>
</div>
