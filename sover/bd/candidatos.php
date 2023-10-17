 <?php 
                                       require "../bd/conexao.php";          
                                                 
                                                $sql="SELECT * FROM resultado_eleicao WHERE id='{$_GET['id_elei']}'";
                                                    $cand=mysqli_query($conn,$sql);
                                                   
                                                if($cand->num_rows>0){
                                                  

                                                    echo "
                                                     <thead> 
                                                     <tr>
                                                   
                                                                                                        <th scope='col'>#</th>
                                                   <th>Nº Universitario</th>
                                                   
                                                    <th>candidato</th>
                                                         <th>curso</th>
                                                    
                                                                    <th>remover</th> 
                                                   </tr>
                                                    </thead>";
                                                    $contt=1;
                                                while($candidatos=mysqli_fetch_assoc($cand)){
                                                   ?>
                                                   <tbody>
                                                <tr>

                                                    <td ><?php 
                                                           echo $contt++;
                                                        ?>
                                                    <img class="border rounded-circle img-profile" src="../util/buscar_foto.php?id=<?php echo $candidatos['foto']; ?>" width="30" height="30"></td>
                                                         <td>
                                                        <?php echo $candidatos['num_univer'];?>
                                                    </td>
                                                    
                                                        <td>
                                                        
                                                         
                                                        <?php echo $candidatos['nome'];?>
                                                    </td>
                                                     <td>
                                                        <?php echo $candidatos['curso'];?>
                                                    </td>
                                                                                <td >
                                                       <button  class=" btn btn-lg btn-outline-success remover"
                                            value=<?=$candidatos['id_cand']?>><img class="border rounded-circle img-profile" src="../img/error.png" width="15"></button>
                                                  
                                                    </td>

                                                </tr>
                                                </tbody>
                                                <?php } 
                                            }?>
                    <script type="text/javascript">

$(".remover").click(function() {
        XSAlert({
   title: "REMOVER!",
   message: "Tens certeza que deseja remover o camdidato selecionado?",
    okButtonText: "sim",
         cancelButtonText: "Cancelar",
     hideProgressBar: false, 
   hideProgressIcon: false, 
 }).then((result)=>{
     if(result=="ok"){
          $.get("../bd/remover_candidato.php?id_cand="+$(this).val(),
          function(retorno){
if(retorno==1){
   XSAlert({
   title: "REMOVER!",
   message: "Candidato Removido!",
   autoCloseTimer: 1000,
   hideProgressBar: false, 
   hideProgressIcon: false, 
   hideOkButton: true,
   hideCancelButton: true
   
 }).then((result) => {
   if(result == "autoClosed") {

      $("#lista_candidatos").load("../bd/candidatos.php?id_elei="+"<?php echo $_GET['id_elei'] ?>");
       $("#pessoas_elegiveis").load('../bd/pessoas_elegiveis.php?id_elei='+"<?php echo $_GET['id_elei'] ?>");

       }
});
}
               })
     }
     })
});
</script>