// 가입 승인 처리 함수
function acceptUser(memberId) {
    const confirmation = confirm("해당 가입 신청을 승인하시겠습니까?");
    if (confirmation) {
        fetch(`/api/v1/registers/register/accept/${memberId}`, {
            method: "POST",
        })
        .then(response => {
            if (response.ok) {
                // 가입 승인 처리 후 회원 목록 페이지로 리다이렉션
                window.location.href = "/members/memberList";
            } else {
                alert("가입 승인 중에 오류가 발생했습니다.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("가입 승인 중에 오류가 발생했습니다.");
        });
    }
}

// 가입 거절 처리 함수
function rejectUser(memberId) {
    const confirmation = confirm("해당 가입 신청을 거절하시겠습니까?");
    if (confirmation) {
        fetch(`/api/v1/registers/register/reject/${memberId}`, {
            method: "POST",
        })
        .then(response => {
            if (response.ok) {
                // 가입 거절 처리 후 가입신청 목록 페이지로 리다이렉션
                window.location.href = "/registers/registerList";
            } else {
                alert("가입 거절 중에 오류가 발생했습니다.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("가입 거절 중에 오류가 발생했습니다.");
        });
    }
}
