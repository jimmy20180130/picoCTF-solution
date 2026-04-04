# Specialer

## 題目描述 (Description)

Reception of Special has been cool to say the least. That's why we made an exclusive version of Special, called Secure Comprehensive Interface for Affecting Linux Empirically Rad, or just 'Specialer'. With Specialer, we really tried to remove the distractions from using a shell. Yes, we took out spell checker because of everybody's complaining. But we think you will be excited about our new, reduced feature set for keeping you focused on what needs it the most. Please start an instance to test your very own copy of Specialer.

### 提示 (Hints)

1. Hint 1  
    What programs do you have access to?

## 解題思路 (Solution Walkthrough)

1. **第一步**：進去以後先按 tab，發現只能用這些指令

    ```text
    !          ]]         break      command    coproc     done       esac       false      function   if         local      pushd      return     source     times      ulimit     wait       
    ./         alias      builtin    compgen    declare    echo       eval       fc         getopts    in         logout     pwd        select     suspend    trap       umask      while      
    :          bash       caller     complete   dirs       elif       exec       fg         hash       jobs       mapfile    read       set        test       true       unalias    {          
    [          bg         case       compopt    disown     else       exit       fi         help       kill       popd       readarray  shift      then       type       unset      }          
    [[         bind       cd         continue   do         enable     export     for        history    let        printf     readonly   shopt      time       typeset    until 
    ```

2. **第二步**：輸入 ./ 發現有三個資料夾，先 cd 到 abra，接著輸入 cd，然後按 tab，發現有兩個檔案，分別為 cadabra.txt 以及 cadaniel.txt

3. **第三步**：接著就可以用 `mapfile content < cadabra.txt;printf "%s" "${content[@]}"` 來讀取檔案，最後可以在 `/ala/kazam.txt` 裡面找到 flag

## Flag

```text
picoCTF{y0u_d0n7_4ppr3c1473_wh47_w3r3_d01ng_h3r3_a8567b6f}
```
