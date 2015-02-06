package nl.simonwhiteley.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

  //  private Button answerYesButton, answerNoButton;
    private EditText nameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //  Button answerYesButton = (Button) findViewById(R.id.answer_yes_button);
       // Button answerNoButton = (Button) findViewById(R.id.answer_no_button);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);

        String[] eten = {"kaas", "eieren", "melk", "boter"};
    // default template (simple)
    //    ListAdapter theAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eten);

        ListAdapter theAdapter = new MyAdapter(this, eten);

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(theAdapter);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String showPicked = "You picked " + String.valueOf(parent.getItemAtPosition(position));

                        Toast.makeText(MainActivity.this, showPicked, Toast.LENGTH_SHORT).show();
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

    public void onNoButtonClick(View view) {

        String name = String.valueOf(nameEditText.getText());

        String yourYesResponse = "Aaay lmao " + name;

        Toast.makeText(this, yourYesResponse, Toast.LENGTH_SHORT).show();
    }

    public void onYesButtonClick(View view) {
        String name = String.valueOf(nameEditText.getText());

        String yourNoResponse = "Aaay naaolmao " + name;

        Toast.makeText(this, yourNoResponse, Toast.LENGTH_SHORT).show();
    }
}
