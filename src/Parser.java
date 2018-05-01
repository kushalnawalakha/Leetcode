import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Record {
    public static HashSet<String> keySet = new HashSet();
    private HashMap<String, String> values = new HashMap();

    public void add(String key, String value) {
        String prev = values.get(key);
        values.put(key, (prev == null ? "" : prev + " ") + value.trim());
    }

    public String print(List<String> order) {
        StringBuilder b = new StringBuilder();
        for (String element : order) {
            b.append(values.getOrDefault(element, "") + "|");
        }
        return b.toString().substring(0, b.length() - 1);
    }
}

public class Parser {
    private static String extractKey(String str) {
        StringBuilder b = new StringBuilder();
        int i = 0;
        while ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || str.charAt(i) == '/') {
            b.append(str.charAt(i));
            i++;
        }
        if (b.length() == 0 || i == str.length() || str.charAt(i) != ':') {
            return null;
        }
        return b.toString();
    }

    private static boolean isDate(String str) {
        return str.matches("[A-Z] [A-Z] [A-Z] {3}.*");
    }

    public static void main(String args[]) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Record currentRecord = new Record();
        List<Record> records = new ArrayList();
        String key = null;
        String value = null;
        String dateString = "DATE";
        String date = null;
        while (true) {
            String text = br.readLine();
            if (text == null) {
                if (date != null)
                    currentRecord.add(dateString, date);
                records.add(currentRecord);
                break;
            }
            if (text.equals("")) {
                if (date != null)
                    currentRecord.add(dateString, date);
                records.add(currentRecord);
                currentRecord = new Record();

                key = null;
                continue;
            }
            if (isDate(text)) {
                date = text;
            } else {
                String currentKey = extractKey(text);
                if (currentKey != null) {
                    key = currentKey;
                    value = text.substring(key.length() + 1);
                } else {
                    value = text;
                }
                Record.keySet.add(key);
                currentRecord.add(key, value);
            }
        }

        List<String> order = new ArrayList<>();
        for (String element : Record.keySet) {
            order.add(element);
        }
        Collections.sort(order);
        order.add(dateString);
        StringBuilder elements = new StringBuilder();
        for (String element : order) {
            elements.append(element + "|");
        }
        if (elements.length() > 0)
            System.out.println(elements.substring(0, elements.length() - 1));
        for (Record record : records) {
            System.out.println(record.print(order));
        }
    }
}