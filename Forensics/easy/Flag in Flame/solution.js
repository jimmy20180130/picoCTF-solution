const fs = require('fs');

logs = fs.readFileSync('logs.txt', 'utf-8')

const binaryData = Buffer.from(logs, 'base64'); // Decode base64 to binary
fs.writeFileSync('output.jpg', binaryData);