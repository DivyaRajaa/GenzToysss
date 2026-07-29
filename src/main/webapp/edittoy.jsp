<%@ page language="java" import="com.genztoy.model.Toy" %>

<%
Toy toy = (Toy)request.getAttribute("toy");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Toy</title>

<style>

body{
font-family:Arial;
background:#f5f0ff;
}

.container{

width:500px;
margin:40px auto;
background:white;
padding:30px;
border-radius:15px;
box-shadow:0 5px 15px rgba(0,0,0,0.2);

}

h1{

text-align:center;
color:#7b2cbf;

}

input,select,textarea{

width:100%;
padding:10px;
margin:10px 0;

}

button{

width:100%;
padding:12px;
background:#7b2cbf;
color:white;
border:none;
border-radius:8px;
cursor:pointer;

}

</style>

</head>

<body>

<div class="container">

<h1>Edit Toy</h1>

<form action="UpdateToyServlet" method="post">

<input type="hidden" name="id" value="<%=toy.getId()%>">

Name

<input type="text"
name="name"
value="<%=toy.getName()%>">

Category

<select name="category">

<option <%=toy.getCategory().equals("Boys")?"selected":""%>>
Boys
</option>

<option <%=toy.getCategory().equals("Girls")?"selected":""%>>
Girls
</option>

</select>

Price

<input type="text"
name="price"
value="<%=toy.getPrice()%>">

Description

<textarea
name="description"><%=toy.getDescription()%></textarea>

Stock

<input type="text"
name="stock"
value="<%=toy.getStock()%>">

Image

<input type="text"
name="image"
value="<%=toy.getImage()%>">

<button type="submit">

Update Toy

</button>

</form>

</div>

</body>

</html>