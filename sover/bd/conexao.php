<?php
$erro =""; 
$mensagemSaida="";
$servidor="localhost";
$usuario="root";
$senha="admin";
$dbnome="sisv_online";
$conn;


$conn = mysqli_connect($servidor, $usuario, $senha, $dbnome);
	//require "../util/alterar_estado.php";
//estado_eleicao($conn);
?>