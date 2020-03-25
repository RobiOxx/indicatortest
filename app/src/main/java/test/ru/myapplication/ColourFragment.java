package test.ru.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ColourFragment extends Fragment {

    private int identifier;
    private int colour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        colour = args.getInt("colour");
        identifier = args.getInt("identifier");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView v = new TextView(getActivity());
        v.setGravity(Gravity.CENTER);
        v.setTextSize(40);
        v.setTextColor(Color.BLACK);
        v.setBackgroundColor(colour);
        v.setText("Fragment ID: " + identifier);
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("dummy", true);
    }
}