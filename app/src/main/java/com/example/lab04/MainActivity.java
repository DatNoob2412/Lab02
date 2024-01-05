package com.example.lab04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtStudentID, edtAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale;
    private CheckBox chkFootball, chkGame;
    private Button btnSave;
    private TextView tvResult, tvHobbies, tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtStudentID = findViewById(R.id.edtStudentID);
        edtAge = findViewById(R.id.edtAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        chkFootball = findViewById(R.id.chkFootball);
        chkGame = findViewById(R.id.chkGame);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);
        tvHobbies = findViewById(R.id.tvHobbies);
        tvGender = findViewById(R.id.tvGender);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String name = edtName.getText().toString();
        String studentID = edtStudentID.getText().toString();
        String age = edtAge.getText().toString();

        // Xử lý giới tính
        String gender = (radioMale.isChecked()) ? "Nam" : "Nữ";
        tvGender.setText("Giới tính: " + gender);

        // Xử lý sở thích
        StringBuilder hobbiesBuilder = new StringBuilder("Sở thích: ");
        if (chkFootball.isChecked()) {
            hobbiesBuilder.append("Đá bóng");
        }
        if (chkGame.isChecked()) {
            if (chkFootball.isChecked()) {
                hobbiesBuilder.append(", "); // Thêm dấu phẩy nếu có sở thích trước đó
            }
            hobbiesBuilder.append("Chơi game");
        }
        tvHobbies.setText(hobbiesBuilder.toString());

        // Hiển thị thông tin sau khi nhấn nút Lưu
        String result = "Tên: " + name + "\n"
                + "Mã số sinh viên: " + studentID + "\n"
                + "Tuổi: " + age + "\n"
                + "Giới tính: " + gender + "\n"
                + hobbiesBuilder.toString();

        tvResult.setText(result);
    }
}
