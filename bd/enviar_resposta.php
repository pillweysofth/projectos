<?php
require 'conexao.php';


try{
$dados=unserialize(@$dad);


	

	$sql="SELECT * FROM perguntas where fk_questionario_id_questionario='{$_POST['id_quest']}'";

	$resultado=mysqli_query($conn,$sql);
	while($row_perg=mysqli_fetch_assoc($resultado)){
		$sql="SELECT id FROM lista_pergunta_respostas
		where id_pergunta='{$row_perg['id_pergunta']}' AND id_resposta='{$_POST[$row_perg['id_pergunta']]}'";
		$resp_perg=mysqli_query($conn,$sql);
		if($id_perg_respo=mysqli_fetch_assoc($resp_perg)){

		$id_pergunta=$row_perg['id_pergunta'];
		$resposta=$_POST['id_quest'];
		$id_pes=$_POST['id_logado'];
		$resp=$id_perg_respo['id'];
		
		$sql="INSERT INTO `responder`(`fk_id_perg_resp`,`fk_id_quest`,`fk_id_pessoa`) 
		values('{$id_perg_respo['id']}','".$resposta."','".$id_pes."')";
		mysqli_query($conn,$sql);
			
	
}

}
echo 1;
}catch(Exceptio $ex){
echo $ex;
}
?>