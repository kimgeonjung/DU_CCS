// 행 전체를 클릭하면 상세 페이지로 이동하는 함수
const rows = document.querySelectorAll("tr[data-href]");
rows.forEach(row => {
    row.addEventListener("click", () => {
        const href = row.getAttribute("data-href");
        if (href) {
            window.location.href = href;
        }
    });
});