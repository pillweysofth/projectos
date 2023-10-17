<?php
include 'conexao.php';


$id_usua=$_SESSION['id'];
$sql="SELECT * FROM pessoa Where num_bi='$id_usua'";

$resultado=mysqli_query($conn,$sql);
 $dados=mysqli_fetch_assoc($resultado);

$primeiro_nome=$dados['nome'];
$segundo_nome=$dados['sobrenome'];
$tipo=$dados['tipo'];
$email=$dados['email'];
$curso=$dados['curso'];
$endereco=$dados['morada'];
$provincia=$dados['fk_municipios_id_mun'];
$sexo=$dados['sexo'];
$data_n=$dados['data_nascimento'];
$contacto=$dados['contacto'];
$num_univer=$dados['num_univer'];
$sql="SELECT * FROM ver_prov WHERE id_mun='$provincia'";
$resu=mysqli_query($conn,$sql);
 $dad=mysqli_fetch_assoc($resu);
$id_mun=$dad['id_mun'];
$id_pro=$dad['id_prov'];
$mun=$dad['nom_mun'];
$pro=$dad['nom_prov'];


?>