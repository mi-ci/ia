const onClickAdd = () => {
  const textEl = document.getElementById("add-text");
  const text = textEl.value;
  textEl.value = "";
  const memoLi = document.getElementById("memo-list");
  const memo = document.createElement("li");
  memo.textContent = text;
  if (text == "") {
    alert("내용을 입력");
  } else {
    memoLi.append(memo);
  }
};
document
  .getElementById("add-button")
  .addEventListener("click", () => onClickAdd());
