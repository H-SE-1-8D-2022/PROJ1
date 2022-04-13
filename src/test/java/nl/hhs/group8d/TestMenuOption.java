package nl.hhs.group8d;

import nl.hhs.group8d.ui.Menu;
import nl.hhs.group8d.ui.MenuOption;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMenuOption {
    @Test
    public void testMenuOption() {
        String input = "10\n10\nTest\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestOption option = new TestOption(0);
        option.executeMenuOption();
    }

    @Test
    public void testMenuOptionFouteInput() {
        String input = "10\n1\n10\nTest\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestOption option = new TestOption(0);
        option.executeMenuOption();
    }

    static class TestOption extends MenuOption {
        public final int id;

        public TestOption(int id) {
            this.id = id;
        }

        @Override
        public String getTitle() {
            return "Test Menu";
        }

        @Override
        public Menu getNextSubMenu() {
            return null;
        }

        @Override
        public void executeMenuOption() {
            // Test inputs
            int anyInt = getUserIntInput();
            int limitedInt = getUserIntInput(5, 100);
            String string = getUserStringInput();

            assertEquals(10, anyInt);
            assertEquals(10, limitedInt);
            assertEquals("Test", string);
        }
    }
}
