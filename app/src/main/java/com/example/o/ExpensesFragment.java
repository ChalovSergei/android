package com.example.o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
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

public class ExpensesFragment extends Fragment implements View.OnClickListener{
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
    TextView tvPlanningMoney;
    TextView tvPlanningMoneyCalc;
    String[] spinnerIncomeArray = {"Еда","Сотовая связь","Интернет","Одежда","Спорт", "Досуг", "Авто", "Дом", "Обеды"};
    Button btnAddIncomeTest;
    String message = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        View rootView = inflater.inflate(R.layout.fragment_expenses, container, false);
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

        tvPlanningMoney = rootView.findViewById(R.id.tvPlanningMoney);
        tvPlanningMoneyCalc = rootView.findViewById(R.id.tvPlanningMoneyCalc);

        tvPlanningMoney.setVisibility(View.GONE);
        tvPlanningMoneyCalc.setVisibility(View.GONE);
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
        DeletePlanningByDate();
        if(!ViewPlanningEndDate().equals("null")){
            tvPlanningMoney.setVisibility(View.VISIBLE);
        }
        if(!ViewPlanningMoney().equals("null")){
            if(Integer.parseInt(ViewPlanningMoney()) >= 0){
                message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Осталось: " + ViewPlanningMoney();
                tvPlanningMoney.setText(message);
                tvPlanningMoneyCalc.setText(ViewPlanningMoney());
            }
            else{
                message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Перерасход запланированных средств: " + ViewPlanningMoney();
                tvPlanningMoney.setText(message);
                tvPlanningMoneyCalc.setText(ViewPlanningMoney());
            }
        }
        ArrayAdapter<String> spinnerIncomeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerIncomeArray);
        spinnerIncomeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerIncome.setAdapter(spinnerIncomeAdapter);
        spinnerIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvTextIncome.setText(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        return rootView;
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
                if(tvInputField.getText().equals("")){ }
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
                if(tvInputField.getText().equals("")){}
                else{
                    tvInputField.setText("");

                }
                break;
            case R.id.btnAddInfo:
                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                String dateText = dateFormat.format(currentDate);
                int date = DateConverter.convertToJulian(dateText);
                if(etCategory.length() < 1){
                    UpdateMoney(Integer.parseInt(tvMoney.getText().toString()) - Integer.parseInt(tvInputField.getText().toString()));
                    InsertExpenses(String.valueOf(tvTextIncome.getText()), Integer.parseInt(tvInputField.getText().toString()),  date);
                    if(!tvPlanningMoneyCalc.getText().toString().equals("")){
                        UpdatePlanningMoney(Integer.parseInt(tvPlanningMoneyCalc.getText().toString()) - Integer.parseInt(tvInputField.getText().toString()));
                        if(Integer.parseInt(ViewPlanningMoney()) >= 0){
                            message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Осталось: " + ViewPlanningMoney();
                            tvPlanningMoney.setText(message);
                            tvPlanningMoneyCalc.setText(ViewPlanningMoney());
                        }
                        else{
                            message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Перерасход запланированных средств: " + ViewPlanningMoney();
                            tvPlanningMoney.setText(message);
                            tvPlanningMoneyCalc.setText(ViewPlanningMoney());
                        }
                    }
                    tvMoney.setText(GetValueMoney());
                    tvInputField.setText("");
                }
                else{
                    UpdateMoney(Integer.parseInt(tvMoney.getText().toString()) - Integer.parseInt(tvInputField.getText().toString()));
                    InsertExpenses(String.valueOf(etCategory.getText()), Integer.parseInt(tvInputField.getText().toString()), date);
                    if(!tvPlanningMoneyCalc.getText().toString().equals("")){
                        UpdatePlanningMoney(Integer.parseInt(tvPlanningMoneyCalc.getText().toString()) - Integer.parseInt(tvInputField.getText().toString()));
                        if(Integer.parseInt(ViewPlanningMoney()) >= 0){
                            message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Осталось: " + ViewPlanningMoney();
                            tvPlanningMoney.setText(message);
                            tvPlanningMoneyCalc.setText(ViewPlanningMoney());
                        }
                        else{
                            message = "Сегодня: "+dateText+ "\n" + "До "+ViewPlanningEndDate() + "\n" + "Перерасход запланированных средств: " + ViewPlanningMoney();
                            tvPlanningMoney.setText(message);
                            tvPlanningMoneyCalc.setText(ViewPlanningMoney());
                        }
                    }
                    tvMoney.setText(GetValueMoney());
                    tvInputField.setText("");
                    etCategory.setText("");
                }
                break;
        }
    }


    /**Метод для учета расходов по категории и дате
     * @param category - название категории
     * @param money - количество денег
     * @param date - текущая дата
     */
    public void InsertExpenses(String category, int money, int date){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_CATEGORY, category);
        contentValues.put(dbHelper.KEY_MONEY, money);
        contentValues.put(dbHelper.KEY_DATE, date);

        database.insert(dbHelper.TABLE_EXPENSES, null, contentValues);
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
        database.close();
        cursor.close();
        return null;
    }


    /**Метод для изменения значения денег в таблице планирования
     * @param money - количество денег
     */
    public void UpdatePlanningMoney(int money){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_MONEY, money);
        database.update(dbHelper.TABLE_PLANNING_EXPENSES, contentValues, DBHelper.KEY_ID + " = " + 1, null);
        database.close();
    }

    /**Метод для удаления планирования из таблицы при окончании его периода
     */
    public void DeletePlanningByDate(){
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        if(ViewPlanningEndDate().equals(dateText)){
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            database.delete(DBHelper.TABLE_PLANNING_EXPENSES, null, null);
        }
    }

    /**Метод для получения из таблицы планирования даты и перевода ее из Юлианской в Григорианскую
     * @return Строка с датой в Григорианском формате
     */
    public String ViewPlanningEndDate(){
        if(getProfilesCount() != 0){
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            Cursor cursor = database.query(DBHelper.TABLE_PLANNING_EXPENSES, null,
                    null, null, null, null, null);
            if(cursor.moveToFirst()){
                int getDateEnd = cursor.getColumnIndex(DBHelper.KEY_DATE_END);
                return DateConverter.ConvertFromJulian(cursor.getInt(getDateEnd));
            }
            database.close();
            cursor.close();
        }
        return "null";
    }

    /**Метод для вывода оставшихся денег, указанных при планировании
     * @return Строка остатком денег
     */
    public String ViewPlanningMoney(){
        if(getProfilesCount() != 0){
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            Cursor cursor = database.query(DBHelper.TABLE_PLANNING_EXPENSES, null,
                    null, null, null, null, null);
            if(cursor.moveToFirst()){
                int getMoney = cursor.getColumnIndex(DBHelper.KEY_MONEY);
                return cursor.getString(getMoney);
            }
            database.close();
            cursor.close();
        }
        return "null";
    }

    /**Метод для вывода количества записей в таблице планирования
     * @return Количество записей
     */
    public long getProfilesCount(){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long count = DatabaseUtils.queryNumEntries(database, dbHelper.TABLE_PLANNING_EXPENSES);
        database.close();
        return count;
    }

    /**Метод для изменение количества денег
     * @param money - количество денег
     */
    public void UpdateMoney(int money) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_MONEY, money);
        database.update(dbHelper.TABLE_FINANCE, contentValues, DBHelper.KEY_ID + " = " + 1, null);
        database.close();
    }
}