<?php
session_start();
if (isset($_SESSION['estado'])) {
    if ($_SESSION['admin'] = 0) {
        header("Location: administrador/administrador.php");
    } else {
        header("Location: principal.php");
    }
} else {
    
}
?>
<!DOCTYPE html>
<html lang="pt-pt">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Pagina Inicial</title>
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

            @media(min-width: 768px){
                #mini-banners{
                    margin-top: -6em;
                }
            }
        </style>
    </head>

    <body id="page-top" class="fixed_header left_nav_fixed">
        <div id="wrapper">
            <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary">
                <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                        <div class="sidebar-brand-icon rotate-n-15"><img class="rounded-circle" src="assets/img/logo.jpg" width="50" height="50"></div>
                        <div class="sidebar-brand-text mx-3"><span>SOVE</span></div>
                    </a>
                    <hr class="sidebar-divider my-0">
                    <ul class="navbar-nav text-light" id="accordionSidebar">
                        <li class="nav-item"><a class="nav-link" href="administrador.html"></a></li>
                        <hr class="sidebar-divider">
                        <div class="sidebar-heading"></div>
                        <li class="nav-item">
                            <div><a class="btn btn-link nav-link disabled" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-1" href="#collapse-1" role="button" style="font-weight: bold;"><i class="fas fa-newspaper"></i>&nbsp;Eleiçoes</a>
                                <div class="collapse" id="collapse-1">
                                    <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="eleicao.php"><i class="fas fa-file-invoice"></i>&nbsp;Votar</a>

                                    </div>
                                </div>
                        </li>
                        <li class="nav-item">
                            <div><a class="btn btn-link nav-link disabled" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-2" href="#collapse-2" role="button" style="font-weight: bold;"><i class="fa fa-wpforms" style="width: 13px;height: 13px;"></i>&nbsp;Questionario</a>
                                <div class="collapse" id="collapse-2">
                                    <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="utilities-color.html"><i class="fa fa-plus-circle"></i>&nbsp;Participar em questionario</a><a class="collapse-item" href="utilities-border.html"><i class="fa fa-check-square-o"></i>&nbsp; Ver Resultado de Questionadio</a></div>
                                </div>
                            </div>
                        </li>
                        <hr class="sidebar-divider">
                        <div class="sidebar-heading"></div>
                        <li class="nav-item">
                            <div><a class="btn btn-link nav-link disabled" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-3" href="#collapse-3" role="button"><i class="far fa-user"></i>&nbsp;<span style="font-weight: bold;">Usuario</span></a>
                                <div class="collapse" id="collapse-3">
                                    <div class="bg-white border rounded shadow flex-fill py-2 collapse-inner"><a class="collapse-item" href="perfil_usuario.php" style="transform: translate(0px);"><i class="fas fa-user-plus"></i>&nbsp;Editar perfil</a>
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
                                    <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href=""><span class="d-none d-lg-inline me-2 text-gray-600 small">

                                                Usuario
                                            </span><img class="border rounded-circle img-profile" src="util/buscar_foto.php?id=1"></a>
                                        <div class="dropdown-menu shadow dropdown-menu-end animated--grow-in"><a class="dropdown-item" href="login.php"><i class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Login</a><a class="dropdown-item" href="login.php"><i class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Definiçoes</a><a class="dropdown-item" href="login.php"><i class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Actividade</a>
                                            <div class="dropdown-divider"></div><a class="dropdown-item" href="bd/terminar_sessao.php"><i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Sair</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <main>

                        <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#myCarousel"  data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1">         </button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="magem" src="img/3.jpg" width="100%" height="100%">
                                    <div class="container">
                                        <div class="carousel-caption text-start">
                                            <h1>Eleiçoes</h1>
                                            <p>O voto é a mais pura demostração de democracia</p>
                                            <p><a class="btn btn-lg btn-primary" href="login.php">Ir ao voto</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="magem" src="img/carousel1.jpg" width="100%" height="100%">
                                    <div class="container">
                                        <div class="carousel-caption">
                                            <h1>Questionario</h1>
                                            <p>Ir e responder aos questionarios.</p>
                                            <p><a class="btn btn-lg btn-primary" href="login.php">Ver Questionarios</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="magem" src="img/carousel2.jpg" width="100%" height="100%">
                                    <div class="container">
                                        <div class="carousel-caption text-end">
                                            <h1>O seu canal perfeito para pequisa</h1>
                                            <p>Encotre resposta reais para as sua pesquisas </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>

                    </main>   
                    <div class="container">
                        <div class="col-12 md-10 offset-md-1" id="mini-banners"> 
                            <div class="row">
                                <div class="col-lg-3 md-4 offset-lg-1 ">
                                    <div class="card align-items-center shadow">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-box-seam" viewBox="0 0 16 16">
                                        <path d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2l-2.218-.887zm3.564 1.426L5.596 5 8 5.961 14.154 3.5l-2.404-.961zm3.25 1.7-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
                                        </svg>
                                        <div class="card-body">
                                            <h5 class="card-title primary-color">Sistema de Votaçao Online</h5>
                                            <p class="card-text secondary-color">SIstema feito para facilitaçao de voto</p>
                                            <p><a href="login.php" class="btn btn-lg btn-primary">SABER MAIS</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 md-4 ">
                                    <div class="card align-items-center shadow">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-journal-check" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M10.854 6.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 8.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
                                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
                                        </svg>
                                        <div class="card-body">
                                            <h5 class="card-title primary-color">Sistema de Questionarios</h5>
                                            <p class="card-text secondary-color">SIstema feito para facilitaçao de voto</p>
                                            <p><a href="login.php" class="btn btn-lg btn-primary">SABER MAIS</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 md-4 ">
                                    <div class="card align-items-center shadow">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-question-diamond" viewBox="0 0 16 16">
                                        <path d="M6.95.435c.58-.58 1.52-.58 2.1 0l6.515 6.516c.58.58.58 1.519 0 2.098L9.05 15.565c-.58.58-1.519.58-2.098 0L.435 9.05a1.482 1.482 0 0 1 0-2.098L6.95.435zm1.4.7a.495.495 0 0 0-.7 0L1.134 7.65a.495.495 0 0 0 0 .7l6.516 6.516a.495.495 0 0 0 .7 0l6.516-6.516a.495.495 0 0 0 0-.7L8.35 1.134z"/>
                                        <path d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z"/>
                                        </svg>
                                        <div class="card-body">
                                            <h5 class="card-title primary-color">Sistema de Votaçao Online</h5>
                                            <p class="card-text secondary-color">SIstema feito para facilitaçao de voto</p>
                                            <p><a href="login.php" class="btn btn-lg btn-primary">SABER MAIS</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
        </div>
    </div>
</div>
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/xsalert.js"></script>

</body>
</html>