document.addEventListener('DOMContentLoaded', function() {
    const otpInput = document.getElementById('otp');
    
    // Focus on OTP input when page loads
    if (otpInput) {
        otpInput.focus();
        
        // Only allow numbers in the OTP field
        otpInput.addEventListener('input', function(e) {
            this.value = this.value.replace(/[^0-9]/g, '');
            
            // Auto-submit when 6 digits are entered
            if (this.value.length === 6) {
                // You can trigger form submission here if needed
                // document.querySelector('form').submit();
            }
        });
        
        // Handle paste event
        otpInput.addEventListener('paste', function(e) {
            e.preventDefault();
            const pasteData = (e.clipboardData || window.clipboardData).getData('text');
            const numericData = pasteData.replace(/[^0-9]/g, '').substring(0, 6);
            this.value = numericData;
        });
    }
    
});