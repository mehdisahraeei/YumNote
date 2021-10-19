<?php



        require_once('config.php');




$IdResponse = 0;
$UserResponse = "";
$PasswordResponse = "";
$EmailResponse = "";
$PhoneResponse = "";


$Res = array();





$user = $_POST['userProfile'];
$pass = $_POST['passProfile'];










$sql_query = "select id,username,email,password,phone,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$user_Id =  $row['id'];
$user_Name = $row['username']; 
$user_Email=  $row['email'];
$user_Pass = $row['password']; 
$user_Phone = $row['phone'];



		
	
			if($row==true){
	                     		                     		
               
                                       $IdResponse = $user_Id;
                                       $UserResponse = $user_Name;
                                       $EmailResponse = $user_Email;
		                        $PasswordResponse = $user_Pass;
		                        $PhoneResponse = $user_Phone;
                                       
		        }
			else{
                      
                      

               
                                       $IdResponse = null;
                                       $UserResponse = null;
		                        $PasswordResponse = null;
                                       $EmailResponse = null;
		                        $PhoneResponse = null;
	               }




          $Res['IdResponse'] = $IdResponse;                             
          $Res['UserResponse'] = $UserResponse;                        
          $Res['PasswordResponse'] = $PasswordResponse;                             
          $Res['EmailResponse'] = $EmailResponse;                         
          $Res['PhoneResponse'] = $PhoneResponse;                        
         
          
          echo json_encode($Res);
          
          



  
?>
	 
			




