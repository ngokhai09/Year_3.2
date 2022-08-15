function login(){
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/user",
        success: function (data) {
            for(let i = 0; i < data.length; i++){
                if(password === data[i].password && username === data[i].email){
                    localStorage.setItem("id", data[i].id);
                    window.location.replace("../html/pages-profile.html");
                }
                else{
                    alert("Sai tài khoản hoặc mật khẩu")
                }
            }

        }, error: function (error) {
            console.log(error);
        }
    })
}