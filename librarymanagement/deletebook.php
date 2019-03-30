<?php
require "init.php";

$bookname = $_GET['bookname'];

$response = array();

$sql_query = "delete from csebooklist where bookname like '$bookname';";

$result = mysqli_query($connection,$sql_query);


if($result)
	echo "successfully deleted";
else
	echo " error ";

$sql_query = "delete from eeebooklist where bookname like '$bookname';";

$result = mysqli_query($connection,$sql_query);

if($result)
	echo "successfully deleted";
else
	echo " error ";

$sql_query = "delete from civilbooklist where bookname like '$bookname';";

$result = mysqli_query($connection,$sql_query);

if($result)
	echo "successfully deleted";
else
	echo " error ";
		


mysqli_close($connection)

?>