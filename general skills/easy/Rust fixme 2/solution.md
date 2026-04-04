# Rust fixme 2

## 題目描述 (Description)

The Rust saga continues? I ask you, can I borrow that, pleeeeeaaaasseeeee?
Download the Rust code [here](https://challenge-files.picoctf.net/c_verbal_sleep/babfbee79718a6363826ba86300173ffde6d81577e9dd07d4130c53a7eecf6c3/fixme2.tar.gz).

### 提示 (Hints)

1. Hint 1  
    https://doc.rust-lang.org/book/ch04-02-references-and-borrowing.html

## 解題思路 (Solution Walkthrough)

1. **第一步**：可以看到 `party_foul` 原本被宣告為不可變（預設 let），但我們在 decrypt 函式中需要修改它的內容，因此必須將其宣告為 let mut

2. **第二步**：`decrypt` 函式的參數定義必須從 `&String` 改為 `&mut String`，這樣函式內部的 `push_str` 才有權限更動該字串

3. **第三步**：在呼叫 `decrypt` 時，必須傳遞 `&mut party_foul`

## Flag

```text
picoCTF{4r3_y0u_h4v1n5_fun_y31?}
```

## 參考資料

1. https://medium.com/@gbahenrijoel/picoctf2025-general-skill-rust-fixme-2-135c2c83dfcf