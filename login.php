<?php
include "bd/alterar_estado.php";

session_start();

if (isset($_SESSION['estado'])) {
    if ($_SESSION['admin'] = 0) {
        header("Location: administrador/administrador.php");
    } else {
        header("Location: principal.php");
    }
}
?>

<html lang="pt-pt">
    <head>
        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <meta name="description" content="">
                    <meta name="PillSofth" content="PillSofth, Amarante">
                        <meta name="charset" content="utf-8">
                            <meta name="generator" content="SOVE 1.0.1">
                                <meta name="author" content="Amarante, PillSofth">
                                    <link rel="icon" type="image/jpeg" sizes="720x675" href="assets/img/logo.jpg">
                                        <title>Login</title>


                                        <link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
                                        <link rel="stylesheet" href="assets/css/themes/light-theme.css">

                                            <link href="estilos/login.css" rel="stylesheet">
                                                </head>

                                                <body>
                                                    <style >
                                                        body {
                                                            background: url('img/1.png') no-repeat center center fixed;
                                                            -webkit-background-size: cover;
                                                            -moz-background-size: cover;
                                                            background-size: cover;
                                                            -o-background-size: cover;
                                                        }
                                                    </style>
                                                    <div id="parte" class="bg-image shadow-2-strong">
                                                        <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0, 0, 0, 0.2);">
                                                            <div class="container">
                                                                <div class="row justify-content-center">
                                                                    <div class="col-xl-5 col-md-8">
                                                                        <form action="bd/login_bd.php" class="bg-white  rounded-5 shadow-5-strong p-5 needs-validation was-validated" novalidate method="POST" id="fazer_login">
                                                                            <div class="row align-items-center">
                                                                                <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">

                                                                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                                                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                                                                </svg>
                                                                            </div>
                                                                            <div class="row align-items-center" id="letra">
                                                                                <h1>Inicio de secçao
                                                                                </h1></div>

                                                                            <div class="form-floating">
                                                                                <input type="text" name="nome" class="form-control" id="nome" placeholder="name@example.com" required >
                                                                                    <label for="floatingInput">Numero de identificaçao</label>
                                                                                    <div class="invalid-feedback">
                                                                                        Insira nome de usuario valido
                                                                                    </div>
                                                                            </div>



                                                                            <div class="form-floating">

                                                                                <input type="password" name="passe"class="form-control" id="passw" placeholder="Palavra passe" required>
                                                                                    <label for="floatingPassword">Palavra passe</label>
                                                                                    <div class="invalid-feedback">
                                                                                        Insira a palavra passe
                                                                                    </div>
                                                                            </div>

                                                                            <!-- 2 column grid layout for inline styling -->
                                                                            <div class="row">
                                                                                <div class="col d-flex justify-content-center">
                                                                                    <!-- Checkbox -->
                                                                                    <div class="form-check">
                                                                                        <input class="form-check-input" type="checkbox" name="ver" id="form1Example3" checked />
                                                                                        <label class="form-check-label" for="form1Example3">
                                                                                            Lembrar-me
                                                                                        </label>

                                                                                    </div>
                                                                                </div>


                                                                                <div class="col-lg-6 ">

                                                                                    <a href="registar_se.php" ><strong>Registar-se</strong></a>
                                                                                    <br>
                                                                                </div>
                                                                                <?php echo @$_SESSION['msg']; ?>
                                                                                <div class="row align-items-center">
                                                                                    <div class="col-lg-3"></div>

                                                                                    <button type="submit" class="btn btn-primary btn-block" id="iniciar" value="iniciar" name="iniciar">Iniciar secçao</button>

                                                                                </div>
                                                                                <div class="row text-center">

                                                                                    <a  href="#"  data-bs-toggle="modal" data-bs-target="#exampleModal">Esqueci-me da palavra passe?</a>
                                                                                </div>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>    
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Redefinir senha</h5>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <form method="POST" id="redefinir_senha" class="needs-validation was-validated" novalidate >
                                                                        <div class="form-floating">
                                                                            <input type="text" class="form-control" name="usuario" required>
                                                                                <label class="floatingInput"> Digite o Nome usuario</label>
                                                                        </div>
                                                                        <div class="form-floating">
                                                                            <input type="email" class="form-control" name="email" required>
                                                                                <label class="floatingInput"> Digite o email</label>
                                                                        </div>
                                                                        <div class="form-floating">
                                                                            <input type="text" class="form-control" name="num_bi"  pattern="[0-9]{9}[a-zA-Z]{2}[0-9]{3}" required>
                                                                                <label class="floatingInput"> Digite o numero do BI</label>
                                                                        </div>
                                                                        <div class="form-floating">
                                                                            <input type="text" class="form-control" name="num_univ"   required>
                                                                                <label class="floatingInput"> Digite o numero Universitario</label>
                                                                        </div>


                                                                        <div class="form-floating">
                                                                            <input type="password" class="form-control" id="passe" name="passe" minlength="6" required>
                                                                                <label class="floatingInput">Digite a nova palavra passe </label>
                                                                        </div>
                                                                        <div class="form-floating">
                                                                            <input type="password" class="form-control" name="conf_passe" data-v-equal="#passe" required>
                                                                                <label class="floatingInput">Confirme a palavra passe </label>
                                                                        </div>

                                                                        <button class="btn btn-primary" data-bs-dismiss="modal" type="submit">Redefinir a senha</button>

                                                                    </form>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">fechar</button>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <script src="assets/js/jquery-3.6.0.min.js"></script>
                                                    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                                                    <script src="assets/js/jbvalidator.js"></script>
                                                    <script src="assets/js/xsalert.js"></script>


                                                    <script type="text/javascript">
                                                        $(function () {

                                                            let validator = $('form.needs-validation').jbvalidator({
                                                                errorMessage: true,
                                                                successClass: true,
                                                            });

                                                            //new custom validate methode
                                                            validator.validator.custom = function (el, event) {

                                                                if ($(el).is('[name=password]') && $(el).val().length < 5) {
                                                                    return 'palavra passe fraca.';
                                                                }

                                                                return '';
                                                            }

                                                            let validatorServerSide = $('form.validatorServerSide').jbvalidator({
                                                                errorMessage: true,
                                                                successClass: true,
                                                            });

                                                            //serverside
                                                            $(document).on('submit', '.validatorServerSide', function () {

                                                                $.ajax({
                                                                    method: "get",
                                                                    url: "test.json",
                                                                    data: $(this).serialize(),
                                                                    success: function (data) {
                                                                        if (data.status === 'error') {
                                                                            validatorServerSide.errorTrigger($('[name=username]'), data.message);
                                                                        }
                                                                    }
                                                                })

                                                                return false;
                                                            });
                                                        })
                                                        $(function () {

                                                            $("#fazer_login").on('submit', function (e) {
                                                                e.preventDefault();
                                                                var dados = $("#fazer_login").serialize();

                                                                $.post("bd/login_bd.php",
                                                                        dados,
                                                                        function (retorno) {
                                                                            if (retorno == 0) {
                                                                                XSAlert({
                                                                                    title: "Seja bem Vindo!",
                                                                                    message: "Entrar como",
                                                                                    okButtonText: 'Administrador',
                                                                                    cancelButtonText: "usuario normal",
                                                                                    hideProgressBar: false,
                                                                                    hideProgressIcon: false,
                                                                                    hideProgressIcon: false,

                                                                                }).then((result) => {
                                                                                    if (result == 'ok') {
                                                                                        XSAlert({
                                                                                            title: "Seja bem Vindo!",
                                                                                            message: "Pagina Administrador",
                                                                                            autoCloseTimer: 2000,
                                                                                            hideProgressBar: false,
                                                                                            hideProgressIcon: false,
                                                                                            hideOkButton: true,
                                                                                            closeOnOutsideClick: false,
                                                                                            hideCancelButton: true

                                                                                        }).then((result) => {
                                                                                            if (result == 'autoClosed') {
                                                                                                $(location).attr('href', 'administrador/administrador.php');
                                                                                            }
                                                                                        });

                                                                                    } else
                                                                                    {
                                                                                        XSAlert({
                                                                                            title: "Seja bem Vindo!",
                                                                                            message: "Pagina usuario",
                                                                                            autoCloseTimer: 2000,
                                                                                            hideProgressBar: false,
                                                                                            hideProgressIcon: false,
                                                                                            hideOkButton: true,
                                                                                            hideCancelButton: true

                                                                                        }).then((result) => {
                                                                                            if (result == 'autoClosed') {
                                                                                                $(location).attr('href', 'principal.php');
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });




                                                                            } else if (retorno == 1) {

                                                                                XSAlert({
                                                                                    title: "Seja bem Vindo!",
                                                                                    message: "Pagina Estudante",
                                                                                    autoCloseTimer: 2000,
                                                                                    hideProgressBar: false,
                                                                                    hideProgressIcon: false,
                                                                                    hideOkButton: true,
                                                                                    hideCancelButton: true

                                                                                }).then((result) => {
                                                                                    if (result == 'autoClosed') {
                                                                                        $(location).attr('href', 'principal.php');
                                                                                    }
                                                                                });
                                                                            } else {

                                                                                XSAlert({

                                                                                    title: "Erro!",
                                                                                    message: retorno,
                                                                                    hideCancelButton: true
                                                                                });

                                                                            }

                                                                        });
                                                            });
                                                        });
                                                        $("#redefinir_senha").on('submit', function (e) {
                                                            e.preventDefault();
                                                            var dados = $("#redefinir_senha").serialize();

                                                            $.post("bd/redefinir_senha.php", dados,
                                                                    function (retorno) {
                                                                        if (retorno == 1) {
                                                                            XSAlert({title: "Redefinir!",
                                                                                message: "Senha redefinida",
                                                                                autoCloseTimer: 2000,
                                                                                hideProgressBar: false,
                                                                                hideProgressIcon: false,
                                                                                hideOkButton: true,
                                                                                hideCancelButton: true

                                                                            }).then((result) => {
                                                                                if (result == 'autoClosed') {
                                                                                    $(location).attr('href', 'login.php');
                                                                                }
                                                                            });

                                                                        } else {
                                                                            XSAlert({

                                                                                title: "Erro!",
                                                                                message: retorno,
                                                                                hideCancelButton: true
                                                                            });
                                                                        }
                                                                    })

                                                        })
                                                    </script>
                                                </body>
                                                </html>