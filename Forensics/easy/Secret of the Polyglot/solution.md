# Secret of the Polyglot

## 題目描述 (Description)

The Network Operations Center (NOC) of your local institution picked up a suspicious file, they're getting conflicting information on what type of file it is. They've brought you in as an external expert to examine the file. Can you extract all the information from this strange file?
Download the suspicious file [here](https://artifacts.picoctf.net/c_titan/99/flag2of2-final.pdf).

### 提示 (Hints)

1. Hint 1  
    This problem can be solved by just opening the file in different ways

## 解題思路 (Solution Walkthrough)

1. **第一步**：直接看 pdf 會得到第二部份的 flag

2. **第二步**：用 hxd editor 可以發現這個 pdf 其實開頭是 png 的 magic byte，於是把檔名改成 .png 即可取得第一部分的 flag

## Flag

```text
picoCTF{f1u3n7_1n_pn9_&_pdf_2a6a1ea8}
```
