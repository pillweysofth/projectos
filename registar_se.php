<?php
 
                        require 'bd/conexao.php';
                              
                                     
?>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Registar-se</title>
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

    </head>

    <body id="page-top">
        <div id="wrapper">
            <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
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
                                <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="buttons.html"><i class="fas fa-file-invoice"></i>&nbsp;Criar Eleiçoes</a><a class="collapse-item" href="cards.html"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-presentation">
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
                        <div><a class="btn btn-link nav-link disabled" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-2" href="#collapse-2" role="button" style="font-weight: bold;"><i class="fa fa-wpforms" style="width: 13px;height: 13px;"></i>&nbsp;Questionario</a>
                            <div class="collapse" id="collapse-2">
                                <div class="bg-white border rounded py-2 collapse-inner"><a class="collapse-item" href="utilities-color.html"><i class="fa fa-plus-circle"></i>&nbsp; Criar Questionario</a><a class="collapse-item" href="utilities-border.html"><i class="fa fa-check-square-o"></i>&nbsp; Ver Resultado de Questionadio</a></div>
                            </div>
                        </div>
                    </li>
                    <hr class="sidebar-divider">
                    <div class="sidebar-heading"></div>
                    <li class="nav-item">
                        <div><a class="btn btn-link nav-link disabled" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse-3" href="#collapse-3" role="button"><i class="far fa-user"></i>&nbsp;<span style="font-weight: bold;">Usuario</span></a>
                            <div class="collapse" id="collapse-3">
                                <div class="bg-white border rounded shadow flex-fill py-2 collapse-inner"><a class="collapse-item" href="login.html" style="transform: translate(0px);"><i class="fas fa-user-plus"></i>&nbsp;Usuario eleitor</a><a class="collapse-item" href="register.html"><i class="fas fa-user-tie"></i>&nbsp; Usuario Candidato</a><a class="collapse-item" href="forgot-password.html"><i class="fas fa-user-edit"></i>&nbsp;Redefinir senha de um Usuario</a></div>
                            </div>
                        </div>

                    </li>
                    <li class="nav-item"><a class="nav-link disabled" href="charts.html"><i class="fas fa-info-circle"></i><span>Sobre</span></a></li>
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

                            <div class="d-none d-sm-block topbar-divider"></div>
                            <li class="nav-item dropdown no-arrow">
                                <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link disabled" aria-expanded="false" data-bs-toggle="dropdown" href="#"><span class="d-none d-lg-inline me-2 text-gray-600 small">

                                </span><img class="border rounded-circle img-profile" src=""></a>
                                <div class="dropdown-menu shadow dropdown-menu-end animated--grow-in"><a class="dropdown-item" href="#"><i class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Perfil</a><a class="dropdown-item" href="#"><i class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Definiçoes</a><a class="dropdown-item" href="#"><i class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Actividade</a>
                                    <div class="dropdown-divider"></div><a class="dropdown-item" href="#"><i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Sair</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            
            <br>
            <div class="container-fluid">

                    <div class="row justify-content-center">
                        <div class="col-lg-12">

                    <div class="card shadow mb-3">
                                <div class="card-header py-3">
                                        <p class="text-primary m-0 fw-bold"><h2 class="text-primary mb-0" style="color: var(--bs-purple);text-align: center;"><strong>REGISTAR-SE</strong></h2></p>

                                    </div>
                                <div class="row">
                                <div class="col">
                                    
                                    <div class="card-body">
                                     

                                       <div class="row">
                         <form id="cadastro" class="needs-validation was-validated" role="form"  method="POST" novalidate >
                                  
                                    <div class="row">
                                               <div class="col-lg-6">
                                                <div class="row">
                                        <div class="col-lg-6">
                                     <div class="form-floating mb-3">
                                                <input class="form-control" name="identif" type="text" id="identif" placeholder="Amarante"  required>
                                                      <div class="invalid-feedback">Numero de Identificação</div>
                                                <label class="form-label" for="floatingInput"><strong>Numero de Identificação</strong></label>
                                            </div>
                             
                                             
                                        </div>
                                         <div class="col-lg-6">
                                   <div class="form-floating mb-3">
                                             <button type="button" id="verificar" class="btn btn-outline-primary ">Verificcar</i></button>
                                            </div>
                                             </div>
                                             </div>
                                        </div>
                                         <div class="col-lg-6">
                                     <div class="row invisible" id="inse_passe">
                                    <div class="col-lg-6">

                                     <div class="form-floating mb-3">
                                    <input class="form-control" name="palavra_passe" type="password" id="palavra_passe" placeholder="Insira a Palavra passe" required >
                                    <div class="invalid-feedback" id="passe_erro">
                                      Escreva a palavra passe
                                  </div>
                                  <label class="form-label" for="floatingInput"><strong>Palavra Passe</strong></label></div>
                                       </div>
                                      <div class="col-lg-6">
                                   <div class="form-floating mb-3">
                                    <input class="form-control" type="password" id="conf_passe" placeholder="Confirme a palavra passe" name="conf_passe" data-v-equal="#palavra_passe"  required  >
                                   
                                  <label class="form-label" for="floatingInput"><strong>Confirma Palavra Passe</strong></label>
                                    
                               </div>
                               </div>
                               <button type="button" class=" btn btn-lg btn-outline-primary" type="button" name="registar_novo" id="registar" value="registar">Registar-se</button>
                               </div>
                               </div>
                                </div>
                                
                               <div class="row" id="carregar_dados">

                               
                                       
                                    
                            </div>
</form>
                                  </div>
                                
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
   
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/xsalert.js"></script>
<script src="assets/js/theme.js"></script>
    <script src="assets/js/jquery.mask.min.js"></script>
 <script src="assets/js/jbvalidator.js"></script>    
   <script src="assets/js/buscar_municipio.js"></script>
    <script src="assets/js/registar-se.js"></script>
    <script type="text/javascript">
        $("#verificar").click(function(e){
   
            e.preventDefault();
            $.get("bd/verificar_estudante.php?num_univ="+$("#identif").val(),
                function(retorno){

          
                       XSAlert({
   title: "Buscando!",
   message: "Verificando dados...",
   autoCloseTimer: 2000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
   
 }).then((result)=>{

 if(result == 'autoClosed') {
    if(retorno!=0){
 $('#carregar_dados').load("bd/verificar_estudante.php?num_univ="+$("#identif").val());
       $("#inse_passe").removeClass('invisible');    
       $("#inse_passe").addClass('visible');
 }
   else{
                    XSAlert({
                    title: "Erro!",
    message: "Dados nao encontrados",
      hideCancelButton: true

});
       
        }
                 }

 })
                
               
                    
                });
        })
       $(function(){
        $("#registar").click(function(e){
        e.preventDefault();
        $dados=$("#cadastro").serialize();
        $.post("bd/cadastrar_se.php",$dados,function(retorno) {
            if(retorno==1){
                XSAlert({
   title: "Registado!",
   message: "Seja bem vindo",
   autoCloseTimer: 2000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
   
 }).then((result) => {
   if(result == 'autoClosed') {
    $(location).attr('href', 'login.php');                
                          
       }
});
            }else{
                 XSAlert({
                    title: "Erro!",
    message: retorno,
     hideCancelButton: true

});
   
            }
        })
        })

       })

     </script>
    
    </body>
    </html>