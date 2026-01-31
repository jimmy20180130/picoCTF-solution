# droids2

## 題目描述 (Description)

Find the pass, get the flag. Check out this [file](https://challenge-files.picoctf.net/c_fickle_tempest/a16f42ed8f9e92de13d5140a90ba1b9b3e719500265e0b96f8553a59a5e07881/two.apk).

### 提示 (Hints)

1. Hint 1
   Try using apktool and an emulator
2. Hint 2
   https://ibotpeaches.github.io/Apktool/
3. Hint 3
   https://developer.android.com/studio

## 解題思路 (Solution Walkthrough)

1.  **第一步**：用 jadx 分析 two.apk，發現取得 flag 的函式在這裡
   ```Java
   /* loaded from: classes.dex */
   public class FlagstaffHill {
      public static native String sesame(String str);

      public static String getFlag(String input, Context ctx) {
         String[] witches = {"weatherwax", "ogg", "garlick", "nitt", "aching", "dismass"};
         int second = 3 - 3; // 0
         int third = (3 / 3) + second; // 1
         int fourth = (third + third) - second; // 2
         int fifth = 3 + fourth; // 5
         int sixth = (fifth + second) - third; // 4
         String password = "".concat(witches[fifth]).concat(".").concat(witches[third]).concat(".").concat(witches[second]).concat(".").concat(witches[sixth]).concat(".").concat(witches[3]).concat(".").concat(witches[fourth]); // dismass.ogg.weatherwax.aching.nitt.garlick
         return input.equals(password) ? sesame(input) : "NOPE";
      }
   }
   ```

2.  **第二步**：根據程式碼可以得到正確的密碼 `dismass.ogg.weatherwax.aching.nitt.garlick`

3.  **第三步**：打開 android studio 的模擬器，裝好 two.apk 後輸入密碼 (`dismass.ogg.weatherwax.aching.nitt.garlick`) 後即可取得 flag
   ![輸入密碼畫面](image-1.png)

## Flag

```text
picoCTF{what.is.your.favorite.colour}
```