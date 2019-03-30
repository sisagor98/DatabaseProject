<?php

require "init.php";

$username = $_GET['username'];
$reg = $_GET['reg'];

$sql_quary = "select * from registerbook where username like '$username' and reg like '$reg' ";

$response2 = array();

$result = mysqli_query($connection,$sql_quary);

if(mysqli_num_rows($result)>0){

	while($row = mysqli_fetch_array($result)){
		$response  = array();

  			$response['bookname']=$row['bookname'];
  			$response['bookid']=$row['bookid'];
  			$response['date']=$row['date'];
			array_push($response2, $response);
	}
}else{
	$response['message'] = "no data";
}

$output= json_encode($response2);
echo $output;
mysqli_close($connection);

?>