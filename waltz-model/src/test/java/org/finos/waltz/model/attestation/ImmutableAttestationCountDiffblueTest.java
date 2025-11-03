package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationCount.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCountDiffblueTest {
  /**
   * Test Builder {@link Builder#count(Integer)}.
   * <p>
   * Method under test: {@link Builder#count(Integer)}
   */
  @Test
  @DisplayName("Test Builder count(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(Integer)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#from(AttestationCount)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationCount)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationCount); given three; then builder build key is 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationCount)"})
  void testBuilderFrom_givenThree_thenBuilderBuildKeyIsKey() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();
    AttestationCount instance = mock(AttestationCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.key()).thenReturn("Key");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).key();
    ImmutableAttestationCount buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals(3, buildResult.count().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationCount)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationCount)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationCount); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationCount)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();
    AttestationCount instance = mock(AttestationCount.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).key();
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   * <p>
   * Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableAttestationCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCount(Integer)}
   *   <li>{@link Json#setKey(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCount(Integer)", "void Json.setKey(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCount(3);
    actualJson.setKey("Key");

    // Assert
    assertEquals(3, actualJson.count.intValue());
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
  }
}
