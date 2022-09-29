
let signUpButton = document.querySelector('#signUp');
let signInButton = document.getElementById('signIn');
let container = document.querySelector('#container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});


signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});