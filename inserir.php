<?php 
require "bd/conexao.php";

$nome=array("Antonia","Paula","Teresa","Isabel","Maria","Janeth","Antonio", "Joao", "Mateus","Rufino" , "Capoco", "Sebastiao","calos","Jorge"
);
$sobrenome=array("Gomes","Edson","Gelson","Toivo", "Marcelo", "Rebeca", "Janeth", "Adilso", "Fonseca","calos","Tiago","Constancia","Marcia","Mendes"
);
$curso=array("Engenharia Informatica", "Engenharia em Recursos Hidricos","Comunicaçao Social","Enfermage","Contabilidade");
$morada=array("Cacuaco","Cuito","Huambo","Castanheira","Ortenciode sousa","PAraiso","sao jose","Sao joao");

for ($i=80; $i <90; $i++) { 
	$valor=rand(0,13);
	$valor2=rand(0,13);
	if($i<10){
		$bi="005365653LA16".$i;
	}else
	$bi="005365653LA1".$i;
	$data_n=date("Y-m-d",strtotime( rand(0,28)."-".rand(0,12)."-".rand(1985,2005)));
$sexo="Homem";
	if($valor<6)
	$sexo="Mulher";

$email=$nome[$valor]."@gmail.com";
$nom_usu=$nome[$valor]."".$i;
	$num_univer=100000+$i;
	$senha1="11111"+$i;
	$contato="9".rand(20000000,99999999);
	$sql ="INSERT INTO `pessoa` (`num_bi`, `nome`, `sobrenome`, `email`,`sexo`,`morada`,`data_nascimento`,`contacto`,`fk_municipios_id_mun`,`curso`,`num_univer`) 
VALUES ('".$bi."','{$nome[$valor]}','{$sobrenome[$valor2]}','".$email."','".$sexo."','{$morada[rand(0,7)]}','".$data_n."','".$contato."'
,'".rand(0,159)."','{$curso[rand(0,4)]}','".$num_univer."')";
  
    $senha1=sha1($senha1);
            if ($conn->query($sql)) {

                $sql ="INSERT INTO `sisv_online`.`usuario` ( `nom_use`, `senha_usu`,`fk_pessoa_id_pes`) VALUES ('".$nom_usu."','".$senha1."','".$bi."')";
                     $conn->query($sql);
                     echo "inseriu ".$i;
}
}



?>