document.addEventListener("DOMContentLoaded", function () {

    var select = document.getElementById("roles");
    select.addEventListener("change", function () {
        var selectedRole = select.value; // 선택한 권한 값 가져오기
        var memberId = "{{member.id}}"; // 회원의 ID 값

        fetch(`/api/v1/members/member/${memberId}/role/${selectedRole}`, {
            method: "PUT",
        })
        .then(response => {
            if (response.ok) {
                alert("권한이 변경되었습니다.");
                window.location.reload(); // 페이지 새로고침
            } else {
                alert("권한 변경 중에 오류가 발생했습니다.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("권한 변경 중에 오류가 발생했습니다.");
        });
    });
});

//선택옵션 고정
function addOptionToSelect(value, label, selected) {
    var select = document.getElementById("roles");
    var option = document.createElement("option");
    option.value = value;
    option.text = label;
    if (selected) {
        option.selected = true;
    }
    select.appendChild(option);
}

document.addEventListener("DOMContentLoaded", function () {

    var categoriesData = [
        { value: "ROLE_USER", label: "일반 회원", selected: true },
        { value: "ROLE_ADMIN", label: "관리자", selected: false },
    ];

    var selectedCategory = "{{member.role}}";

    categoriesData.forEach(function (role) {
        addOptionToSelect(
            role.value,
            role.label,
            role.value === "{{member.role}}"
        );
    });
});