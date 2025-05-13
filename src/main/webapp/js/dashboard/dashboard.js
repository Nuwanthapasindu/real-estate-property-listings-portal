document.addEventListener('DOMContentLoaded', function() {
    // Initialize dropdown functionality
    const sortDropdown = document.getElementById('sortDropdown');
    const sortItems = document.querySelectorAll('.dropdown-item');
    const sortValue = document.querySelector('.sort-value');
    
    // Handle sort dropdown selection
    sortItems.forEach(item => {
        item.addEventListener('click', function(e) {
            e.preventDefault();
            const selectedValue = this.textContent;
            sortValue.textContent = selectedValue;
            
            // Here you would implement actual sorting logic
            sortProperties(selectedValue);
        });
    });
    
    // Search functionality
    const searchInput = document.querySelector('.search-input');
    searchInput.addEventListener('input', function() {
        const searchTerm = this.value.toLowerCase().trim();
        filterProperties(searchTerm);
    });
    
    // Function to filter properties based on search term
    function filterProperties(searchTerm) {
        const propertyCards = document.querySelectorAll('.property-card');
        
        propertyCards.forEach(card => {
            const title = card.querySelector('.property-title').textContent.toLowerCase();
            const address = card.querySelector('.property-address').textContent.toLowerCase();
            const price = card.querySelector('.property-price').textContent.toLowerCase();
            
            // Check if any property detail contains the search term
            const matchesSearch = 
                title.includes(searchTerm) || 
                address.includes(searchTerm) || 
                price.includes(searchTerm);
            
            // Show or hide the card based on search match
            card.closest('.col-md-6').style.display = matchesSearch ? 'block' : 'none';
        });
    }
    
    // Function to sort properties
    function sortProperties(sortBy) {
        const propertyGrid = document.querySelector('.row');
        const propertyCards = Array.from(document.querySelectorAll('.col-md-6'));
        
        // Sort the property cards based on the selected sort option
        propertyCards.sort((a, b) => {
            const priceA = extractPrice(a.querySelector('.property-price').textContent);
            const priceB = extractPrice(b.querySelector('.property-price').textContent);
            
            switch(sortBy) {
                case 'Newest':
                    // For demo purposes, we'll just reverse the current order
                    return -1; // Keep original order (newest first)
                case 'Oldest':
                    return 1; // Reverse order (oldest first)
                case 'Price: Low to High':
                    return priceA - priceB;
                case 'Price: High to Low':
                    return priceB - priceA;
                default:
                    return 0;
            }
        });
        
        // Remove all current cards
        while (propertyGrid.firstChild) {
            propertyGrid.removeChild(propertyGrid.firstChild);
        }
        
        // Add sorted cards back to the grid
        propertyCards.forEach(card => {
            propertyGrid.appendChild(card);
        });
    }
    
    // Helper function to extract numeric price value
    function extractPrice(priceString) {
        // Remove currency symbol, commas and convert to number
        return parseFloat(priceString.replace(/[^0-9.-]+/g, ''));
    }
    
    // Add New Property button functionality
    const addPropertyBtn = document.querySelector('.add-property-btn');
    addPropertyBtn.addEventListener('click', function() {
        // Redirect to property creation page or show modal
        alert('Add New Property functionality will be implemented here');
    });
});