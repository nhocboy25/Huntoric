package vn.edu.usth.huntoric;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        AppDatabase db = AppDatabase.getInstance(this);
        UserDao userDao = db.userDao();

        // Xử lý đăng nhập
        loginButton.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            new Thread(() -> {
                User u = userDao.login(user, pass);
                runOnUiThread(() -> {
                    if (u != null) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        // Chuyển sang MainActivity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Kết thúc LoginActivity để không quay lại được
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });

        // Xử lý đăng ký
        registerButton.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            new Thread(() -> {
                userDao.insertUser(new User(user, pass));
                runOnUiThread(() -> Toast.makeText(LoginActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show());
            }).start();
        });
    }
}
