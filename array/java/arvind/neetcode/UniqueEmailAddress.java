package arvind.neetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(getSimplifiedEmail(email));
        }
        return set.size();
    }

    private String getSimplifiedEmail(String email) {
        String[] splittedEmail = email.split("@");
        String local = splittedEmail[0];
        String domain = splittedEmail[1];
        // remove everything after +
        local = local.split("\\+")[0].replaceAll("\\.", "");
        return local.concat("@").concat(domain);
    }

    public static void main(String[] args) {
        UniqueEmailAddress solution = new UniqueEmailAddress();
        String[] emails = new String[] {
                "test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"
        };
        int result = solution.numUniqueEmails(emails);
        System.out.println(result);
    }
}
