<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%><%--
<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>--%>
<div class="row" id="index_row">
    <div class="col-md-12">    
    <div class="col-md-12 col-lg-6" id="video_div">
         <div align="center" class="embed-responsive embed-responsive-16by9">
            <video autoplay loop class="embed-responsive-item">
                <source src=img/nuig type=video/mp4>
            </video>
        </div>   
    </div>
        <div class="col-xs-12 col-sm-12 col-lg-6" id="catOuter">
        <div class="col-xs-12" id="catBoxes">
            <c:forEach var="category" items="${categories}">
                <div class="col-xs-12 col-sm-6 col-md-6" id="categoryBox">
                    <a href="category?${category.id}">
                        <span class="categoryLabel"></span>
                        <span class="categoryLabelText">${category.name}</span>
                        <img src="${initParam.categoryImagePath}${category.name}.png"
                                 alt="${category.name}" class="img-thumbnail">
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>