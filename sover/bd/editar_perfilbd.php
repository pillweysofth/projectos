<?php 
session_start();
include 'conexao.php';




$primeiro_nome=$_POST['primeiro_nome'];
$segundo_nome=$_POST['ultimo_nome'];
$email=$_POST['email'];
$morada=$_POST['endereco'];
$sexo=$_POST['sexo'];
$data_n=$_POST['data_nascimento'];
$contato=$_POST['telemovel'];
$id=$_SESSION['id'];
$municipio=$_POST['municipio_nascimento'];


include '../util/salvar.php';
$sql ="UPDATE `pessoa` SET  `nome`='".$primeiro_nome."', `sobrenome`='".$segundo_nome."', `data_nascimento`='".$data_n."', `morada`='".$morada."', `sexo`='".$sexo."', `email`='".$email."',`foto`='".$id_foto."',`fk_municipios_id_mun`='".$municipio."', `contacto`='".$contato."' WHERE  `num_bi`='".$id."'";

	
   
            if ($conn->query($sql)) {
                   
               	$_SESSION['msg'] = '<div class="alert alert-success" role="alert">Perfil alterado!</div>';
                $_SESSION['foto']=$id_foto;

              header("Location: ../perfil.php");
             }else{
            
              echo '<div class="alert alert-danger" role="alert"><p><strong>Erro ao alterar! aqui</div>';
              header("Location: ../editar_perfil.php");
          
           }

           
       




?>