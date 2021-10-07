const url = "http://localhost:8080/rockola/api/canciones"
const contenedor = document.querySelector('tbody')
let resultados = ''
const modalCancion = new bootstrap.Modal(document.getElementById('modalCancion'))
const formCanciones = document.querySelector('form')
const nombreCancion = document.getElementById('Cancion')
const nombreAutor = document.getElementById('Autor')
const genero = document.getElementById('Genero')
let opcion = ''
btnCrear.addEventListener('click', () => {
    
    nombreCancion.value = ''
    nombreAutor.value = ''
    genero.value=''
    modalCancion.show()
    opcion = 'crear'
})
const ajax = (options) => {
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();
 
    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;
 
        if (xhr.status >= 200 && xhr.status < 300) {
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    });
 
    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(data));
};
const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);
 
            res.forEach((canciones) => {
                resultados += `<tr>
                        <td width="5%">${canciones.idCancion}</td>
                        <td width="20%">${canciones.nombre}</td>
                        <td width="15%">${canciones.generos}</td>
                        <td width="15%">${canciones.artista}</td>
                        <td width="15%">${canciones.created_at}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
            });
            contenedor.innerHTML = resultados
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};
document.addEventListener("DOMContentLoaded", getAll);
document.addEventListener("click", (e) => {
 
    if (e.target.matches(".btnBorrar")) {
        const fila = e.target.parentNode.parentNode
        const id = fila.firstElementChild.innerHTML
        console.log(id)
        alertify.confirm(`¿Estás seguro de eliminar ${id}?`,
            function () {
                ajax({
                    url: url + "/" + id,
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: (res) => location.reload(),
                    error: (err) => alert(err),
                });
                alertify.success('Registro eliminado')
            },
            function () {
                alertify.error('Cancel')
            });
    }
    if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        nombreCancion.value = fila.children[1].innerHTML
        genero.value = fila.children[2].innerHTML
        nombreAutor.value = fila.children[3].innerHTML
        opcion = 'editar'
        modalCancion.show()
    }
})
const fila = e.target.parentNode.parentNode
idCancion.value = fila.children[0].innerHTML
formCanciones.addEventListener('submit', (e) => {
    e.preventDefault()
    let metodo = "POST"
    if (opcion == 'editar') {
        metodo = "PUT"
 
    }
    ajax({
        url: url,
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        success: (res) => location.reload(),
        error: (err) =>
            $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
            "nombre": nombreCancion.value,
            "artista": nombreAutor.value,
            "generos": genero.value,
            "idCancion":idCancion.value
        },
    });
    modalCancion.hide()
})
