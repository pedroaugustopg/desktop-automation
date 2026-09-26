package tests.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class NotepadPageTest {

    private final Robot robot;

    public NotepadPageTest() throws AWTException {
        robot = new Robot();
        robot.setAutoDelay(150);
    }

    public void typeText(String text) {
        for (char character : text.toCharArray()) {
            typeCharacter(character);
        }
    }

    private void typeCharacter(char character) {
        if (character == ' ') {
            pressKey(KeyEvent.VK_SPACE);
            return;
        }
        if (character == '-') {
            pressKey(KeyEvent.VK_MINUS);
            return;
        }
        if (Character.isUpperCase(character)) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(
                    Character.toLowerCase(character)
            );
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            return;
        }
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);
        pressKey(keyCode);
    }

    private void pressKey(int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        robot.delay(80);
    }

    public void selectAll() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(200);
    }

    public void deleteText() {
        pressKey(KeyEvent.VK_BACK_SPACE);
    }

    public void closeNotepad() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}