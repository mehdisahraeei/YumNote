<?php



        require_once('config.php');



$id_imgp = 0;
$image_imgp = "";

$Res = array();



$image=$_POST['imageImageP'];  
$url=$_POST['urlImageP'];  
$user = $_POST['userImageP'];
$pass = $_POST['passImageP'];


           $filename="upload/$url.jpg";
	   file_put_contents($filename,base64_decode($image));








$sql_query = "select id,username,password,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$user_id =  $row['id'];
$image_Name = $row['url']; 






                       $qry = "UPDATE tableData SET url ='$filename'  WHERE id = $user_id";                       	
                       			$run=mysqli_query($conn,$qry);
		
		
		
$sql_query = "select id,username,password,url from tableData where username like '$user' and password like '$pass';";
$result = mysqli_query($conn, $sql_query);
$row = mysqli_fetch_assoc($result);

$user_id =  $row['id'];
$image_Name = $row['url']; 


		
		
		
	
			if($qry==true){
	                     		                     		
               
                                       $id_Res = $user_id;
                                       $imageRes = $filename;
		
		        }
			else{
                      
                      

                                       $IdResponse = null;
                                       $imageRes = null;

                      
	               }




          $Res['id_Res'] = $id_Res;                             
          $Res['imageRes'] = $imageRes;                        
         
          
          echo json_encode($Res);
          
          



  
?>
	 
			




