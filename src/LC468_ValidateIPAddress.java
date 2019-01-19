public class LC468_ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP.indexOf('.')>0) return checkIPv4(IP);
        else return checkIPv6(IP);
    }

    private String checkIPv4(String IP){
        String[] segments = IP.split("\\.");
        if(segments.length!=4 || IP.lastIndexOf('.')==IP.length()-1) return "Neither";
        for(int i=0;i<segments.length;i++){
            String num = segments[i];
            if( num.length()==0 || num.length()>3 ||
                    (num.length()>1 && num.charAt(0)=='0') ||
                    containNondigit(num) ||
                    Integer.parseInt(num)>255 || Integer.parseInt(num)<0 ) return "Neither";
        }
        return "IPv4";
    }

    private String checkIPv6(String IP){
        String[] segments = IP.split(":");
        if(segments.length!=8 || IP.lastIndexOf(':')==IP.length()-1) return "Neither";

        for(int i=0;i<segments.length;i++){
            String hex = segments[i];
            if(hex.length()>4 || hex.length()<1 || containOtherChars(hex) ) return "Neither";
        }

        return "IPv6";
    }

    private boolean containNondigit(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) return true;
        }
        return false;
    }

    private boolean containOtherChars(String str){
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if( (!Character.isDigit(str.charAt(i)) &&
                    !Character.isLetter(str.charAt(i))) ||
                    str.charAt(i)>'f' ) return true;
        }
        return false;
    }
}
