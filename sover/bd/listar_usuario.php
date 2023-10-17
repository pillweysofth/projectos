<?php
require 'conexao.php';
$pagina=$_GET['pag'];
$qnd=$_GET['qnd'];
$inicio=($pagina * $qnd)-$qnd;
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
                                                    $sql="SELECT * FROM pessoa ORDER BY nome DESC LIMIT $inicio,$qnd";
                                                    $resultado=mysqli_query($conn,$sql);
                                                    $cont=$inicio;
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
                                                    $sql="SELECT * FROM ver_prov WHERE id_mun='{$dados['fk_municipios_id_mun']}'";
                                                 
                                                    $provincia=mysqli_query($conn,$sql);
                                                    $prov=mysqli_fetch_assoc($provincia);
                                                      echo $prov['nom_prov'];
                                                    ?></td>
                                                        <td><?php 
                                                    echo  $prov['nom_mun'];
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
                            $sql = "SELECT COUNT(num_bi) AS total FROM pessoa";
                             $resultado = mysqli_query($conn, $sql);
                         $row_pg = mysqli_fetch_assoc($resultado);

                        //Quantidade de pagina
                    $quantidade_pg = ceil($row_pg['total'] / $qnd);

                        //Limitar os link antes depois
                            $max_links = 2;
                            echo '<nav aria-label="paginacao">';
    echo '<ul class="pagination">';
    echo '<li class="page-item">';
    echo "<span class='page-link'><a href='#' onclick='listar_usuario(1, $qnd)'>Primeira</a> </span>";
    echo '</li>';
    for ($pag_ant = $pagina - $max_links; $pag_ant <= $pagina - 1; $pag_ant++) {
        if($pag_ant >= 1){
            echo "<li class='page-item'><a class='page-link' href='#' onclick='listar_usuario($pag_ant, $qnd)'>$pag_ant </a></li>";
        }
    }
    echo '<li class="page-item active">';
    echo '<span class="page-link">';
    echo "$pagina";
    echo '</span>';
    echo '</li>';

    for ($pag_dep = $pagina + 1; $pag_dep <= $pagina + $max_links; $pag_dep++) {
        if($pag_dep <= $quantidade_pg){
            echo "<li class='page-item'><a class='page-link' href='#' onclick='listar_usuario($pag_dep, $qnd)'>$pag_dep</a></li>";
        }
    }
    echo '<li class="page-item">';
    echo "<span class='page-link'><a href='#' onclick='listar_usuario($quantidade_pg, $qnd)'>Última</a></span>";
    echo '</li>';
    echo '</ul>';
    echo '</nav>';
?>