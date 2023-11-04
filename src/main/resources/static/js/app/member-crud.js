var main = {
    init : function() {
        var _this = this;
        $('#member-update').on('click', function(){
            _this.update();
        });
        $('#member-delete').on('click', function(){
            _this.delete();
        });
    },
    update : function() {
        var data = {
            grade: $('#grade').val(),
            phone: $('#phone').val(),
            class_num: $('#class').val(),
            role: $('#role').val()
        };
        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/member/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원 정보가 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/member/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function(){
            alert('회원 정보가 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();