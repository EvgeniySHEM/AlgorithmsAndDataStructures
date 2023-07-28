import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoverSegmentsWithDots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantitySegment = scanner.nextInt();
        Segment[] segments = new Segment[quantitySegment];
        for (int i = 0; i < quantitySegment; i++) {
            segments[i] = new Segment(scanner.nextLong(), scanner.nextLong());
        }
        Arrays.sort(segments, (e1, e2) -> Long.compare(e1.r, e2.r));

        long count = 1;
        List<Long> res = new ArrayList<>();
        res.add(segments[0].r);
        for (int i = 1; i < quantitySegment; i++) {
            if(segments[i].l > res.get(res.size() - 1)) {
                res.add(segments[i].r);
                count++;
            }
        }
        System.out.println(count);
        res.forEach(el -> System.out.print(el + " "));
    }

    private static class Segment{
        long l;
        long r;

        public Segment(long l, long r) {
            this.l = l;
            this.r = r;
        }
    }
}
