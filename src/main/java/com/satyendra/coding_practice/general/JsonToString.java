package general;

import java.util.*;

public class JsonToString {
    public static void main(String[] args) {
        Boolean test1 = Boolean.FALSE;
        System.out.println(convert(test1));
        List<String> test2 = new ArrayList<>();
        test2.add("bh");
        test2.add("jkg");
        System.out.println(test2);
        Employee employee = new Employee("Sattu");
        System.out.println(convert(employee));

        String test3 = new String("my \"name\" is sattu");
        System.out.println(convert(test3));

        String test4 = new String("\"\"");
        System.out.println(convert(test4));

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        System.out.println(convert(map));
    }

    private static String convert(Object value) {
        String result = "";
        if (value instanceof Boolean) {
            result += (Boolean) value;
        } else if(value instanceof String) {
            String s = (String) value;
            String[] list = s.split("\"");
            for(int i =0 ; i <list.length;i++) {
                if(i % 2 != 0) {
                    result += ("\\\"" + list[i] + "\\\"");
                } else {
                    result += list[i];
                }
            }
        }
        else if (value instanceof Collection) {
            result += (Collection)value;
        } else if (value instanceof Map){
            result += (Map<String, Object>)value;
        }
        return result;
    }
}


class Employee {
    private String name;
    Employee(String name) {
        this.name = name;
    }
}

