
<?php
session_start();
require 'bd/consultarusuario.php';

if (!isset($_SESSION['user'])) {

    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html lang="pt-pt">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Perfil do Ususario</title>
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
        <link rel="stylesheet" href="assets/css/themes/light-theme.css">

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
                            <h3 class="text-dark mb-4">Perfil</h3>

                            <form action ="bd/editar_perfilbd.php" id="form_editar" method="POST" enctype="multipart/form-data" class="needs-validation was-validated "  novalidate>

                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="card mb-3">
                                            <div class="card-body text-center shadow">
                                                <div class="thumbnail">
                                                    <img class="rounded-circle mb-3 mt-4"
                                                         src="util/buscar_foto.php?id=<?php echo $_SESSION['foto']; ?>" width="160" height="160">
                                                </div>
                                                <div class="mb-3">
                                                    <input  type="file" name="foto" id="foto">
                                                </div>
                                            </div>
                                            <div class="card-footer">
                                                <div class="mt-3">
                                                    <h5>

                                                        <strong>
                                                            <p>   <?php echo "Nome Ususario: " . $_SESSION['user']; ?></p>
                                                        </strong>
                                                        <p>
                                                            <?php echo "Numero do BI: " . $_SESSION['id']; ?></p>
                                                        <p class="text-secondary mb-1"><?php echo "Cusro: " . $curso; ?></p></h5>
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="col-lg-8">

                                        <div class="row">

                                            <div class="col">

                                                <div class="card shadow mb-3">
                                                    <div class="card-header py-3">
                                                        <p class="text-primary m-0 fw-bold"><h2 class="text-primary">Editar perfil</h2></p>
                                                    </div>
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-lg-4">
                                                                <div class="form-floating"><input class="form-control" name="primeiro_nome" type="text" placeholder="" name="primeiro_nome" value="<?= $primeiro_nome; ?>" required>
                                                                    <div class="invalid-feedback">
                                                                        Escreva o Primeiro Nome
                                                                    </div>
                                                                    <label class="form-label" for="floatingInput"><strong>Primeiro Nome</strong></label>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <div class="form-floating">
                                                                    <input class="form-control" type="text" id="Ultimo_nome" placeholder="Doe" name="ultimo_nome" value="<?= $segundo_nome; ?>"required>
                                                                    <div class="invalid-feedback">
                                                                        Escreva o Segundo Nome
                                                                    </div>
                                                                    <label for="floatingPassword"> <strong>Ultimo Nome</strong></label></div></div>
                                                            <div class="col-lg-4">
                                                                <div class="form-floating">

                                                                    <input class="form-control" name="email" type="email" id="email" placeholder="user@example.com" name="email" value="<?= $email; ?>" required>
                                                                    <div class="invalid-feedback">
                                                                        Escreva o Email
                                                                    </div>
                                                                    <label  for="floatingInput"><strong>Endereço Email</strong></label>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <hr>

                                                        <div class="row">
                                                            <div class="col-lg-7">
                                                                <div class="form-floating">
                                                                    <input class="form-control" type="text" id="endereco" placeholder="Hortencio de sousa" name="endereco" value="<?= $endereco; ?>" required>
                                                                    <div class="invalid-feedback">
                                                                        Escreva o endereço
                                                                    </div>
                                                                    <label for="floatingInput"><strong>Endereço</strong></label>
                                                                </div> </div>
                                                            <div class="col">                               
                                                                <div class="form-floating">
                                                                    <input class="form-control form-control" type="text" id="telemovel" placeholder="9xx xxx xx" name="telemovel" value="<?= $contacto; ?>" required>
                                                                    <div class="invalid-feedback">
                                                                        Escreva o numero de telemovel
                                                                    </div>
                                                                    <label  for="floatingInput"><strong>Telemovel</strong></label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="row">
                                                            <div class="col">
                                                                <div id="dataTable_length" class=" dataTables_length" aria-controls="dataTable">
                                                                    <div class="form-control">
                                                                        <label class="form-label">Selecione a Provincia</label>
                                                                        <select class="d-inline-block form-select form-control" id="provincia_nascimento" name="provincia_nascimento" required>

                                                                            <?php
                                                                            $sql = "SELECT * FROM provincia";
                                                                            $provincia = $conn->query($sql);
                                                                            while ($resultado = mysqli_fetch_assoc($provincia)) {

                                                                                echo" <option value={$resultado['id_prov']}";
                                                                                if ((int) $resultado['id_prov'] == $id_pro) {
                                                                                    echo ' selected';
                                                                                }
                                                                                echo ">";
                                                                                echo "{$resultado['nom_prov']}</option>";
                                                                            }
                                                                            ?>
                                                                        </select>&nbsp;
                                                                        <div class="invalid-feedback">
                                                                            Seleciona a provincia
                                                                        </div></div>
                                                                </div>
                                                            </div>
                                                            <div class="col">
                                                                <div id="dataTable_length" class=" dataTables_length" aria-controls="dataTable">
                                                                    <div class="form-control" id="minicipios">

                                                                        <div class="invalid-feedback">
                                                                            Seleciona o Municipio
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="row">

                                                            <div class="col-lg-6">
                                                                <div class="form-control">
                                                                    <label class="form-label">Data Nascimento  </label>
                                                                    <input class="form-control" type="date" id="data_nascimento" placeholder="Data Nascimento" name="data_nascimento" value="<?= $data_n; ?>" required>
                                                                    <div class="invalid-feedback" >
                                                                        Selecione a data
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-4">

                                                                <div id="dataTable_length" class=" dataTables_length" aria-controls="dataTable">
                                                                    <div class="form-control">
                                                                        <label class="form-label">Selecione o Sexo</label>
                                                                        <select class="d-inline-block form-select form-select-sm" id="sexo" name="sexo" required>
                                                                            <option value="Homem">Homem</option>
                                                                            <option value="Mulher">Mulher</option>

                                                                        </select>&nbsp;
                                                                        <div class="invalid-feedback">
                                                                            Selecione o sexo
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <div> <hr>

                                                            </div> 

                                                            <div class="row align-items-center">


                                                                <div class="col">
                                                                    <button class="btn btn-primary btn-sm" id="salvar_alterado" value="salvar_alterado" name="salvar_alterado" type="submit">Salvar Alteraçoes</button></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>





                            </form>
                        </div>



                        <hr class="featurette-divider">




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
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/validate-forms.js"></script>
        <script src="assets/js/xsalert.js"></script>

        <script src="assets/js/buscar_municipio.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#minicipios').load('bd/buscar_provincia.php?provincia=' + $('#provincia_nascimento').val() + '&sele=<?= $id_mun ?>');
            })



        </script>
    </body>

</html>