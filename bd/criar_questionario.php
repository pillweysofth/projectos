<?php 
require 'conexao.php';
$id_pergunta;
$dados=unserialize(@$dado);
if(isset($_POST['titulo'])){
if($_POST['data_inicio']>$_POST['data_final']){
	echo "Verifique as datas de inicio e termino!";
}else{
	$titulo=$_POST['titulo'];
	$sobre=$_POST['sobre'];
	$data_inicio=$_POST['data_inicio'];
	$data_final=$_POST['data_final'];
	$criador=$_POST['criador'];

	$sql="INSERT INTO `questionario`(`nome_quest`,`data_inicio`,`data_fim`,`sobre`,`fk_cria`) 
	VALUES('".$titulo."','".$data_inicio."','".$data_final."','".$sobre."','".$criador."')";

		if(mysqli_query($conn,$sql)){
		
			echo 1;
		}else
		echo 0;
}

}elseif(isset($_POST['tipo_pergunta'])){
	$selecionado=$_POST['tipo_pergunta'];
	
	$sql="INSERT INTO `perguntas`(`pergunta`,`fk_questionario_id_questionario`) 
	VALUES('{$_POST['pergunta']}','{$_POST['quest_nome']}')";
	if(mysqli_query($conn,$sql)){
			$id_pergunta=mysqli_insert_id($conn);
	for( $i = 1; $i < 24 ; $i++ ){
	
switch ($selecionado) {
	case 'sim':
		if($i<4){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
		
			}
		break;
	case 'percentagem':
	if( $i > 3 && $i < 9){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
			}
		break;
	case 'zero_dez':
	if( $i > 8 && $i < 12){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
		}
			break;
	case 'zero_cem':
		if( $i > 11 && $i < 18){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
		}
		break;
	case 'semanal':
		if( $i > 17 && $i < 21){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
		}
		break;
	case 'mensal':
		if( $i > 20 && $i < 24){
			$sql="INSERT INTO `pergunta_respos`(`id_pergunta`,`id_resposta`) 
	VALUES('".$id_pergunta."','".$i."')";
		mysqli_query($conn,$sql);
			}

		break;
	
	}
	

	}
	echo 1;
}

}


?>