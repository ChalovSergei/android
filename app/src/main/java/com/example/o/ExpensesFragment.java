package com.example.o;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpensesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpensesFragment extends Fragment implements View.OnClickListener{
    Button btnAddition;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnSubtraction;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnMultiplication;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnDivision;
    Button btnDecimal;
    Button btnZero;
    Button btnRemove;
    TextView tvMoney;
    TextView etInputField;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExpensesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpensesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpensesFragment newInstance(String param1, String param2) {
        ExpensesFragment fragment = new ExpensesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expenses, container, false);
        btnAddition = rootView.findViewById(R.id.btnAddition);
        btnOne = rootView.findViewById(R.id.btnOne);
        btnTwo = rootView.findViewById(R.id.btnTwo);
        btnThree = rootView.findViewById(R.id.btnThree);
        btnSubtraction = rootView.findViewById(R.id.btnSubtraction);
        btnFour = rootView.findViewById(R.id.btnFour);
        btnFive = rootView.findViewById(R.id.btnFive);
        btnSix = rootView.findViewById(R.id.btnSix);
        btnMultiplication = rootView.findViewById(R.id.btnMultiplication);
        btnSeven = rootView.findViewById(R.id.btnSeven);
        btnEight = rootView.findViewById(R.id.btnEight);
        btnNine = rootView.findViewById(R.id.btnNine);
        btnDivision = rootView.findViewById(R.id.btnDivision);
        btnDecimal = rootView.findViewById(R.id.btnDecimal);
        btnZero = rootView.findViewById(R.id.btnZero);
        btnRemove = rootView.findViewById(R.id.btnRemove);
        tvMoney = rootView.findViewById(R.id.tvMoney);
        etInputField = rootView.findViewById(R.id.etInputField);




        btnAddition.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        return rootView;
    }
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnAddition:
                break;
            case R.id.btnSubtraction:
                break;
            case R.id.btnMultiplication:
                break;
            case R.id.btnDivision:
                break;
            case R.id.btnDecimal:
                if(etInputField.getText().equals("")){
                    etInputField.setText("0.");
                }
                else if(etInputField.getText() != ""){
                    etInputField.setText(etInputField.getText()+".");
                }

                break;
            case R.id.btnRemove:
                String newStr = (String) etInputField.getText();
                newStr = newStr.substring(0, newStr.length() - 1);
                etInputField.setText(newStr);
                break;
            case R.id.btnZero:
                etInputField.setText(etInputField.getText()+"0");
                break;
            case R.id.btnOne:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("1");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"1");
                }

                break;
            case R.id.btnTwo:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("2");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"2");
                }
                break;
            case R.id.btnThree:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("3");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"3");
                }
                break;
            case R.id.btnFour:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("4");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"4");
                }
                break;
            case R.id.btnFive:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("5");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"5");
                }
                break;
            case R.id.btnSix:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("6");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"6");
                }
                break;
            case R.id.btnSeven:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("7");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"7");
                }
                break;
            case R.id.btnEight:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("8");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"8");
                }
                break;
            case R.id.btnNine:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("9");
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"9");
                }
                break;
        }
    }
}