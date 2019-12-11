package com.example.sharedpreferneces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_count;
    Button btn_count, btn_reset, btn_exit;
    EditText ed_text;
    int count;
    String name;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_count = findViewById(R.id.tv_count);
        ed_text = findViewById(R.id.ed_text);

        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        count = save.getInt("count",0);
        name = save.getString("text","");

        tv_count.setText(""+ count);
        ed_text.setText(""+name);

    }

    public void oc_count(View view) {
        count++;
        tv_count.setText(""+count);
    }

    public void oc_reset(View view) {
        count = 0;
        tv_count.setText(""+count);
        ed_text.setText(" ");
    }

    public void oc_exit(View view) {
        name = ed_text.getText().toString();
        SharedPreferences settings = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("count",count);
        editor.putString("text",name);
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if(st.equals("Home")){

        }
        if(st.equals("Credits")){
            intent = new Intent(this,Credits.class);
            startActivity(intent);
        }
        return true;
    }
}
