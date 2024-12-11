package com.satyendra.coding_practice.uber;

public class MatchNextCharacter {
    public static void main(String[] args) {
        MatchNextCharacter matchNextCharacter = new MatchNextCharacter();
        System.out.println(matchNextCharacter.verifyNextCharacter("ack", "bdl"));
        System.out.println(matchNextCharacter.verifyNextCharacter("ack", "cdl"));
        System.out.println(matchNextCharacter.verifyNextCharacter("ackz", "bdla"));
    }

    private boolean verifyNextCharacter(String a, String b) {
        for(int i = 0; i < a.length() ; i++) {

            if((a.charAt(i) - 'a' + 1) % 26 != b.charAt(i) - 'a') {
                return false;
            }
        }
        return true;
    }
}
