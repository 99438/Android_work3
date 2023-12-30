package com.example.bili;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bili.databinding.UpInfoBinding;

public class detailActivity extends AppCompatActivity {

    private UpInfoBinding binding;
    Button btnUnfollow;
    TextView name;
    TextView focus;
    TextView follow;

    // 返回键退出
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(0, intent);
        finish();
    }

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UpInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        btnUnfollow = binding.button;
        name = binding.idInfo;
        focus = binding.focusInfo;
        follow = binding.fellowInfo;

        // 接受MainActivity传输过来的数据
        Intent i =getIntent();
        name.setText(i.getStringExtra("name"));
        focus.setText("关注：100");
        follow.setText("粉丝：100");
        String upid = i.getStringExtra("name");

        // 返回


        btnUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 向上一个Activity返回数据
                Intent intent = new Intent();
                intent.putExtra("name", i.getStringExtra("name"));
                setResult(1, intent);

                // Toast提示取关成功
                Toast.makeText(getApplicationContext(), "取关成功", Toast.LENGTH_SHORT).show();
                // 关闭当前Activity
                finish();
            }
        });

    }

}

