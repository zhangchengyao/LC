import java.util.HashMap;
import java.util.Random;

public class LC535_EncodeAndDecodeTinyURL {
    private HashMap<String, String> long2short;
    private HashMap<String, String> short2long;
    private int len;
    private char[] dict;
    private String prefix;

    public LC535_EncodeAndDecodeTinyURL(){
        long2short = new HashMap<>();
        short2long = new HashMap<>();
        len = 6;
        dict = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        prefix = "http://tinyurl.com/";
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        String res = "";
        while(true){
            for(int i=0;i<len;i++){
                int idx = r.nextInt(dict.length);
                sb.append(dict[idx]);
            }
            if(!short2long.containsKey(sb.toString())){
                String shortUrl = sb.toString();
                long2short.put(longUrl, shortUrl);
                short2long.put(shortUrl, longUrl);
                res = prefix+shortUrl;
                break;
            }
        }
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = shortUrl.lastIndexOf('/');
        return short2long.get(shortUrl.substring(idx+1));
    }
}
