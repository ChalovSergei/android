package com.example.o;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new
            ActivityScenarioRule<>(
            MainActivity.class);
    Date currentDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    String dateText = dateFormat.format(currentDate);
    @Test
    public void TestNumericInputBlock() {
        Espresso.onView(ViewMatchers.withId(R.id.incomeFragment))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnZero))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("0")));
        Espresso.onView(ViewMatchers.withId(R.id.btnOne))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("1")));
        Espresso.onView(ViewMatchers.withId(R.id.btnTwo))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12")));
        Espresso.onView(ViewMatchers.withId(R.id.btnThree))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("123")));
        Espresso.onView(ViewMatchers.withId(R.id.btnFour))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("1234")));
        Espresso.onView(ViewMatchers.withId(R.id.btnFive))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12345")));
        Espresso.onView(ViewMatchers.withId(R.id.btnSix))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("123456")));
        Espresso.onView(ViewMatchers.withId(R.id.btnSeven))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("1234567")));
        Espresso.onView(ViewMatchers.withId(R.id.btnEight))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12345678")));
        Espresso.onView(ViewMatchers.withId(R.id.btnDecimal))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12345678.")));
        Espresso.onView(ViewMatchers.withId(R.id.btnNine))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12345678.9")));
        Espresso.onView(ViewMatchers.withId(R.id.btnRemove))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("12345678.")));
        Espresso.onView(ViewMatchers.withId(R.id.btnClearInputField))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvInputField))
                .check(matches(withText("")));
    }
    @Test
    public void TestAnalysisCharts(){
        Espresso.onView(ViewMatchers.withId(R.id.graphicAnalysisFragment))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnExpensesChart))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.pieChartExpenses))
                .check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btnIncomeChart))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.pieChartIncome))
                .check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.etStartDate))
                .check(matches(withText(dateText)));
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .check(matches(withText(dateText)));
        Espresso.onView(ViewMatchers.withId(R.id.etStartDate))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.etStartDate))
                .perform(ViewActions.typeText("26.01.2021"));
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .perform(ViewActions.typeText("26.01.2021"));
        Espresso.onView(ViewMatchers.withId(R.id.btnExpensesChart))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.pieChartExpenses))
                .check(matches(isDisplayed()));
    }
    @Test
    public void TestPlanning(){
        Espresso.onView(ViewMatchers.withId(R.id.planningFragment))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.etStartDate))
                .check(matches(withText(dateText)));
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .check(matches(withText(dateText)));
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .check(matches(withText(dateText)));
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.etEndDate))
                .perform(ViewActions.typeText("30.01.2021"));
        Espresso.onView(ViewMatchers.withId(R.id.btnOne))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnZero))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnZero))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnAddPlanningExpenses))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnClearPlanningExpenses))
                .perform(click());
    }
    @Test
    public void TestPlanningCheck(){
        Espresso.onView(ViewMatchers.withId(R.id.expensesFragment))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.tvPlanningMoney))
                .check(matches(isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.tvPlanningMoney))
                .check(matches(withText("Сегодня: "+dateText+ "\n"+ "До 28.01.2021" + "\n" + "Осталось: 20")));
    }
    @Test
    public void TestIncome(){
        Espresso.onView(ViewMatchers.withId(R.id.incomeFragment))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnOne))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnZero))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.btnZero))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.etCategory))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.etCategory))
                .perform(ViewActions.typeText("Income"));
        Espresso.onView(ViewMatchers.withId(R.id.btnAddInfo))
                .perform(click());
    }
}