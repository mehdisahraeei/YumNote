<?php



        require_once('config.php');



$Phone_res = "0";
$Res = array();



$phone = $_POST['phoneP'];
$user = $_POST['userPhone'];
$pass = $_POST['passPhone'];


       






$sql_query = "select id,username,email,password,phone,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$user_id =  $row['id'];
$user_phone = $row['phone']; 







                       $qry = "UPDATE tableData SET phone ='$phone'  WHERE id = $user_id";                       	
                       			$run=mysqli_query($conn,$qry);



$sql_query = "select id,username,email,password,phone,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);


$user_id =  $row['id'];
$user_phone = $row['phone']; 


		
		
		
	
			if($qry==true){
	                     		                     		
               
                                       $Phone_res = $user_phone;
		
		        }
			else{
                      
                      
                                       $Phone_res = "0";

                      
	               }





          $Res['Phone_res'] = $Phone_res;                        
         
          
          echo json_encode($Res);
          
          



			


		

		


  
?>
	 

