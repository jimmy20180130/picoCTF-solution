# Timeline 1

## 題目描述 (Description)

Can you find the flag in this disk image? Wrap what you find in the picoCTF flag format.
Download the disk image [here](https://challenge-files.picoctf.net/c_plain_mesa/fef9e3937fced503da228c6affaea69ed51d6234ed8fde14a52b573777b869e7/partition4.img.gz).

### 提示 (Hints)

1. Hint 1  
    Create a Sleuthkit MAC timeline!
2. Hint 2  
    Look at recent timestamps
3. Hint 3  
    Pay close attention to timestamps near an anti-forensic action
4. Hint 4  
    Filter only new files by grepping for `macb`

## 解題思路 (Solution Walkthrough)

1. **第一步**：按照提示先用以下兩個指令建立一個 `Sleuthkit MAC timeline`

    ```text
    fls -r -m / partition4.img > body.txt  
    mactime -b body.txt > timeline.txt
    ```


2. **第二步**：好了以後就 grep `macb`

    ```text
    strings timeline.txt | grep "macb"
    ```

3. **第三步**：之後發現 `/etc/chat` 看起來很可疑，因為這不是 linux 原本會有的東西

    ```text
    49 macb r/rrw-r--r-- 0        0        32716    /etc/chat
    ```

4. **第四步**：於是使用 `icat partition4.img 32716`，並得到一串 base64 encode 的字串，那個即為 flag

## Flag

```text
picoCTF{573417h13r_7h4n_7h3_1457_58527bb222}
```
