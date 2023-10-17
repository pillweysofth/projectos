<?php
require 'conexao.php';

$id_elei=$_GET['id_elei'];
$sql="SELECT * FROM candidatos WHERE fk_eleicao_id_elei='$id_elei'";
$resultado=mysqli_query($conn,$sql);
				echo"	<div class='table-responsive'><table class='table'>
                    <thead><tr>
                     <th scope='col'>#</th><th>Nome Candidato</th><th>Sexo</th>
                   <th>Sobre</th>
                      </tr></thead><tbody>";
                                  $cont=0;         
                   while($candidatos=mysqli_fetch_assoc($resultado)){ 
                                    $sql="SELECT * FROM pessoa WHERE num_bi='{$candidatos['fk_pessoa_id_pes']}'";
                                         $pessoa=mysqli_query($conn,$sql);
                                         
                                         while($nome_cad=mysqli_fetch_assoc($pessoa)){
                                         	echo" <tr>
                                            <th scope='row' >
                                                    ".++$cont." 
                                                      </th>
                                           <td>
                                           {$nome_cad['nome']}
                                           </td>
                                         <td>
                                           {$nome_cad['sexo']}
                                           </td>"
                                            ;
                                         }

                                         echo "<td>
                                           {$candidatos['sobre_cand']}
                                           </td>
                                           <td>
                                           </tr>";
                                                }

                           echo"</tbody></table></div> 
                                ";

?>