 <?php 
 require 'conexao.php';

$elei=$_GET['elei'];
$pagina=$_GET['pagina'];
$qnd=$_GET['qntd'];
$inicio=($pagina * $qnd)-$qnd;

                $sql="SELECT * FROM dados_voto WHERE id_elei='$elei' ORDER BY data_nascimento DESC LIMIT $inicio,$qnd";
                                                        $resultado=mysqli_query($conn,$sql);
                                                        $sql="SELECT * FROM dados_voto WHERE id_elei='$elei'";
                                                        $result=mysqli_query($conn,$sql);
                                                    if($result->num_rows > 0){
   echo ' <div class="col-lg-5">
                                    <div class="card shadow">
                                        <div class="card-header">
                                            Participantes nas Eleiçoes
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                        <th scope="col">#</th>
                                                            <th>
                                                                Hora de voto
                                                            </th>
                                                            <th>
                                                                Sexo
                                                            </th>
                                                            <th>
                                                                Idade
                                                            </th>
                                                            
                                                        </tr>
                                                    </thead>
                                                    <tbody>';
                                                    $total_m=0;
                                                    $total_h=0;
                                                     $total_reg=0;
                                                     $cont=$inicio;
                                                     while ($dados=mysqli_fetch_assoc($result)) {
                                                         if($dados['sexo']=="Homem"){
                                                                $total_h++;
                                                            }else{
                                                                $total_m++;
                                                            } 
                                                        }                                                    
                                                        
                                                        while($dados=mysqli_fetch_assoc($resultado)){
                                                           
                                                                $total_reg=$dados['total'];
                                                            $idade=(date('Y',strtotime("today"))-date('Y',strtotime($dados['data_nascimento'])));
                                                            $hora=date('H : i',strtotime($dados['data_voto']));
                                                           
                                                       echo "<tr>
                                                       <th scope='row' >
                                                       ".++$cont."</th>
                                                            <td>
                                                            ".$hora."
                                                            </td>
                                                            <td>
                                                            {$dados['sexo']}
                                                            </td>
                                                            <td>
                                                            ".$idade."
                                                            </td>
                                                        </tr>";
                                                        }
                                                        
                                                        $perc_H=number_format(($total_h*100)/($total_h+$total_m),2);
                                                        $perc_M=number_format(($total_m*100)/($total_h+$total_m),2);

                        $perc_v=number_format((($total_h+$total_m)*100)/$total_reg,2);
                                          echo '

                                                    </tbody>
                                                    
                                                </table>
                                                ';

                            $sql = "SELECT * FROM resultado_eleicao WHERE id=$elei";
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


                                                echo '
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                <div class="col-lg-7">
                                     <div >
                            <div class="card shadow border-start-info py-2">
                                <div class="card-body">
                                    <div class="row align-items-center">
                                        <div class="col-lg-12">
                                        <div class="card shadow border-start-info py-2">
                                <div class="card-body">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col me-2">
                                            <div class="text-uppercase text-info fw-bold text-xs mb-1"><span>Participaçao dos domens</span></div>
                                            <div class="row g-0 align-items-center">
                                                <div class="col-auto">
                                                    <div class="text-dark fw-bold h5 mb-0 me-3"><span>'.$perc_H.'%</span></div>
                                                </div>
                                                <div class="col">
                                                    <div class="progress progress-xl">
                                                        <div class="progress-bar bg-info" aria-valuenow="'.$perc_H.'" aria-valuemin="0" aria-valuemax="100" style="width:'.$perc_H.'%;"><span ">'.$total_h.' homens participaram</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                </div>
                            </div>
                                         </div>
                                       
                                         <div class="col-lg-12 shadow">
                                         <div class="card shadow border-start-info py-2">
                                <div class="card-body">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col me-2">
                                            <div class="text-uppercase text-info fw-bold text-xs mb-1"><span>Participaçao dos domens</span></div>
                                            <div class="row g-0 align-items-center">
                                                <div class="col-auto">
                                                    <div class="text-dark fw-bold h5 mb-0 me-3"><span>'.$perc_M.'%</span></div>
                                                </div>
                                                <div class="col">
                                                    <div class="progress progress-xl">
                                                        <div class="progress-bar bg-info" aria-valuenow="'.$perc_M.'" aria-valuemin="0" aria-valuemax="100" style="width:'.$perc_M.'%;"><span ">'.$total_m.' mulheres participaram</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                </div>
                            </div>
                                        </div>
                                         </div>
                                        <div class="row">
                                        <div class="col-lg-4 shadow">
                            <div class="card shadow border-start-success py-2">
                                <div class="card-body">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col me-2">
                                            <div class="text-uppercase text-success fw-bold text-xs mb-1"><span>Total de pessoas registadas</span></div>
                                            <div class="text-dark fw-bold h5 mb-0"><span>'.$total_reg.'</span></div>
                                        </div>
                                          </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 shadow">
                            <div class="card shadow border-start-success py-2">
                                <div class="card-body">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col me-2">
                                            <div class="text-uppercase text-success fw-bold text-xs mb-1"><span>Pessoas que votaram</span></div>
                                            <div class="text-dark fw-bold h5 mb-0"><span>'.$total_h+$total_m.'</span></div>
                                        </div>
                                          </div>
                                </div>
                            </div>
                        </div>
                       
                        <div class="col-lg-4 shadow">
                            <div class="card shadow border-start-success py-2">
                                <div class="card-body">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col me-2">
                                            <div class="text-uppercase text-success fw-bold text-xs mb-1"><span>Percentagem dos que votaram</span></div>
                                            <div class="text-dark fw-bold h5 mb-0"><span>'.$perc_v.' %</span></div>
                                        </div>
                                          </div>
                                </div>
                            </div>
                            </div>
                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                              

                            </div>';
                        }else{
                            echo "<div class='alert alert-danger'><button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>
                       <h1>SEM DADOS PRA SER MOSTRADO!</h1>

                         </div>";
                         
                        }
?>
                           