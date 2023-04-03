package com.example.test11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText4);
        textView = findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() {
            // TextWathher 인터페이스는 아래 3개의 메서드를 필수로 구현하여아 한다.
            // 이 문제에서는 변화가 있을 경우에 대한 처리 관련 메서드만 필요하다.

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 입력하기 전에 동작하는 메서드
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // editText에 변화가 있을 경우 동작하는 메서드

                // start는 editText 범위에 벗어났을 당시의 마지막 위치를 담고 있다
                // 예를들어 처음에 빈 editText에 들어왔을 때는 0이지만
                // "일이삼사오육칠팔" 여덟글자를 입력하고 editText를 벗어난 뒤
                // 다시 들어왔을 때에는 8부터 시작한다

                // count는 editText에 들어와서 지금까지 입력한 글자의 수를 담고 있다
                // editText를 나가면 0으로 초기화 된다.

                // 그러므로 start + count를 했다.
                textView.setText((start + count) + " / " + 80 + " 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 입력이 끝났을 때 호출 된다
            }
        });
    }

    // 전송버튼 클릭 시 동작
    public void onButton1Clicked(View v) {
        sendToast();
    }

    // Toast 메시지를 출력한다.
    private void sendToast() {
        Toast.makeText(this, editText.getText(), Toast.LENGTH_LONG).show();
    }
}