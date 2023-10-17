<?php
include 'conexao.php';

	
if(!empty($_POST['registar'])){

$primeiro_nome=$_POST['primeiro_nome'];
$segundo_nome=$_POST['ultimo_nome'];
$nom_usu=$_POST['usuario'];
$senha1=$_POST['palavra_passe'];
$senha2=$_POST['conf_pass'];
$email=$_POST['email'];
$bi="q";
$sql ="INSERT INTO `sisv_online`.`pessoa` (`num_bi`, `nome`, `sobrenome`, `email`) 
VALUES ('".$bi."','".$primeiro_nome."','".$segundo_nome."','".$email."')";
	
    if($senha1===$senha2){

            if ($conn->query($sql)) {
                   $id=mysqli_insert_id($conn);
                $sql ="INSERT INTO `sisv_online`.`usuario` ( `nom_use`, `senha_usu`,`fk_pessoa_id_pes`) VALUES ('".$nom_usu."','".$senha1."','".$id."')";
                	 if ($conn->query($sql)) {
				$mensagemSaida = '<div class="alert alert-success" role="alert">Pessoa registada</div>';
             }else{
             echo "Error: " .$sql."<br>".$conn->error;
                $erro = '<div class="alert alert-danger" role="alert"><p><strong>No se guardaron los datos </div>';
           }

            }
            else{
                
                echo "Error: " .$sql."<br>".$conn->error;
                $erro = '<div class="alert alert-danger" role="alert"><p><strong>No se guardaron los datos </div>';
            }
        }else{
            $mensagemSaida = '<div class="alert-danger" role="alert"> <p><strong>Senhas nao coincidem </div>';
        }

}
?>