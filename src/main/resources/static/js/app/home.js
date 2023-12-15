// var index 객체를 만들고 해당 객체 안에 필요한 모든 함수 선언함
// 위처럼 안하고 save 등의 이름이 겹치는 함수들로 여러 파일이 있다면 나중에 로딩된 파일에서 js 의 함수를 덮어씀
// 그래서 이렇게 해당 파일만의 객체 생성하는 방식을 사용함
// alert('Home.js is loaded.');
var main = {
    init : function () {
        console.log('Home.js is loaded.');
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Article submited.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' +id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8/euc-kr',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Article Updated.');
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    delete: function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8/euc-kr'
        }).done(function() {
            alert("Article Deleted.");
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init()
