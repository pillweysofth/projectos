<?php 

require "conexao.php";
$sql="SELECT * FROM eleicao";
$resultado=mysqli_query($conn,$sql);
$data_hoje=strtotime("now");
 $hora=date('H : i',strtotime(@$datas['data_voto']));

while($eleicao=mysqli_fetch_assoc($resultado)){
if ($data_hoje>=(strtotime($eleicao['data_inicio']." ".$eleicao['hora_inicio']))) {
	$sql="UPDATE `eleicao` SET `estado`='2' 
	WHERE `id_elei`='{$eleicao['id_elei']}'";
	mysqli_query($conn,$sql);
}
if(strtotime(date("d-m-Y",strtotime("today")))>strtotime($eleicao['data_inicio'])){

	$sql="UPDATE `eleicao` SET `estado`='3' WHERE `id_elei`='{$eleicao['id_elei']}'";
	mysqli_query($conn,$sql);
}

}



?>