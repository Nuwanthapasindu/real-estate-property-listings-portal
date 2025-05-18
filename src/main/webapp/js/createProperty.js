document.addEventListener('DOMContentLoaded', function() {
    // Image Upload Functionality
    const uploadArea = document.getElementById('uploadArea');
    const uploadedImages = document.getElementById('uploadedImages');
    const fileInput  = document.getElementById("fileInput");
    const propertyTypeSelect = document.getElementById('propertyType');


    // fileInput.addEventListener('change', handleFileSelect);


    // Handle file selection
    // function handleFileSelect(event) {
    //   const imageFiles = event.target.files;
    //
    //     if (imageFiles.length === 0) return;
    //
    //     for (let i = 0; i < imageFiles.length; i++) {
    //         const file = imageFiles[i];
    //
    //         // Validate file type
    //         if (!file.type.match('image/jpeg') && !file.type.match('image/png')) {
    //             alert('Only JPG and PNG files are allowed');
    //             continue;
    //         }
    //
    //         const reader = new FileReader();
    //
    //         reader.onload = function(e) {
    //             const imagePreview = document.createElement('div');
    //             imagePreview.className = 'image-preview';
    //
    //             const img = document.createElement('img');
    //             img.src = e.target.result;
    //
    //
    //             imagePreview.appendChild(img);
    //             uploadedImages.appendChild(imagePreview);
    //         };
    //
    //         reader.readAsDataURL(file);
    //     }
    //
    // }

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

    // propertyForm.addEventListener('submit', function(event) {
    //     event.preventDefault();
    //
    //     // Get form values
    //     const propertyTitle = document.getElementById('propertyTitle').value;
    //     const propertyType = document.getElementById('propertyType').value;
    //     const location = document.getElementById('location').value;
    //     const price = document.getElementById('price').value;
    //     const size = document.getElementById('size').value;
    //     const sizeUnit = document.getElementById('sizeUnit').value;
    //     const description = document.getElementById('description').value;
    //
    //     // Validate form
    //     if (!propertyTitle || !location || !price || !size) {
    //         alert('Please fill in all required fields');
    //         return;
    //     }
    //
    //     // In a real application, you would send this data to a server
    //     // For demo purposes, we'll just show an alert
    //     console.log(fileInput);
    //
    //     alert('Property added successfully!');
    //
    //     // Redirect to dashboard
    // });

    // Updated form submission handler
    // propertyForm.addEventListener('submit', function(event) {
    //     event.preventDefault();
    //
    //     // Get common form values
    //     const formData = new FormData(this);
    //     const propertyType = propertyTypeSelect.value;
    //
    //     // Validate form
    //     if (!propertyType) {
    //         alert('Please select a property type');
    //         return;
    //     }
    //
    //     // Additional validation can be added here
    //
    //     // Log form data for debugging
    //     for (let [key, value] of formData.entries()) {
    //         console.log(key + ': ' + value);
    //     }
    //
    //     // In a real application, you would send formData to the server
    //     // Example: fetch('/api/properties', { method: 'POST', body: formData })
    //
    //     alert('Property added successfully!');
    //     // Redirect or reset form as needed
    //     // this.reset();
    // });

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