package com.satyendra.coding_practice.oracle;

public class VersionCompare {
    public static void main(String[] args) {
        VersionCompare versionCompare = new VersionCompare();
        System.out.println(versionCompare.compareVersion("1.2", "1.10"));
    }
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split(".");
        String[] ver2 = version2.split(".");
        System.out.println("version1 :" +ver1.length);
        System.out.println("version2 :" +ver2.length);
        System.out.println("Inside :" +Math.max(ver1.length, ver2.length));
        for(int i = 0 ; i < Math.max(ver1.length, ver2.length); i++) {
            try {
                int firstV = Integer.parseInt((i < ver1.length) ? ver1[i].strip() : "0");
                int secondV = Integer.parseInt((i < ver2.length) ? ver2[i].strip() : "0");
                System.out.println("First : "+ firstV + " Second : "+ secondV);
                if(firstV > secondV) {
                    return 1;
                } else if(firstV < secondV) {
                    return -1;
                }
            } catch(Exception exception) {
                throw exception;
            }
        }
        return 0;
    }
}
