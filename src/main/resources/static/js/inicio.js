// llamada a la api
var xhr = new XMLHttpRequest(); //invocar nueva instancia de XMLHttpRequest
var productosLocal = JSON.parse(this.responseText);

xhr.open('GET', 'http://localhost:8080/chanchostore/api/producto/all'); // Abrir solicitud GET
xhr.onload = exito; // llamar a la funcion exito si exitosa
xhr.onerror = error;  // llamar a la funcion error si fallida
xhr.send(); // mandar la solicitud al vervidor.

console.log(productosLocal);
// funcion para cuando la llamada es exitosa
function exito() {
    console.log('Funciono');
}

// funcion para la llamada fallida
function error(err) {
    console.log('Solicitud fallida', err); //los detalles en el objecto "err"
}



function comprar(){
}


function MostrarReg(){
	document.getElementById('registro').style.display = 'block';
    document.getElementById('login').style.display = 'none';
}

function MostrarLog(){
	document.getElementById('registro').style.display = 'none';
    document.getElementById('login').style.display = 'block';
}