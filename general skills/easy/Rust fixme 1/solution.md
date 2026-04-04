# Rust fixme 1

## 題目描述 (Description)

Have you heard of Rust? Fix the syntax errors in this Rust file to print the flag!
Download the Rust code [here](https://challenge-files.picoctf.net/c_verbal_sleep/3f0e13f541928f420d9c8c96b06d4dbf7b2fa18b15adbd457108e8c80a1f5883/fixme1.tar.gz).

### 提示 (Hints)

1. Hint 1  
    Cargo is Rust's package manager and will make your life easier. See the getting started page [here](https://doc.rust-lang.org/book/ch01-03-hello-cargo.html)
2. Hint 2  
    [println!](https://doc.rust-lang.org/std/macro.println.html)
3. Hint 3  
    Rust has some pretty great compiler error messages. Read them maybe?

## 解題思路 (Solution Walkthrough)

1. **第一步**：在 `String::from("CSUCKS")` 後面加上一個 `;`

2. **第二步**：把 `ret; // How do we return in rust?` 改為 `return;`

3. **第三步**：把 `println!(":?",String::from_utf8_lossy(&decrypted_buffer));` 改為 `println!("{}",String::from_utf8_lossy(&decrypted_buffer));`

## Flag

```text
picoCTF{4r3_y0u_4_ru$t4c30n_n0w?}
```
