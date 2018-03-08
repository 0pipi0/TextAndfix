package com.martian.andfix.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.martian.andfix.R;
import com.martian.andfix.base.MyApplication;
import com.martian.andfix.util.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


  private  TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    initView();
  }

  /**
   * 初始化布局
   */
  private void initView() {
    textView = findViewById(R.id.tv);
    textView.setText(Utils.getContent());
    Button button = findViewById(R.id.button);
    button.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()){
      case  R.id.button:
        MyApplication.getInstance().addPatch();
        textView.setText(Utils.getContent());
        break;
    }

  }
}
