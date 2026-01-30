# hashcrack

## 題目描述 (Description)

A company stored a secret message on a server which got breached due to the admin using weakly hashed passwords. Can you gain access to the secret stored within the server?
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   Understanding hashes is very crucial. [Read more here](https://primer.picoctf.org/#_hashing).
2. Hint 2
   Can you identify the hash algorithm? Look carefully at the length and structure of each hash identified.
3. Hint 3
   Tried using any hash cracking tools?

## 解題思路 (Solution Walkthrough)

1.  **第一步**：連進去 server 發現他回傳一段 hash `482c811da5d5b4bc6d497ffa98491e38`，由長度可判斷出他是 md5，於是使用 john 暴力破解
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ john --format=raw-md5 --wordlist=/usr/share/wordlists/rockyou.txt hash.txt
   Using default input encoding: UTF-8
   Loaded 1 password hash (Raw-MD5 [MD5 256/256 AVX2 8x3])
   Warning: no OpenMP support for this hash type, consider --fork=4
   Press 'q' or Ctrl-C to abort, almost any other key for status
   password123      (?)     
   1g 0:00:00:00 DONE (2026-01-30 06:20) 100.0g/s 153600p/s 153600c/s 153600C/s 753951..mexico1
   Use the "--show --format=Raw-MD5" options to display all of the cracked passwords reliably
   Session completed. 
   ```

2.  **第二步**：成功後 server 再傳一段 hash `b7a875fc1ea228b9061041b7cec4bd3c52ab3ce3`，由長度可判斷出他是 SHA-1，於是使用 john 暴力破解
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ john --format=raw-sha1 --wordlist=/usr/share/wordlists/rockyou.txt hash.txt
   Using default input encoding: UTF-8
   Loaded 1 password hash (Raw-SHA1 [SHA1 256/256 AVX2 8x])
   Warning: no OpenMP support for this hash type, consider --fork=4
   Press 'q' or Ctrl-C to abort, almost any other key for status
   letmein          (?)     
   1g 0:00:00:00 DONE (2026-01-30 06:22) 100.0g/s 51200p/s 51200c/s 51200C/s stupid..letmein
   Use the "--show --format=Raw-SHA1" options to display all of the cracked passwords reliably
   Session completed. 
   ```

3.  **第三步**：成功後 server 再傳一段 hash `916e8c4f79b25028c9e467f1eb8eee6d6bbdff965f9928310ad30a8d88697745`，由長度可判斷出他是 SHA-256，於是使用 john 暴力破解，上傳完成後成功取得 flag
   ```
   ┌──(kali㉿kali)-[~/Desktop]
   └─$ john --format=raw-sha256 --wordlist=/usr/share/wordlists/rockyou.txt hash.txt
   Using default input encoding: UTF-8
   Loaded 1 password hash (Raw-SHA256 [SHA256 256/256 AVX2 8x])
   Warning: poor OpenMP scalability for this hash type, consider --fork=4
   Will run 4 OpenMP threads
   Press 'q' or Ctrl-C to abort, almost any other key for status
   qwerty098        (?)     
   1g 0:00:00:00 DONE (2026-01-30 06:26) 50.00g/s 32768Kp/s 32768Kc/s 32768KC/s sammy987..grass9
   Use the "--show --format=Raw-SHA256" options to display all of the cracked passwords reliably
   Session completed. 
   ```

## Flag

```text
picoCTF{UseStr0nG_h@shEs_&PaSswDs!_eb2f8459}
```