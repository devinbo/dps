(function($){
   $.alert = {};

   $.alert.options = {
       fade_in_speed: 'medium', // how fast notifications fade in
       fade_out_speed: 1000, // how fast the notices fade out
       time: 6000 // hang on the screen for...
   };

   $.alert.success = function(msg, param) {
       var options = $.extend(this.options, param);
       var html = "<div id='alert_success_x1' hidden class='alert alert-success' style='position: fixed; top: 5px; left:33%; right: 33%;'>" +
           '<button type="button" class="close" data-dismiss="alert">' +
           '<i class="ace-icon fa fa-times"></i>' +
           '</button>'+
           '+msg+'+
           "</div>";
       $("body").append(html);
       $("#alert_success_x1").slideDown(300);
   }

})((jQuery));