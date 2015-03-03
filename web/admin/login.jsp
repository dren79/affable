<%-- 
    Document   : login
    Created on : 27-Feb-2015, 12:48:27
    Author     : Ryan
--%>

<form action="j_security_check" method=post>
    <a href="login.jsp"></a>
    <div id="loginBox">
        <p><strong>username:</strong>
            <input type="text" size="20" name="j_username"></p>

        <p><strong>password:</strong>
            <input type="password" size="20" name="j_password"></p>

        <p><input type="submit" value="submit"></p>
    </div>
</form>