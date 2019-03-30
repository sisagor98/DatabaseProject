<?php

require "init.php";


$username = $_GET['username'];
$reg = $_GET['reg'];
$bookid = $_GET['bookid'];

$response = array();

$sql = "select * from registerbook where username like '$username' and reg like '$reg';";

$sql_reg="delete from registerbook where bookid like '$bookid' and username like '$username'";

$result=mysqli_query($connection, $sql);

if(mysqli_num_rows($result)>0){
	if(mysqli_query($connection,$sql_reg))
  		$status = "ok";
  	else
  		$status = "failed";
}else{
	$status = "error";
}

$response["response"]=$status;;
$output= json_encode($response);
echo $output;
mysqli_close($connection);

?>