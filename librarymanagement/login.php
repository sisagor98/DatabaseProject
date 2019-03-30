<?php

require "init.php";

$username = $_GET['username'];
$password = $_GET['password'];

$sql_quary = "select * from students where username like '$username'
				and password like '$password';";

		$result = mysqli_query($connection,$sql_quary);

		if(mysqli_num_rows($result)>0){
			$row = mysqli_fetch_assoc($result);
			$status = "ok";
			$response['id'] = $row['id'];
			$response['username'] = $row['username'];
			$response['password'] = $row['password'];
			//$response['name'] = $row['name'];
			//$response['email'] = $row['email'];
			$response['response'] = $status;
			$output = json_encode($response);
			echo $output;

		}else{

			$status = "failed";
			echo json_encode(array("response"=>$status));
		}

mysqli_close($connection);

?>