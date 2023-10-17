<?php
require 'conexao.php';

	
$id_pro = $_GET['provincia'];

	$sql="SELECT * FROM municipios WHERE fk_provincia_id_prov='$id_pro'";
	if($resultado=mysqli_query($conn,$sql)){

 echo "<label class='form-label' for='municipio_nascimento'><strong>Municipio Nascimento</strong></label>";
                        echo "<select class='d-inline-block form-select form-select-xl' id='mucinipio_nascimento' name='municipio_nascimento' required>
<option value=''>Selecione o municipio</option>
                        ";
                        
while($municipio = mysqli_fetch_assoc($resultado)){
	    echo "<option value='{$municipio['id_mun']}'
	    >{$municipio['nom_mun']}</option>";
	    }

echo "</select>";
}else{
echo $conn->mysql_errno();
}
?>