// This program validates an email address based on basic formatting rules.
// It checks for required characters, correct positioning, and extracts username and domain if valid.

void main(){
    int conditionCheck = 0;
    String email = IO.readln("Enter your email address:");
    email = email.trim();
    boolean loop = true;

    while(loop){

        if (email.isEmpty()){
            IO.println("Email was not entered.");
            break;
        }
        conditionCheck++;

        if (!email.contains("@")){
            IO.println("Email must contain '@'.");
            break;
        }
        conditionCheck++;

        if (email.charAt(0) == '@' || email.charAt(email.length()-1) == '@'){
            IO.println("'@' cannot be the first or last character.");
            break;
        }
        conditionCheck++;

        if (!(email.substring(email.indexOf("@"), email.length()).contains("."))){
            IO.println("There must be at least one '.' after '@'.");
            break;
        }
        conditionCheck++;

        if (email.endsWith(".")){
            IO.println("Email cannot end with '.'.");
            break;
        }
        conditionCheck++;

        if (conditionCheck == 5){
            email = email.toUpperCase(Locale.ROOT);
            IO.println("Username: " + email.substring(0, email.indexOf("@")));
            IO.println("Domain: " + email.substring(email.indexOf("@"), email.length()));
            loop = false;
            break;
        }
    }
}