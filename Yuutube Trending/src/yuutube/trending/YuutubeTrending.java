
package yuutube.trending;


public class YuutubeTrending {

    
    public static void main(String[] args) {
        //the videos are stored in an array. Then, they are sorted using bubble sort according to total views.
        //The title of the first 5 videos with the highest views are displayed.
        int[] videos = {59,60,90,12,56};
        int[] array = trending(videos);
        System.out.println("-----Trending-----");
        for (int i=0;i<5;i++){
            System.out.print(i+1+". ");
            System.out.println(array[i]);
        }
    }
    
    public static int[] trending(int[] totalvids){
        for (int pass=1; pass<totalvids.length;pass++){
            for (int i=0;i<totalvids.length-1;i++){
                if (totalvids[i]<totalvids[i+1]){
                    int hold = totalvids[i];
                    totalvids[i]=totalvids[i+1];
                    totalvids[i+1]=hold;
                }
            }
        }
        return totalvids;
    }
    
    
}







