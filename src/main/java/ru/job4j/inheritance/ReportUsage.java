package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport reportH = new HtmlReport();
        System.out.println(reportH.generate("Report's name", "Report's body"));

        JSONReport reportJSON = new JSONReport();
        System.out.println(reportJSON.generate("\"name\"", "\"body\""));
    }
}
