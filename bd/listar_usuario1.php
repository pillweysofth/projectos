<?php
require 'conexao.php';
  $sql="SELECT * FROM pessoa WHERE num_bi='{$_GET['id_pes']}' OR num_univer='{$_GET['id_pes']}' OR nome='{$_GET['id_pes']}' OR sobrenome='{$_GET['id_pes']}'";
                                                    $resultado=mysqli_query($conn,$sql);
if($_GET['id_pes']!="" && $resultado->num_rows > 0){
echo '
<table class="table">
                                                <thead>
                                                    <tr>
                                                         <th scope="col">#</th>
                                                        <th>Nome Completo</th>
                                                        <th>Numero do BI</th>
                                                        <th>Nº Universitario</th>
                                                        <th>Curso</th>
                                                        <th>Sexo</th>
                                                        <th>Provincia Nascimento</th>
                                                        <th>Municipio</th>
                                                        <th>Data Nascimento</th>
                                                        <th>Email</th>
                                                        <th>Telefone</th>
                                                        <th>Morada</th>
                                                        
                                                    </tr>
                                                   
                                                </thead>
                                                <tbody>';
                                                ?>
                                                     <?php
                                                  
                                                    $cont=0;
                                                    while($dados=mysqli_fetch_assoc($resultado)){
                                                    ?>
                                                    <tr>
                                                         <th scope='row' >
                                                      <?php echo ++$cont;?></th>
                                                          
                                                        <td>
                                                            <?php  echo $dados['nome']
                                                   ." ".
                                                        $dados['sobrenome'];
                                                    ?></td>
                                                    <td><?php 
                                                     echo   $dados['num_bi'];
                                                    ?></td>
                                                    </td>
                                                    <td><?php 
                                                     echo   $dados['num_univer'];
                                                    ?></td>
                                                    </td>
                                                    <td><?php 
                                                     echo   $dados['curso'];
                                                    ?></td>
                                                        <td><?php 
                                                     echo   $dados['sexo'];
                                                    ?></td>
                                                    <td><?php 
                                                    if($dados['fk_municipios_id_mun']==null){
                                                        echo "</td>
                                                        <td></td>
                                                        ";
                                                    }else{
                                                    $sql="SELECT * FROM ver_prov WHERE id_mun='{$dados['fk_municipios_id_mun']}'";
                                                 
                                                    $provincia=mysqli_query($conn,$sql);
                                                    $prov=mysqli_fetch_assoc($provincia);
                                                      echo $prov['nom_prov'];
                                                    ?></td>
                                                        <td><?php 
                                                    echo  $prov['nom_mun'];
                                                }
                                                    ?></td>
                                                    <td><?php 
                                                    echo    $dados['data_nascimento'];
                                                    ?></td>
                                                        <td><?php 
                                                    echo    $dados['email']; ?>
                                                        <td><?php 
                                                   echo     $dados['contacto'];
                                                    ?></td>
                                                        <td><?php 
                                                   echo     $dados['morada'];
                                                    ?></td>
                                                        <td><?php 
                                                  echo      $dados['tipo'];
                                                    ?></td>
                                                  </td>
                                                    </tr>
                                                    <?php } ?>
                                                </tbody>
                                            </table>
                                <?php 
                            }else{
                            echo "<div class='alert alert-danger'>
                                <h1>Erro!</h1>
                                <p>
                                <h3>
                                Dados inserido nao encontrado
                                </h3></p></div>";
                            }
                            ?>