# Riddle Registry（Hidden in plainsight）

## 題目描述
You’re given a seemingly ordinary JPG image. Something is tucked away out of sight inside the file. Your task is to discover the hidden payload and extract the flag.
Download the jpg image [here](https://challenge-files.picoctf.net/c_amiable_citadel/90f1eb2dc53634c5e708b56878391f0398bc8848104d86464e06822a469d2d99/img.jpg).

### 提示 (Hints)
- Download the jpg image and read its metadata

## 解題思路 (Solution Walkthrough)

### 1) 檢查圖片 metadata，找出可疑字串
用 `exiftool`（或任何能看 JPEG comment 的工具）查看註解欄位：

```bash
exiftool img.jpg | grep -i comment
```

在 comment 會看到一段疑似 Base64 的字串：
- `c3RlZ2hpZGU6Y0VGNmVuZHZjbVE9`

### 2) 第一次 Base64 解碼
```bash
echo 'c3RlZ2hpZGU6Y0VGNmVuZHZjbVE9' | base64 -d
```

得到：
- `steghide:cEF6endvcmQ=`

### 3) 第二次 Base64 解碼（取出 steghide 密碼）
```bash
echo 'cEF6endvcmQ=' | base64 -d
```

得到 steghide passphrase：
- `pAzzword`

### 4) 用 steghide 從 JPG 抽出隱藏檔案
```bash
steghide extract -sf img.jpg -p 'pAzzword'
```

會輸出（或類似）：
- `wrote extracted data to "flag.txt".`

### 5) 讀取 flag
```bash
cat flag.txt
```

## Flag
```text
picoCTF{h1dd3n_1n_1m4g3_2ac27d95}
```