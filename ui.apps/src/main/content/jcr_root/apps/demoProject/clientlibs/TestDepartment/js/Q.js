$(document).ready(function () {
    $('#submit-button').click(function(e) {
    e.preventDefault();
    let dName= $('#dname').val();
   $.ajax({
      url: '/bin/Department',
      data: {
            departmentName: dName
      },
      error: function() {
         $('#infoSubmit').html('<p>An error has occurred</p>');
         $('button').hide();
      },
      success: function(data) {
         var $names = $('<h4>').text(data);
         $('#infoSubmit').html('').append($names);
//         $('button').hide();
         $('#afterSubmit').hide();
      },
      type: 'GET'
   });
})});