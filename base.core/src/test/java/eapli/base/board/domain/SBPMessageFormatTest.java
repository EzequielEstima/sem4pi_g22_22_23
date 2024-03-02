package eapli.base.board.domain;

import eapli.base.sharedBoard.SBPMessageFormat;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class SBPMessageFormatTest {
    @Test
    public void ensureDecodeDTOSucceeds(){
        String input = "1111Agua,agua2,agua3,;,Sede,sede2,sede3";
        List<List<String>> expected = new ArrayList<>();
        List<String> expected1 = new ArrayList<>();
        expected1.add("Agua");expected1.add("agua2");expected1.add("agua3");
        expected.add(expected1);
        expected1 = new ArrayList<>();
        expected1.add("Sede");expected1.add("sede2");expected1.add("sede3");
        expected.add(expected1);
        List<List<String>> result = SBPMessageFormat.decodeDTO(input.getBytes(StandardCharsets.UTF_8));
        assertEquals(expected, result);
    }

    @Test
    public void ensureDecodeDTOEmptySucceeds(){
        String input = "1111";
        List<List<String>> expected = new ArrayList<>();
        List<List<String>> result = SBPMessageFormat.decodeDTO(input.getBytes(StandardCharsets.UTF_8));
        assertEquals(expected, result);
    }

    @Test
    public void ensureDecodeOnlyOneDTOSucceeds(){
        String input = "1111Agua,agua2,agua3";
        List<List<String>> expected = new ArrayList<>();
        List<String> expected1 = new ArrayList<>();
        expected1.add("Agua");expected1.add("agua2");expected1.add("agua3");
        expected.add(expected1);
        List<List<String>> result = SBPMessageFormat.decodeDTO(input.getBytes(StandardCharsets.UTF_8));
        assertEquals(expected, result);
    }
}
