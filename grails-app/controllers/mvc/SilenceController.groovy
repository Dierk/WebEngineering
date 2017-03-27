package mvc

class SilenceController {

    static int segmentCount = 100
    static int radius = 200
    static int cx = radius
    static int cy = radius


    def index() {
        def lines = []
        for(int i; i<segmentCount; i++) {
            lines.add([
                        x1: xValueOf(i),
                        y1: yValueOf(i),
                        x2: xValueOf(i * 2),
                        y2: yValueOf(i * 2)
                    ])
        }
        render view:"show", model:[lines: lines]
    }

    private static double arc(int segment) {
        2 * Math.PI * segment / segmentCount
    }
    def xValueOf(int segment) {
        return cx + Math.cos(arc(segment)) * radius
    }
    def yValueOf(int segment) {
        return cy + Math.sin(arc(segment)) * radius
    }
}
