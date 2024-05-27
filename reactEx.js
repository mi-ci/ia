const myProfile = ["누시다", 24];
console.log(myProfile[0]);
const [name, age] = myProfile;
console.log(name);
console.log(age);

const sayHello = (irum = "김유신") => console.log(`${irum}님 안녕`);

sayHello("홍길동");
sayHello();

const objFile = {
  number1: 24,
};
console.log(objFile.number1);

const { number1 } = objFile;

console.log(number1);

console.log(...myProfile);

const summaryFun = (x1, x2, x3) => console.log(x1 + x2 + x3);
arr = [1, 2, 3];
summaryFun(...arr);

const [n1, ...arr2] = arr;
console.log(n1);
console.log(arr2);

const arr3 = arr;
console.log(arr3);

const arr4 = [...arr, ...arr3];
console.log(arr4);

const obj1 = { v1: 10, v2: 20 };
console.log({ ...obj1 });
const obj2 = { ...obj1 };
const obj3 = obj1;
obj1.v1 = 30;
console.log(obj2);
console.log(obj3);

const n10 = 10;
const d10 = "data";
const obj5 = {
  n10,
  d10,
};
console.log(obj5);

// for (let index = 0; index < nameArr.length; index++) {}
// const nameArr2 = nameArr.map();
const arr10 = [1, 2, 3, 4, 5];
const map1 = arr10.map((a) => {
  if (a < 3) {
    return a + 10;
  } else {
    return a;
  }
});
console.log(map1);

const obj11 = { v1: 10, v2: 20 };
const filter1 = arr10.filter((a) => {
  return a + 10;
});
console.log(filter1);

const nameArr = ["누시다", "사키오카", "코토"];

console.log(typeof true);

const pfn = (num) => {
  const fN =
    typeof num === "number" ? typeof num.toLocaleString() : "숫자를 입력해요";
  return fN;
};
console.log(pfn(100));
console.log(pfn("aaa"));

const num = null;
const fee = num || "금액을 설정하지 않음";
console.log(fee);

const num1 = 100;
const fee1 = num1 || "금액을 설정하지 않음";
console.log(fee1);

const num2 = 100;
const fee2 = num2 && "금액을 설정하지 않음";
console.log(fee2);
