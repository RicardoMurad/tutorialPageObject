package com.ricardomurad;

import com.ricardomurad.pages.GitHubJoinPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class GitHubJoinPageTest extends SeleniumBaseTest {

    private GitHubJoinPage gitHubJoinPage;

    @Override
    protected void initPage() {
        gitHubJoinPage = PageFactory.initElements(webDriver, GitHubJoinPage.class);
        webDriver.get(baseUrl + gitHubJoinPage.getPath());
    }

    @Test
    public void shouldShowMessageUsernameIsAlreadyTakenWhenUserExists() {
        gitHubJoinPage.setUsername("ricardomurad");
        gitHubJoinPage.setEmail("ricardomurad@gmail.com");

        assertTrue(gitHubJoinPage.isErrorMessageVisible("Username is already taken"));
        assertTrue(gitHubJoinPage.isErrorMessageVisible("Email is invalid or already taken"));
    }

}
