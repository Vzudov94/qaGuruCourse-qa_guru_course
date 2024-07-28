package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String mouth, String year) {
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOption("1998");
        $(".react-datepicker__day--021:not(.react-datepicker__day--outside-month)").click();
    }
}

