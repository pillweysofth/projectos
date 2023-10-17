
<?php
session_start();
require 'bd/conexao.php';

if(!isset($_SESSION['id'])){

    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html lang="pt-pt">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Votar</title>
    <meta name="charset" content="utf-8">
    <meta name="generator" content="SOVE 1.0.1">
    <meta name="author" content="Amarante, PillSofth">
    <link rel="icon" type="image/jpeg" sizes="720x675" href="assets/img/logo.jpg">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Stats.css">
 <link rel="stylesheet" href="assets/css/Pretty-Footer.css?h=e3701357e9e8ffe6753611314222d361">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
      }
  }

  .b-example-divider {
    height: 3rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
    flex-shrink: 0;
    width: 1.5rem;
    height: 100vh;
}

.bi {
    vertical-align: -.125em;
    fill: currentColor;
}

.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
}

.nav-scroller .nav {
    display: flex;
    flex-wrap: nowrap;
    padding-bottom: 1rem;
    margin-top: -1px;
    overflow-x: auto;
    text-align: center;
    white-space: nowrap;
    -webkit-overflow-scrolling: touch;
}
</style>
</head>

<body id="page-top">
    
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
  </symbol>
  <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
  </symbol>
  <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
</svg>
    <div id="wrapper">
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary">
            <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="principal.php">
                <div class="sidebar-brand-icon rotate-n-15"><img class="rounded-circle" src="assets/img/logo.jpg" width="50" height="50"></div>
                <div class="sidebar-brand-text mx-3"><span>SOVE</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item"><a class="nav-link" href="administrador.html"></a></li>
                <hr class="sidebar-divider">
                <div class="sidebar-heading"></div>
                <li class="nav-item">
                    <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-1" href="#collapse-1" role="button" style="font-weight: bold;"><i class="fas fa-newspaper"></i>&nbsp;Eleiçoes</a>
                        <div class="collapse" id="collapse-1">
                            <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="eleicao.php"><i class="fas fa-file-invoice"></i>&nbsp;Votar</a>

                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-2" href="#collapse-2" role="button" style="font-weight: bold;"><i class="fa fa-wpforms" style="width: 13px;height: 13px;"></i>&nbsp;Questionario</a>
                            <div class="collapse" id="collapse-2">
                                <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" 
                                    href="criar_questionario.php"><i class="fa fa-plus-circle"></i>&nbsp;Participar em questionario</a><a class="collapse-item" href="lista_questionario.php"><i class="fa fa-check-square-o"></i>&nbsp; Ver Resultado de Questionadio</a></div>
                            </div>
                        </div>
                    </li>
                    <hr class="sidebar-divider">
                    <div class="sidebar-heading"></div>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-3" href="#collapse-3" role="button"><i class="far fa-user"></i>&nbsp;<span style="font-weight: bold;">Usuario</span></a>
                            <div class="collapse" id="collapse-3">
                                <div class="bg-white border rounded shadow flex-fill py-2 collapse-inner"><a class="collapse-item" href="perfil.php" style="transform: translate(0px);"><i class="fas fa-user-plus"></i>&nbsp;Perfil</a>
                                </div>
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
                <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top" style="background: url(&quot;assets/img/5.jpg&quot;) center / cover;">
                    <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                        <ul class="navbar-nav flex-nowrap ms-auto">
                            <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><i class="fas fa-search"></i></a>
                                <div class="dropdown-menu dropdown-menu-end p-3 animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="me-auto navbar-search w-100">
                                        <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                            <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                        </div>
                                    </form>
                                </div>
                            </li>
                            <li class="nav-item dropdown no-arrow mx-1">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="badge bg-danger badge-counter">3+</span><i class="fas fa-bell fa-fw"></i></a>

                                </div>
                            </li>
                            <li class="nav-item dropdown no-arrow mx-1">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"></a>

                                </div>
                                <div class="shadow dropdown-list dropdown-menu dropdown-menu-end" aria-labelledby="alertsDropdown"></div>
                            </li>
                            <div class="d-none d-sm-block topbar-divider"></div>
                            <li class="nav-item dropdown no-arrow">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="d-none d-lg-inline me-2 text-gray-600 small">

                                  <?php
                                  echo "{$_SESSION['user']}";
                                  ?>
                              </span><img class="border rounded-circle img-profile" src="util/buscar_foto.php?id=<?php echo $_SESSION['foto']; ?>"></a>
                              <div class="dropdown-menu shadow dropdown-menu-end animated--grow-in"><a class="dropdown-item" href="perfil.php"><i class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Perfil</a><a class="dropdown-item" href="perfil_usuario.php"><i class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Definiçoes</a><a class="dropdown-item" href="#"><i class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Actividade</a>
                                <div class="dropdown-divider"></div><a class="dropdown-item" href="bd/terminar_sessao.php"><i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Sair</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <main>

           
            <div class="container-fluid">
           
        <div class="col-12 md-10" >
             <div class="card shadow ">
            <div class="row align-items-center">
 
                <?php 

                 $sql="SELECT * FROM eleicao";
                $resultado=mysqli_query($conn, $sql);
                while($row_eleicao = mysqli_fetch_assoc($resultado)){
                    if($row_eleicao['estado']>1){
                      $data_final=strtotime($row_eleicao['data_inicio']." ".$row_eleicao['hora_final']);
                        $data_inicio=strtotime($row_eleicao['data_inicio']." ".$row_eleicao['hora_inicio']);
                        $hora_inicio=strtotime($row_eleicao['hora_inicio']);
                ?>
                 <div class="col-lg-4 align-items-center ">
                <div class="card shadow bg-secondary" >
                  
                       
                           <h2 class="text-dark mb-0" style="color: var(--bs-purple);text-align: center;"><strong><?php
                     echo $row_eleicao['titulo'];
                       ?></strong></h2>
                    
                             <div class="card-body align-items-center">
                                   <p class="card-text text-white secondary-color text-white text-center"><strong><?php
                                 echo $row_eleicao['descricao'];
                                  ?></p></strong>
                             <small>
                               <h4> <p class="card-text text-white text-center"><?php
                                 echo "Data de votaçao: ".date('d-m-Y',$data_inicio);
                                 ?>
                             </p></h4>
                             <h5>   <p class="card-text text-white text-center"><?php
                                 echo "Inicia: ".date('H:i',$hora_inicio);
                                 ?>
                             </p> </h5>
                             <h5>   <p class="card-text text-white text-center"><?php
                                 echo "Inicia: ".date('H:i',$data_final);
                                 ?>
                             </p> </h5>
                         </small>
                         <?php 

                       
                       
                         if($data_final<strtotime("now")){
                        echo     "<div class='alert alert-success d-flex align-items-center' role='alert'>
                             <svg class='bi flex-shrink-0 me-2' width='24' height='24' role='img' aria-label='Success:'><use xlink:href='#check-circle-fill'/></svg>
                                Eleicao encerrada! </div>";
                         echo "<div><p class='align-items-center'><a href='resultado_eleicoes.php?id_elei={$row_eleicao['id_elei']}' class='btn btn-lg btn-success '>Ver resultado</a></p>
                        </div> </div>";
                         }elseif($data_inicio>strtotime("now")){
                            if($row_eleicao['estado']==0){
                             echo     "<div class='alert alert-warning d-flex align-items-center' role='alert'>
                             <svg class='bi flex-shrink-0 me-2' width='24' height='24' role='img' aria-label='Success:'><use xlink:href='#exclamation-triangle-fill'/></svg>
                             <p><strong>Eleiçao indisponivel! Arrancara no dia ".date('d-m-Y',$data_inicio)."</strong></p2></div> </div> ";
                            }else{
                                 echo     "<div class='alert alert-warning d-flex align-items-center' role='alert'>
                             <svg class='bi flex-shrink-0 me-2' width='24' height='24' role='img' aria-label='Success:'><use xlink:href='#exclamation-triangle-fill'/></svg>
                             <p><strong>Eleiçao Arrancara no dia {$row_eleicao['data_inicio']} <br> Mas esta aberta para votaçao Antecipada </strong></p2></div>";
                                 echo "<div><p class='align-items-center'><a href='votar.php?id_ele={$row_eleicao['id_elei']}&eleitor={$_SESSION['id']}' class='btn btn-lg btn-primary' >Ir a Voto</a></p>
                        </div> </div>";
                            }
                         
                         }
                         else{
                             echo "<div><p class='align-items-center'><a href='votar.php?id_ele={$row_eleicao['id_elei']}&eleitor={$_SESSION['id']}' class='btn btn-lg btn-primary' >Ir a Voto</a></p>
                        </div> </div>";
                         }
                 
                         ?>
                            
                   
                </div>
            </div>
              <?php 
    }
          }?>
            </div>    </div>   

            </div>
        </main>     
<div class="container-fluid">
</div>
</div>
<footer class="bg-gradient-primary sticky-footer">
    <div class="container-fluid">
    <div class="row">
            <div class="col-sm-6 col-md-4 footer-navigation">
                <h3><a href="#">SOVE<span></span></a></h3>
                <p class="links"><a href="#">Inicio</a><strong> · </strong><a href="#">Blog</a><strong> · </strong><a href="#">Sobre</a><strong> · </strong><a href="#">Faq</a><strong> · </strong><a href="#">Contacte-me</a></p>
                <p class="company-name">Pacheco Gomes © 2023 </p>
            </div>
            <div class="col-sm-6 col-md-4 footer-contacts">
                <div><span class="fa fa-map-marker footer-contacts-icon"> </span>
                    <p><span class="new-line-span">Vila de Cacuaco</span> Luanda, Angola</p>
                </div>
                <div><i class="fa fa-phone footer-contacts-icon"></i>
                    <p class="footer-center-info email text-start"> 244 929 008 009 </p>
                </div>
                <div><i class="fa fa-envelope footer-contacts-icon"></i>
                    <p> <a href="#" target="_blank">pachecorufino1997@gmail.com.com</a></p>
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
</div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>