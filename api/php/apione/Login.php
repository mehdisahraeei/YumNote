<?php


$output = array();

$username = $_POST['userLogin'];
$password = $_POST['passLogin'];





require_once('config.php');




//checking if user exists
$conn=$dbh->prepare('SELECT * FROM `tableData` WHERE `username` = ? AND `password` = ?' );
$conn->bindParam(1 , $username);
$conn->bindParam(2 , $password);
$conn->execute();

//results
if($conn->rowCount()!==0){
	//username exist
	$output['isSuccess'] = 1;
}else{
	$output['isSuccess'] = 0;

}





echo json_encode($output);



?>
