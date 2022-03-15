package com.example.wyglady;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sr_button_singUp).setOnClickListener(v -> {
            String username = findViewById(R.id.sr_editText_username).toString();
            String email = findViewById(R.id.sr_editText_email).toString();
            String password = findViewById(R.id.sr_editText_password).toString();
            String confirmPassword = findViewById(R.id.sr_editText_confirmPassword).toString();

            boolean err = false;

            if(username.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) err = true;
            if(!password.equals(confirmPassword)) err = true;

            if(email.length() > 4) {
                if (email.contains("@")) {
                    int count = email.length() - email.replaceAll("@", "").length();
                    if (count > 1) err = true;
                } else err = true;

                if (email.contains(".")) {
                    int count = email.length() - email.replaceAll(".", "").length();
                    if (count > 1) err = true;
                } else err = true;

                String emailAllowedChars = "@.!#$%&'*+-/=?^_`{|}~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

                for(int i = 0; i<email.length(); i++) {
                    String ch = Character.toString(email.charAt(i));
                    if(!emailAllowedChars.contains(ch)) err = true;
                }
            } else err = true;

            if(username.length() > 1) {
                String usernameAllowedChars = ".0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

                for(int i = 0; i<username.length(); i++) {
                    String ch = Character.toString(username.charAt(i));
                    if(!usernameAllowedChars.contains(ch)) err = true;
                }
            } else err = true;

            if(password.length() > 5) {
                String passwordAllowedChars = "~`! @#$%^&*()_-+={[}]|\\:;\"'<,>.?/0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

                for(int i = 0; i<password.length(); i++) {
                    String ch = Character.toString(password.charAt(i));
                    if(!passwordAllowedChars.contains(ch)) err = true;
                }
            } else err = true;

            TextView txtView_err = findViewById(R.id.sr_textView_error);
            if(err == true) txtView_err.setText("Niepoprawne dane");
            else txtView_err.setText("");
        });
    }
}