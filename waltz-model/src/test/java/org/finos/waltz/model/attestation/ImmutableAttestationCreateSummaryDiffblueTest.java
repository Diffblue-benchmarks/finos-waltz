package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCreateSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#entityCount(int)}.
   * <p>
   * Method under test: {@link Builder#entityCount(int)}
   */
  @Test
  @DisplayName("Test Builder entityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityCount(int)"})
  void testBuilderEntityCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityCount(3));
  }

  /**
   * Test Builder {@link Builder#from(AttestationCreateSummary)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build entityCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationCreateSummary)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationCreateSummary); given three; then builder build entityCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationCreateSummary)"})
  void testBuilderFrom_givenThree_thenBuilderBuildEntityCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();
    AttestationCreateSummary instance = mock(AttestationCreateSummary.class);
    when(instance.entityCount()).thenReturn(3);
    when(instance.instanceCount()).thenReturn(3);
    when(instance.recipientCount()).thenReturn(3L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityCount();
    verify(instance).instanceCount();
    verify(instance).recipientCount();
    ImmutableAttestationCreateSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.entityCount());
    assertEquals(3, buildResult.instanceCount());
    assertEquals(3L, buildResult.recipientCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instanceCount(int)}.
   * <p>
   * Method under test: {@link Builder#instanceCount(int)}
   */
  @Test
  @DisplayName("Test Builder instanceCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.instanceCount(int)"})
  void testBuilderInstanceCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceCount(3));
  }

  /**
   * Test Builder {@link Builder#recipientCount(long)}.
   * <p>
   * Method under test: {@link Builder#recipientCount(long)}
   */
  @Test
  @DisplayName("Test Builder recipientCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recipientCount(long)"})
  void testBuilderRecipientCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientCount(3L));
  }

  /**
   * Test Json {@link Json#entityCount()}.
   * <p>
   * Method under test: {@link Json#entityCount()}
   */
  @Test
  @DisplayName("Test Json entityCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.entityCount()"})
  void testJsonEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityCount());
  }

  /**
   * Test Json {@link Json#instanceCount()}.
   * <p>
   * Method under test: {@link Json#instanceCount()}
   */
  @Test
  @DisplayName("Test Json instanceCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.instanceCount()"})
  void testJsonInstanceCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).instanceCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0, actualJson.entityCount);
    assertEquals(0, actualJson.instanceCount);
    assertEquals(0L, actualJson.recipientCount);
    assertFalse(actualJson.entityCountIsSet);
    assertFalse(actualJson.instanceCountIsSet);
    assertFalse(actualJson.recipientCountIsSet);
  }

  /**
   * Test Json {@link Json#recipientCount()}.
   * <p>
   * Method under test: {@link Json#recipientCount()}
   */
  @Test
  @DisplayName("Test Json recipientCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.recipientCount()"})
  void testJsonRecipientCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recipientCount());
  }

  /**
   * Test Json {@link Json#setEntityCount(int)}.
   * <p>
   * Method under test: {@link Json#setEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setEntityCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setEntityCount(int)"})
  void testJsonSetEntityCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityCount(3);

    // Assert
    assertEquals(3, json.entityCount);
    assertTrue(json.entityCountIsSet);
  }

  /**
   * Test Json {@link Json#setInstanceCount(int)}.
   * <p>
   * Method under test: {@link Json#setInstanceCount(int)}
   */
  @Test
  @DisplayName("Test Json setInstanceCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setInstanceCount(int)"})
  void testJsonSetInstanceCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInstanceCount(3);

    // Assert
    assertEquals(3, json.instanceCount);
    assertTrue(json.instanceCountIsSet);
  }

  /**
   * Test Json {@link Json#setRecipientCount(long)}.
   * <p>
   * Method under test: {@link Json#setRecipientCount(long)}
   */
  @Test
  @DisplayName("Test Json setRecipientCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRecipientCount(long)"})
  void testJsonSetRecipientCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecipientCount(3L);

    // Assert
    assertEquals(3L, json.recipientCount);
    assertTrue(json.recipientCountIsSet);
  }
}
