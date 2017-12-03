package org.pprp.core.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pprp.core.api.Painter;
import org.pprp.core.api.internal.OutputCanvas;
import org.pprp.core.api.internal.TechnicalPainter;
import org.pprp.core.api.model.BrushStroke;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Point;
import org.pprp.core.api.model.Stroke;
import org.pprp.core.impl.AbstractPainter;
import org.pprp.core.impl.BasePointImpl;
import org.pprp.core.impl.BrushStrokeImpl;
import org.pprp.core.impl.HueSaturationBrightness;
import org.pprp.core.impl.PainterFactory;
import org.pprp.core.impl.PhysicalPaletteImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicPainterTest {

    private Painter painter;

    private MockPainterEventListenerImpl mockPel = new MockPainterEventListenerImpl();

    private static final String MOCK_CANVAS = "mockCanvas";

    @BeforeEach
    void setUp() {

        painter = PainterFactory.createDefaultPainter(Arrays.asList(MOCK_CANVAS));

        // I need to setup the listeners before setting up the palette to not loose those events
        ((TechnicalPainter) painter).addPainterEventListener(mockPel);

        Palette palette = new PhysicalPaletteImpl();

        painter.setUpPalette(palette);
    }

    @Test
    void createABoxWithStrokesTest() {

        List<Stroke> boxStrokes = generateBoxStrokes();

        assertEquals(4,
                     boxStrokes.size());

        painter.paint(boxStrokes.parallelStream().toArray(Stroke[]::new));

        assertEquals(10,
                     mockPel.getEvents().size());

        OutputCanvas mock = ((AbstractPainter) painter).getInternalPainter().getOutputCanvasByName(MOCK_CANVAS);

        assertEquals(4,
                     mock.size());

        List<String> workQueue = ((AbstractPainter) painter).getInternalPainter().getWorkQueue();
        assertEquals(8,
                     workQueue.size());
        for (String cmd : workQueue) {
            System.out.println(">> CMD: " + cmd);
        }
    }

    private List<Stroke> generateBoxStrokes() {

        List<Stroke> boxStrokes = new ArrayList<>();
        // Left side of the box

        Point startPoint1 = new BasePointImpl(0,
                                              0);
        Point endPoint1 = new BasePointImpl(0,
                                            10);

        HueSaturationBrightness HSB = new HueSaturationBrightness(0,
                                                                  0,
                                                                  0);

        BrushStroke brushStroke1 = new BrushStrokeImpl(startPoint1,
                                                       endPoint1,
                                                       HSB);
        boxStrokes.add(brushStroke1);

        // bottom side of the box
        Point startPoint2 = new BasePointImpl(0,
                                              10);
        Point endPoint2 = new BasePointImpl(10,
                                            10);

        BrushStroke brushStroke2 = new BrushStrokeImpl(startPoint2,
                                                       endPoint2,
                                                       HSB);
        boxStrokes.add(brushStroke2);

        // right side of the box
        Point startPoint3 = new BasePointImpl(10,
                                              10);
        Point endPoint3 = new BasePointImpl(10,
                                            0);

        BrushStroke brushStroke3 = new BrushStrokeImpl(startPoint3,
                                                       endPoint3,
                                                       HSB);
        boxStrokes.add(brushStroke3);

        // top side of the box
        Point startPoint4 = new BasePointImpl(10,
                                              0);
        Point endPoint4 = new BasePointImpl(0,
                                            0);

        BrushStroke brushStroke4 = new BrushStrokeImpl(startPoint4,
                                                       endPoint4,
                                                       HSB);

        boxStrokes.add(brushStroke4);

        return boxStrokes;
    }
}
