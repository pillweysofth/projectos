<?php
require "bd/conexao.php";

$sql="SELECT * FROM pessoa";
$res=mysqli_query($conn,$sql);
$cont=0;
while($pe=mysqli_fetch_assoc($res)){
        $candidato=rand(42,46);
        $eleicao=30;
        $eleitor=$pe['num_bi'];

        $sql="SELECT * FROM pessoa WHERE num_bi='$eleitor'";
        $resultado=mysqli_query($conn,$sql);
        if($pessoa_eleitor=mysqli_fetch_assoc($resultado)){
            $num_bi=$pessoa_eleitor['num_bi'];
            $cod_eleitor=sha1($num_bi);
            $sql="SELECT * FROM eleitor WHERE cod_eleitor='$cod_eleitor'";
            $verificar=$conn->query($sql);

            if($verificar->num_rows<1){

                $sexo=$pessoa_eleitor['sexo'];
                $data_n=$pessoa_eleitor['data_nascimento'];

                $sql="INSERT INTO `eleitor`(`cod_eleitor`,`sexo`,`data_nascimento`) 
                VALUES('".$cod_eleitor."','".$sexo."','".$data_n."')";
                if(mysqli_query($conn,$sql)){

                    $sql="SELECT * FROM voto WHERE cod_voto='$cod_eleitor' AND fk_eleicao_id_elei='$eleicao'";
                    $result=mysqli_query($conn,$sql);

                    if ($result->num_rows > 0) {
                        $_SESSION['msg'] = "<div class='alert alert-danger'>Você já votou!</div>";

                       }else{
                        $_SESSION['msg'] = "<div class='alert alert-success'>voto realizado</div>";
                        $sql="INSERT INTO voto (  `cod_voto`,`fk_candidatos_id_cand`,`fk_eleicao_id_elei`) 
                        VALUES ('".$cod_eleitor."','".$candidato."','".$eleicao."')";

                        if(mysqli_query($conn,$sql)){
                          
                            echo 1;
                            }else{
                             echo "<div class='alert alert-danger'>Erro!</div>";
                             }
                        }
                         }

        }else{

        $sql="SELECT * FROM voto WHERE cod_voto='$cod_eleitor' AND fk_eleicao_id_elei='$eleicao'";
        $result=$conn->query($sql);

                if ($result->num_rows > 0) {
                 echo "<div class='alert alert-danger'>Você já votou!</div>";
                   
              }else{
                    $_SESSION['msg'] = "<div class='alert alert-success'>voto realizado</div>";
                    $sql="INSERT INTO voto (  `cod_voto`,`fk_candidatos_id_cand`,`fk_eleicao_id_elei`) 
                    VALUES ('".$cod_eleitor."','".$candidato."','".$eleicao."')";

                        if($conn->query($sql)){
                            echo 1;
                     }
            }    	
            }
    }
   
}

	?>