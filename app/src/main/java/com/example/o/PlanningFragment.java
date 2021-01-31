package com.example.o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PlanningFragment extends Fragment implements View.OnClickListener {
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
    Button btnAddPlanningExpenses;
    Button btnClearPlanningExpenses;
    ImageButton btnClearInputField;
    TextView tvMoney;
    TextView tvInputField;
    EditText etStartDate;
    EditText etEndDate;
    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_planning, container, false);
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);

        btnOne = rootView.findViewById(R.id.btnOne);
        btnTwo = rootView.findViewById(R.id.btnTwo);
        btnThree = rootView.findViewById(R.id.btnThree);
        btnFour = rootView.findViewById(R.id.btnFour);
        btnFive = rootView.findViewById(R.id.btnFive);
        btnSix = rootView.findViewById(R.id.btnSix);
        btnSeven = rootView.findViewById(R.id.btnSeven);
        btnEight = rootView.findViewById(R.id.btnEight);
        btnNine = rootView.findViewById(R.id.btnNine);
        btnDecimal = rootView.findViewById(R.id.btnDecimal);
        btnZero = rootView.findViewById(R.id.btnZero);
        btnRemove = rootView.findViewById(R.id.btnRemove);
        btnClearInputField = rootView.findViewById(R.id.btnClearInputField);
        btnAddPlanningExpenses = rootView.findViewById(R.id.btnAddPlanningExpenses);
        btnClearPlanningExpenses = rootView.findViewById(R.id.btnClearPlanningExpenses);

        dbHelper = new DBHelper(getActivity());
        tvMoney = rootView.findViewById(R.id.tvMoney);
        tvMoney.setText(GetValueMoney());
        tvInputField = rootView.findViewById(R.id.tvInputField);
        etStartDate = rootView.findViewById(R.id.etStartDate);
        etEndDate = rootView.findViewById(R.id.etEndDate);
        etStartDate.setText(dateText);
        etEndDate.setText(dateText);


        btnClearPlanningExpenses.setOnClickListener(this);
        btnAddPlanningExpenses.setOnClickListener(this);
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
                if(tvInputField.getText().equals("")){ }
                else{
                    tvInputField.setText("");
                }
                break;
            case R.id.btnAddPlanningExpenses:
                //добавить проверку и возврат тоста
                if(GetProfilesCount() == 0 && tvInputField.length() > 0){
                    int money = Integer.parseInt(String.valueOf(tvInputField.getText()));
                    int dateStart = DateConverter.ConvertToJulian(etStartDate.getText().toString());
                    int dateEnd = DateConverter.ConvertToJulian(etEndDate.getText().toString());
                    if(dateStart != 0 && dateEnd != 0 && dateStart < dateEnd){
                        SQLiteDatabase database = dbHelper.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(DBHelper.KEY_MONEY, money);
                        contentValues.put(DBHelper.KEY_DATE_START, dateStart);
                        contentValues.put(DBHelper.KEY_DATE_END, dateEnd);
                        database.insert(DBHelper.TABLE_PLANNING_EXPENSES, null, contentValues);
                    }
                    else if(dateStart == 0 && dateEnd == 0 || (dateStart == 0 || dateEnd == 0)){
                        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                "Ошибка ввода даты"+"\n"
                                        +"Дату необходимо записать в формате: День.Месяц.Год(dd.mm.yyyy)",
                                Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 100, 100);
                        toast.show();
                    }
                    else if(dateStart > dateEnd){
                        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                "Ошибка диапазона дат:"+"\n"
                                        +"Дата начала периода должна быть раньше, чем дата его завершения",
                                Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 100, 100);
                        toast.show();
                    }
                }
                else if (GetProfilesCount() == 1){
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Ошибка добавления планирования:"+"\n"
                                    +"Планирование уже было создано",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 100, 100);
                    toast.show();
                }
                else if (tvInputField.length() == 0){
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Ошибка ввода суммы планирования:"+"\n"
                                    +"Введите сумму планирования",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 100, 100);
                    toast.show();
                }
                break;
            case R.id.btnClearPlanningExpenses:
                if(GetProfilesCount() == 1){
                    SQLiteDatabase database = dbHelper.getWritableDatabase();
                    database.delete(DBHelper.TABLE_PLANNING_EXPENSES, null, null);
                }
                else{
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Ошибка удаления планирования:"+"\n"
                                    +"Планирование отсутствует",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 100, 100);
                    toast.show();
                }
                break;
        }
    }
    /**Метод для вывода количества записей в таблице планирования
     * @return Количество записей
     */
    public long GetProfilesCount(){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long count = DatabaseUtils.queryNumEntries(database, dbHelper.TABLE_PLANNING_EXPENSES);
        database.close();
        return count;
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
}