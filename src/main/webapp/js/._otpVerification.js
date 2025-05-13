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

    // Handle resend link
    const resendLink = document.querySelector('a[href="#"]');
    if (resendLink) {
        resendLink.addEventListener('click', function(e) {
            e.preventDefault();
            // Show a message that code has been resent
            const messageElement = document.createElement('div');
            messageElement.className = 'alert alert-success mt-3';
            messageElement.textContent = 'A new verification code has been sent.';

            const form = document.querySelector('form');
            form.appendChild(messageElement);

            // Remove the message after 3 seconds
            setTimeout(() => {
                messageElement.remove();
            }, 3000);
        });
    }
});