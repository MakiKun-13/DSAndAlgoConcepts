package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SmsSplitting {
    public static void main(String[] args) {
        System.out.println(segments("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus"));
    }
    public static List<String> segments(String message) {
        if(message.length()<=160)
            return new ArrayList<>(List.of(message));
        int segments;
        if(message.length()%155==0)
            segments = message.length()/155;
        else
            segments = message.length()/155 +1;
        List<String> resultList = new ArrayList<>();
        int endIndex;
        int startIndex = 0;
        for(int currSegment=1; currSegment<=segments; currSegment++) {
            String currStr = "";
            if(currSegment!=segments) {
                endIndex = startIndex + 154;
                if(message.charAt(endIndex) != ' ' && message.charAt(endIndex+1) != ' '){
                    while (message.charAt(endIndex) != ' ') {
                        endIndex--;
                    }
                }
                System.out.println("actual "+endIndex);
                currStr = message.substring(startIndex, endIndex+1);
                startIndex = endIndex+1;

            }
            else {
                currStr = message.substring(startIndex);
            }
            currStr = currStr + "(" + currSegment + "/" + segments + ")";
            resultList.add(currStr);
        }
        return resultList;
    }

}
