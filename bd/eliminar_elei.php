<?php 
require "Conexao.php";

$sql="DELETE FROM eleicao WHERE `id_elei`={$_GET['id_elei']}";
if(mysqli_query($conn,$sql)){
echo 1;
}else{
echo "erro";}


?>