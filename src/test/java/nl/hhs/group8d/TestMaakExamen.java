package nl.hhs.group8d;

import nl.hhs.group8d.entities.Examen;
import nl.hhs.group8d.ui.menus.examen.MaakExamenMenuOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

class TestMaakExamen {

    /**
     * Deze test word gebruikt om het aanmaken van een test via de user interface te testen.
     * We maken een examen aan en testen daarna of de examen is toegevoegd aan de local arraylist en of de hoeveelheid vragen kloppen met de juiste antwoorden.
     * Deze test wordt gedaan om te kijken of het aanmaken van een examen vanuit de app goed verloopt en geen problemen heeft.
     */
    @Test
    void maakExamenTest() {

        int currentExamenAmount = Examen.examens.size();

        String input = "Wiskunde Examen\n" + "3\n" + "2\n" + "1\n"
                + "3+3=\n" + "6\n" + "2\n" + "6\n" + "2\n" + "2\n"
                + "3*3=9\n" + "1\n" + "3\n" + "10+5\n" + "15\n 0";

        ByteArrayInputStream byteStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(byteStream);

        MaakExamenMenuOption examenMaken = new MaakExamenMenuOption();
        examenMaken.executeMenuOption();

        Examen aangemaakteExamen = Examen.examens.get(Examen.examens.size() - 1);

        Assertions.assertEquals(currentExamenAmount + 1, Examen.examens.size());
        Assertions.assertEquals("Wiskunde Examen", aangemaakteExamen.getName());
        Assertions.assertEquals(3, aangemaakteExamen.getVragen().size());
        Assertions.assertEquals("6", aangemaakteExamen.getVragen().get(0).getCorrecteAntwoord());
        Assertions.assertEquals("True", aangemaakteExamen.getVragen().get(1).getCorrecteAntwoord());
        Assertions.assertEquals("15", aangemaakteExamen.getVragen().get(2).getCorrecteAntwoord());
    }
}
