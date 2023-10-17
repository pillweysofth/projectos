
<?php

  include 'conexao.php';
 

       $dados=unserialize(@$dados);
 
   
        $usuario = $_POST['nome'];
        $palavra_passe = $_POST['passe'];
        
       
      $palavra_passe=sha1($palavra_passe);
        if ($conn->connect_error){
            die("Erro na conexao: ".$conn->connect_error);
        }else{
           
             $sql ="SELECT senha_usu,nom_use, estado,fk_pessoa_id_pes FROM usuario where nom_use = '$usuario'  AND senha_usu = '$palavra_passe'";
           
            $result = $conn->query($sql);
          
            if ($result->num_rows > 0) {
                
              
                    $row = mysqli_fetch_assoc($result);
                
                    $sql="SELECT * FROM pessoa WHERE num_bi='{$row['fk_pessoa_id_pes']}'"; 
                    $num_bi=$conn->query($sql);
                    $num_bi_lo=mysqli_fetch_assoc($num_bi);

                         if($row["estado"] === '0'){
                           
                             session_start();
                             $_SESSION['estado']=$row["estado"];
                            $_SESSION['user'] = $num_bi_lo["nome"];
                            $_SESSION['id']=$row["fk_pessoa_id_pes"];
                            $_SESSION['foto']=$num_bi_lo["foto"];
                             
                                  
                         echo 0;
                         }else if($row["estado"] === '1'){
                             
                             session_start();
                             $_SESSION['estado']=$row["estado"];
                              $_SESSION['user'] = $num_bi_lo["nome"];
                            $_SESSION['id']=$row["fk_pessoa_id_pes"];
                             $_SESSION['foto']=$num_bi_lo["foto"];
                      
                             echo 1;   
                         
                            }
                        
                     
             } else{
                 
            echo "<div class='alert alert-danger' role='alert'><p><strong>Usuario ou senha Errada!!
                </strong> </div>";
                 
                  }


            
       

       
        
    }

  

?>
