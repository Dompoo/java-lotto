package lotto.io.writer;

public class ConsoleWriter implements Writer {
	
	@Override
	public void write(final String value) {
		System.out.print(value);
	}
}
