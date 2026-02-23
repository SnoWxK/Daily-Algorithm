public class hasAllCodes {
    public boolean hasAllCodes(String s,int k){
        int need = 1<<k;
        int mask=need-1;
        boolean[] got=new boolean[ need];
        int num=0;
        int count=0;

        for(int i=0;i<s.length();i++){
            num=((num<<1)&mask)|(s.charAt(i)-'0');
            if(i>=k-1){
                if(!got[num]){
                    got[num]=true;
                    count++;
                }
                if(count==need){
                    return true;
                }
            }
        }
        return false;
    }
}
