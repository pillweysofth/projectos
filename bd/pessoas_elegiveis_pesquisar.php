<?php
require "Conexao.php";
  echo '

 <div class="table-responsive shadow">
                                        <table class="table table-bordered" >
                                            <thead>
                                                <tr>
                                                     <th scope="col">#</th>
                                                     <th>Numero do BI</th>
                                                                <th>Nome Completo</th>
                                                     <th>Curso</th>
                                                       <th>Sexo</th>
                                                                                                <th>Adicionar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                ';
                                              $sql="SELECT * FROM pessoa WHERE num_bi='{$_GET['num_bi']}' OR num_univer='{$_GET['num_bi']}'";
                                                
                                                $resultado=mysqli_query($conn,$sql);

                                                $cont=0;
                                                while($pessoas=mysqli_fetch_assoc($resultado)){
                                                	$sql="SELECT * FROM pessoas_elegiveis WHERE   id_pessoa='{$pessoas['num_bi']}'";
                                                	$veri=mysqli_query($conn,$sql);

                                                if($veri->num_rows>0){
                                                	continue;
                                                }
                                              echo '                                     
                                                <tr>
                                                    <th scope="row" >
                                                    '.++$cont.' 
                                                      </th>
                                                                                                          <td>';
                                                       
                                                           echo $pessoas['num_bi'].'
                                                    </td>
                                                   
                                                                    <td>';
                                                           echo $pessoas['nome'].'
                                                    </td>                                                                                   
                                                                                                          <td>';
                                                       
                                                           echo $pessoas['curso'].'
                                                    </td>
                                                   <td>';
                                                           echo $pessoas['sexo'].'
                                                    </td>
                                                    
                                                   
                                                                                                      
                                                    
                                                    <td>
                                                        <button value='.$pessoas['num_bi'].' class="fa fa-check btn btn-lg btn-outline-success add_cand" id="add_cand" data-bs-dismiss="modal"></button>
                                                    </td>
                                                </tr>';
                                               
                                            }
                                               echo'


                                            </tbody>
                                        </table>
                                                       </div>';



?>

<script type="text/javascript">
   
   

$(".add_cand").click(function() {
     
var id_pes=$(this).parents("tr").find("td").eq(0).text(); 

id_pes=$.trim(id_pes);
               $.get("../bd/elegiveis.php?id_pes="+id_pes,
          function(retorno){
if(retorno==1){
   XSAlert({
   title: "Adicionar!",
   message: "Candidato adicionado!",
   autoCloseTimer: 1000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
   
 }).then((result) => {
   if(result == "autoClosed") {
       $(location).attr('href', 'criar_eleicoes.php');  
       }
});
}else{
    XSAlert({

   title: "Erro!",
   message:retorno,
     hideCancelButton: true
})
}
               })
    
    
})
;

</script>