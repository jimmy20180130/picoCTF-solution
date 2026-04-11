# YaraRules0x100

## 題目描述 (Description)

Dear Threat Intelligence Analyst,
Quick heads up - we stumbled upon a shady executable file on one of our employee's Windows PCs. Good news: the employee didn't take the bait and flagged it to our InfoSec crew.
Seems like this file sneaked past our Intrusion Detection Systems, indicating a fresh threat with no matching signatures in our database.
Can you dive into this file and whip up some YARA rules? We need to make sure we catch this thing if it pops up again.
Thanks a bunch!
The suspicious file can be downloaded [here](https://challenge-files.picoctf.net/c_standard_pizzas/ee6b10d914417ab217f97387bc4638512ba95e4cc75458fde49c897221a30115/suspicious.zip). Unzip the archive with the password picoctf
Once you have created the YARA rule/signature, submit your rule file as follows:
socat -t60 - TCP:standard-pizzas.picoctf.net:54338 < sample.txt
(In the above command, modify "sample.txt" to whatever filename you use).
When you submit your rule, it will undergo testing with various test cases. If it successfully passes all the test cases, you'll receive your flag.

### 提示 (Hints)

1. Hint 1  
    The test cases will attempt to match your rule with various variations of this suspicious file, including a packed version, an unpacked version, slight modifications to the file while retaining functionality, etc.
2. Hint 2  
    Since this is a Windows executable file, some strings within this binary can be "wide" strings. Try declaring your string variables something like $str = "Some Text" wide ascii wherever necessary.
3. Hint 3  
    Your rule should also not generate any false positives (or false negatives). Refine your rule to perfection! One YARA rule file can have multiple rules! Maybe define one rule for Packed binary and another rule for Unpacked binary in the same rule file?

## 解題思路 (Solution Walkthrough)

1. **第一步**：先把下載的.zip解壓縮，然後看看裡面長怎樣。
    發現不能讀，所以用
    ```text
    file suspicious.exe
    ```
    發現被upx壓縮過
    ```text
    suspicious.exe: PE32 executable (GUI) Intel 80386, for MS Windows, UPX compressed, 3 sections
    ```
    所以再用upx看看
    ```text
    upx -d suspicious.exe
    ```
    這次終於看到suspicious.exe的內容了

2. **第二步**：要生一個規則，但怎麼弄都沒過，所以只好參考別人的答案QAQ

## Flag

```text
picoCTF{yara_rul35_r0ckzzz_2ba332bd}
```

## 參考資料

1. https://hackmd.io/@fearnot/picoCTF_General_Skills