<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%--<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>--%>
            <div id="indexLeftColumn">
                <div id="welcomeText">
                    <p>[ welcome text ]</p>
                </div>
            </div>

            <div id="indexRightColumn">
                <c:forEach var="category" items="${categories}">
                    <div class="categoryBox">
                        <a href="category?${category.id}">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.name}</span>

                            <img src="${initParam.categoryImagePath}${category.name}.png"
                                 alt="${category.name}" class="categoryImage">
                        </a>
                    </div>
                </c:forEach>
            </div>

