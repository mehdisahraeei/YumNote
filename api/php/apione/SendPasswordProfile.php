<?php



        require_once('config.php');



$ReturnPass = "0";
$arr = array();



$password = $_POST['PasswordProfile'];
$user = $_POST['UserProfile'];
$pass = $_POST['PassProfile'];


       






$sql_query = "select id,username,password,phone from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$id =  $row['id'];
$Passing = $row['password']; 







                       $qry = "UPDATE tableData SET password ='$password'  WHERE id = $id";                       	
                       			$run=mysqli_query($conn,$qry);



$sql_query = "select id,username,password,phone from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);



$id =  $row['id'];
$Passing = $row['password']; 



		
		
		
	
			if($qry==true){
	                     		                     		
               
                                       $ReturnPass = $Passing;
		
		        }
			else{
                      
                      
                                       $ReturnPass = "0";
                      
	               }





          $arr['ReturnPass'] = $ReturnPass;                        
         
          
          echo json_encode($arr);
          
          



			


		

		


  
?>
	 

