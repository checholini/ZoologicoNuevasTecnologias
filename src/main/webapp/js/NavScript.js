function responsiveNav() {
  var x = document.getElementById("Nav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
