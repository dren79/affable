<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : category
    Created on : Jan 4, 2015, 4:19:35 PM
    Author     : david
--%>
<%--<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>
<sql:query var="selectedCategory" dataSource="jdbc/affablebean">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>
<sql:query var="categoryProducts" dataSource="jdbc/affablebean">
    SELECT * FROM product WHERE category_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>
<div class="row" id="category_row">
    <div class="col-md-12">
    <ul class="nav nav-justified">
            
                <c:forEach var="category" items="${categories}">

                    <c:choose>
                        
                        <c:when test="${category.name == selectedCategory.name}">
                            <li class="active">
<!--                                <span class="categoryText">-->
                                    ${category.name}
<!--                                </span>-->
                            </li>
                        </c:when>
                        
                        
                        <c:otherwise>
                            <li>
                            <a href="category?${category.id}">
<!--                                <span class="categoryText">-->
                                    ${category.name}
<!--                                </span>-->
                            </a>
                            </li>
                        </c:otherwise>
                        
                    </c:choose>

                </c:forEach>
            
    </ul>
            <table class="table table-striped table-bordered" cellspacing="0" width="80%">
          <thead>
            <tr>
                <th>Swag</th>
                <th>Description</th>
                <th><span class="glyphicon glyphicon-euro"></span></th>
                <th><span class="glyphicon glyphicon-thumbs-up"></span></th>
            </tr>
          </thead>
          <tbody>
                    <c:forEach var="product" items="${categoryProducts}" varStatus="iter">

                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                            <td>
                                <img src="${initParam.productImagePath}${product.name}.png" class="img-responsive-3 img-responsive-4"
                                    alt="${product.name}">
                            </td>
                            <td>
                                ${product.name}
                                <br>
                                <span class="smallText">${product.descreption}</span>
                            </td>
                            <td>
                                &euro; ${product.price} / unit
                            </td>
                            <td>
                                <form action="addToCart" method="post">
                                    <input type="hidden"
                                           name="productId"
                                           value="${product.productid}">
                                    <input type="submit"
                                           value="add to cart">
                                </form>
                            </td>
                        </tr>

                    </c:forEach>
          </tbody>
                </table>
            </div>
    </div>
</div>
