/*

This file can be downloaded and with few changes, people can easily connect to a MySQL database

*/

<?php

$host_name = "localhost"; //change to database hostname
$username = "root"; //change to database username
$password = "password"; //change to database password
$database_name = "db"; //change to database name


//No changes have to be made after this point

if( $con = mysqli_connect($host_name, $username, $password) ) {
  $db = mysqli_select_db($con, $db);
  echo "Connection established!";
}
else {
  echo "Connection could not be established.");
  exit();
}
