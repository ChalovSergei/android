package com.example.o;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;




public class GraphicAnalysisFragment extends Fragment implements View.OnClickListener {

    EditText etStartDate;
    EditText etEndDate;
    PieChart pieChartIncome;
    PieChart pieChartExpenses;
    Button btnIncomeChart;
    Button btnExpensesChart;
    DBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_graphic_analysis, container, false);

        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);

        btnIncomeChart = rootView.findViewById(R.id.btnIncomeChart);
        btnExpensesChart = rootView.findViewById(R.id.btnExpensesChart);
        btnIncomeChart.setOnClickListener(this);
        btnExpensesChart.setOnClickListener(this);

        pieChartIncome = rootView.findViewById(R.id.pieChartIncome);
        pieChartExpenses = rootView.findViewById(R.id.pieChartExpenses);

        dbHelper = new DBHelper(getActivity());

        etStartDate = rootView.findViewById(R.id.etStartDate);
        etEndDate = rootView.findViewById(R.id.etEndDate);
        etStartDate.setText(dateText);
        etEndDate.setText(dateText);
        pieChartExpenses.setVisibility(View.INVISIBLE);
        ChartCreationIncome();
        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        ChartCreationIncome();
        ChartCreationExpenses();
    }

    /**Метод для построения диаграммы доходов
     */
    public void ChartCreationIncome(){
        String[][] graphicMass = DateForChartIncome();
        ArrayList<PieEntry> income = new ArrayList<>();
        if(graphicMass[0][0].equals("null")){
            income.add(new PieEntry(0, "За данный период доходы отсутствуют"));
            PieDataSet pieDataSet = new PieDataSet(income, "");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(16f);

            PieData pieData = new PieData(pieDataSet);

            pieChartIncome.setData(pieData);
            pieChartIncome.getDescription().setEnabled(false);
            pieChartIncome.setCenterText("Доходы");
            pieChartIncome.animate();
        }
        else{
            for (int i = 0; i < graphicMass.length; i++){
                income.add(new PieEntry(Integer.parseInt(graphicMass[i][1]), graphicMass[i][0]));
            }
            PieDataSet pieDataSet = new PieDataSet(income, "");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(16f);

            PieData pieData = new PieData(pieDataSet);

            pieChartIncome.setData(pieData);
            pieChartIncome.getDescription().setEnabled(false);
            pieChartIncome.setCenterText("Доходы");
            pieChartIncome.animate();
        }
    }

    /**Метод для создания массива, который используется при построении диаграммы доходов
     * @return Двумерный массив, состоящий из названия категории и суммы доходов по ней
     */
    public String[][] DateForChartIncome(){
        Cursor cursor;

        int listCount = 0;


        ArrayList<String> incomeList = new ArrayList<>();
        ArrayList<String> equalList = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String[][] graphicMassNull = new String[1][1];
        graphicMassNull[0][0] = "null";
        int startDateIncome = DateConverter.ConvertToJulian(String.valueOf(etStartDate.getText()));
        int endDateIncome = DateConverter.ConvertToJulian(String.valueOf(etEndDate.getText()));
        if(startDateIncome != 0 && endDateIncome != 0 && startDateIncome <= endDateIncome){
            cursor = database.rawQuery(
                    "SELECT " + dbHelper.KEY_MONEY + ", "+dbHelper.KEY_CATEGORY+"  FROM  "+dbHelper.TABLE_INCOME+"  WHERE "+dbHelper.KEY_DATE+" BETWEEN "+startDateIncome+" AND  "+endDateIncome+" ", null);
            if(cursor.moveToFirst()){
                int categoryIndex = cursor.getColumnIndex(DBHelper.KEY_CATEGORY);
                int moneyIndex = cursor.getColumnIndex(DBHelper.KEY_MONEY);
                do {
                    incomeList.add(cursor.getString(categoryIndex));
                    incomeList.add(String.valueOf(cursor.getInt(moneyIndex)));
                }
                while (cursor.moveToNext());
            }
            String[][] incomeMass = new String[incomeList.size() / 2][2];
            if(incomeList.size() > 0){
                //создание массива из таблицы дохода
                for (int i = 0; i < incomeList.size() / 2; i++){
                    for(int j = 0; j < 2; j++){
                        incomeMass[i][j] = incomeList.get(listCount);
                        listCount++;
                    }
                }
                //список категорий
                for (int i = 0; i < incomeList.size() / 2; i++){
                    for(int j = 0; j < 1; j++){
                        if(!equalList.contains(incomeMass[i][j])){
                            equalList.add(incomeMass[i][j]);
                        }
                    }
                }
                //создание массива денег
                int[] moneyMass = new int[equalList.size()];
                for (int countEqualList = 0; countEqualList < equalList.size(); countEqualList++){
                    for (int j = 0; j < incomeList.size() / 2; j++){
                        if(incomeMass[j][0].equals(equalList.get(countEqualList))){
                            moneyMass[countEqualList] += Integer.parseInt(incomeMass[j][1]);
                        }
                    }
                }
                //заполнение массива для построения графика
                String[][] graphicMass = new String[equalList.size()][2];
                for (int i = 0; i < equalList.size(); i++){
                    graphicMass[i][0] = equalList.get(i);
                    graphicMass[i][1] = String.valueOf(moneyMass[i]);
                }
                return graphicMass;
            }
            cursor.close();
            database.close();
        }
        else if(startDateIncome == 0 && endDateIncome == 0 || (startDateIncome == 0 || endDateIncome == 0)){
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "Ошибка ввода даты"+"\n"
                            +"Дату необходимо записать в формате: День.Месяц.Год(dd.mm.yyyy)",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 100, 100);
            toast.show();
        }
        else if(startDateIncome > endDateIncome){
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "Ошибка диапазона дат:"+"\n"
                            +"Дата начала периода должна быть раньше, чем дата завершения, либо равна ей",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 100, 100);
            toast.show();
        }
        return graphicMassNull;
    }
    /**Метод для построения диаграммы расходов
     */
    public void ChartCreationExpenses(){
        String[][] graphicMass = DateForChartExpenses();
        ArrayList<PieEntry> income = new ArrayList<>();
        if(graphicMass[0][0].equals("null")){
            income.add(new PieEntry(0, "За данный период расходы отсутствуют"));
            PieDataSet pieDataSet = new PieDataSet(income, "");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(16f);

            PieData pieData = new PieData(pieDataSet);

            pieChartExpenses.setData(pieData);
            pieChartExpenses.getDescription().setEnabled(false);
            pieChartExpenses.setCenterText("Расходы");
            pieChartExpenses.animate();
        }
        else{
            for (int i = 0; i < graphicMass.length; i++){
                income.add(new PieEntry(Integer.parseInt(graphicMass[i][1]), graphicMass[i][0]));
            }
            PieDataSet pieDataSet = new PieDataSet(income, "");
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(16f);

            PieData pieData = new PieData(pieDataSet);

            pieChartExpenses.setData(pieData);
            pieChartExpenses.getDescription().setEnabled(false);
            pieChartExpenses.setCenterText("Расходы");
            pieChartExpenses.animate();
        }
    }

    /**Метод для создания массива, который используется при построении диаграммы расходов
     * @return Двумерный массив, состоящий из названия категории и суммы расходов по ней
     */
    public String[][] DateForChartExpenses(){
        Cursor cursor;
        int listCount = 0;

        ArrayList<String> incomeList = new ArrayList<>();
        ArrayList<String> equalList = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        int startDateIncome = DateConverter.ConvertToJulian(String.valueOf(etStartDate.getText()));
        int endDateIncome = DateConverter.ConvertToJulian(String.valueOf(etEndDate.getText()));
        String[][] graphicMassNull = new String[1][1];
        graphicMassNull[0][0] = "null";
        if(startDateIncome != 0 && endDateIncome != 0 && startDateIncome <= endDateIncome){
            cursor = database.rawQuery(
                    "SELECT " + dbHelper.KEY_MONEY + ", "+dbHelper.KEY_CATEGORY+"  FROM  "+dbHelper.TABLE_EXPENSES+"  WHERE "+dbHelper.KEY_DATE+" BETWEEN "+startDateIncome+" AND  "+endDateIncome+" ", null);
            if(cursor.moveToFirst()){
                int categoryIndex = cursor.getColumnIndex(DBHelper.KEY_CATEGORY);
                int moneyIndex = cursor.getColumnIndex(DBHelper.KEY_MONEY);
                do {
                    incomeList.add(cursor.getString(categoryIndex));
                    incomeList.add(String.valueOf(cursor.getInt(moneyIndex)));
                }
                while (cursor.moveToNext());
            }
            String[][] incomeMass = new String[incomeList.size() / 2][2];
            if(incomeList.size() > 0){
                //создание массива из таблицы расходов
                for (int i = 0; i < incomeList.size() / 2; i++){
                    for(int j = 0; j < 2; j++){
                        incomeMass[i][j] = incomeList.get(listCount);
                        listCount++;
                    }
                }
                //список категорий
                for (int i = 0; i < incomeList.size() / 2; i++){
                    for(int j = 0; j < 1; j++){
                        if(!equalList.contains(incomeMass[i][j])){
                            equalList.add(incomeMass[i][j]);
                        }
                    }
                }
                //создание массива денег
                int[] moneyMass = new int[equalList.size()];
                for (int countEqualList = 0; countEqualList < equalList.size(); countEqualList++){
                    for (int j = 0; j < incomeList.size() / 2; j++){
                        if(incomeMass[j][0].equals(equalList.get(countEqualList))){
                            moneyMass[countEqualList] += Integer.parseInt(incomeMass[j][1]);
                        }
                    }
                }
                //заполнение массива для построения графика
                String[][] graphicMass = new String[equalList.size()][2];
                for (int i = 0; i < equalList.size(); i++){
                    graphicMass[i][0] = equalList.get(i);
                    graphicMass[i][1] = String.valueOf(moneyMass[i]);
                }
                return graphicMass;
            }
            cursor.close();
            database.close();
        }
        else if(startDateIncome == 0 && endDateIncome == 0 || (startDateIncome == 0 || endDateIncome == 0)){
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "Ошибка ввода даты"+"\n"
                            +"Дату необходимо записать в формате: День.Месяц.Год(dd.mm.yyyy)",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 100, 100);
            toast.show();
        }
        else if(startDateIncome > endDateIncome){
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "Ошибка диапазона дат:"+"\n"
                    +"Дата начала периода должна быть раньше, чем дата завершения, либо равна ей",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 100, 100);
            toast.show();
        }
        return graphicMassNull;
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnIncomeChart:
                pieChartIncome.setVisibility(View.INVISIBLE);
                pieChartExpenses.setVisibility(View.INVISIBLE);
                ChartCreationIncome();
                pieChartIncome.setVisibility(View.VISIBLE);
                break;
            case R.id.btnExpensesChart:
                pieChartExpenses.setVisibility(View.INVISIBLE);
                pieChartIncome.setVisibility(View.INVISIBLE);
                ChartCreationExpenses();
                pieChartExpenses.setVisibility(View.VISIBLE);
                break;
        }
    }
}