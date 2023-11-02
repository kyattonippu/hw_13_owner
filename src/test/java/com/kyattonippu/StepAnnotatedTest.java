package com.kyattonippu;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.kyattonippu.steps.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String ALLURE = "allure-framework/allure2";

    @Tag("Allure")
    @Owner("kyattonippu")
    @Feature("Check contributors in Allure repo")
    @Story("Check contributors in Allure repo with SelenideListener")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check eroshenkoam as contributor in Allure Framework repository with SelenideListener")
    @Link(name = "GitHub", url = "https://github.com")
    @Test

    public void checkContributorsAnnotatedSteps() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openGitHub()
                .searchAllureRepository(ALLURE)
                .openAllureRepository(ALLURE)
                .openAllureContributors()
                .checkContributorsInAllureRepository();
    }
}
