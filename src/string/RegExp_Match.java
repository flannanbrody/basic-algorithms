package string;

public class RegExp_Match {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a*b.";
        System.out.println(s1 + " : " + s2 + " : " + isRexMatch(s1, s2));

       String s3 = "a*b*.*";
        System.out.println(s2 + " : " + s3 + " full lenght match : " + isRexMatch1(s2, s3));
	}

    public static boolean isRexMatch(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s2.isEmpty()) return s2.isEmpty();    // "" , ""


        if (s2.length() == 1) {
            if (s2.charAt(0) == s1.charAt(0) || s2.charAt(0) == '.' || s2.charAt(0) == '*') {
                return true;
            } else
                return false;
        }

        if (s2.length() >= 2) {
            if (s2.charAt(1) != '*') {

                if (s1.charAt(0) == s2.charAt(0) || s2.charAt(0) == '.') {
                    if (s1.length() > 1)
                        return isRexMatch(s1.substring(1), s2.substring(1));
                    else
                        return true;
                } else
                    return false;
            } else { // s2.charAt(1) == '*'
                if ((s2.charAt(0) == '.') || (s1.charAt(0) == s2.charAt(0))) {

                    if (s1.length() == 1)
                        return true;
                    else if (s2.length() > 2)
                        return isRexMatch(s1, s2.substring(2)) || isRexMatch(s1.substring(1), s2.substring(2));
                    else //s2.length() == 2
                        return true;
                } else
                    return false;
            }
        }

        return isRexMatch(s1.substring(1), s2.substring(2));
    }

    public static boolean isRexMatch1(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s2.isEmpty()) return s2.isEmpty();    // "" , ""


        if (s2.length() == 1) {
            if ((s2.charAt(0) == s1.charAt(0) || s2.charAt(0) == '.') && (s1.length() == 1)) {
                return true;
            } else
                return false;
        }

        if (s2.length() >= 2) {
            if (s2.charAt(1) != '*') {

                if (s1.charAt(0) == s2.charAt(0) || s2.charAt(0) == '.') {
                    if (s1.length() > 1)
                        return isRexMatch1(s1.substring(1), s2.substring(1));
                    else
                        return false;
                } else
                    return false;
            } else { // s2.charAt(1) == '*'
                if ((s2.charAt(0) == '.') || (s1.charAt(0) == s2.charAt(0))) {

                    if (s1.length() == 1)
                        if (s2.length() == 2)
                            return true;
                        else
                            return false;
                    else // (s1.length() > 1)
                        if (s2.length() > 2)
                            return isRexMatch1(s1, s2.substring(2)) || isRexMatch1(s1.substring(1), s2.substring(2));
                        else // s2.length() == 2
                            return isRexMatch1(s1.substring(1), s2);


                } else
                    return false;
            }
        }

        return isRexMatch1(s1.substring(1), s2.substring(2));
    }
}
