package nl.hhs.group8d;

import nl.hhs.group8d.menuCode.menus.Examen.Examen;
import nl.hhs.group8d.menuCode.menus.Examen.MaakExamenMenuOption;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

class testMaakExamen {

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

        Assert.assertEquals(currentExamenAmount+1, Examen.examens.size());
        Assert.assertEquals(aangemaakteExamen.getName(), "Wiskunde Examen");
        Assert.assertEquals(aangemaakteExamen.getVragen().size(), 3);
        Assert.assertEquals(aangemaakteExamen.getVragen().get(0).getCorrecteAntwoord(), "6");
        Assert.assertEquals(aangemaakteExamen.getVragen().get(1).getCorrecteAntwoord(), "True");
        Assert.assertEquals(aangemaakteExamen.getVragen().get(2).getCorrecteAntwoord(), "15");


    }

}
