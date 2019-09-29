package cards.output;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class StdOutPrinterTest {

    @Mock
    PrintStream printStream;

    @InjectMocks
    StdOutPrinter stdOutPrinter;

    @Before
    public void setup() {
        stdOutPrinter = new StdOutPrinter(printStream);
        initMocks(this);
    }

    @Test
    public void test_DisplayBold() {
        stdOutPrinter.displayBold("");
        verify(printStream, times(3)).println(anyString());
    }

    @Test
    public void test_display() {
        stdOutPrinter.display("");
        verify(printStream, times(1)).println("");
    }

}