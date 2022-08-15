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
                  <th scope="col">Số học sinh</th>           
                  <th scope="col">Hành động</th>           
                </tr>
              </thead>
              <tbody id="list-class">
               
              </tbody>
            </table>
        </div>`
    // <div class="col-3" id="categories"></div>`;
    document.getElementById('content').innerHTML = html;
    loadListStudent();
    // loadListClass();
}

function loadListStudent() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/classes",
        success: function (data) {
            let html1 = "";
            for (let i = 0; i < data.length; i++) {
                html1 += `<tr><th scope="row">${i + 1}</th>
                          <td>${data[i].name}</td>
                          <td>${data[i].quantity}</td>
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
        url: "http://localhost:8080/api/classes/" + id,
        success: function (respone) {
            let html = "<div class='offset-3 col-6 mb-3'><h2 style=\"text-align: center\">Cập nhật lớp</h2>" +
                "<div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Họ và tên</label>\n" +
                "    <div class=\"col-sm-8\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"name\" value='" + respone.name + "'>\n" +
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
    let name = inpName.value;
    let data = {
        name: name
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'PUT',
        url: 'http://localhost:8080/api/classes/' + id,
        data: JSON.stringify(data),
        success: loadHomeContent,
        error: function (error) {
            console.log(error)
        }
    })
}

function showAddForm() {

    let html = "<div class='offset-3 col-6 mb-3'><h2 style=\"text-align: center\">Thêm mới lớp</h2>" +
        "<div>\n" +
        "  <div class=\"form-group row\">\n" +
        "    <label for=\"name\" class=\"col-sm-4 col-form-label\">Tên Lớp</label>\n" +
        "    <div class=\"col-sm-8\">\n" +
        "      <input type=\"text\" class=\"form-control\" id=\"name\">\n" +
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
    let name = inpName.value;
    let data = {
        name: name
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'POST',
        url: 'http://localhost:8080/api/classes',
        data: JSON.stringify(data),
        success: loadHomeContent,
        error: function (error) {
            console.log(error)
        }
    })
}

function del(id, name) {
    if (confirm("Bạn có chắc chắn muốn xoá lớp " + name + "???")) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            type: 'Delete',
            url: 'http://localhost:8080/api/classes/' + id,
            success: loadHomeContent,
            error: function (error) {
                console.log(error)
            }
        })
    }
}
