package prompto.translate.eme;

import org.junit.Test;

import prompto.parser.e.BaseEParserTest;

public class TestWidget extends BaseEParserTest {

	@Test
	public void testMinimal() throws Exception {
		compareResourceEME("widget/minimal.pec");
	}

	@Test
	public void testNative() throws Exception {
		compareResourceEME("widget/native.pec");
	}

}

