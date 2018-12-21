package cn.com.cesgroup.numberpickerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.com.cesgroup.numpickerview.NumberPickerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NumberPickerView numberPickerView = (NumberPickerView) findViewById(R.id.purchase_num1);
        numberPickerView.setMaxValue(40)
                .setCurrentInventory(150)
                .setMinDefaultNum(1)
                .setCurrentNum(20)
                .setmOnClickInputListener(new NumberPickerView.OnClickInputListener() {
            @Override
            public void onWarningForInventory(int inventory) {
                Toast.makeText(MainActivity.this,"超过最大库存",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onWarningMinInput(int minValue) {
                Toast.makeText(MainActivity.this,"低于最小设定值",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onWarningMaxInput(int maxValue) {
                Toast.makeText(MainActivity.this,"超过最大限制量",Toast.LENGTH_SHORT).show();
            }
        });
        // 默认的监听大部分可以满足要求了，如果有需要自己监听输入框的数字变化的话，需要以下监听
        numberPickerView.setOnInputNumberListener(new NumberPickerView.OnInputNumberListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("MainActivity",editable.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
