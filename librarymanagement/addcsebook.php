<?php

require "init.php";


$bookname = $_GET['bookname'];
$writername = $_GET['writername'];
$edition = $_GET['edition'];
$amount = $_GET['amount'];

$response = array();

$sql = "select * from csebooklist where bookname like '$bookname'
				and writername like '$writername' and edition like '$edition';";

$sql_book="insert into csebooklist (bookname,writername,edition,amount)
values ('$bookname','$writername','$edition','$amount');";

$result=mysqli_query($connection, $sql);

if(mysqli_num_rows($result)>0){
  $status="exist";
}else{
  if(mysqli_query($connection,$sql_book)){

  	$new=mysqli_query($connection, $sql);
  	while($row = mysqli_fetch_array($new)){

  	$response['id']=$row['id'];
    $status="ok";
    $response['bookname']=$bookname;
    $response['writername']=$writername;
    $response['edition'] = $edition;
    $response['amount'] = $amount;
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