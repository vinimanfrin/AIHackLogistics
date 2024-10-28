document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.querySelector('section');
    signupForm.style.opacity = 0;
    setTimeout(() => {
        signupForm.style.transition = 'opacity 1s ease-in-out';
        signupForm.style.opacity = 1;
    }, 500);
    const signupButton = document.querySelector('button');
    signupButton.addEventListener('click', function (event) {
        const emailInput = document.querySelector('input[type="email"]');
        const passwordInput = document.querySelector('input[type="password"]#password');
        const confirmPasswordInput = document.querySelector('input[type="password"]#passwordcon');
        const isValid = emailInput.checkValidity() && passwordInput.checkValidity() && confirmPasswordInput.checkValidity();
        const errorMessage = document.getElementById('error-message');
        if (errorMessage) {
            errorMessage.remove();
        }
        if (!isValid) {
            signupForm.classList.add('shake');
            setTimeout(() => {
                signupForm.classList.remove('shake');
            }, 1000);
            event.preventDefault();
            return;
        }
        if (passwordInput.value !== confirmPasswordInput.value) {
            const error = document.createElement('p');
            error.id = 'error-message';
            error.style.color = 'red';
            error.innerText = 'Passwords do not match!';
            confirmPasswordInput.parentElement.appendChild(error);
            signupForm.classList.add('shake');
            setTimeout(() => {
                signupForm.classList.remove('shake');
            }, 1000);
            event.preventDefault();
            return;
        }
    });
});