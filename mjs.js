var var2 = 10;
console.log(var2);
var var2 = "홍길동";
console.log(var2);

const c1 = 200;
console.log(c1);
// c1 = 300;
// console.log(c1);

const obj1 = {
  name: "홍길동",
  age: 24,
};

obj1.name = "홍길동";
obj1.addr = "서울";
obj1.phone = "010-1234-5678";
console.log(obj1);

const arr1 = [1, 2, 3];
console.log(arr1[2]);

const message = "내이름은" + obj1.name;
const message2 = `내이름은 ${obj1.name}`;
console.log(message2);

function a(var1) {
  return var1 + "함수처리";
}
console.log(a(100));

const aa = (var1) => {
  return var1 + "함수처리";
};
console.log(aa(100));

const bb = (a, b) => {
  console.log(a);
  console.log(b);
  return a + b;
};
console.log(bb(100, 200));

const { name, age, addr, phone } = obj1;
console.log(name);
console.log(age);
console.log(addr);

console.log(phone);
