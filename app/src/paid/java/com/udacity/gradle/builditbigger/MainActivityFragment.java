package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @InjectView(R.id.tell_joke_button)
    protected Button tellJokeButton;

    @InjectView(R.id.progressBarHolder)
    protected FrameLayout progressBarHolder;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, root);

        return root;
    }

    @OnClick(R.id.tell_joke_button)
    public void onTellJokeButtonClick(View v) {
        // Perform action on click
        new JokeUtility().TellJokeButtonClick(getActivity(), v, progressBarHolder);
    }
}
