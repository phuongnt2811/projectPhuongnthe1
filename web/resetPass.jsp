<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="CSS/reset.css">
    <title>Document</title>
</head>
<body>
    
<div class="wrapper">
  <div class="title">
    Reset password
  </div>
    
    <form action="update-pasword" method="POST" class="form">
    <div class="input_field">
        <input type="text" placeholder="Account" class="input" name="account">
      <i class="fas fa-user"></i>
    </div>
    <div class="input_field">
      <input type="text" placeholder="New password" name="psw" class="input">
      <i class="fas fa-lock"></i>
    </div>
    <div class="input_field">
        <input type="text" placeholder="Repeat password" name="psw-repeat" class="input">
        <i class="fas fa-lock"></i>
    </div>
      <div class="input_field">
        <h4 style="color: red">${error} </h4>
        
      </div>
    <div class="btn">
        <input type="submit" value="Reset" style="background:  #3aaf9f; color: white; font-size: 20px; border: none">
    </div>
      
        

    </form>
</body>
</html>