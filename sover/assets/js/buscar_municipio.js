
 $(function(){
    
        $('#provincia_nascimento').change(function(){
            $('#minicipios').load('bd/buscar_provincias.php?provincia='+$('#provincia_nascimento').val());

        });
    });