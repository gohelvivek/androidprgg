<?php
$link = mysqli_connect("localhost", "root", "");
mysqli_select_db($link,"logintest");

$user_name = $_POST["username"];
$password = $_POST["password"];
$sql  = "INSERT INTO `users` (`name`, `password`) VALUES ('$user_name', '$password');";
$res = mysqli_query($link,$sql)or die(mysqli_error($link));
//echo $data = mysql_num_rows($result);
if($res==1){
	echo "Insert Successful";
}
else{
	echo "Something is Wrong";
}
