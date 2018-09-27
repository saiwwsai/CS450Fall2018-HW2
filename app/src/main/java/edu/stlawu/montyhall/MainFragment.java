package edu.stlawu.montyhall;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MainFragment extends Fragment {

    public static final String PREF_NAME = "MontyHall";
    public static final String NEW_CLICKED = "NEWCLICKED";

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    // onCreate gets called when the fragment is created
    // before the UI views are constructed
    // Initialize data needed for the fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

       // LayoutInflater: coverts an XML layout file into corresponding ViewGroups and Widgets

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // About button behaviour @ fragment main
        View aboutButton = rootView.findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.about_title_text); //"About the Monty Hall Problem"
                builder.setMessage(R.string.about); //"This is St. Lawrence University CS450
                                                    //Implementation of the Monty Hall Game."
                builder.setNeutralButton(R.string.ok,
                        new DialogInterface.OnClickListener() {  //"OK"
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                //return;
                            }
                        });
                builder.show();
            }
        });

        //New button behaviour @fragment main
        View newButton = rootView.findViewById(R.id.new_button);
        newButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               SharedPreferences.Editor pref_ed =
                 getActivity().getSharedPreferences(
                  PREF_NAME, Context.MODE_PRIVATE).edit();
               pref_ed.putBoolean(NEW_CLICKED, true).apply();
               // a passive data structure holding an abstract description of an action to be performed
                 // in the launching of activities, where it can be thought of as the glue between activities

                 // get gameActivity when NEW button is pressed
                 Intent intent = new Intent(
                   getActivity(), GameActivity.class);
                 getActivity().startActivity(intent);
             }
         }

);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
