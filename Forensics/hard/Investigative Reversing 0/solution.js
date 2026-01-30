/*
flag 寫入圖片的方法 (寫在 png 最後面)
0 ~ 5: 照原本的順序寫入
6 ~ 14: 每個 byte +5
15: -3
16 ~ 25: 照原本的順序寫入
*/

const fs = require('fs');
const file = fs.readFileSync('mystery.png');

const flagLength = 26;
const encodedFlag = file.subarray(-flagLength);

const decodedFlag = Buffer.alloc(flagLength);

for (let i = 0; i < flagLength; i++) {
    if (i >= 0 && i <= 5) {
        // 0 ~ 5: 照原本的順序寫入 (不需變動)
        decodedFlag[i] = encodedFlag[i];
    } else if (i >= 6 && i <= 14) {
        // 6 ~ 14: 每個 byte +5，所以還原時要 -5
        decodedFlag[i] = encodedFlag[i] - 5;
    } else if (i === 15) {
        // 15: -3，所以還原時要 +3
        decodedFlag[i] = encodedFlag[i] + 3;
    } else if (i >= 16 && i <= 25) {
        // 16 ~ 25: 照原本的順序寫入 (不需變動)
        decodedFlag[i] = encodedFlag[i];
    }
}

console.log('flag:', decodedFlag.toString());



