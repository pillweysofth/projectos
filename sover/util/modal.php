<?php 
echo "

<div class='modal fade' id='exampleModal' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>
  <div class='modal-dialog'>
    <div class='modal-content'>
      <div class='modal-header'>
        <h5 class='modal-title' id='exampleModalLabel'>{$_GET['titulo']}</h5>
        <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>
      </div>
      <div class='modal-body'>
        {$_GET['msg']};
      </div>
      <div class='modal-footer'>
        <button type='button' class='btn btn-alert' data-bs-dismiss'modal'>Close</button>
            </div>
    </div>
  </div>
</div>
";
?>

<script type="text/javascript">
$("#selecionado").click(function(){
var id_elei=$(this).val();
var id_pes=$(this).parents("tr").find("td").eq(1).text();

    $.get("adicionar_candidatos.php?id_pes="+id_pes"&id_elei="+id_elei, function(retorno){
        if(retorno==1){
                        XSAlert({
                            title: "ADICIONAR",
                            message: "CAndidato Adicionado com sucesso",
                            autoCloseTimer: 1000,
                hideProgressBar: false, 
                hideProgressIcon: false, 
                hideOkButton: true,
                ideCancelButton: true
                        }).then((result)=>{
                            if (result=="autoClosed") {
                            $(location).attr("href", "criar_eleicoes.php");
                            }
                        })
                    }else{
                        
               XSAlert({

   title: "Erro!",
   message:retorno,
     hideCancelButton: true
})
           }
    })
})
</script>';