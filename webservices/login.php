<?php
$link = mysqli_connect("localhost", "root", "");
mysqli_select_db($link,"logintest");

$user_name = $_POST["username"];
$password = $_POST["password"];
$sel_query = "select * from users where name like '$user_name' and password like '$password'";
$result = mysqli_query($link,$sel_query);
$data = mysqli_num_rows($result);

if ($data > 0) {
	echo "Login Successful";
} else {
	echo "Sorry Please Use Valid Username and Password";
}
