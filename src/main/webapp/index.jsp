<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Contact us</h1>
<label>Kind of Request</label><br>
<form action="main-view" method="post">
<select name="kind_req" id="type">
        <option value="Contract_Adjustment" name="CA">Contract Adjustment</option>
        <option value="Damage_Case" name="DC">Damage Case</option>
        <option value="Complaint" name="CM">Complaint</option>
</select>
<br>
Policy Number
<br>
<input type="text" name="Policy_Number">
<br>
Name
<br>
<input type="text" name="Name">
<br>
Surname
<br>
<input type="text" name="Surname">
<br>
<br>
Your Request
<style>
    textarea {
        resize: none;
    }
</style>
<br>
<textarea  id="area" name="area" rows="4" cols="50"></textarea>
<br/>
<input type="submit" value="SEND REQUEST">
</form>
</body>
</html>