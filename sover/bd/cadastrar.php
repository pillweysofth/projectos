<?php 
    include 'conexao.php';
 try{   
$dados=unserialize(@$dad);
$municipio="";
$primeiro_nome=$_POST['nome'];
$segundo_nome=$_POST['ultimo_nome'];
$email=$_POST['email'];
$bi=$_POST['num_bi'];
if(!isset($_POST['provincia_nascimento']))
$municipio=(int)$_POST['municipio_nascimento'];
$sexo=$_POST['sexo'];
$contato=$_POST['telemovel'];
$morada=$_POST['morada'];
$curso=$_POST['curso'];
$num_univer=$_POST['num_univ'];
$data_n=$_POST['data_nascimento'];
if($primeiro_nome !="" && $bi !="" && $num_univer !="" && $curso !="" && $sexo != "" && $segundo_nome != "" && $data_n ){
$sql ="INSERT INTO `pessoa` (`num_bi`, `nome`, `sobrenome`,`sexo`,`data_nascimento`,`curso`,`num_univer`) 
VALUES ('".$bi."','".$primeiro_nome."','".$segundo_nome."','".$sexo."','".$data_n."','".$curso."','".$num_univer."')";
  
   
            $conn->query($sql);

                 
                 echo 1;
         
           }else{
              echo "Verifique os campos obrigatorios!";
           }
       
    }catch(mysqli_sql_exception $ex){
       $mensagem=$ex->getMessage();
      
  
       if(strpos($mensagem, "PRIMARY")){
        echo "Numero do BI inserido ja se encontra registado!";
       }elseif(strpos($mensagem, "num_univer") &&
         strpos($mensagem,"duplicate")==0){

        echo "Numero Universitario inserido ja se encontra registado!";
        }elseif(strpos($mensagem, "num_univer")){
          echo "Verifica o numero Universitario!";

         
       }elseif(strpos($mensagem, "nom_use")){
        echo "Nome de Usuario inserido ja se encontra registado!";
       
       }else{
        echo $ex->getMessage();
       }
       
    }


?>