<?php
require 'conexao.php';
if(strtotime($_POST['data_inicio']." ".$_POST['hora_inicio'])<strtotime($_POST['data_inicio']." ".$_POST['hora_final'])){
	if(criar_eleicoes($_POST['titulo'],$_POST['sobre'],$_POST['data_inicio'],$_POST['hora_final'],$_POST['hora_inicio'])){
		echo mysqli_insert_id($conn);
	}else{
		echo "Erro ao inserir";
	}
		
}else{
	echo "Verifique a hora seleciona";
}
function criar_eleicoes($titulo,$sobre,$data_inicio,$hora_final,$hora_inicio){
	global $conn;
	$sql="INSERT INTO `eleicao`(`titulo`, `descricao`, `estado`, `data_inicio`, `hora_final`, `hora_inicio`) VALUES ('".$titulo."', '".$sobre."', '0', '".$data_inicio."', '".$hora_final."','".$hora_inicio."')";
 $resultado=mysqli_query($conn,$sql);
		return true;

}

?>