package org.pprp.core.api.internal.gcode;

import org.pprp.core.api.model.Color;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Point;
import org.pprp.core.api.model.Stroke;

public class GCodeUtil {

    public static final String LINE_BREAK = "\n\r";

    public static String generateGCodeForStroke(Stroke stroke) {
        StringBuffer gcodeBuffer = new StringBuffer();
        // set moving speed
        gcodeBuffer.append("G0 F3000").append(LINE_BREAK);
        //Go to start point
        gcodeBuffer.append("G0 X").append(stroke.getStartPoint().getX()).append(" Y").append(stroke.getStartPoint().getY()).append(LINE_BREAK);
        //Put down the brush
        gcodeBuffer.append("G0 Z").append("0").append(LINE_BREAK);
        // change speed to paint
        gcodeBuffer.append("G0 F1000").append(LINE_BREAK);
        // Paint to the end point
        gcodeBuffer.append("G0 X").append(stroke.getEndPoint().getX()).append(" Y").append(stroke.getEndPoint().getY()).append(LINE_BREAK);
        return gcodeBuffer.toString();
    }

    public static String generateGCodeForPickColor(Palette palette,
                                                   Color color) {
        Point colorPoint = palette.getColorPoint(color);
        StringBuffer gcodeBuffer = new StringBuffer();
        //Set speed
        gcodeBuffer.append("G0 F3000").append(LINE_BREAK);
        //put down brush to paint level inside a bucket
        gcodeBuffer.append("G0 Z18").append(LINE_BREAK);
        //move 5 units inside the bucket to pick paint at level 14
        gcodeBuffer.append("G0 Y").append(colorPoint.getY() + 5).append(" Z14").append(LINE_BREAK);

        //move 10 units inside the bucket to pick paint at level 18
        gcodeBuffer.append("G0 Y").append(colorPoint.getY() + 10).append(" Z18").append(LINE_BREAK);

        //change speed to move
        gcodeBuffer.append("G0 F10000").append(LINE_BREAK);

        //go back to initial position at level 45
        gcodeBuffer.append("G0 Y").append(colorPoint.getY()).append(LINE_BREAK);

        return gcodeBuffer.toString();
    }

    public static String generateGCodeForInitPPRP() {
        StringBuffer gcodeBuffer = new StringBuffer();
        //Init code for callibration
        gcodeBuffer.append("G21 G90").append(LINE_BREAK);
        gcodeBuffer.append("G92 Z0").append(LINE_BREAK);
        gcodeBuffer.append("G0 Z40").append(LINE_BREAK);
        gcodeBuffer.append("G28").append(LINE_BREAK);
        gcodeBuffer.append("G20 Y80").append(LINE_BREAK);
        gcodeBuffer.append("G0 F10000").append(LINE_BREAK);
        return gcodeBuffer.toString();
    }
}
