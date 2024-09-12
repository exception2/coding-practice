package general;

import java.util.*;

class NestedInteger {
    Integer value;
    List<NestedInteger> list;
    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.value = value;
        this.list = new ArrayList<>();
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
    }

    public void add(NestedInteger ni) {
        list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

class MiniParser {
    // "[123,[456,[789]]]"
    public NestedInteger deserialize(String s) {
//        if(s.charAt(0) != '[') {
//            return new general.NestedInteger(Integer.parseInt(s));
//        } else {
//            general.NestedInteger ni = new general.NestedInteger();
//            fun2(ni, s);
//            return ni;
//        }
        return fun3(s);
    }

    NestedInteger fun3(String s) {
        Stack<Object> stack = new Stack<>();
        //System.out.println("Length : " + s.length());
        //System.out.println("Last character : " + s.charAt(16));
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                stack.add(s.charAt(i++));
            } else if (s.charAt(i) == ']') {
                //System.out.println("came to merge");
                NestedInteger ni = new NestedInteger();
                List<NestedInteger> list = new ArrayList<>();
                while(!stack.isEmpty()) {
                    Object element = stack.pop();
                    if(element instanceof NestedInteger) {
                        list.add((NestedInteger) element);
                    } else {
                        break;
                    }
                }
                Collections.reverse(list);
                for(NestedInteger nni : list) {
                    ni.add(nni);
                }
                stack.add(ni);
                i++;
            } else if (s.charAt(i) == '-') {
                String num = "";
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                int n = Integer.parseInt(num);
                stack.add(new NestedInteger(-n));
            } else if (Character.isDigit(s.charAt(i))) {
                String num = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                int n = Integer.parseInt(num);
                stack.add(new NestedInteger(n));
            } else {
                i++;
            }
        }
        return (NestedInteger)stack.pop();
    }

    void fun2(NestedInteger ni, String s) {
        String[] arr = s.substring(1, s.length()-1).trim().split(",");
        for(int i = 0 ;i < arr.length ; i++) {
            boolean isNumber = arr[i].matches("\\d+");
            if(isNumber) {
                ni.add(new NestedInteger(Integer.parseInt(arr[i])));
            } else {
                NestedInteger nni = new NestedInteger();
                ni.add(nni);
                fun2(nni, arr[i]);
            }
        }
    }
//    general.NestedInteger fun(String s, int i, int len, general.NestedInteger ni) {
//        if (i == len) {
//            return ni;
//        }
//
//        if (s.charAt(i) == '[') {
//            general.NestedInteger nni = new general.NestedInteger();
//            ni.add(nni);
//            return fun(s, i + 1, len, nni);
//        }
//        else if (s.charAt(i) == '-') {
//            String num = "";
//            i++;
//            while (i < len && Character.isDigit(s.charAt(i))) {
//                num += s.charAt(i);
//                i++;
//            }
//            int n = Integer.parseInt(num);
//            general.NestedInteger nii = new general.NestedInteger(-n);
//            ni.add(nii);
//            return fun(s, i, len, ni);
//        } else if (Character.isDigit(s.charAt(i))) {
//            String num = "";
//            while (i < len && Character.isDigit(s.charAt(i))) {
//                num += s.charAt(i);
//                i++;
//            }
//            int n = Integer.parseInt(num);
//            general.NestedInteger nii = new general.NestedInteger(n);
//            ni.add(nii);
//            return fun(s, i, len, ni);
//        } else {
//            return fun(s, i + 1, len, ni);
//        }
//    }
public static void main(String[] args) {
    MiniParser miniParser = new MiniParser();
    miniParser.deserialize("[123,[456,[789]]]");
}
}
