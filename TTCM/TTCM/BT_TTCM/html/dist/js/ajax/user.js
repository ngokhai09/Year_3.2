// let inpName = document.getElementById('name');
// let inpAge = document.getElementById('age');
// let inpScore = document.getElementById('score');
let content = document.getElementById('content')

$(document).ready(function () {
    let id = localStorage.getItem("id");
    if(id === null)
        window.location.replace("../login-form-20/login.html");
    loadHomeContent();
});

function loadHomeContent() {
    let html = `
        <div class="col-12" >
            <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Tên</th>           
                  <th scope="col">Email</th>           
                  <th scope="col">Số điện thoại</th>           
                  <th scope="col">Thành Phố</th>           
                  <th scope="col">Hành động</th>           
                </tr>
              </thead>
              <tbody id="list-class">
               
              </tbody>
            </table>
        </div>`
    // <div class="col-3" id="categories"></div>`;
    document.getElementById('content').innerHTML = html;
    loadListUser();
    // loadListClass();
}

function loadListUser() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user",
        success: function (data) {
            let html1 = "";
            for (let i = 0; i < data.length; i++) {
                html1 += `<tr><th scope="row">${i + 1}</th>
                          <td>${data[i].name}</td>
                          <td>${data[i].email}</td>
                          <td>${data[i].number}</td>
                          <td>${data[i].city}</td>
                          <td><button class="btn btn-outline-secondary mr-2" onclick="showEdit(${data[i].id})">Sửa</button><Button class="btn btn-outline-danger" onclick="del(${data[i].id},'${data[i].name}')">Xoá</Button></td></tr>`
            }
            document.getElementById('list-class').innerHTML = html1;
        }, error: function (error) {
            console.log(error);
        }
    })
}

function showEdit(id) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user/" + id,
        success: function (respone) {
            let html = "<div class='offset-3 col-6 mb-3'><h2 style=\"text-align: center\">Cập nhật người dùng</h2>" +
                "<div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Họ và tên</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"name\" value='" + respone.name + "'>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Email</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"email\" value='" + respone.email + "'>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Mật Khẩu</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"password\" class=\"form-control\" id=\"password\" value='" + respone.password + "'>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Số điện thoại</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"number\" value='" + respone.number + "'>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Thành phố</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"city\" value='" + respone.city + "'>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"row\">\n" +
                "    <div class=\"offset-5 col-sm-2\">\n" +
                "       <button class=\"btn btn-outline-primary mt-2\" onclick=\"loadHomeContent()\">Quay về</button>" +
                "    </div>\n" +

                "    <div class=\"offset-5 col-sm-2\">\n" +
                "       <button class=\"btn btn-outline-primary mt-2\" onclick=\"save(" + respone.id + ")\">Sửa</button>" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>" +
                "</div>"
            content.innerHTML = html
        }
    })

}

function save(id) {
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
        email:email,
        number:number,
        city:city,
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
        success: loadHomeContent,
        error: function (error) {
            console.log(error)
        }
    })
}

function showAddForm() {

    let html = "<div class='offset-3 col-6 mb-3'><h2 style=\"text-align: center\">Thêm mới người dùng</h2>" +
        "<div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Tên người dùng</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"text\" class=\"form-control\" id=\"name\">\n" +
        "    </div>\n" +
        "  </div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Email</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"text\" class=\"form-control\" id=\"email\">\n" +
        "    </div>\n" +
        "  </div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Mật Khẩu</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"password\" class=\"form-control\" id=\"password\">\n" +
        "    </div>\n" +
        "  </div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Số điện thoại</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"text\" class=\"form-control\" id=\"number\">\n" +
        "    </div>\n" +
        "  </div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Thành phố</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"text\" class=\"form-control\" id=\"city\">\n" +
        "    </div>\n" +
        "  </div>\n" +
        "  <div class=\"row mt-2\">\n" +
        "    <div class=\"offset-5 col-sm-2\">\n" +
        "       <button class=\"btn btn-outline-primary mt-2\" onclick=\"loadHomeContent()\">Quay về</button>" +
        "    </div>\n" +
        "    <div class=\"offset-5 col-sm-2\">\n" +
        "       <button class=\"btn btn-outline-primary\" onclick=\"add()\">Thêm</button>" +
        "    </div>\n" +
        "  </div>\n" +
        "</div>" +
        "</div>"
    content.innerHTML = html;
}

function add() {
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
        email:email,
        number:number,
        city:city,
        password: password,
        admin: false
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'POST',
        url: 'http://localhost:8080/api/user',
        data: JSON.stringify(data),
        success: loadHomeContent,
        error: function (error) {
            console.log(error)
        }
    })
}

function del(id, name) {
    if (confirm("Bạn có chắc chắn muốn xoá người dùng " + name + "???")) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            type: 'Delete',
            url: 'http://localhost:8080/api/user/' + id,
            success: loadHomeContent,
            error: function (error) {
                console.log(error)
            }
        })
    }
}
