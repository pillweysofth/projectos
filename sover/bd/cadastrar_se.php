<?php 

    include 'conexao.php';
 try{   
$dados=unserialize(@$dad);

$bi=$_POST['num_bi'];
$num_univer=$_POST['num_univ'];
$senha1=$_POST['palavra_passe'];
    $senha1=sha1($senha1);
          

                $sql ="INSERT INTO `sisv_online`.`usuario` ( `nom_use`, `senha_usu`,`fk_pessoa_id_pes`) VALUES ('".$num_univer."','".$senha1."','".$bi."')";
                     if ($conn->query($sql)) {
                 
                 echo 1;
                    }else{
             echo "Error: " .$sql."<br>".$conn->error;
             
           }

           
    }catch(mysqli_sql_exception $ex){
       $mensagem=$ex->getMessage();
       if(strpos($mensagem, "PRIMARY")){
        echo "Numero do BI inserido ja se encontra registado!";
       }elseif(strpos($mensagem, "num_univer")){
        echo "Verifica o numero Universitario!";
       }elseif(strpos($mensagem, "nom_use")){
        echo "Nome de Usuario inserido ja se encontra registado!";
       
       }else{
        echo $ex->getMessage();
       }
       
    }


?>