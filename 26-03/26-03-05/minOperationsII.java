public class minOperationsII {
    public int minOperations(String s) {
        StringBuilder sb1=new StringBuilder();
        sb1.append("0");
        for(int i=0;i<s.length()-1;i++){
            if(sb1.charAt(i)=='0'){
                sb1.append("1");
            }else{
                sb1.append("0");
            }
        }
        StringBuilder sb2=new StringBuilder();
        sb2.append("1");
        for(int i=0;i<s.length()-1;i++){
            if(sb2.charAt(i)=='0'){
                sb2.append("1");
            }else{
                sb2.append("0");
            }
        }
        int count1=0;
        int count2=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=sb1.charAt(i)){
                count1++;
            }
            if(s.charAt(i)!=sb2.charAt(i)){
                count2++;
            }
        }
        return Math.min(count1,count2);
    }
}
