<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>




<div class="col-md-12 col-sm-12">
    <div class="row">
        <div class="col-md-4 col-sm-12 col-md-offset-8" >
            <c:choose>
                <c:when test="${cart.numberOfItems > 1}">
                    <span class="label label-success label-as-badge" id="shopping_badge">You have ${cart.numberOfItems} items.</span>
                </c:when>
                <c:when test="${cart.numberOfItems == 1}">
                    <span class="label label-warning label-as-badge" id="shopping_badge">Only one ${cart.numberOfItems} item?</span>
                </c:when>
                <c:otherwise>
                    <span class="label label-default label-as-badge" id="shopping_badge">Empty cart.  
                    <span class="glyphicon glyphicon-thumbs-down"></span>
                    </span>
                </c:otherwise>
            </c:choose>
        </div>
        
            <div class="btn-group btn-group-lg" id="cart_button_group">
        <%-- clear cart widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">

            <c:url var="url" value="viewCart">
                <c:param name="clear" value="true"/>
            </c:url>

            <a href="${url}" class="btn btn-primary">
                <span class="glyphicon glyphicon-remove-sign"></span>
                clear cart
            </a>
        </c:if>

        <%-- continue shopping widget --%>
        <c:set var="value">
            <c:choose>
                <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
                <c:when test="${!empty selectedCategory}">
                    category
                </c:when>
                <%-- otherwise send user to welcome page --%>
                <c:otherwise>
                    index.jsp
                </c:otherwise>
            </c:choose>
        </c:set>

        <c:url var="url" value="${value}"/>
        <a href="${url}" class="btn btn-primary">
            <span class="glyphicon glyphicon-fast-backward"></span>
            go shopping
        </a>

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            <a href="<c:url value='checkout'/>" class="btn btn-primary">
                go pay 
                <span class="glyphicon glyphicon-fast-forward"></span>
            </a>
        </c:if>
    </div>
     <div class="row">   
    <c:if test="${!empty cart && cart.numberOfItems != 0}">
        <div class="col-md-4 col-sm-12 col-md-offset-8" id="sub">
            <span class="label label-success label-as-badge">subtotal: <span class="glyphicon glyphicon-euro"></span> ${cart.subtotal}</span>
        </div>
    </div>
      <table class="table table-striped table-bordered" cellspacing="0" width="80%">
          <thead>
            <tr>
                <th>Swag</th>
                <th>name</th>
                <th><span class="glyphicon glyphicon-euro"></span></th>
                <th><span class="glyphicon glyphicon-duplicate"></span></th>
            </tr>
          </thead>
          <tbody>
        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

          <c:set var="product" value="${cartItem.product}"/>

          <tr class="${((iter.index % 2) == 0) ? 'lightblue' : 'white'}">
            <td>
                
                <img src="${initParam.productImagePath}${product.name}.png" class="img-responsive img-responsive-2"
                   alt="${product.name}">
            </td>

            <td>${product.name}</td>

            <td>
                &euro; ${cartItem.total}
                <br>
                <span class="smallText">( &euro; ${product.price} / unit )</span>
            </td>

            <td>
                <form action="<c:url value='updateCart'/>" method="post">
                    <input type="hidden"
                           name="productId"
                           value="${product.productid}">
                    <input type="text"
                           maxlength="2"
                           size="2"
                           value="${cartItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           name="submit"
                           value="update">
                </form>
            </td>
          </tr>

        </c:forEach>
          </tbody>  
      </table>

    </c:if>
    </div>
</div>