<?php
require 'conexao.php';


$sobre="h";
$id_pes=$_GET['id_pes'];

$id_elei=(int)$_GET['id_elei'];
$sql="INSERT INTO `candidatos`(`sobre_cand`,`fk_eleicao_id_elei`,`fk_pessoa_id_pes`) VALUES('".$sobre."','".$id_elei."','".$id_pes."')";

if(mysqli_query($conn,$sql)){
	echo 1;
}else
echo "erro";
	
		

?>