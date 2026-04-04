# bytemancy 0

## 題目描述 (Description)

Can you conjure the right bytes? The program's source code can be downloaded [here](https://challenge-files.picoctf.net/c_candy_mountain/87600c43f9f35274d6269e8237fcd84602c631a5ebcf5251266fb11dc0e94f3b/app.py).

### 提示 (Hints)

1. Hint 1  
    Solving this with a one-liner will help with the next challenge in this series

## 解題思路 (Solution Walkthrough)

1. **第一步**：可以看到 app.py 裡面說要 3 個 `\x65` 才會給 flag，於是輸入三個 `e` 即可取得 flag

    ```text
    ⊹──────[ BYTEMANCY-0 ]──────⊹
    ☍⟐☉⟊☽☈⟁⧋⟡☍⟐☉⟊☽☈⟁⧋⟡☍⟐☉⟊☽☈⟁⧋⟡☍⟐

    Send me ASCII DECIMAL 101, 101, 101, side-by-side, no space.

    ☍⟐☉⟊☽☈⟁⧋⟡☍⟐☉⟊☽☈⟁⧋⟡☍⟐☉⟊☽☈⟁⧋⟡☍⟐
    ⊹─────────────⟡─────────────⊹
    ==> eee
    picoCTF{pr1n74813_ch4r5_4daf27d8}
    ```

## Flag

```text
picoCTF{pr1n74813_ch4r5_4daf27d8}
```
