<?php 
require 'conexao.php';


$sql= "SELECT * FROM concorrentes WHERE id_pes ='{$_SESSION['id']'";

$resultado=mysqli_query($conn,$sql);





?>