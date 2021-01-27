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
    TextView tvInputField;
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
        tvInputField = rootView.findViewById(R.id.tvInputField);
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnDecimal:
                if(tvInputField.getText().equals("")){
                    tvInputField.setText("0.");
                }
                else if(tvInputField.getText() != ""){
                    tvInputField.setText(tvInputField.getText()+".");
                }
                break;
            case R.id.btnRemove:
                if(tvInputField.getText().equals("")){

                }
                else{
                    String newStr = (String) tvInputField.getText();
                    newStr = newStr.substring(0, newStr.length() - 1);
                    tvInputField.setText(newStr);
                }
                break;
            case R.id.btnZero:
                tvInputField.setText(tvInputField.getText()+"0");
                break;
            case R.id.btnOne:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("1");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"1");
                }

                break;
            case R.id.btnTwo:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("2");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"2");
                }
                break;
            case R.id.btnThree:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("3");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"3");
                }
                break;
            case R.id.btnFour:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("4");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"4");
                }
                break;
            case R.id.btnFive:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("5");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"5");
                }
                break;
            case R.id.btnSix:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("6");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"6");
                }
                break;
            case R.id.btnSeven:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("7");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"7");
                }
                break;
            case R.id.btnEight:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("8");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"8");
                }
                break;
            case R.id.btnNine:
                if(tvInputField.getText().equals("0")){
                    tvInputField.setText("9");
                }
                else if(tvInputField.getText() != "0"){
                    tvInputField.setText(tvInputField.getText()+"9");
                }
                break;
            case R.id.btnClearInputField:
                if(tvInputField.getText().equals("")){ }
                else{
                    tvInputField.setText("");
                }
                break;
            case R.id.btnAddInfo:
                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                String dateText = dateFormat.format(currentDate);
                int date = DateConverter.ConvertToJulian(dateText);
                if(etCategory.length() < 1 && tvInputField.length() > 0){
                    UpdateMoney(Integer.parseInt(tvInputField.getText().toString()) + Integer.parseInt(tvMoney.getText().toString()));
                    InsertIncome(String.valueOf(tvTextIncome.getText()), Integer.parseInt(tvInputField.getText().toString()), date);
                    tvMoney.setText(GetValueMoney());
                    tvInputField.setText("");
                }
                else if(tvInputField.length() > 0){
                    UpdateMoney(Integer.parseInt(tvInputField.getText().toString()) + Integer.parseInt(tvMoney.getText().toString()));
                    InsertIncome(String.valueOf(etCategory.getText()), Integer.parseInt(tvInputField.getText().toString()), date);
                    tvMoney.setText(GetValueMoney());
                    tvInputField.setText("");
                    etCategory.setText("");
                }
                break;
        }
    }

    /**Метод для учета доходов по категории и дате
     * @param category - название категории
     * @param money - количество денег
     * @param date - текущая дата
     */
    public void InsertIncome(String category, int money, int date){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_CATEGORY, category);
        contentValues.put(dbHelper.KEY_MONEY, money);
        contentValues.put(dbHelper.KEY_DATE, date);

        database.insert(dbHelper.TABLE_INCOME, null, contentValues);
        database.close();
    }

    /**Метод для вывода текущего состояния финансов
     * @return Строка с количеством денег
     */
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

    /**Метод для изменение количества денег
     * @param money - количество денег
     */
    public void UpdateMoney(int money) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_MONEY, money);
        database.update(dbHelper.TABLE_FINANCE, contentValues, DBHelper.KEY_ID + " = " + 1, null);
    }
}