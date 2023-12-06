function hover() {
  var jogos = document.querySelectorAll(".jogo");
  jogos.forEach(function (jogo) {
    jogo.addEventListener("mouseover", function () {
      jogo.querySelector("img").classList.remove("hidden");
      jogo.querySelector("p").classList.remove("hidden");
    });

    jogo.addEventListener("mouseout", function () {
      jogo.querySelector("img").classList.add("hidden");
      jogo.querySelector("p").classList.add("hidden");
    });
  });
}
