const fs = require('fs');

function reverseTransform(output) {
    let input = '';
    for (let i = 0; i < output.length; i++) {
        let combined = output.charCodeAt(i);
        let firstChar = String.fromCharCode(combined >> 8);
        let secondChar = String.fromCharCode(combined & 0xFF);
        input += firstChar + secondChar;
    }
    return input;
}

const encryptedData = fs.readFileSync('enc', 'utf-8');
console.log('flag:', reverseTransform(encryptedData));