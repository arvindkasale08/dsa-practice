package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyUrl {

    private Map<String, String> encodeMap = new HashMap<>();

    private Map<String, String> decodeMap = new HashMap<>();

    private static Integer count = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        encodeMap.put(longUrl, count+"");
        decodeMap.put(count+"", longUrl);
        count++;
        return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        EncodeDecodeTinyUrl solution = new EncodeDecodeTinyUrl();
        String encodedUrl = solution.encode(url);
        System.out.println(encodedUrl);
        String decodedUrl = solution.decode(encodedUrl);
        System.out.println(decodedUrl);
    }
}
