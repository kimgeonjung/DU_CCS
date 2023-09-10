// update-member.js

// 이벤트 리스너를 등록하여 수정 버튼이 클릭되었을 때 실행될 함수를 정의합니다.
document.addEventListener("DOMContentLoaded", function () {
    const updateButton = document.getElementById("update-button"); // 수정 버튼의 아이디를 확인하세요.
    
    // 수정 버튼이 클릭되었을 때 실행될 함수
    updateButton.addEventListener("click", function () {
        const memberId = document.getElementById("member_id").value; // 회원 ID를 얻어옵니다.
        const selectedGrade = document.getElementById("grades").value; // 학년 선택값을 얻어옵니다.
        const selectedPhone = document.getElementById("phones").value; // 전화번호 입력값을 얻어옵니다.
        const selectedClass = document.getElementById("class_names").value; // 반 선택값을 얻어옵니다.
        const selectedRole = document.getElementById("roles").value; // 권한 선택값을 얻어옵니다.
        
        // 서버로 전송할 데이터 객체를 생성합니다.
        const data = {
            grade: selectedGrade,
            phone: selectedPhone,
            class_name: selectedClass,
            role: selectedRole,
        };
        
        // 서버로 데이터를 전송하는 fetch 요청을 생성합니다.
        fetch(`/api/v1/members/member/update/${member_id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
            body: JSON.stringify(data),
        })
        .then(response => {
            if (response.ok) {
                alert("수정이 완료되었습니다.");
                window.location.reload(); // 페이지 새로고침
            } else {
                alert("수정 중에 오류가 발생했습니다.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("수정 중에 오류가 발생했습니다.");
        });
    });
});
