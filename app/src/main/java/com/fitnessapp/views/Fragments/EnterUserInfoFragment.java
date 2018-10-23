package com.fitnessapp.views.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fitnessapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sunny on 16-Apr-16.
 */
public class EnterUserInfoFragment extends Fragment {

    int position;
    @BindView(R.id.nameTitle)
    TextView nameTitle;
    @BindView(R.id.nameInput)
    EditText nameInput;
    @BindView(R.id.phoneTitle)
    TextView phoneTitle;
    @BindView(R.id.phoneInput)
    EditText phoneInput;
    @BindView(R.id.genderTitle)
    TextView genderTitle;
    @BindView(R.id.maleRadio)
    RadioButton maleRadio;
    @BindView(R.id.femaleRadio)
    RadioButton femaleRadio;
    @BindView(R.id.genderGroup)
    RadioGroup genderGroup;
    @BindView(R.id.ageTitle)
    TextView ageTitle;
    @BindView(R.id.ageInput)
    EditText ageInput;
    @BindView(R.id.heightTitle)
    TextView heightTitle;
    @BindView(R.id.heightInput)
    EditText heightInput;
    @BindView(R.id.ftHint)
    TextView ftHint;
    @BindView(R.id.weightTitle)
    TextView weightTitle;
    @BindView(R.id.weightInput)
    EditText weightInput;
    @BindView(R.id.whint)
    TextView whint;
    @BindView(R.id.bmiimage)
    ImageView bmiimage;
    @BindView(R.id.bmititle)
    TextView bmititle;
    @BindView(R.id.bmi)
    TextView bmi;
    @BindView(R.id.bmiresult)
    TextView bmiresult;
    @BindView(R.id.nextbutton)
    Button nextbutton;
    @BindView(R.id.container)
    RelativeLayout container;
    Unbinder unbinder;
    private String height = "";
    public String weight = "";

    public EnterUserInfoFragment() {
        // Required empty public constructor
    }

    public static EnterUserInfoFragment newInstance() {
        EnterUserInfoFragment fragment = new EnterUserInfoFragment();
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFloatingButtonClickListener {
        public void onFloatingButtonClicked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_enteruser_info, container, false);

        final Button next = (Button) rootView.findViewById(R.id.nextbutton);


        final RadioGroup myRadioGroup = (RadioGroup) rootView.findViewById(R.id.genderGroup);

        ImageView userPhoto = (ImageView) getActivity().findViewById(R.id.userPhoto);
//        userPhoto.setImageResource(R.drawable.runimage);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameInput.getText().toString().length() == 0) {
                    nameInput.setError("Name is required!");
                    return;
                }
//                mListener.onFloatingButtonClicked();


            }
        });

        final TextView bmicalc = (TextView) rootView.findViewById(R.id.bmi);
        final TextView bmires = (TextView) rootView.findViewById(R.id.bmiresult);
        ImageView bmiImage = (ImageView) rootView.findViewById(R.id.bmiimage);
        bmiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (weightInput.getText().toString() != "" || heightInput.getText().toString() != "") {
                        Log.d("In try Block", "");
                        Float bmi = ((Float.parseFloat(weightInput.getText().toString())) * 10000) / ((Float.parseFloat(heightInput.getText().toString())) * (Float.parseFloat(heightInput.getText().toString())));
                        bmi = Float.parseFloat(String.format("%.2f", bmi));
                        Log.d("BMI is", bmi.toString());
                        bmicalc.setText(bmi.toString());
                        if (bmi < 18.5) {
                            bmires.setText("Under Weight");
                        } else if (bmi > 18.5 && bmi < 24.99) {
                            bmires.setText("Normal Weight");
                        } else if (bmi > 25 && bmi < 29.99) {
                            bmires.setText("Over Weight");
                        } else {
                            bmires.setText("Obesity");
                        }
                    }
                } catch (Exception ex) {
                    Log.d("In Catch Block", "");
                    Toast toast = Toast.makeText(getActivity(), "Forgot to enter height or weight?", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


}

