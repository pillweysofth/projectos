<?php 
require 'conexao.php';
$sql="SELECT * FROM pessoa";

function buscar_todos(){
	global $sql;
	global $conn;
	$resultado=mysqli_query( $conn,$sql);
	return $resultado;
}


