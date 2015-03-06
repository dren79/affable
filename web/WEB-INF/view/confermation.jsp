<%-- 
    Document   : confermation
    Created on : Jan 4, 2015, 4:20:55 PM
    Author     : david
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!--            <div id="singleColumn">

                <p id="confirmationText">
                    [ text ]
                    <br><br>
                    [ order reference number ]
                </p>

                <div class="summaryColumn" >

                    <table id="orderSummaryTable" class="detailsTable" >
                        <tr class="header">
                            <th style="padding:10px">[ order summary table ]</th>
                        </tr>
                    </table>

                </div>

                <div class="summaryColumn" >

                    <table id="deliveryAddressTable" class="detailsTable">
                        <tr class="header">
                            <th style="padding:10px">[ customer details ]</th>
                        </tr>
                    </table>
                </div>
            </div>-->


<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Order Confirmation</h4>
            </div>
            <div class="modal-body">
                <p>
        <strong>Your order has been successfully processed and will be delivered within 3 days.</strong>
        <br><br>
        Please keep a note of your receipt number:
        <strong>${orderRecord.reciept}</strong>
        <br>
        If you have a query concerning your order, feel free to <a href="#">contact us</a>.
        <br><br>
        Thank you for shopping at the UniStore!
    </p>
                <p class="text-warning"><small>Close this window to print confirmation receipt</small></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

      
<div class="row">
    <div class="col-md-5 col-xs-12 col-md-offset-1" align="left">
        <br>
        <div>
            <h2>Delivery Address Summary</h2>
            <br><strong>First Name:</strong>${customer.fname}
            <br><strong>Last Name:</strong>${customer.lname}
            <br><strong>Address Line 1:</strong>${address.line1}
            <br><strong>Address Line 2:</strong>${address.line2}
            <br><strong>Town/City:</strong>${address.towncity}
            <br><strong>Email:</strong> ${customer.email}</br></div>
        </div>

       
        

<div id="singleColum">
    
    <div class="col-md-12 col-lg-6">
        <h2 class="sub-header">Order Summary</h2>
        <div class="table-responsive">
          <table class="table table-striped">
          <thead>
            <tr>
              <th>Product</th>
              <th>Quantity</th>
              <th>Price</th>
            </tr>
          </thead>
          <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">
          <tbody>
            <tr>
              <td><div class="text-left">${products[iter.index].name}</td>
              <td><div class="text-left">${orderedProduct.quantity}</td>
              <td><div class="text-left"> &euro; ${products[iter.index].price * orderedProduct.quantity}</td>
            </tr>
            </c:forEach>
          </tbody>
          <tbody>
              <tr>
                  <td><div class="text-left"><strong>Cost Summary</strong></td>
              </tr>
          </tbody>
          <tbody>
              <tr>
                  <th>Delivery Surcharge</th>
                  <th>Total</th>
                  <th>Processed</th>
              </tr>
          </tbody>
          <tbody>
              <tr>
                  <td><div class="text-left">&euro; ${initParam.deliverySurcharge}</td>
                  <td><div class="text-left">&euro; ${orderRecord.amount}</td>
                  <td><div class="text-left"><span class="glyphicon glyphicon-ok"></span>
              </tr>
          </tbody>
        </table>
      </div>
    </div>
                  </div>  
  
          <div class="goomap"  id="map-canvas"></div>
    


