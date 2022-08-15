// let inpName = document.getElementById('name');
// let inpAge = document.getElementById('age');
// let inpScore = document.getElementById('score');
let content = document.getElementById('content')
let id = localStorage.getItem("id");
$(document).ready(function () {

    if(id === null)
        window.location.replace("../login-form-20/login.html");
    loadUserInfo(id);
});

function loadUserInfo(id) {
    console.log(id)
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/" + id,
        success: function (data) {
            document.getElementById('name').value = data.name;
            document.getElementById('email').value = data.email;
            document.getElementById('password').value = data.password;
            document.getElementById('number').value = data.number;
            document.getElementById('city').value = data.city;
        }, error: function (error) {
            console.log(error);
        }
    })
}

function save() {
    let inpName = document.getElementById('name');
    let inpEmail = document.getElementById('email');
    let inpNumber = document.getElementById('number');
    let inpCity = document.getElementById('city');
    let inpPass = document.getElementById('password');
    let name = inpName.value;
    let email = inpEmail.value;
    let number = inpNumber.value;
    let city = inpCity.value;
    let password = inpPass.value;
    let data = {
        name: name,
        email: email,
        number: number,
        city: city,
        password: password,
        admin: false
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'PUT',
        url: 'http://localhost:8080/api/user/' + id,
        data: JSON.stringify(data),
        success: loadUserInfo,
        error: function (error) {
            console.log(error)
        }
    })
}
function logout(){
    localStorage.removeItem("id");
}