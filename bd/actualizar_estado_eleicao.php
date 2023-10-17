<?php 
require 'conexao.php';

	$dados=unserialize(@$dados);
	$estado=(int)$_POST['estado_elei'];
		$id_elei=$_POST['id_elei'];
$sql="UPDATE `eleicao` SET `estado`='".$estado."' WHERE id_elei='".$id_elei."'";
if(mysqli_query($conn,$sql)){
echo 1;
}else{
echo "Erro";
}
?>