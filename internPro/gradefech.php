<?php
$response = array();
include 'db/db_connect.php';
include 'functions.php';
 
//Get the input request parameters
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, TRUE); //convert JSON into array
 
$result = midqli_query($con,$sql);
while ($row = mysql_fetch_array($result)) {
	# code...
	array_push($response,  array('id' => $row['id'], 'subject_1' => $row['subject_2'], 'subject_2' => $row['subject_2'], 'subject_3' => $row['subject_3']);)
}