# Rust fixme 3

## 題目描述 (Description)

Have you heard of Rust? Fix the syntax errors in this Rust file to print the flag!
Download the Rust code [here](https://challenge-files.picoctf.net/c_verbal_sleep/dcdaf491b35c1d0f5075e9583edbbb7aaea1dffb6ad32bc000e4d87b5200ff7b/fixme3.tar.gz).

### 提示 (Hints)

1. Hint 1  
    Read the comments...darn it!

## 解題思路 (Solution Walkthrough)

1. **第一步**：先嘗試使用 cargo run 編譯該檔案時，編譯器會報錯。錯誤主要集中在 `std::slice::from_raw_parts` 這一行。在 Rust 中，處理原始指標（raw pointers）被視為「不安全」的操作。

2. **第二步**：註解有提示涉及原始指標的操作必須包裹在 unsafe {} 區塊內，因為題目中的 unsafe 關鍵字與大括號被註解掉了，導致編譯器無法通過安全檢查。

3. **第三步**：取消註解並修復語法 將 decrypt 函式中關於 unsafe 的註解拿掉，讓解密邏輯在正確的作用域內執行。同時確保所有變數（如 `decrypted_buffer`）在進入 unsafe 區塊前已正確定義。

## Flag

```text
picoCTF{n0w_y0uv3_f1x3d_1h3m_411}
```

## 參考資料

1. https://medium.com/@gbahenrijoel/picoctf2025-general-skill-rust-fixme-3-be931c6c5428
