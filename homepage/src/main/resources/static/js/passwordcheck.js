document.addEventListener('DOMContentLoaded', function () {
    var passwordInput = document.getElementById('password');
    var errorDiv = document.getElementById('passwordError');
    var form = document.querySelector('.card__form');
    var lastEnteredPassword = document.getElementById('lastEnteredPassword').value;

    form.addEventListener('submit', function (event) {
        var enteredPassword = passwordInput.value;

        if (enteredPassword !== lastEnteredPassword) {
            errorDiv.style.display = 'block';
            event.preventDefault();
        } else {
            errorDiv.style.display = 'none';
            // window.location.href = '/LeeJaeBeen';
        }
    });
});
