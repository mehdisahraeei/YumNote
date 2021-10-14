<?php


//---------------------------------------------------------------------------------

try{
       $host="mysql:host=localhost;dbname=yum_db";
       $user_name="root";
       $user_password="";
       $dbh=new PDO($host,$user_name,$user_password);
}
 
catch(Exception $e){
exit("Connection Error".$e->getMessage());
}

$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

//---------------------------------------------------------------------------------



$conn = mysqli_connect("localhost","root","","yum_db"); 



?>
