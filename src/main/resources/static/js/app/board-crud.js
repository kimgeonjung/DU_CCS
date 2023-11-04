var main = {
    init : function() {
        var _this = this;
        $('#board-save').on('click', function(){
            _this.save();
        });
        $('#board-update').on('click', function(){
            _this.update();
        });
        $('#board-delete').on('click', function(){
            _this.delete();
        });
    },
    save : function() {
        var data = {
            categories: $('#categories').val(),
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/board',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            categories: $('#categories').val(),
            title: $('#title').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/board/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        console.log('id:', id); // 추가: id 값을 확인하기 위해 로그로 출력
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/board/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();