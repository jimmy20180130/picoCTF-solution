# Hidden in plainsight

## 題目描述 (Description)

You're given a seemingly ordinary JPG image. Something is tucked away out of sight inside the file. Your task is to discover the hidden payload and extract the flag.
Download the jpg image [here](https://challenge-files.picoctf.net/c_amiable_citadel/90f1eb2dc53634c5e708b56878391f0398bc8848104d86464e06822a469d2d99/img.jpg).

### 提示 (Hints)

1. Hint 1
   Download the jpg image and read its metadata

## 解題思路 (Solution Walkthrough)

1. **第一步**：下載圖片後，使用 `exiftool` 檢查圖片的 metadata，尋找可疑字串。
   ```bash
   exiftool img.jpg | grep -i comment
   ```
   在 comment 欄位發現一段疑似 Base64 編碼的字串：`c3RlZ2hpZGU6Y0VGNmVuZHZjbVE9`。

2. **第二步**：對字串進行第一次 Base64 解碼。
   ```bash
   echo 'c3RlZ2hpZGU6Y0VGNmVuZHZjbVE9' | base64 -d
   ```
   得到結果：`steghide:cEF6endvcmQ=`，發現這是 steghide 相關的提示，且後面還有一段 Base64 編碼。

3. **第三步**：對第二段字串進行 Base64 解碼，取得 steghide 密碼。
   ```bash
   echo 'cEF6endvcmQ=' | base64 -d
   ```
   得到密碼：`pAzzword`。

4. **第四步**：使用 steghide 從 JPG 圖片中提取隱藏檔案。
   ```bash
   steghide extract -sf img.jpg -p 'pAzzword'
   ```
   成功提取出 `flag.txt` 檔案。

5. **第五步**：讀取 flag。
   ```bash
   cat flag.txt
   ```
   得到 flag 為 `picoCTF{h1dd3n_1n_1m4g3_2ac27d95}`。

## Flag

```text
picoCTF{h1dd3n_1n_1m4g3_2ac27d95}
```