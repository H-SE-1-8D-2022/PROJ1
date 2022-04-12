package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.menus.Examen.Examen;
import nl.hhs.group8d.menuCode.menus.Examen.MaakExamenMenuOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

class TestMaakExamenMenuOption {

    @Test
    void maakExamenTest(){

        int currentExamenAmount = Examen.examens.size();

        String input = "Wiskunde Examen\n" + "3\n" + "2\n" + "1\n"
                + "3+3=\n" + "6\n" + "2\n" + "6\n" + "2\n" + "2\n"
                + "3*3=9\n" + "1\n" + "3\n" + "10+5\n" + "15\n 0";

        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        MaakExamenMenuOption examenMaken = new MaakExamenMenuOption();
        examenMaken.executeMenuOption();

        Examen aangemaakteExamen = Examen.examens.get(Examen.examens.size()-1);

        Assertions.assertEquals(currentExamenAmount+1, Examen.examens.size());
        Assertions.assertEquals("Wiskunde Examen", aangemaakteExamen.getName());
        Assertions.assertEquals(3, aangemaakteExamen.getVragen().size());
        Assertions.assertEquals("6", aangemaakteExamen.getVragen().get(0).getCorrecteAntwoord());
        Assertions.assertEquals("True", aangemaakteExamen.getVragen().get(1).getCorrecteAntwoord());
        Assertions.assertEquals("15", aangemaakteExamen.getVragen().get(2).getCorrecteAntwoord());
    }
}
