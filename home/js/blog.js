var isClosed;

$(document).ready(function () {
  $('html, body').animate({scrollTop: 55}, 500);

  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
      autoclosed = $('.btn-autoclosed');
  isClosed = false;

  trigger.click(function () {
    hamburger_cross();      
  });

  function hamburger_cross() {

    $('html, body').animate({scrollTop: 55}, 500);
    if (isClosed == true) {          
      overlay.hide();
      trigger.removeClass('is-open');
      trigger.addClass('is-closed');
      autoclosed.css({"visibility": "hidden"});
      isClosed = false;
    } else {   
      overlay.show();
      trigger.removeClass('is-closed');
      trigger.addClass('is-open');
      autoclosed.css({"visibility": "visible"});
      isClosed = true;
    }
  }
  
  $('[data-toggle="offcanvas"]').click(function () {
    $('#wrapper').toggleClass('toggled');
  });  
});


/**
 * bind shortcut for open/close the sidebar
 * <- / esc : close the sidebar
 * ->       : open the sidebar
 */
$(document).bind('keydown', function(e) {  

  var trigger = $('.hamburger');
  var overlay = $('.overlay');

  var key  = e.keyCode;

  if((key == 27 || key == 37) && isClosed == true) {
    $('html, body').animate({scrollTop: 55}, 500);
    overlay.hide();
    trigger.removeClass('is-open');
    trigger.addClass('is-closed');
    isClosed = false;
    $('#wrapper').toggleClass('toggled');
  } else if(key == 39 && isClosed == false) {
    $('html, body').animate({scrollTop: 55}, 500);
    overlay.show();
    trigger.removeClass('is-closed');
    trigger.addClass('is-open');
    isClosed = true;
    $('#wrapper').toggleClass('toggled');
  }
});

/**
 * Keep dropdown menu open when click the subitem in it.
 */
$('.dropdown .dropdown-menu').on({
  "click":function(e){
      e.stopPropagation();
    }
});


/**
 * Add JQuery animation to bootstrap dropdown elements.
 */
(function($) {
    var dropdown = $('.dropdown');

    // Add slidedown animation to dropdown
    dropdown.on('show.bs.dropdown', function(){
        $(this).find('.dropdown-menu').first().stop(true, true).slideDown();
    });

    // Add slideup animation to dropdown
    dropdown.on('hide.bs.dropdown', function(){
        $(this).find('.dropdown-menu').first().stop(true, true).slideUp();
    });
})(jQuery);

$('.leetcode').click(function(e) {
    var txt = $(e.target).text();
    var href = $(e.target).attr('target');
    var dir = "../leetcode/leetcode.html?name="+txt+"&"+"href="+href;

    // alert(dir);

    $('#frame').attr('src', dir); 
});

var autoclosed = false;
$('#autoclosed').click(function(e) {

    if (autoclosed) {
      $('.fa').removeClass('fa-check');
      $('.fa').addClass('fa-times');
    } else {
      $('.fa').removeClass('fa-times');
      $('.fa').addClass('fa-check');
    }
    
    autoclosed =! autoclosed;
});

$('li li').click(function(e) {
    if (autoclosed) {
      $('.hamburger').trigger( "click" );
    }   
});

