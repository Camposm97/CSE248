package util_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import util.StringUtils;

class StringUtilsTest {
	@Test
	void testEmitUsername() {
		String username = StringUtils.emitUsername("michael", "campos", "01174447");
		assertEquals("campM7", username);
	}
	
	@Test
	void testEmitPassword() {
		String password = StringUtils.emitPassword("michael", "campos", "01174447");
		assertEquals("CampM7", password);
	}
}
