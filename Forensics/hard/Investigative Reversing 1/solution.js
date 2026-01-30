// | 原始位元組 (Index) | 運算方式             | 寫入目標檔案 |
//    | ------------------ | -------------------- | ------------ |
//    | ptr[0]             | +21          | mystery2.png |
//    | ptr[1]             | 照原本的順序寫入    | mystery3.png |
//    | ptr[2]             | 照原本的順序寫入    | mystery3.png |
//    | ptr[3]             | +4 | mystery2.png |
//    | ptr[4]             | 照原本的順序寫入    | mystery.png  |
//    | ptr[5]             | 照原本的順序寫入    | mystery3.png |
//    | ptr[6] ~ ptr[9]    | 照原本的順序寫入    | mystery.png  |
//    | ptr[10] ~ ptr[14]  | 照原本的順序寫入    | mystery3.png |
//    | ptr[15] ~ ptr[25]  | 照原本的順序寫入    | mystery.png  |

const fs = require('fs');

const my1 = fs.readFileSync('mystery.png');
const my2 = fs.readFileSync('mystery2.png');
const my3 = fs.readFileSync('mystery3.png');

// 取得 PNG 檔案中 IEND 後的附加資料
const getExtraData = (buf) => {
    const iend = buf.lastIndexOf(Buffer.from('IEND'));
    return buf.slice(iend + 8); // IEND 後面有 4 字節 CRC，所以跳過 8 字節
};

const my1Extra = getExtraData(my1);
const my2Extra = getExtraData(my2);
const my3Extra = getExtraData(my3);

const flagLength = 26;
const decodedFlag = Buffer.alloc(flagLength);

// mystery.png: ptr[4], ptr[6-9], ptr[15-25] (total 1+4+11=16 bytes)
// mystery2.png: ptr[0]+21, ptr[3]+4 (total 2 bytes)
// mystery3.png: ptr[1], ptr[2], ptr[5], ptr[10-14] (total 1+1+1+5=8 bytes)

decodedFlag[0] = my2Extra[0] - 21;
decodedFlag[1] = my3Extra[0];
decodedFlag[2] = my3Extra[1];
decodedFlag[3] = my2Extra[1] - 4;
decodedFlag[4] = my1Extra[0];
decodedFlag[5] = my3Extra[2];

for (let i = 6; i <= 9; i++) {
    decodedFlag[i] = my1Extra[i - 5];
}

for (let i = 10; i <= 14; i++) {
    decodedFlag[i] = my3Extra[i - 7];
}

for (let i = 15; i <= 25; i++) {
    decodedFlag[i] = my1Extra[i - 10];
}

console.log('flag:', decodedFlag.toString());



