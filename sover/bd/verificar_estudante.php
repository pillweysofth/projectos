<?php 
require "conexao.php";

$sql="SELECT * FROM pessoa WHERE num_bi='{$_GET['num_univ']}' OR num_univer ='{$_GET['num_univ']}'";
$resultado=mysqli_query($conn,$sql);
if($resultado->num_rows>0){


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
$num_bi=$dados['num_bi'];
$num_univer=$dados['num_univer'];
$sql="SELECT * FROM ver_prov WHERE id_mun='$provincia'";
$resu=mysqli_query($conn,$sql);
 $dad=mysqli_fetch_assoc($resu);
$id_mun=$dad['id_mun'];
$id_pro=$dad['id_prov'];
$mun=$dad['nom_mun'];
$pro=$dad['nom_prov'];

?>
	 <div class="row">
                                        <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input class="form-control " name="nome" type="text" id="nome" placeholder="Amarante" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;" value="<?php echo $primeiro_nome." ". $segundo_nome; ?>" disabled>
                                                      <label class="form-label" for="floatingInput"><strong>Nome completo</strong></label>
                                            </div>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input  class="form-control" type="text" id="num_bi" placeholder="Doe" name="num_bi" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                                value="<?php echo $num_bi ?>" readonly>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Numero do BI</strong></label>
                                          </div>
                                      </div>
                                       <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input  class="form-control" type="text" id="num_univ" placeholder="Doe" name="num_univ" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;" 
                                                value="<?php echo $num_univer ?>"readonly>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Nº Universitario</strong></label>
                                          </div>
                                      </div>
                                      <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input  class="form-control" type="text" id="curso" placeholder="Doe" name="curso" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                                value="<?php echo $curso ?>" disabled>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Curso</strong></label>
                                          </div>
                                      </div>
                                      </div>
                                      <div class="row">
                                        <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" type="text" id="provincia" placeholder="Doe" name="provincia" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                                value="<?php echo $pro?>" disabled>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Provincia Nascimento</strong></label>
                                          </div>
                                      </div>
                                       <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input  class="form-control" type="text" id="naturalidade" placeholder="Doe" name="naturalidade" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                                value="<?php echo $mun ?>" disabled>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Naturalidade</strong></label>
                                          </div>
                                             </div>
                                        <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" name="data_nascimento" id="data_nascimento" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;" 
                                                value="<?php echo $data_n?>"disabled>
                                                <label class="form-label" for="floatingInput"><strong>Data Nascimento</strong></label>
                                            </div>
                                        </div>
                                         <div class="col-lg-3">
                                            <div class="form-floating mb-3">
                                                <input  class="form-control" type="text" id="sexo" placeholder="Doe" name="sexo"  style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;" 
                                                value="<?php echo $sexo ?>"disabled>
                                              
                                               
                                              <label class="form-label" for="floatingInput"><strong>Sexo</strong></label>
                                          </div>
                                      </div>
                                                                        
                                       
                                      </div>
                                        

                                      
                                      
                                          

                                     <div class="row">
                                         <div class="col-lg-4">
                                    <div class="form-floating">

                                    <input class="form-control" type="text" id="telemovel" placeholder="9xx xxx xxx" name="telemovel" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                    value="<?php echo $contacto ?>" disabled>
                                   
                                   
                                     <label class="form-label" for="floatingInput"><strong>Telemovel</strong></label>
                                      </div>
                                        </div>
                                      <div class="col-lg-4">
                                         <div class="form-floating mb-3">
                                    <input class="form-control" type="email" id="email" placeholder="user@example.com" name="email" style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                    value="<?php echo $email ?>" disabled>
                              
                                   
                                    <label class="form-label" for="floatingInput"><strong>Enderço Email</strong></label></div>
                                      </div>
                                      <div class="col-lg-4">
                                         <div class="form-floating mb-3">
                                    <input class="form-control" type="text" id="morada" placeholder="" name="morada" 
                                     style="border-top-style: none;border-right-style: none;border-bottom-width: 3px;border-bottom-color: var(--bs-gray-900);border-left-style: none;background: transparent;"
                                     value="<?php echo $endereco ?>" readonly>
                             
                                    <label class="form-label " for="floatingInput"><strong>Morada</strong></label></div>
                                      </div>
                                   </div>

<?php

}else{

echo 0;
}


?>