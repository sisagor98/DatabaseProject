<?php

require "init.php";


$username = $_GET['username'];
$reg = $_GET['reg'];
$bookname = $_GET['bookname'];
$bookid = $_GET['bookid'];
$date =$_GET['date'];

$response = array();

$sql = "select * from registerbook where bookname like '$bookname';";
$sql2 = "select * from students where username like '$username' and reg like '$reg'";

$sql_reg="insert into registerbook (username,reg,bookname,bookid,date)
values ('$username','$reg','$bookname','$bookid','$date');";

$result=mysqli_query($connection, $sql);
$result1=mysqli_query($connection, $sql2);

if(mysqli_num_rows($result)>0){
  $status="exist";
}else{
  if(mysqli_num_rows($result1)>0){
    if(mysqli_query($connection,$sql_reg)){

  	 $new=mysqli_query($connection, $sql);
  	 while($row = mysqli_fetch_array($new)){
        $status="ok";
     }

   }else {
      $status = "error";
   }
  }
}

$response["response"]=$status;;
$output= json_encode($response);
echo $output;
mysqli_close($connection);

?>