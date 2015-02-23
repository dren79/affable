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

<div id="singleColumn">

    <p id="confirmationText">
        <strong>Your order has been successfully processed and will be delivered within 3 days.</strong>
        <br><br>
        Please keep a note of your receipt number:
        <strong>${orderRecord.reciept}</strong>
        <br>
        If you have a query concerning your order, feel free to <a href="#">contact us</a>.
        <br><br>
        Thank you for shopping at the UniStore!
    </p>

    <div class="summaryColumn" >

        <table id="orderSummaryTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">order summary</th>
            </tr>

            <tr class="tableHeading">
                <td>product</td>
                <td>quantity</td>
                <td>price</td>
            </tr>

            <c:forEach var="orderedProduct" items="${orderedProducts}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${products[iter.index].name}</td>
                    <td class="quantityColumn">
                        ${orderedProduct.quantity}
                    </td>
                    <td class="confirmationPriceColumn">
                        &euro; ${products[iter.index].price * orderedProduct.quantity}
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="deliverySurchargeCellLeft"><strong>delivery surcharge:</strong></td>
                <td id="deliverySurchargeCellRight">&euro; ${initParam.deliverySurcharge}</td>
            </tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>total:</strong></td>
                <td id="totalCellRight">&euro; ${orderRecord.amount}</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

<!--            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow"><strong>date processed:</strong>
                    
                </td>
            </tr>-->
        </table>

    </div>

    <div class="summaryColumn" >

        <table id="deliveryAddressTable" class="detailsTable">
            <tr class="header">
                <th colspan="3">delivery address</th>
            </tr>

            <tr>
                <td colspan="3" class="lightBlue">
                    ${customer.fname}
                    <br>
                    ${customer.lname}
                    <br>
                    ${address.line1}
                    <br>
                    ${address.line2}
                    <br>
                    ${address.towncity}
                    <br>
                    <hr>
                    <strong>email:</strong> ${customer.email}
                </td>
            </tr>
        </table>

    </div>
</div>

