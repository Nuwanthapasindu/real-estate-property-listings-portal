// Login form validation
document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            
            // Simple validation
            if (!email) {
                showError('email', 'Email is required');
                return;
            } else if (!isValidEmail(email)) {
                showError('email', 'Please enter a valid email');
                return;
            } else {
                removeError('email');
            }
            
            if (!password) {
                showError('password', 'Password is required');
                return;
            } else {
                removeError('password');
            }
            
            // If validation passes, you would typically send the data to your server
            console.log('Login form submitted:', { email, password });
            
            // For demo purposes, show success message
            alert('Login successful!');
            
            // Optionally redirect to another page
            // window.location.href = 'dashboard.html';
        });
    }
    
    // Helper functions
    function showError(fieldId, message) {
        const field = document.getElementById(fieldId);
        const errorElement = field.nextElementSibling?.classList.contains('error-message') 
            ? field.nextElementSibling 
            : document.createElement('div');
        
        if (!errorElement.classList.contains('error-message')) {
            errorElement.classList.add('error-message', 'text-danger', 'mt-1', 'small');
            field.parentNode.insertBefore(errorElement, field.nextSibling);
        }
        
        errorElement.textContent = message;
        field.classList.add('is-invalid');
    }
    
    function removeError(fieldId) {
        const field = document.getElementById(fieldId);
        const errorElement = field.nextElementSibling;
        
        if (errorElement && errorElement.classList.contains('error-message')) {
            errorElement.remove();
        }
        
        field.classList.remove('is-invalid');
    }
    
    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});