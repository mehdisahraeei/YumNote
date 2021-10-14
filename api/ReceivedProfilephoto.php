<?php



        require_once('config.php');



$id_img = 0;
$imageimg = "";

$Res = array();


$user = $_POST['userimg'];
$pass = $_POST['passimg'];









$sql_query = "select id,username,email,password,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$user_id =  $row['id'];
$image_Name = $row['url']; 




		
		
		
	
			if($row==true){
	                     		                     		
               
                                       $id_img = $user_id;
                                       $imageimg = $image_Name;
		
		        }
			else{
                      
                      

                                       $id_img = null;
                                       $imageimg = null;

                      
	               }




          $Res['id_img'] = $id_img;                             
          $Res['imageimg'] = $imageimg;                        
         
          
          echo json_encode($Res);
          
          



  
?>
	 
			




