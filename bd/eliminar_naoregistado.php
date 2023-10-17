<?php 
require "conexao.php";



$sql="SELECT * FROM candidatos WHERE fk_eleicao_id_elei='{$_GET['id_elei']}'";


$resultado=mysqli_query($conn,$sql);
if($resultado->num_rows==0){
$sql="DELETE FROM eleicao WHERE id_elei='{$_GET['id_elei']}'";
mysqli_query($conn,$sql);
}



?>