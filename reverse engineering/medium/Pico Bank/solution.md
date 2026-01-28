# Pico Bank

## 題目描述 (Description)

In a bustling city where innovation meets finance, Pico Bank has emerged as a beacon of cutting-edge security. Promising state-of-the-art protection for your assets, the bank claims its mobile application is impervious to all forms of cyber threats. Pico Bank’s tagline, "Security Beyond the Limits," echoes through its high-tech marketing campaigns, assuring users of their utmost safety.
As a cybersecurity enthusiast, your mission is to test these bold claims. You’ve been hired by a secretive organization to put Pico Bank’s mobile app through a rigorous security assessment. The flag might be in one or more locations, and additional information reveals that a Pico Bank user’s credentials were leaked in an unusual way. Your task is to crack the username and password based on the following profile information: His name is Alex Johnson with the email johnson@picobank.com, Date of Birth: March 14, 1990, Last Transaction Amount: $345.67, Pet name: tricky, and Favorite Color: Blue.
To perform this challenge, you can use any Android emulator. Some examples include Genymotion Android Emulator or Android Studio.
Additional details will be available after launching your challenge instance.

### 提示 (Hints)

1. Hint 1
   Use tools like JadxGUI or apktool to inspect the APK.
2. Hint 2
   Look at the app's network requests, especially for login and OTP.
3. Hint 3
   The flag has two parts.
4. Hint 4
   Check the server’s response after entering the correct OTP.
5. Hint 5
   Investigate the transaction history for unusual data.

## 解題思路 (Solution Walkthrough)

1.  **第一步**：下載 apk 以後，照慣例先用 jadx-gui 開啟，並反編譯 apk 的程式碼

2.  **第二步**：先發現帳號密碼分別為 `jsonson` 和 `tricky1990`
   ```Java
   this.loginButton.setOnClickListener(new View.OnClickListener() { // from class: com.example.picobank.Login.1
      @Override // android.view.View.OnClickListener
      public void onClick(View v) {
         String username = Login.this.usernameEditText.getText().toString();
         String password = Login.this.passwordEditText.getText().toString();
         if ("johnson".equals(username) && "tricky1990".equals(password)) {
            Intent intent = new Intent(Login.this, (Class<?>) OTP.class);
            Login.this.startActivity(intent);
            Login.this.finish();
            return;
         }
         Toast.makeText(Login.this, "Incorrect credentials", 0).show();
      }
   });
   ```

3.  **第三步**：發現登入後還需輸入 OTP 驗證碼，經過尋找後發現 OTP 是寫死的
   ```Java
   if (getResources().getString(R.string.otp_value).equals(otp)) {
      Intent intent = new Intent(this, (Class<?>) MainActivity.class);
      startActivity(intent);
      finish();
   } else {
      Toast.makeText(this, "Invalid OTP", 0).show();
   }
   ```

4. **第四步**：從 `/res/values/strings.xml` 可發現 OTP 碼為 `9673`
5. **第五步**：在 `verifyOtp` 這段中發現程式碼會 POST `your server url/verify-otp`
   ```Java
   JSONObject postData = new JSONObject();
   try {
      postData.put("otp", otp);
   } catch (JSONException e) {
      e.printStackTrace();
   }
   JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, endpoint, postData, new Response.Listener<JSONObject>() { // from class: com.example.picobank.OTP.2
      AnonymousClass2() {
      }

      @Override // com.android.volley.Response.Listener
      public void onResponse(JSONObject response) throws JSONException {
            try {
               boolean success = response.getBoolean("success");
               if (success) {
                  String flag = response.getString("flag");
                  String hint = response.getString("hint");
                  Intent intent2 = new Intent(OTP.this, (Class<?>) MainActivity.class);
                  intent2.putExtra("flag", flag);
                  intent2.putExtra("hint", hint);
                  OTP.this.startActivity(intent2);
                  OTP.this.finish();
               } else {
                  Toast.makeText(OTP.this, "Invalid OTP", 0).show();
               }
            } catch (JSONException e2) {
               e2.printStackTrace();
            }
      }
   }, new Response.ErrorListener() { // from class: com.example.picobank.OTP.3
      AnonymousClass3() {
      }

      @Override // com.android.volley.Response.ErrorListener
      public void onErrorResponse(VolleyError error) {
      }
   });
   this.requestQueue.add(jsonObjectRequest);
   ```

6. **第六步**：於是我將 `your server url` 改為 picoCTF 提供的網址，取得底下這段回應，成功取得第二段 flag
   ```
   POST /verify-otp HTTP/1.1
   Accept-Encoding: deflate, gzip
   User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/142.0.0.0 Safari/537.36
   Host: amiable-citadel.picoctf.net
   Accept: application/json
   Content-Type: application/json
   Content-Length: 15

   {"otp": "9673"}
   ```
   ```
   HTTP/1.1 200 OK
   X-Powered-By: Express
   Access-Control-Allow-Origin: *
   Content-Type: application/json; charset=utf-8
   Content-Length: 151
   ETag: W/"97-oHPDGfTqeaHXTqVWfp/3mT5nxJU"
   Date: Sun, 25 Jan 2026 04:51:25 GMT
   Connection: keep-alive
   Keep-Alive: timeout=5

   {"success":true,"message":"OTP verified successfully","flag":"s3cur3d_m0b1l3_l0g1n_c16c18ab}","hint":"The other part of the flag is hidden in the app"}
   ```

7. **第七步**：進入程式中，發現有一長串的轉帳紀錄，其中金額看起來像是以二進位表示的
   ```Java
   this.transactionList = new ArrayList();
   this.transactionList.add(new Transaction("Grocery Shopping", "2023-07-21", "$ 1110000", false));
   this.transactionList.add(new Transaction("Electricity Bill", "2023-07-20", "$ 1101001", false));
   this.transactionList.add(new Transaction("Salary", "2023-07-18", "$ 1100011", true));
   this.transactionList.add(new Transaction("Internet Bill", "2023-07-17", "$ 1101111", false));
   this.transactionList.add(new Transaction("Freelance Payment", "2023-07-16", "$ 1000011", true));
   this.transactionList.add(new Transaction("Dining Out", "2023-07-15", "$ 1010100", false));
   this.transactionList.add(new Transaction("Gym Membership", "2023-07-14", "$ 1000110", false));
   this.transactionList.add(new Transaction("Stocks Dividend", "2023-07-13", "$ 1111011", true));
   this.transactionList.add(new Transaction("Car Maintenance", "2023-07-12", "$ 110001", false));
   this.transactionList.add(new Transaction("Gift Received", "2023-07-11", "$ 1011111", true));
   this.transactionList.add(new Transaction("Rent", "2023-07-10", "$ 1101100", false));
   this.transactionList.add(new Transaction("Water Bill", "2023-07-09", "$ 110001", false));
   this.transactionList.add(new Transaction("Interest Earned", "2023-07-08", "$ 110011", true));
   this.transactionList.add(new Transaction("Medical Expenses", "2023-07-07", "$ 1100100", false));
   this.transactionList.add(new Transaction("Transport", "2023-07-06", "$ 1011111", false));
   this.transactionList.add(new Transaction("Bonus", "2023-07-05", "$ 110100", true));
   this.transactionList.add(new Transaction("Subscription Service", "2023-07-04", "$ 1100010", false));
   this.transactionList.add(new Transaction("Freelance Payment", "2023-07-03", "$ 110000", true));
   this.transactionList.add(new Transaction("Entertainment", "2023-07-02", "$ 1110101", false));
   this.transactionList.add(new Transaction("Groceries", "2023-07-01", "$ 1110100", false));
   this.transactionList.add(new Transaction("Insurance Premium", "2023-06-28", "$ 1011111", false));
   this.transactionList.add(new Transaction("Charity Donation", "2023-06-26", "$ 1100010", true));
   this.transactionList.add(new Transaction("Vacation Expense", "2023-06-26", "$ 110011", false));
   this.transactionList.add(new Transaction("Home Repairs", "2023-06-24", "$ 110001", false));
   this.transactionList.add(new Transaction("Pet Care", "2023-06-22", "$ 1101110", false));
   this.transactionList.add(new Transaction("Personal Loan", "2023-06-18", "$ 1100111", true));
   this.transactionList.add(new Transaction("Childcare", "2023-06-15", "$ 1011111", false));
   ```

8. **第八步**：於是將金額全部拿出來並轉換成 string 以後 (用 ASCII 編碼)，得到第一段 flag: `picoCTF{1_l13d_4b0ut_b31ng_`

## Flag

```text
picoCTF{1_l13d_4b0ut_b31ng_s3cur3d_m0b1l3_l0g1n_c16c18ab}
```