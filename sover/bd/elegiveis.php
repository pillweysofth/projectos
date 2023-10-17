<?php 
require "conexao.php";

$sql="INSERT INTO `pessoas_elegiveis`(`id_pessoa`) VALUES('{$_GET['id_pes']}')";
if(mysqli_query($conn,$sql)){
echo 1;
}else{
echo "Erro ao inserir ";
}
?>