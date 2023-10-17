<?php 
require "conexao.php";

$dados=unserialize(@$dado);

$sql="SELECT * FROM pessoa WHERE email='{$_POST['email']}' AND num_bi='{$_POST['num_bi']}' AND num_univer='{$_POST['num_univ']}'";
$resultado=mysqli_query($conn,$sql);
if($resultado->num_rows>0){
	$pessoa=mysqli_fetch_assoc($resultado);
	$senha=sha1($_POST['passe']);
	$sql="UPDATE `usuario` SET `senha_usu`='{$senha}' WHERE `fk_pessoa_id_pes`='{$pessoa['num_bi']}' AND `nom_use`='{$_POST['usuario']}'";
if(mysqli_query($conn,$sql)){
		echo 1;
}else{
echo "dados inseridos nao foram encontrados";
}
}else{

echo "dados inseridos nao foram encontrados";
}

?>