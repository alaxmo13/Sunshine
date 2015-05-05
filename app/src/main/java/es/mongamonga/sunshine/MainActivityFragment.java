package es.mongamonga.sunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<String> weekDays = new ArrayList<String>(Arrays.asList("Monday - Sunny", "Tuesday - Sunny", "Wednesday - Storm", "Thursday - BrainStorm", "Friday - Cloudy", "Saturday - CloudyAgain", "Sunday - CloudyToo"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                                                R.layout.list_item_forecast,
                                                                R.id.list_item_forecast_textview,
                                                                weekDays);
        ListView lw = (ListView)rootview.findViewById(R.id.listview_forecast);
        lw.setAdapter(adapter);
        return rootview;
    }
}
