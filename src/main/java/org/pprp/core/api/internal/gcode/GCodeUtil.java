package org.pprp.core.api.internal.gcode;

import org.pprp.core.api.model.Stroke;

public class GCodeUtil {

    private static final String LINE_BREAK = "\n\r";

    public static String generateGCodeForStroke(Stroke stroke) {
        StringBuffer gcodeBuffer = new StringBuffer();
        //Go to start point
        gcodeBuffer.append("G0 F3000").append(LINE_BREAK);
        gcodeBuffer.append("G0 X").append(stroke.getStartPoint().getX()).append(" Y").append(stroke.getStartPoint().getY()).append(LINE_BREAK);
        //Put down the brush
        gcodeBuffer.append("G0 Z").append("0").append(LINE_BREAK);
        // Paint to the end point
        gcodeBuffer.append("G0 F1000").append(LINE_BREAK);
        gcodeBuffer.append("G0 X").append(stroke.getEndPoint().getX()).append(" Y").append(stroke.getEndPoint().getY()).append(LINE_BREAK);
        return gcodeBuffer.toString();
    }
}
