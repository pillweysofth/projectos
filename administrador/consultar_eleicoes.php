     <?php
     session_start();
if( !isset($_SESSION['estado'])||($_SESSION['estado']!=0)){
header("Location: ../bd/terminar_sessao.php");
}
     ?>

     <!DOCTYPE html>
     <html>

     <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Eleiçoes</title>
        <meta name="charset" content="utf-8">
        <meta name="generator" content="SOVE 1.0.1">
        <meta name="author" content="Amarante, PillSofth">
        <link rel="icon" type="image/jpeg" sizes="720x675" href="../assets/img/logo.jpg">
        <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
        <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
        <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="../assets/fonts/fontawesome5-overrides.min.css">
        <link rel="stylesheet" href="../assets/css/Stats.css">
         <link rel="stylesheet" href="../assets/css/Pretty-Footer.css?h=e3701357e9e8ffe6753611314222d361">
          <link rel="stylesheet" href="../assets/css/themes/light-theme.css">

<style type="text/css">
                               .progress{
                       height: 30px;

                }
            </style>
    </head>

    <body id="page-top">
         <div id="wrapper">
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="administrador.php">
                    <div class="sidebar-brand-icon rotate-n-15"><img class="rounded-circle" src="../assets/img/logo.jpg" width="50" height="50"></div>
                    <div class="sidebar-brand-text mx-3"><span>SOVE</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"><a class="nav-link active" href="administrador.html"></a></li>
                    <hr class="sidebar-divider">
                    <div class="sidebar-heading"></div>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-1" href="#collapse-1" role="button" style="font-weight: bold;"><i class="fas fa-newspaper"></i>&nbsp;Eleiçoes</a>
                            <div class="collapse" id="collapse-1">
                                <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="criar_eleicoes.php"><i class="fas fa-file-invoice"></i>&nbsp;Criar Eleiçoes</a><a class="collapse-item" href="consultar_eleicoes.php"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-presentation">
                                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                                            <line x1="3" y1="4" x2="21" y2="4"></line>
                                            <path d="M4 4v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-10"></path>
                                            <line x1="12" y1="16" x2="12" y2="20"></line>
                                            <line x1="9" y1="20" x2="15" y2="20"></line>
                                            <path d="M8 12l3 -3l2 2l3 -3"></path>
                                        </svg>&nbsp;Estado de eleiçao</a></div>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-2" href="#collapse-2" role="button" style="font-weight: bold;"><i class="fa fa-wpforms" style="width: 13px;height: 13px;"></i>&nbsp;Questionario</a>
                            <div class="collapse" id="collapse-2">
                                <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="criar_questionario.php"><i class="fa fa-plus-circle"></i>&nbsp; Criar Questionario</a><a class="collapse-item" href="lista_questionario.php"><i class="fa fa-check-square-o"></i>&nbsp; Ver Questionadio</a></div>
                            </div>
                        </div>
                    </li>
                    <hr class="sidebar-divider">
                    <div class="sidebar-heading"></div>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-3" href="#collapse-3" role="button"><i class="far fa-user"></i>&nbsp;<span style="font-weight: bold;">Usuario</span></a>
                            <div class="collapse" id="collapse-3">
                                <div class="bg-white border rounded shadow flex-fill py-2 collapse-inner"><a class="collapse-item" href="lista_usuario.php"><i class="fas fa-user-tie"></i>&nbsp; Usuarios registados</a></div>
                            </div>
                        </div>
                                           </li>
                    <li class="nav-item"><a class="nav-link" href="charts.html"><i class="fas fa-info-circle"></i><span>Sobre</span></a></li>
                    <li class="nav-item"></li>
                    <hr class="sidebar-divider">
                </ul>
                <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
            </div>
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top" style="background: url(&quot;../assets/img/5.jpg&quot;) center / cover;">
                    <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                        <ul class="navbar-nav flex-nowrap ms-auto">
                                 
                              
                           
                            <li class="nav-item dropdown no-arrow mx-1">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="badge bg-danger badge-counter">3+</span><i class="fas fa-bell fa-fw"></i></a>
                                    
                                </div>
                            </li>
                            <li class="nav-item dropdown no-arrow mx-1">
                               
                               
                                <div class="shadow dropdown-list dropdown-menu dropdown-menu-end" aria-labelledby="alertsDropdown"></div>
                            </li>
                            <div class="d-none d-sm-block topbar-divider"></div>
                            <li class="nav-item dropdown no-arrow">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="d-none d-lg-inline me-2 text-gray-600 small">
                                    <?php
                                    echo "{$_SESSION['user']}";
                                    ?>
                                </span><img class="border rounded-circle img-profile" src="../util/buscar_foto.php?id=<?php echo $_SESSION['foto']; ?>"></a>
                                    <div class="dropdown-menu shadow dropdown-menu-end animated--grow-in"><a class="dropdown-item" href="perfil.php"><i class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Perfil</a><a class="dropdown-item" href="#"><i class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Definiçoes</a><a class="dropdown-item" href="#"><i class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Actividade</a>
                                        <div class="dropdown-divider"></div><a class="dropdown-item" href="../bd/terminar_sessao.php"><i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Sair</a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="container-fluid">
                     
                     <div class="card shadow mb-1">
                                    <div class="card-header py-3 align-items-center">
                                        <p class="text-primary m-0 fw-bold " style="color: var(--bs-purple);text-align: center;">
                                         <strong> Eleiçoes Listadas </strong></p>
                                     </div>
                                     <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">#</th>
                                                    <th>Titulo</th>
                                                    <th>Descriçao</th>
                                                    <th>Data Votaçao</th>
                                                    <th>Hora de inicio</th>
                                                     <th>Hora de termino</th>
                                                    <th>Estado</th>
                                                                                                 </tr>
                                            </thead>
                                            <tbody>
                                                <?php 
                                                require '../bd/conexao.php';
                                                $sql="SELECT * FROM eleicao";
                                                $resultado=mysqli_query($conn,$sql);

                                                $cont=1;
                                                while($pessoas=mysqli_fetch_assoc($resultado)){
                                                         if($pessoas['estado']==1){
                                                            echo '<tr class="table-primary ">';
                                                         }elseif($pessoas['estado']==2){
                                                            echo '<tr class="table-warning ">';
                                                         }  
                                                         elseif($pessoas['estado']==3){
                                                            echo '<tr class="table-success ">';
                                                       } else{
                                                         echo '<tr class="table-secondary ">';
                                                       }                         ?>
                                              
                                                    <th scope="row" ><?php 
                                                           echo $cont++;
                                                        ?></th>
                                                    <th>
                                                        <?php 
                                                           echo $pessoas['titulo'];
                                                        ?>
                                                    </th>
                                                    <th>
                                                        <?php 
                                                           echo $pessoas['descricao'];
                                                        ?>
                                                    </th>
                                                   
                                                    <th>
                                                        <?php 
                                                           echo date("d-m-Y ", strtotime($pessoas['data_inicio']));
                                                        ?>
                                                    </th>
                                                    <th>
                                                        <?php 
                                                           echo $pessoas['hora_inicio'];
                                                       
                                                        ?>
                                                    </th>
                                                    <th>
                                                        <?php 
                                                       echo $pessoas['hora_final'];
                                                        ?>
                                                    </th>
                                                    <th>
                                                        <?php 
                                                        if( $pessoas['estado']==0)
                                                        {

                                                           echo "Aguardando a data...";

                                                        }
                                                        elseif( $pessoas['estado']==1)
                                                        {
                                                         echo "Em Votaçao Antecipada"; 
                                                        }
                                                        elseif( $pessoas['estado']==2)
                                                        {
                                                         echo "Em Votaçao";
                                                          }
                                                          else
                                                          {
                                                            echo "Votaçao encerrada";
                                                          }
                                                        ?>
                                                    </th>
                                                             
                                                      
                                                 <?php 
                                                  
                                                  echo "</th> </tr>           ";
                                                $sql="SELECT * FROM candidatos_alistados WHERE id_elei='{$pessoas['id_elei']}'";
                                                    $cand=mysqli_query($conn,$sql);
                                                if($cand->num_rows>0){
                                                    echo "<tr>
                                                    <th colspan='3'></th>
                                                    <th colspan>Lista de Candidatos Inscritos</th>
                                                    </tr>";
                                          echo      " <tr> 
                                                    <th scope='col'>#</th>
                                                    <th>Nome Completo</th>
                                                    <th>Sobre Candidato</th> </tr>";
                                                    $contt=1;
                                                while($candidatos=mysqli_fetch_assoc($cand)){
                                             
                                                ?>

                                                <tr>
                                                    <td ><?php 
                                                           echo $contt++;
                                                        ?></td>
                                                                        <td>
                                                                            <img class="border rounded-circle img-profile" src="../util/buscar_foto.php?id=<?=$candidatos['foto']?>>" width="60" height="60">
                                                        <?php echo $candidatos['nome'];?>
                                                    </td>
                                                    <td>
                                                        <?php echo $candidatos['sobre_cand'];?>
                                                    </td>
                                                </tr>
                                                <?php 
                                               
                                                }
                                            
                                        }
                                                ?>

                                                 

                                                </tr>
  <?php 
                                                          }
                                                        ?>
                                            </tbody>
                                        </table>
                                                       </div>
                                </div>   
                   
                </div>
         
       
                   
                <hr>
               <footer class="bg-gradient-primary sticky-footer">
    <div class="container-fluid">
    <div class="row">
            <div class="col-sm-6 col-md-4 footer-navigation">
                <h3><a href="#">SOVE<span></span></a></h3>
                <p class="links"><a href="#">Inicio</a><strong> · </strong><a href="#">Blog</a><strong> · </strong><a href="#">Sobre</a><strong> · </strong><a href="#">Faq</a><strong> · </strong><a href="#">Contacte-me</a></p>
                <p class="company-name">Amarante ST © 20122 </p>
            </div>
            <div class="col-sm-6 col-md-4 footer-contacts">
                <div><span class="fa fa-map-marker footer-contacts-icon"> </span>
                    <p><span class="new-line-span">Rua 3 Castanheira</span> Cuito, Bie</p>
                </div>
                <div><i class="fa fa-phone footer-contacts-icon"></i>
                    <p class="footer-center-info email text-start"> 244 943 32 0571 </p>
                </div>
                <div><i class="fa fa-envelope footer-contacts-icon"></i>
                    <p> <a href="#" target="_blank">support@company.com</a></p>
                </div>
            </div>
            <div class="col-md-4 footer-about">
                <h4>Sobre Criador</h4>
                <p> Escreva aqui sobre vc </p>
                <div class="social-links social-icons"><a href="https://facebook.com/luckstaiv.youngtug"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-linkedin"></i></a><a href="#"><i class="fa fa-github"></i></a></div>
            </div>
            </div>
        </div>
</footer>
            </div> </div>
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>

<script src="../assets/js/jquery-3.6.0.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/xsalert.js"></script>
<script src="../assets/js/theme.js"></script>
     <script type="text/javascript">
       $("#eleicao_s").change(function(){
        $("#cadidados_inc").load('../bd/buscar_candidatos.php?id_elei='+$("#eleicao_s").val());
       });
        var clicado = null, titulo = null;
$('.selecionado').click(function(){
  titulo = $(this).parents('tr').find('th').eq(1).text();
  estado = $(this).parents('tr').find('td').eq(5).text();
 
   clicado = $(this).val();
  
   document.getElementById("id_elei").value=clicado;
var trimStr = $.trim(titulo);
document.getElementById("elei_sele").value=trimStr;

$("#actualizar_estado").on('submit',function(e){
e.preventDefault();

var dados=$("#actualizar_estado").serialize();
$.post("../bd/actualizar_estado_eleicao.php",
    dados,
    function(retorno){
        if (retorno==1) {
            XSAlert({
 title: "ALTERAR ESTADO!",
   message: "Estado elterado com sucesso!",
   autoCloseTimer: 1000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
            }).then((result)=>{
                if(result == 'autoClosed') {
    $(location).attr('href', 'consultar_eleicoes.php');
       }
            })
        }else{

               XSAlert({

   title: "Erro!",
   message:retorno,
     hideCancelButton: true
});
   
        }
    })
})

})
;
$(".eliminar_elei").click(function(){
XSAlert({
title: "Eliminar!",
   message: "Tens a certeza que desejas eliminar a eleiçao selecionada?",
    okButtonText: 'SIM',
         cancelButtonText: "CANCELAR",
     hideProgressBar: false, 
   hideProgressIcon: false, 
}).then((result)=>{
if (result=='ok') {
$.get("../bd/eliminar_elei.php?id_elei="+$(this).val(),
    function(retorno){
        if(retorno==1){
XSAlert({
    title: "ELIMINAR!",
   message: "Eleiçao eliminada com sucesso!",
   autoCloseTimer: 1000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
            }).then((result)=>{
                if(result == 'autoClosed') {
    $(location).attr('href', 'consultar_eleicoes.php');
       }
})
        }else{
             XSAlert({

   title: "Erro!",
   message:retorno,
     hideCancelButton: true
})
   
        }
})
}
})
})
</script>
    </body>

    </html>