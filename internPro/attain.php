<!-- <?php

 //conecting to database and getting the conection object
 $con = new mysqli(DB_SERVER, DB_USER, DB_department, DB_DATABASE);
 
 //Checking if any error occured while conecting
$examDate = $_POST[examDate];
$id = $_POST[id];
$department = $_POST[department];
$exampType = $_POST[exampType];
 //creating a query

?> -->

<?php
$response = array();
include 'db/db_connect.php';
include 'functions.php';
 
//Get the input request parameters
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, TRUE); //convert JSON into array
 
//Check for Mandatory parameters
if(isset($input['examDate']) && isset($input['id']) && isset($input['department']) && isset($input['exampType'])){
	$examDate = $input['examDate'];
	$id = $input['id'];
	$department = $input['department'];
	$fullName = $input['exampType'];
	
	//Check if user already exist
	if(!userExists($examDate)){
 
		
		//Query to register new user
		$insertQuery  = "INSERT INTO attain(examDate, exampType, department, id) VALUES (?,?,?,?)";
		if($stmt = $con->prepare($insertQuery)){
			$stmt->bind_param($examDate,$exampType,$department,$id);
			$stmt->execute();
			$response["status"] = 0;
			$response["message"] = "chake";
			$stmt->close();
		}
	}
	else{
		$response["status"] = 1;
		$response["message"] = "User exists";
	}
}
else{
	$response["status"] = 2;
	$response["message"] = "Missing mandatory parameters";
}
echo json_encode($response);
?>