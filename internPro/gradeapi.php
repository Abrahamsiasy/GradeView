<?php
include 'db/db_connect.php';
include 'functions.php';

 //conecting to database and getting the conection object
 $con = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
 
 //Checking if any error occured while conecting

 //creating a query
 $stmt = $con->prepare("SELECT id, subject, grade, ects, chours, type FROM grade1;");
 
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($id, $subject, $grade, $ects, $chours, $type);
 
 $response = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp['id'] = $id; 
 $temp['subject'] = $subject; 
 $temp['grade'] = $grade; 
 $temp['ects'] = $ects; 
 $temp['chours'] = $chours; 
 $temp['type'] = $type; 
 array_push($response, $temp);
 }
 
 //displaying the result in json format 
 echo json_encode($response);
?>