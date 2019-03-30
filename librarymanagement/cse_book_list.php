<?php

require "init.php";

$sql_quary = "select * from csebooklist";

$response2 = array();

$result = mysqli_query($connection,$sql_quary);

if(mysqli_num_rows($result)>0){

	while($row = mysqli_fetch_array($result)){
		$response  = array();
			$response['id']=$row['id'];
			$response['bookname']=$row['bookname'];
  			$response['writername']=$row['writername'];
  			$response['edition']=$row['edition'];
  			$response['amount']=$row['amount'];
			array_push($response2, $response);
	}
}else{
	$response['message'] = "no data";
}

$output= json_encode($response2);
echo $output;
mysqli_close($connection);

?>