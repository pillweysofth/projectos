<?php
require 'conexao.php';

$sql="DELETE FROM candidatos WHERE  `id_cand`={$_GET['id_cand']}";
if(mysqli_query($conn,$sql)){
	echo 1;
}else
echo 2;
?>