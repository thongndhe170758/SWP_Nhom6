/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

       // Automatically display the first tab content when the page loads
                            document.addEventListener("DOMContentLoaded", function () {
                                // Get the first tab link
                                var firstTabLink = document.querySelector(".nav-tabs li:first-child a");
                                // Trigger a click event on the first tab link
                                firstTabLink.click();
                            });
  



function showMoreGenres() {
    const genreList = document.getElementById('genreList');
    const hiddenItems = genreList.querySelectorAll('.genre-item.hidden');

    hiddenItems.forEach(item => item.classList.remove('hidden'));
    document.querySelector('.show-more-button').classList.add('hidden');
    document.querySelector('.show-less-button').classList.remove('hidden');
}

function showLessGenres() {
    const genreList = document.getElementById('genreList');
    const visibleItems = genreList.querySelectorAll('.genre-item:not(.hidden)');

    visibleItems.forEach((item, index) => {
        if (index >= 7) {
            item.classList.add('hidden');
        }
    });
    document.querySelector('.show-more-button').classList.remove('hidden');
    document.querySelector('.show-less-button').classList.add('hidden');
}
$(document).ready(function() {
    $('.category-tab ul.nav-tabs li a').on('click', function(e) {
        e.preventDefault();
        var categoryId = $(this).data('category-id');
        loadCategoryItems(categoryId);
    });

    // Function to load category items via AJAX
    function loadCategoryItems(categoryId) {
        $.ajax({
            url: '/swp/home',
            method: 'POST',
            data: { categoryId: categoryId },
            success: function(response) {
                $('.category-tab .tab-content').html(response);
            },
            error: function() {
                console.error('Error occurred while loading category items.');
            }
        });
    }
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
document.querySelector('form').addEventListener('submit', function(event) {
  event.preventDefault(); // Prevent form submission

  // Retrieve the quantity value
  var quantity = document.getElementById('quantityInput').value;

  // Do something with the quantity value
  console.log('Quantity:', quantity);
  // You can perform further processing or send the value to the server

  // Submit the form programmatically if needed
  // event.target.submit();
});



