package mannystudio.memoryinfo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;


public class MemInfoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_info);

        type = getIntent().getIntExtra("device_type", 0);
        updateInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mem_info, menu);
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

    /* on button click */
    static final String[] DEVICE_STRING = new String[]{ "/proc/meminfo",
                         "/proc/ramzswap",
                         "/proc/vmstat",
                         "/proc/swaps",
                         "/proc/process" };
    int type = 0;

    void updateInfo(){
        TextView tv = (TextView) findViewById(R.id.tv_meminfo);

        try {
            FileReader fileReader = new FileReader(DEVICE_STRING[type]);

            BufferedReader reader = new BufferedReader(fileReader);
            StringBuffer output = new StringBuffer();
            int read;
            char[] buffer = new char[4096];
            while((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            fileReader.close();

            tv.setText(output);

        }
        catch (Exception e) {
            Log.e("MemInfo", "exception occurred!");
            Log.e("MemInfo", e.toString());
            tv.setText(e.toString());
        }
    }
    public void onBack(View view){
        this.finish();
    }
    public void onRefresh(View view){
        updateInfo();
    }
}
