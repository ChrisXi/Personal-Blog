var isClosed;
$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay');
  isClosed = false;

  trigger.click(function () {
    hamburger_cross();      
  });

  function hamburger_cross() {

    if (isClosed == true) {          
      overlay.hide();
      trigger.removeClass('is-open');
      trigger.addClass('is-closed');
      isClosed = false;
    } else {   
      overlay.show();
      trigger.removeClass('is-closed');
      trigger.addClass('is-open');
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
    overlay.hide();
    trigger.removeClass('is-open');
    trigger.addClass('is-closed');
    isClosed = false;
    $('#wrapper').toggleClass('toggled');
  } else if(key == 39 && isClosed == false) {
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