/*price range*/

 $('#sl2').slider();

	var RGBChange = function() {
	  $('#RGB').css('background', 'rgb('+r.getValue()+','+g.getValue()+','+b.getValue()+')')
	};	
		
/*scroll to top*/

$(document).ready(function(){
	$(function () {
		$.scrollUp({
	        scrollName: 'scrollUp', // Element ID
	        scrollDistance: 300, // Distance from top/bottom before showing element (px)
	        scrollFrom: 'top', // 'top' or 'bottom'
	        scrollSpeed: 300, // Speed back to top (ms)
	        easingType: 'linear', // Scroll to top easing (see http://easings.net/)
	        animation: 'fade', // Fade, slide, none
	        animationSpeed: 200, // Animation in speed (ms)
	        scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
					//scrollTarget: false, // Set a custom target element for scrolling to the top
	        scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
	        scrollTitle: false, // Set a custom <a> title if required.
	        scrollImg: false, // Set true to use image
	        activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	        zIndex: 2147483647 // Z-Index for the overlay
		});
	});
});
window.addEventListener('DOMContentLoaded', function() {
    const itemNames = document.getElementsByClassName('item-name');
    for (let i = 0; i < itemNames.length; i++) {
        const item = itemNames[i];
        const truncatedName = truncateText(item.textContent, 20); // Adjust the number of characters as needed
        item.textContent = truncatedName;
    }

    function truncateText(text, maxLength) {
        if (text.length > maxLength) {
            return text.substr(0, maxLength) + '...';
        }
        return text;
    }
});
       // Automatically display the first tab content when the page loads
                            document.addEventListener("DOMContentLoaded", function () {
                                // Get the first tab link
                                var firstTabLink = document.querySelector(".nav-tabs li:first-child a");
                                // Trigger a click event on the first tab link
                                firstTabLink.click();
                            });
