public class countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ptr=0;
        int n=s.length();
        int lastCount=0;
        int totalCount=0;
        while(ptr<n){
            char c=s.charAt(ptr);
            int currentCount=0;
            while(ptr<n && s.charAt(ptr)==c){
                ptr++;
                currentCount++;
            }
            totalCount+=Math.min(currentCount,lastCount);
            lastCount=currentCount;
        }
        return totalCount;
    }
}
