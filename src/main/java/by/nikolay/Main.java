package by.nikolay;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JavaxJMS javaxJMS = new JavaxJMS("Javax JMS", "Этот пакет определяет Java Message Server (JMS) " +
                "API (Application Programming Interface). JMS API предоставляет для программ " +
                "Java распространенный способ создавать, отправлять, получать и " +
                "читать сообщения системы корпоративного обмена сообщениями.");

        JavaxServlet javaxServlet = new JavaxServlet("Javax Servlet", "Спецификация сервлетов определяет " +
                "набор программных интерфейсов для обслуживания HTTP-запросов." +
                " Она включает в себя спецификации JavaServer Pages." +
                "Спецификация сервлетов определяет набор программных интерфейсов для обслуживания HTTP-запросов. " +
                "Она включает в себя спецификации JavaServer Pages.");

        JavaxWebsocket javaxWebsocket = new JavaxWebsocket("Javax Websocket", "Спецификация Java API для " +
                "WebSocket определяет набор программных интерфейсов для обслуживания WebSocket-соединений.");

        MyJakarta myJakarta = new MyJakarta();
        myJakarta.setVersion("1.0");
        myJakarta.setDescription("Some description");
        myJakarta.addTechnology(javaxServlet, javaxWebsocket, javaxJMS);

        myJakarta.writeToJson("src\\main\\resources\\some.json");


        JavaxWebsocket javaxWebsocket2 = new JavaxWebsocket("Javax Websocket", "тупо для теста");


        MyJakarta jakarta = MyJakarta.readFromJson("src\\main\\resources\\some.json");
        System.out.println(jakarta);
        MyJakarta.updateTechnology(javaxWebsocket2, "src\\main\\resources\\some1.json");
        System.out.println(MyJakarta.readFromJson("src\\main\\resources\\some1.json"));
    }
}