function selectedOption(selectId, value, label, selected) {
    var select = document.getElementById(selectId);
    var option = document.createElement("option");
    option.value = value;
    option.text = label;
    if (selected) {
        option.selected = true;
    }
    select.appendChild(option);
}

document.addEventListener("DOMContentLoaded", function () {
    // grade 항목 데이터와 선택된 값 설정
    var gradesData = [
        { value: "GRADE_1", label: "1학년", selected: true },
        { value: "GRADE_2", label: "2학년", selected: false },
        { value: "GRADE_3", label: "3학년", selected: false },
        { value: "GRADE_4", label: "4학년", selected: false },
    ];
    var selectedGrade = "{{member.grade}}";

    // class_name 항목 데이터와 선택된 값 설정
    var classNamesData = [
        { value: "A_CLASS", label: "A반", selected: true },
        { value: "B_CLASS", label: "B반", selected: false },
        { value: "C_CLASS", label: "C반", selected: false },
    ];
    var selectedClassName = "{{member.class_name}}";

    // role 항목 데이터와 선택된 값 설정
    var rolesData = [
        { value: "ROLE_USER", label: "일반 회원", selected: true },
        { value: "ROLE_ADMIN", label: "관리자", selected: false },
    ];
    var selectedRole = "{{member.role}}";


    // 각 항목에 옵션 추가
    gradesData.forEach(function (grade) {
        selectedOption("grades", grade.value, grade.label, grade.value === selectedGrade);
    });

    classNamesData.forEach(function (className) {
        selectedOption("class_names", className.value, className.label, className.value === selectedClassName);
    });

    rolesData.forEach(function (role) {
        selectedOption("roles", role.value, role.label, role.value === selectedRole);
    });

});
