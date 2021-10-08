<?php



	require_once('config.php');





	   $user=$_POST['user'];	   
	   $email=$_POST['email'];
	   $password=$_POST['pass'];




    


			$qry="INSERT INTO tableData(username,email,password,phone,url)
	                       	      VALUES ('$user','$email','$password',0,'null')";

			$res=mysqli_query($conn,$qry);
			
			if($res==true){
	                     		echo json_encode(array( "status" => "true","true" => "uploaded!"));
		        }
			else{
	                     		echo json_encode(array( "status" => "true","error" => "Failed!"));
                       }


?>
