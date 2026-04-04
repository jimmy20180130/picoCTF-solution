# Undo

## 題目描述 (Description)

Can you reverse a series of Linux text transformations to recover the original flag?

### 提示 (Hints)

1. Hint 1  
    For text translation and character replacement, see [tr command documentation](https://man7.org/linux/man-pages/man1/tr.1.html).

## 解題思路 (Solution Walkthrough)

1. **第一步**：第一步我一開始以為要反轉這串，原來只要把他 decode 就好，於是輸入 `base64 -d`

    ```text
    --- Step 1 ---
    Current flag: KTJxNW85NjQ1LWZhMDFnQHplMHNmYTRlRy1nazNnLXRhMWZlcmlyRShTR1BicHZj
    Hint: Base64 encoded the string.
    Enter the Linux command to reverse it: echo "KTJxNW85NjQ1LWZhMDFnQHplMHNmYTRlRy1nazNnLXRhMWZlcmlyRShTR1BicHZj" | rev
    Incorrect. Try again.
    Output: [Error] Command not allowed.
    Hint: Try reversing: base64

    Enter the Linux command to reverse it: base64 -d
    ```

2. **第二步**：題目說要反轉這串字串，於是輸入 `rev` 即可

    ```text
    --- Step 2 ---
    Current flag: )2q5o9645-fa01g@ze0sfa4eG-gk3g-ta1ferirE(SGPbpvc
    Hint: Reversed the text.
    Enter the Linux command to reverse it: rev
    Correct!
    ```

3. **第三步**：他基本上要把 `-` 變成 `_`，於是用 `tr "-" "_"` 即可

    ```text
    --- Step 3 ---
    Current flag: cvpbPGS(Eriref1at-g3kg-Ge4afs0ez@g10af-5469o5q2)
    Hint: Replaced underscores with dashes.
    Enter the Linux command to reverse it: tr "-" "_"        
    Correct!
    ```

4. **第四步**：他基本上要把 `()` 變成 `{}`，於是用 `tr "()" "{}"` 即可

    ```text
    --- Step 4 ---
    Current flag: cvpbPGS(Eriref1at_g3kg_Ge4afs0ez@g10af_5469o5q2)
    Hint: Replaced curly braces with parentheses.
    Enter the Linux command to reverse it: tr "()" "{}"
    Correct!
    ```

5. **第五步**：他是經過 ROT13 加密過的，於是使用 `tr "A-Za-z" "N-ZA-Mn-za-m"` 即可取得 flag

    ```text
    --- Step 5 ---
    Current flag: cvpbPGS{Eriref1at_g3kg_Ge4afs0ez@g10af_5469o5q2}
    Hint: Applied ROT13 to letters.
    Enter the Linux command to reverse it: tr "A-Za-z" "N-ZA-Mn-za-m"
    Correct!

    Congratulations! You've recovered the original flag:
    >>> picoCTF{Revers1ng_t3xt_Tr4nsf0rm@t10ns_5469b5d2}
    ```

## Flag

```text
picoCTF{Revers1ng_t3xt_Tr4nsf0rm@t10ns_5469b5d2}
```
