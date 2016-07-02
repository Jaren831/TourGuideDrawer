package com.example.android.tourguidedrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jaren Lynch on 7/2/2016.
 */

public class AttractionsActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of infos
        final ArrayList<Info> infos = new ArrayList<Info>();
        infos.add(new Info("Golden Gate Bride", "$", "5/5 Stars", R.drawable.golden_gate));
        infos.add(new Info("Alcatraz", "$", "4/5 Stars", R.drawable.alcatraz));
        infos.add(new Info("Stimson Beach", "$", "5/5 Stars", R.drawable.stinson));


        // Create an {@link InfoAdapter}, whose data source is a list of {@link Info}s. The
        // adapter knows how to create list items for each item in the list.
        InfoAdapter adapter = new InfoAdapter(this, infos, R.color.category_food);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link InfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Info} in the list.
        listView.setAdapter(adapter);

    }
}
