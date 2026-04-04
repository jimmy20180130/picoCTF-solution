# Verify

## 題目描述 (Description)

People keep trying to trick my players with imitation flags. I want to make sure they get the real thing! I'm going to provide the SHA-256 hash and a decrypt script to help you know that my flags are legitimate.

### 提示 (Hints)

1. Hint 1  
    Checksums let you tell if a file is complete and from the original distributor. If the hash doesn't match, it's a different file.
2. Hint 2  
    You can create a SHA checksum of a file with `sha256sum <file>` or all files in a directory with `sha256sum <directory>/*`.

## 解題思路 (Solution Walkthrough)

1. **第一步**：先用 `sha256sum files/*`，之後發現 `files/87590c24` 的 checksum 等於題目給的，於是用 decrypt.sh 解密即得到 flag

## Flag

```text
picoCTF{trust_but_verify_87590c24}
```
