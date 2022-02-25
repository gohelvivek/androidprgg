<?php
$link = mysqli_connect("localhost", "root", "");
mysqli_select_db($link, "logintest");

$sel_query = "select name,password from users";
$result = mysqli_query($link, $sel_query) or die(mysqli_error($link));
while ($r = mysqli_fetch_array($result)) {
    extract($r);
    $res[] = array("username" => $name, "password" => $password);
}
header('Content-type: application/json');
echo json_encode($res);