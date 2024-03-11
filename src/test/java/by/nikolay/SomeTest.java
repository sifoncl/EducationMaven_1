package by.nikolay;


import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeTest {

    @Test
    public void readFromJson() throws IOException {
        MyJakarta mJ = MyJakarta.readFromJson("src\\test\\resources\\Test.json");
        MyJakarta mJr = MyJakarta.readFromJson("src\\test\\resources\\readerTest.json");
        assertTrue(mJ.getDescription().equals(mJr.getDescription()) && mJ.getVersion().equals(mJr.getVersion()) &&
                mJ.getTechnologies().containsAll(mJr.getTechnologies()));
    }

    @Test
    public void writeToJson() throws IOException {
        MyJakarta mJt = MyJakarta.readFromJson("src\\test\\resources\\Test.json");
        mJt.writeToJson("src\\test\\resources\\writeTest.json");
        MyJakarta mJ = MyJakarta.readFromJson("src\\test\\resources\\writeTest.json");
        assertTrue(mJ.getDescription().equals(mJt.getDescription()) && mJ.getVersion().equals(mJt.getVersion()) &&
                mJ.getTechnologies().containsAll(mJt.getTechnologies()));
    }

    @Test
    public void updateTechnology() throws IOException {
        MyJakarta mJt = MyJakarta.readFromJson("src\\test\\resources\\Test.json");
        mJt.writeToJson("src\\test\\resources\\updateTest.json");
        JavaxWebsocket javaxWebsocket2 = new JavaxWebsocket("Javax Websocket", "тупо для теста");
        MyJakarta.updateTechnology(javaxWebsocket2, "src\\test\\resources\\updateTest.json");
        MyJakarta mJUpdateExample = MyJakarta.readFromJson("src\\test\\resources\\updateTestExample.json");
        mJt = MyJakarta.readFromJson("src\\test\\resources\\updateTest.json");
        assertTrue(mJUpdateExample.getDescription().equals(mJt.getDescription()) && mJUpdateExample.getVersion().equals(mJt.getVersion()) &&
                mJUpdateExample.getTechnologies().containsAll(mJt.getTechnologies()));

    }

}

