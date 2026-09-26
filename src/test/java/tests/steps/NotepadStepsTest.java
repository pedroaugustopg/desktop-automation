package tests.steps;

import tests.pages.NotepadPageTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.io.IOException;

public class NotepadStepsTest {

    private NotepadPageTest notepad;

    @Given("que o Notepad está aberto")
    public void openNotepad() throws AWTException, InterruptedException, IOException {
        ProcessBuilder processBuilder =
                new ProcessBuilder("notepad.exe");
        processBuilder.start();
        Thread.sleep(1500);
        notepad = new NotepadPageTest();
    }

    @When("eu digito {string}")
    public void typeText(String text) {
        notepad.typeText(text);
    }

    @When("deleto todo o conteúdo do documento")
    public void deleteDocumentContent() {
        notepad.selectAll();
        notepad.deleteText();
    }

    @Then("Fecho o Notepad")
    public void closeNotepad() {
        notepad.closeNotepad();
    }
}