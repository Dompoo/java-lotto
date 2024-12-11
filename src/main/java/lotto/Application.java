package lotto;

import lotto.common.RetryHandler;
import lotto.common.exception.ExceptionHandler;
import lotto.controller.LottoController;
import lotto.io.input.InputHandler;
import lotto.io.input.InputParser;
import lotto.io.input.InputValidator;
import lotto.io.output.OutputHandler;
import lotto.io.output.OutputParser;
import lotto.io.reader.ConsoleReader;
import lotto.io.writer.ConsoleWriter;
import lotto.io.writer.Writer;
import lotto.service.numberPicker.RandomNumberPicker;

public class Application {
    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        new LottoController(
                new InputHandler(new ConsoleReader(), writer, new InputValidator(), new InputParser()),
                new OutputHandler(writer, new OutputParser()),
                new RetryHandler(new ExceptionHandler(writer)),
                new RandomNumberPicker()
        ).run();
    }
}
