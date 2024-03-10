<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Student Registration App</h1>
        <form action="MainServlet" method="POST">
            <label>Student Number</label>
            <input type="text" name="studenno" placeholder="2145828820" pattern="[0-9]+" title="Please enter only numbers" ><br><br>
            <label>First Name</label>
            <input type="text" name="firstname" placeholder="Noko"><br><br>
            <label>Last Name</label>
             <input type="text" name="lastname" placeholder="Mathapo"><br><br>
             <label>Contact Number</label>
             <input type="text" name="contactno" placeholder="0795966220" pattern="[0-9]+" title="Please enter only numbers" ><br><br>
            <label>Email Address</label>
             <input type="email" name="email" placeholder="noko.mathapo@gmail.com"><br><br>
            <label>Degree Description</label>
             <input type="text" name="degree" placeholder="National Diploma in Computer Science"><br><br>
            <input type="submit" name="Request" value="Register">
            <input type="submit" name="Request" value="View List" style="background-color: #007BFF;">
        </form>
    </body>
</html>
