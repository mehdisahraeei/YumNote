<?php



	require_once('config.php');





	   $user=$_POST['userSignUp'];	   
	   $email=$_POST['emailSignUp'];
	   $password=$_POST['passSignUp'];




    


			$qry="INSERT INTO tableData(username,email,password,phone,url)
	                       	      VALUES ('$user','$email','$password',0,'')";

			$res=mysqli_query($conn,$qry);
			
			if($res==true){
	                     		echo json_encode(array( "status" => "true","true" => "uploaded!"));
		        }
			else{
	                     		echo json_encode(array( "status" => "true","error" => "Failed!"));
                       }


?>
