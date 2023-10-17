
<?php
session_start();
?>
<!DOCTYPE html>
<html lang="pt-pt">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Resultado daas Eleiçoes</title>
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
        <style type="text/css">
            .progress{
                height: 30px;

            }
        </style>
    </head>

    <body id="page-top">
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


                    <div class="container-fluid">


                        <?php
                        include 'bd/conexao.php';
                        $sql = $sql = "SELECT * FROM eleicao WHERE id_elei='{$_GET['id_elei']}'";
                        $resultado = mysqli_query($conn, $sql);

                        $row_eleicao = mysqli_fetch_assoc($resultado);
                        if (((int) $row_eleicao['estado'] == 3)) {
                            ?>
                            <div class="row">      
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <h2 class="text-primary mb-0" style="color: var(--bs-purple);text-align: center;"><strong>RESULTADO FINAL</strong></h2>
                                    </div>
                                    <h2 class="text-dark mb-0" style="color: var(--bs-purple);text-align: center;"><strong> <?php
                        echo $row_eleicao['titulo'];
                        echo " <p> Arrancou no dia " . date("d-m-Y", strtotime($row_eleicao['data_inicio']));
                        echo "</h2></strong></p>
               <h4 class='text-dark mb-0' style='color: var(--bs-purple);text-align: center;'><p> Arrancou pelas " .
                        date("H:i", strtotime($row_eleicao['hora_inicio'])) . " horas </p>";
                        echo "</p><p> Terminou pelas " .
                        date("H:i", strtotime($row_eleicao['hora_final'])) . " horas </p>";
                            ?>
                                            </h4>
                                            <hr class="featurette-divider">
                                            <div class="row">

    <?php
    $sql = "SELECT * FROM resultado_eleicao WHERE id='{$row_eleicao['id_elei']}' ORDER BY num_votos DESC";
    $resul_elei = mysqli_query($conn, $sql);

    while ($row_resultado = mysqli_fetch_assoc($resul_elei)) {
        if ($row_resultado['num_votos'] != 0) {
            $porcentagem = number_format((($row_resultado['num_votos'] * 100) / $row_resultado['total']), 2);
            ?>
                                                        <div class="col-lg-6">
                                                            <div class="card shadow border-start-info py-2">
                                                                <div class="card-body">
                                                                    <div class="row align-items-center no-gutters">
                                                                        <div class="col">
                                                                            <div class="text-uppercase text-center fw-bold mb-1"><strong><?php echo $row_resultado['nome']; ?></strong></div>
                                                                            <div class="col-auto">
                                                                                <div class="col-auto align-items-center"><img class="border rounded-circle img-profile" src="util/buscar_foto.php?id=<?= $row_resultado['foto'] ?>>" width="100" height="100"></div>
                                                                            </div>
                                                                            <div class="col">
                                                                                <div class="progress">
                                                                                    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="<?= $porcentagem; ?>" aria-valuemin="0" aria-valuemax="100" style="width:<?= $porcentagem; ?>%"> <?php echo $porcentagem; ?>
                                                                                    </div>
                                                                                </div> 
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="text-dark text-center fw-bold h5 "><span><?php echo $porcentagem . "%" ?></span></div>

                                                                </div>
                                                            </div>
                                                        </div>

            <?php
        } else {
            echo "<div class='alert alert-danger'>SEM VOTOS!</div>";
        }
    }
} elseif ((int) $row_eleicao['estado'] == 2) {
    ?>


                                                <div class="row">      
                                                    <div class="card shadow mb-3">
                                                        <div class="card-header py-3">
                                                            <h2 class="text-primary mb-0" style="color: var(--bs-purple);text-align: center;"><strong>RESULTADO PROVISORIO</strong></h2>
                                                        </div>
                                                        <h2 class="text-dark mb-0" style="color: var(--bs-purple);text-align: center;"><strong> <?php
                                                echo $row_eleicao['titulo'];
                                                echo " <p> Arrancou no dia " . date("d-m-Y", strtotime($row_eleicao['data_inicio'])) . " decorrendo... </p>";
                                                ?></strong></h2>
                                                        <hr class="featurette-divider">
                                                        <div class="row">

    <?php
    $sql = "SELECT * FROM resultado_eleicao WHERE id='{$row_eleicao['id_elei']}' ORDER BY num_votos DESC";
    $resul_elei = mysqli_query($conn, $sql);

    while ($row_resultado = mysqli_fetch_assoc($resul_elei)) {
        if ($row_resultado['num_votos'] != 0) {
            $porcentagem = number_format((($row_resultado['num_votos'] * 100) / $row_resultado['total']), 2);
            ?>
                                                                    <div class="col-lg-6">
                                                                        <div class="card shadow border-start-info py-2">
                                                                            <div class="card-body">
                                                                                <div class="row align-items-center no-gutters">
                                                                                    <div class="col me-2">
                                                                                        <div class="text-uppercase text-center fw-bold mb-1"><strong><?php echo $row_resultado['nome']; ?></strong></div>
                                                                                        <div class="row g-0 align-items-center">
                                                                                            <div class="col-auto">
                                                                                                <div class="col-auto align-items-center"><img class="border rounded-circle img-profile" id="fot" src="util/buscar_foto.php?id=1>" width="100" height="100"></div>
                                                                                            </div>
                                                                                            <div class="col">
                                                                                                <div class="progress">
                                                                                                    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="<?= $porcentagem; ?>" aria-valuemin="0" aria-valuemax="100" style="width:<?= $porcentagem; ?>%"> <?php echo $porcentagem; ?>
                                                                                                    </div>
                                                                                                </div> 
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="text-dark text-center fw-bold h5 "><span><?php echo $porcentagem . "%" ?></span></div>

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
            <?php
        } else {
            echo "<div class='alert alert-danger'>SEM VOTOS!</div>";
        }
    }
}
?> 
                                                    </div></div>
                                            </div>    
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

                                        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                                        <script src="assets/js/theme.js"></script>
                                        </body>

                                        </html>