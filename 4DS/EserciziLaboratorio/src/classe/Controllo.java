package classe;
import java.util.regex.*;

public class Controllo {

        private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        private static final String CAR_PLATE_PATTERN = "^[A-Z]{2}-[0-9]{3}-[A-Z]{2}$";
        private static final String CAP = "^[0-9]{5}$";
        private static final String IP_ADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        private static final String URL_PATTERN = "^(https?|ftp)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?$";
        private static final String TAX_CODE_PATTERN = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";

        public static boolean validateEmail(String email) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        public static boolean validatePassword(String password) {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }

        public static boolean validateTarga(String carPlate) {
            Pattern pattern = Pattern.compile(CAR_PLATE_PATTERN);
            Matcher matcher = pattern.matcher(carPlate);
            return matcher.matches();
        }

        public static boolean validateCap(String zipCode) {
            Pattern pattern = Pattern.compile(CAP);
            Matcher matcher = pattern.matcher(zipCode);
            return matcher.matches();
        }

        public static boolean validateIpAddress(String ipAddress) {
            Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN);
            Matcher matcher = pattern.matcher(ipAddress);
            return matcher.matches();
        }

        public static boolean validateUrl(String url) {
            Pattern pattern = Pattern.compile(URL_PATTERN);
            Matcher matcher = pattern.matcher(url);
            return matcher.matches();
        }

        public static boolean validateCodiceFiscale(String taxCode) {
            Pattern pattern = Pattern.compile(TAX_CODE_PATTERN);
            Matcher matcher = pattern.matcher(taxCode);
            return matcher.matches();
        }
}
