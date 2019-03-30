<?php

require "init.php";


$username = $_GET['username'];
$email = $_GET['email'];
$password = $_GET['password'];
$department = $_GET['department'];
$reg =$_GET['reg'];
$session = $_GET['session'];
$phone = $_GET['phone'];

$response = array();

$sql = "select * from students where username like '$username'
				and password like '$password';";

$sql_reg="insert into students (username,email,password,department,reg,session,phone)
values ('$username','$email','$password','$department','$reg','$session','$phone');";

$result=mysqli_query($connection, $sql);

if(mysqli_num_rows($result)>0){
  $status="exist";
}else{
  if(mysqli_query($connection,$sql_reg)){

  	$new=mysqli_query($connection, $sql);
  	while($row = mysqli_fetch_array($new)){

  	$response['id']=$row['id'];
    $status="ok";
    $response['name']=$username;
    $response['email']=$email;
    }

  }else {
      $status = "error";
  }
}

$response["response"]=$status;;
$output= json_encode($response);
echo $output;
mysqli_close($connection);

?>