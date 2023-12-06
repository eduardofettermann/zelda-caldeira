var login = true;

var loginText = document.getElementById("faca-login");
var changeLoginText = document.getElementById("changeLogin-text");
var changeSignText = document.getElementById("changeSign-text");

var nameInput = document.getElementById("name");
var emailInput = document.getElementById("email");
var passwordInput = document.getElementById("password");
var confirmPasswordInput = document.getElementById("confirm-password");
var submitInput = document.getElementById("submit");

var changeLinkLogin = document.getElementById("change-login");
var changeLinkSign = document.getElementById("change-sign");

changeLinkLogin.addEventListener("click", () => {
  changeLogin();
});
changeLinkSign.addEventListener("click", () => {
  changeLogin();
});

function changeLogin() {
  if (login) {
    nameInput.classList.remove("hidden");
    confirmPasswordInput.classList.remove("hidden");
    emailInput.placeholder = "Insira um e-mail";
    passwordInput.placeholder = "Insira uma senha";
    submitInput.value = "Cadastrar-se";
    loginText.innerText = "Cadastre-se!";
    changeSignText.classList.remove("hidden");
    changeLoginText.classList.add("hidden");
  } else {
    nameInput.classList.add("hidden");
    confirmPasswordInput.classList.add("hidden");
    emailInput.placeholder = "Seu e-mail";
    passwordInput.placeholder = "Sua senha";
    submitInput.value = "Entrar";
    loginText.innerText = "Faça Login!";
    changeSignText.classList.add("hidden");
    changeLoginText.classList.remove("hidden");
  }

  login = !login;
}
