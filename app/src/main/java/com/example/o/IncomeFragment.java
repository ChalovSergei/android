package com.example.o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class IncomeFragment extends Fragment implements View.OnClickListener {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnDecimal;
    Button btnZero;
    Button btnRemove;
    TextView tvMoney;
    TextView etInputField;
    ImageButton btnClearInputField;
    Spinner spinnerIncome;
    EditText etCategory;
    DBHelper dbHelper;
    TextView tvCurrentMoney;
    TextView tvTextIncome;
    String[] spinnerIncomeArray = {"Зарплата","Подарки","Дивиденды","Подработка","Бизнес"};
    Button btnAddIncomeTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_income, container, false);
        btnOne = rootView.findViewById(R.id.btnOne);
        btnTwo = rootView.findViewById(R.id.btnTwo);
        btnThree = rootView.findViewById(R.id.btnThree);
        btnFour = rootView.findViewById(R.id.btnFour);
        btnFive = rootView.findViewById(R.id.btnFive);
        btnSix = rootView.findViewById(R.id.btnSix);
        btnSeven = rootView.findViewById(R.id.btnSeven);
        btnEight = rootView.findViewById(R.id.btnEight);
        btnNine = rootView.findViewById(R.id.btnNine);
        btnAddIncomeTest = rootView.findViewById(R.id.btnAddInfo);

        btnDecimal = rootView.findViewById(R.id.btnDecimal);
        btnZero = rootView.findViewById(R.id.btnZero);
        btnRemove = rootView.findViewById(R.id.btnRemove);
        btnClearInputField = rootView.findViewById(R.id.btnClearInputField);
        tvMoney = rootView.findViewById(R.id.tvMoney);
        etInputField = rootView.findViewById(R.id.etInputField);
        spinnerIncome = rootView.findViewById(R.id.spinnerIncome);
        etCategory = rootView.findViewById(R.id.etCategory);
        tvCurrentMoney = rootView.findViewById(R.id.tvCurrentMoney);
        tvTextIncome = rootView.findViewById(R.id.tvTextIncome);

        btnAddIncomeTest.setOnClickListener(this);
        btnClearInputField.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        dbHelper = new DBHelper(getActivity());
        tvMoney.setText(GetValueMoney());
        tvTextIncome.setVisibility(View.GONE);
        ArrayAdapter<String> spinnerIncomeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerIncomeArray);
        spinnerIncomeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerIncome.setAdapter(spinnerIncomeAdapter);
        spinnerIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvTextIncome.setText(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }
    public int resultInt = 0;
    public String data = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnDecimal:
                if(etInputField.getText().equals("")){
                    etInputField.setText("0.");
                    data += "0.";
                }
                else if(etInputField.getText() != ""){
                    etInputField.setText(etInputField.getText()+".");
                    data += ".";
                }
                break;
            case R.id.btnRemove:
                String newStr = (String) etInputField.getText();
                newStr = newStr.substring(0, newStr.length() - 1);

                etInputField.setText(newStr);
                if(data != ""){
                    data = data.substring(0, data.length() - 1);
                }
                break;
            case R.id.btnZero:
                etInputField.setText(etInputField.getText()+"0");
                data += "0";
                break;
            case R.id.btnOne:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("1");
                    data += "1";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"1");
                    data += "1";
                }

                break;
            case R.id.btnTwo:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("2");
                    data += "2";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"2");
                    data += "2";
                }
                break;
            case R.id.btnThree:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("3");
                    data += "3";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"3");
                    data += "3";
                }
                break;
            case R.id.btnFour:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("4");
                    data += "4";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"4");
                    data += "4";
                }
                break;
            case R.id.btnFive:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("5");
                    data += "5";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"5");
                    data += "5";
                }
                break;
            case R.id.btnSix:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("6");
                    data += "6";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"6");
                    data += "6";
                }
                break;
            case R.id.btnSeven:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("7");
                    data += "7";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"7");
                    data += "7";
                }
                break;
            case R.id.btnEight:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("8");
                    data += "8";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"8");
                    data += "8";
                }
                break;
            case R.id.btnNine:
                if(etInputField.getText().equals("0")){
                    etInputField.setText("9");
                    data += "9";
                }
                else if(etInputField.getText() != "0"){
                    etInputField.setText(etInputField.getText()+"9");
                    data += "9";
                }
                break;
            case R.id.btnClearInputField:
                etInputField.setText("");

                data = "";
                resultInt = 0;
                break;
            case R.id.btnAddInfo:
                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                String dateText = dateFormat.format(currentDate);

                if(etCategory.getText().equals("")){
                    UpdateMoney(Integer.parseInt(etInputField.getText().toString())+Integer.parseInt(tvMoney.getText().toString()));
                    InsertIncome(tvTextIncome.getText().toString(), Integer.parseInt(etInputField.getText().toString()), dateText);
                    tvMoney.setText(GetValueMoney());
                    etInputField.setText("");
                }
                else{
                    UpdateMoney(Integer.parseInt(etInputField.getText().toString())+Integer.parseInt(tvMoney.getText().toString()));
                    InsertIncome(etCategory.getText().toString(), Integer.parseInt(etInputField.getText().toString()), dateText);
                    tvMoney.setText(GetValueMoney());
                    etInputField.setText("");
                    etCategory.setText("");
                }
                break;
        }
    }
    public void InsertIncome(String category, int money, String date){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_CATEGORY, category);
        contentValues.put(dbHelper.KEY_MONEY, money);
        contentValues.put(dbHelper.KEY_DATE, date);

        database.insert(dbHelper.TABLE_INCOME, null, contentValues);
        database.close();
    }
    public String GetValueMoney(){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_FINANCE, null,
                null, null, null, null, null);
        if(cursor.moveToFirst()){
            int getMoney = cursor.getColumnIndex(DBHelper.KEY_MONEY);
            return cursor.getString(getMoney);
        }
        cursor.close();
        return null;
    }
    public void UpdateMoney(int money) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_MONEY, money);
        database.update(dbHelper.TABLE_FINANCE, contentValues, DBHelper.KEY_ID + " = " + 1, null);
    }
}