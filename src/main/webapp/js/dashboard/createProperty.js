document.addEventListener('DOMContentLoaded', function() {
    // Image Upload Functionality
    const uploadArea = document.getElementById('uploadArea');
    const uploadedImages = document.getElementById('uploadedImages');
    const fileInput  = document.getElementById("fileInput");
    const propertyTypeSelect = document.getElementById('propertyType');


    // Show/hide property type specific fields
    propertyTypeSelect.addEventListener('change', function() {
        // Hide all property type fields first
        document.querySelectorAll('.property-type-fields').forEach(field => {
            field.style.display = 'none';
        });

        // Show fields for selected property type
        const selectedType = this.value;
        if (selectedType) {
            document.getElementById(selectedType.toLowerCase() + 'Fields').style.display = 'block';
        }
    });

    // Handle file selection and preview (updated version of handleFileSelect)
    fileInput.addEventListener('change', function(event) {
        const files = event.target.files;
        uploadedImages.innerHTML = ''; // Clear previous previews

        if (files.length === 0) return;

        for (let i = 0; i < files.length; i++) {
            const file = files[i];

            // Validate file type
            if (!file.type.match('image/jpeg') && !file.type.match('image/png')) {
                alert('Only JPG and PNG files are allowed');
                continue;
            }

            const reader = new FileReader();

            reader.onload = function(e) {
                const imagePreview = document.createElement('div');
                imagePreview.className = 'image-preview';

                const img = document.createElement('img');
                img.src = e.target.result;
                img.alt = 'Property image preview';

                imagePreview.appendChild(img);
                uploadedImages.appendChild(imagePreview);
            };

            reader.readAsDataURL(file);
        }
    });

    // Form Submission
    const propertyForm = document.getElementById('propertyForm');


    // Initialize dropdown functionality
    const dropdownToggle = document.querySelector('.dropdown-toggle');
    const dropdownItems = document.querySelectorAll('.dropdown-item');
    const sortValue = document.querySelector('.sort-value');

    dropdownItems.forEach(item => {
        item.addEventListener('click', function(e) {
            e.preventDefault();
            sortValue.textContent = this.textContent;
        });
    });
});