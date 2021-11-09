package com.example.mymoviebrowser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {


    private static final String MOVIE = "movie";

    private Movie movie;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(Movie movie) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(MOVIE, movie);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(MOVIE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setMovie(view, movie);


    }

    public void setMovie(View view, Movie movie) {

        TextView txtName = (TextView) view.findViewById(R.id.txtMovieName);
        txtName.setText(movie.getName());

        TextView txtYear = (TextView) view.findViewById(R.id.txtYear);
        txtYear.setText(Integer.toString(movie.getYear()));


        TextView txtDirector = (TextView) view.findViewById(R.id.txtDirector);
        txtDirector.setText(movie.getDirector());

        TextView txtDescription = (EditText) view.findViewById(R.id.txtDescription);
        txtDescription.setText(movie.getDescription());
        txtDescription.setEnabled(false);

        ListView listView = (ListView) view.findViewById(R.id.lstStars);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter, movie.getStars().toArray(new String[1])));

    }
}