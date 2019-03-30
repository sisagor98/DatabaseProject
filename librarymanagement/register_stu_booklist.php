<?php

require "init.php";

$sql_quary = "select distinct username,reg from registerbook"; 
$response2 = array();

$result = mysqli_query($connection,$sql_quary);

if(mysqli_num_rows($result)>0){

	while($row = mysqli_fetch_array($result)){
		$response  = array();
			//$response['id']=$row['id'];
			$response['username']=$row['username'];
  			$response['reg']=$row['reg'];
  			//$response['bookname']=$row['bookname'];
			array_push($response2, $response);
	}
}else{
	$response['message'] = "no data";
}

$output= json_encode($response2);
echo $output;
mysqli_close($connection);

?>