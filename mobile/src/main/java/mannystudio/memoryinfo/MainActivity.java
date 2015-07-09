package mannystudio.memoryinfo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

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
            Log.w("MemInfo", "option selected: " + id);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* on button click */
    public void onMemInfo(View view) {
        Log.w("MemInfo", "show meminfo");
        Intent intent = new Intent(this, MemInfoActivity.class);
        intent.putExtra("device_type", 0);
        startActivity(intent);
    }
    public void onCache(View view) {
        Log.w("MemInfo", "show cache stat");
        Intent intent = new Intent(this, MemInfoActivity.class);
        intent.putExtra("device_type", 1);
        startActivity(intent);
    }
    public void onVmstat(View view) {
        Log.w("MemInfo", "show vmstat");
        Intent intent = new Intent(this, MemInfoActivity.class);
        intent.putExtra("device_type", 2);
        startActivity(intent);
    }
    public void onSwap(View view) {
        Log.w("MemInfo", "show swap");
        Intent intent = new Intent(this, MemInfoActivity.class);
        intent.putExtra("device_type", 3);
        startActivity(intent);
    }
    public void onProcess(View view) {
        Log.w("MemInfo", "show process");
        Intent intent = new Intent(this, MemInfoActivity.class);
        intent.putExtra("device_type", 4);
        startActivity(intent);
    }
}
