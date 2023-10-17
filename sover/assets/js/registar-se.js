 $(function () {

        let validator = $('form.needs-validation').jbvalidator({
            errorMessage: true,
            successClass: true,
                });

        //new custom validate methode
        validator.validator.custom = function (el, event) {

            if ($(el).is('[name=palavra_passe]')){
                if( $(el).val().length < 6) {
                return 'Palavra passe fraca';
             }
           }
            
   
             if ($(el).is('[name=num_bi]')){
var v = new RegExp( "^[0-9]{9}[a-zA-Z]{2}[0-9]{3}$");
             if(!(v.test($(el).val()))) {
                return 'Numero do Bilhete invalido!.';
            }
            }
            if ($(el).is('[name=num_univ]')) {
            var c = new RegExp( "^10[0-9]{4}$");
            if( !(c.test($(el).val()))) {
                return 'Numero Universitavrio invalido!';
            }
        }

            return '';
        }

        let validatorServerSide = $('form.validatorServerSide').jbvalidator({
            errorMessage: true,
            successClass: true,
        });

        //serverside
        $(document).on('submit', '.validatorServerSide', function () {

            $.ajax({
                method: "get",
                url: "test.json",
                data: $(this).serialize(),
                success: function (data) {
                    if (data.status === 'error') {
                        validatorServerSide.errorTrigger($('[name=username]'), data.message);
                    }
                }
            })

            return false;
        });
    })
       

       
$(function(){
$("#telemovel").mask("999 999 999");
});

   
   
    