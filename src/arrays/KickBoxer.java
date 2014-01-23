package arrays;

/*************************************************************************
 *  Compilation:  javac KickBoxer.java
 *  Execution:    java KickBoxer w
 *  
 *  Reads in the weight w of a Thai kickboxer, and prints out their
 *  kickboxing category (fly weight - super heavyweight).
 *
 *  Reference: http://www.elitekickboxing.com/competitioninfo3.asp
 *
 *  % java KickBoxer 144
 *  Welter Weight
 *
 *  % java KickBoxer 300
 *  Super Heavy Weight
 *
 *  % java KickBoxer 111
 *  Fly Weight
 *
 *  % java KickBoxer 112
 *  Super Fly Weight
 *
 *************************************************************************/


public class KickBoxer {
    public static void main(String[] args) { 
        int w = Integer.parseInt("156");
        int[] weights = { 112, 115, 118, 122, 126, 130, 135, 140, 147,
                          154, 160, 167, 174, 183, 189, 198, 209, 9999 };

        String[] categories = { "Fly Weight",
                                "Super Fly Weight",
                                "Bantam Weight",
                                "Super Bantam Weight",
                                "Feather Weight",
                                "Super Feather Weight",
                                "Light Weight",
                                "Super Light Weight",
                                "Welter Weight",
                                "Super Welter Weight",
                                "Middle Weight",
                                "Super Middle Weight",
                                "Light Heavy Weight",
                                "Super Light Heavy Weight",
                                "Cruiser Weight",
                                "Super Cruiser Weight",
                                "Heavy Weight",
                                "Super Heavy Weight"
                              };

        for (int i = 0; i < weights.length; i++) {
            if (w < weights[i]) {
                System.out.println(categories[i]);
                break;
            }
        }
    }

}

