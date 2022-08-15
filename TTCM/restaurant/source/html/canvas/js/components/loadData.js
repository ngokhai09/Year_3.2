$(document).ready(function () {
    getProductByCategory();
});
function getProductByCategory(id){
    $.ajax({
        url: 'http://127.0.0.1:8080/api/product/' + id,
        // headers: { 'Access-Control-Allow-Origin': '*' },
        method: 'GET',
        contentType: 'json',
        dataType: 'json',
        error: function (response) {
        },
        success: function (reponse) {
            const len = reponse.length;
            let table = '';
            if(len === 0){
                table += "<h1>Không có sản phần nào trong ngày</h1>"

            }
            console.log(reponse);
            for (var i = 0; i < len; ++i) {

                table = table + ' <div class="col-md-4 col-xl-3 " ><div class="product__promotion__item">';
                table = table + '<div class="product__promotion__img">';
                table = table + '<a href="#"><img src="../img/'+reponse[i].image.url+'"  alt=""></a></div>';
                table = table + '<a href="#">' + reponse[i].name + '</a>';
                table = table + '<span>' + reponse[i].price.price + '</span>';
                table = table +'</div>';
                table = table +'</div>';
            }
            $("#newProduct").html(table);
        },
        fail: function (response) {
        }
    });
}

}