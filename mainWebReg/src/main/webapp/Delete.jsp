<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.server.Register"%>

<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

.container {
    width: 600px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.user-details {
    margin-bottom: 20px;
}

.user-details label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
}

.user-details p {
    margin: 5px 0;
}

.btn {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.btn:hover {
    background-color: #0056b3;
}

.user-details {
    width: 100%;
}

.user-details table {
    width: 100%;
    border-collapse: collapse;
}

.user-details td {
    padding: 8px;
    border: 2px solid #ddd;
}

.user-details td:first-child {
    width: 120px;
    font-weight: bold;
}

.user-details td:nth-child(odd) {
    background-color: #f2f2f2;
}

.user-details tr:last-child td {
    border-bottom: none;
}

.search-box {
    margin: 20px 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.search-box form {
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 5px;
    background-color: #f9f9f9;
}

.search-box input[type="text"] {
    border: none;
    padding: 10px;
    font-size: 16px;
    outline: none;
    border-radius: 5px 0 0 5px;
    width: 300px;
}

.search-box input[type="submit"] {
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    border-radius: 0 5px 5px 0;
    transition: background-color 0.3s ease;
}

.search-box input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
    <div class="container">
    <form action="Sorting" method="post">
             <select name="column" id="column"
                style="width: 7%; padding: 10px; margin: 10px 0; border-radius: 4px; border: 1px solid #ccc; font-size: 16px;">
                <option value="name">Name</option>
                <option value="attendance">Email</option>
            </select>
            <button type="submit"
                style="background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Sort</button>
        </form>
     <div class="search-box">
            <form action="SearchServlet" method="post">
                <input type="text" name="name" placeholder="Search...">
                <input type="submit" value="Search">
            </form>
        </div>
        <h2>User Details</h2>
        <div class="user-details">
            <table>
                <thead>
                    <tr>
                    	<th>id</th>
                        <th>Name</th>
                        <th>Mobile</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    ArrayList<Register> user = (ArrayList<Register>) request.getAttribute("list");
                    if (user != null) {
                        for (Register info : user) {
                    %>
                    <tr>
                    	<td><%=info.getId()%>
                        <td><%=info.getName()%></td>
                        <td><%=info.getMobile()%></td>
                        <td><%=info.getEmail()%></td>
                        <td>
                            <form action="Registration" method="post">
                                <input type="hidden" name="deleteid" value="<%=info.getId()%>">
                                <input type="submit" name="action" value="Delete">
                            </form>
                        </td>

                      <td>
                        <input type="hidden" name="action" value="update">
                         <input type="hidden" name="editid" value="<%= info.getId() %>">
                         <button class="edit-btn" type="button" onclick="location.href = 'Update.jsp?editid=<%=info.getId()%>'">Edit</button>
                        </td>
                    </tr>
                    <%
                    }
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>