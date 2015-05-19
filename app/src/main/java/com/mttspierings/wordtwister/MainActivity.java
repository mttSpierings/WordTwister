package com.mttspierings.wordtwister;

import android.content.Context;
import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    public String removeSpaces(String a){

        a = a.replaceAll("\\s+", "");

        return a;
    }

    public void reverse(View view) {

        //Hide soft Keyboard after OnClick
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        CheckBox checkBox = (CheckBox) findViewById(R.id.no_space_checkBox);
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView textView = (TextView) findViewById(R.id.output);
        String message = editText.getText().toString();
        textView.setTextSize(32);

        //Check for message length, so I don't break the TextField
        if(message.length() > 40 ) {

            Toast.makeText(getApplicationContext(),"Text to long!", Toast.LENGTH_SHORT).show();

        }else{
            if (checkBox.isChecked()) {

                Toast.makeText(getApplicationContext(),"Working", Toast.LENGTH_SHORT).show();

                String noSpaceMessage = removeSpaces(message);
                String RevMessage = reverse(noSpaceMessage);
                textView.setText(RevMessage);
            } else {

                String RevMessage = reverse(message);
                textView.setText(RevMessage);

            }

        }


    }
    //Text gets reversed here
    public static String reverse(String toReverse){
        String reverse = "";

        for(int i = toReverse.length() - 1; i >= 0;i--){
            reverse = reverse + toReverse.charAt(i);
        }
        return reverse;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
