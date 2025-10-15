package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationCreateSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationCreateSummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationCreateSummary actualImmutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Assert
    assertEquals(3, actualImmutableAttestationCreateSummary.entityCount());
    assertEquals(3, actualImmutableAttestationCreateSummary.instanceCount());
    assertEquals(3L, actualImmutableAttestationCreateSummary.recipientCount());
  }

  /**
   * Test Builder {@link Builder#entityCount(int)}.
   *
   * <p>Method under test: {@link Builder#entityCount(int)}
   */
  @Test
  @DisplayName("Test Builder entityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityCount(int)"})
  void testBuilderEntityCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act
    Builder actualEntityCountResult = builderResult.entityCount(3);

    // Assert
    assertSame(builderResult, actualEntityCountResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationCreateSummary)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationCreateSummary)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationCreateSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationCreateSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();
    ImmutableAttestationCreateSummary instance =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationCreateSummary actualImmutableAttestationCreateSummary =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationCreateSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instanceCount(int)}.
   *
   * <p>Method under test: {@link Builder#instanceCount(int)}
   */
  @Test
  @DisplayName("Test Builder instanceCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.instanceCount(int)"})
  void testBuilderInstanceCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act
    Builder actualInstanceCountResult = builderResult.instanceCount(3);

    // Assert
    assertSame(builderResult, actualInstanceCountResult);
  }

  /**
   * Test Builder {@link Builder#recipientCount(long)}.
   *
   * <p>Method under test: {@link Builder#recipientCount(long)}
   */
  @Test
  @DisplayName("Test Builder recipientCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recipientCount(long)"})
  void testBuilderRecipientCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationCreateSummary.builder();

    // Act
    Builder actualRecipientCountResult = builderResult.recipientCount(3L);

    // Assert
    assertSame(builderResult, actualRecipientCountResult);
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#copyOf(AttestationCreateSummary)}.
   *
   * <ul>
   *   <li>Then return entityCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationCreateSummary#copyOf(AttestationCreateSummary)}
   */
  @Test
  @DisplayName("Test copyOf(AttestationCreateSummary); then return entityCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.copyOf(AttestationCreateSummary)"
  })
  void testCopyOf_thenReturnEntityCountIsThree() {
    // Arrange
    ImmutableAttestationCreateSummary instance =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act
    ImmutableAttestationCreateSummary actualCopyOfResult =
        ImmutableAttestationCreateSummary.copyOf(instance);

    // Assert
    assertEquals(3, actualCopyOfResult.entityCount());
    assertEquals(3, actualCopyOfResult.instanceCount());
    assertEquals(3L, actualCopyOfResult.recipientCount());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}, and {@link
   * ImmutableAttestationCreateSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCreateSummary#equals(Object)}
   *   <li>{@link ImmutableAttestationCreateSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary2 =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationCreateSummary, immutableAttestationCreateSummary2);
    assertEquals(
        immutableAttestationCreateSummary.hashCode(),
        immutableAttestationCreateSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}, and {@link
   * ImmutableAttestationCreateSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCreateSummary#equals(Object)}
   *   <li>{@link ImmutableAttestationCreateSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationCreateSummary, immutableAttestationCreateSummary);
    int expectedHashCodeResult = immutableAttestationCreateSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationCreateSummary.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(1)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationCreateSummary,
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(1)
            .recipientCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationCreateSummary,
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationCreateSummary,
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationCreateSummary.equals(Object)",
    "int ImmutableAttestationCreateSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build(),
        "Different type to ImmutableAttestationCreateSummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationCreateSummary#toString()}
   *   <li>{@link ImmutableAttestationCreateSummary#entityCount()}
   *   <li>{@link ImmutableAttestationCreateSummary#instanceCount()}
   *   <li>{@link ImmutableAttestationCreateSummary#recipientCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableAttestationCreateSummary.entityCount()",
    "int ImmutableAttestationCreateSummary.instanceCount()",
    "long ImmutableAttestationCreateSummary.recipientCount()",
    "String ImmutableAttestationCreateSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act
    String actualToStringResult = immutableAttestationCreateSummary.toString();
    int actualEntityCountResult = immutableAttestationCreateSummary.entityCount();
    int actualInstanceCountResult = immutableAttestationCreateSummary.instanceCount();

    // Assert
    assertEquals(
        "AttestationCreateSummary{entityCount=3, instanceCount=3, recipientCount=3}",
        actualToStringResult);
    assertEquals(3, actualEntityCountResult);
    assertEquals(3, actualInstanceCountResult);
    assertEquals(3L, immutableAttestationCreateSummary.recipientCount());
  }

  /**
   * Test Json {@link Json#entityCount()}.
   *
   * <p>Method under test: {@link Json#entityCount()}
   */
  @Test
  @DisplayName("Test Json entityCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.entityCount()"})
  void testJsonEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityCount());
  }

  /**
   * Test Json {@link Json#instanceCount()}.
   *
   * <p>Method under test: {@link Json#instanceCount()}
   */
  @Test
  @DisplayName("Test Json instanceCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.instanceCount()"})
  void testJsonInstanceCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().instanceCount());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#recipientCount()}
   */
  @Test
  @DisplayName("Test Json recipientCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.recipientCount()"})
  void testJsonRecipientCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recipientCount());
  }

  /**
   * Test Json {@link Json#setEntityCount(int)}.
   *
   * <p>Method under test: {@link Json#setEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setInstanceCount(int)}
   */
  @Test
  @DisplayName("Test Json setInstanceCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setRecipientCount(long)}
   */
  @Test
  @DisplayName("Test Json setRecipientCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableAttestationCreateSummary#withEntityCount(int)}.
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withEntityCount(int)}
   */
  @Test
  @DisplayName("Test withEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withEntityCount(int)"
  })
  void testWithEntityCount() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(42)
            .instanceCount(3)
            .recipientCount(3L)
            .build();

    // Act
    ImmutableAttestationCreateSummary actualWithEntityCountResult =
        immutableAttestationCreateSummary.withEntityCount(42);

    // Assert
    assertSame(immutableAttestationCreateSummary, actualWithEntityCountResult);
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#withEntityCount(int)}.
   *
   * <ul>
   *   <li>Then return instanceCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withEntityCount(int)}
   */
  @Test
  @DisplayName("Test withEntityCount(int); then return instanceCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withEntityCount(int)"
  })
  void testWithEntityCount_thenReturnInstanceCountIsThree() {
    // Arrange and Act
    ImmutableAttestationCreateSummary actualWithEntityCountResult =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build()
            .withEntityCount(42);

    // Assert
    assertEquals(3, actualWithEntityCountResult.instanceCount());
    assertEquals(3L, actualWithEntityCountResult.recipientCount());
    assertEquals(42, actualWithEntityCountResult.entityCount());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#withInstanceCount(int)}.
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withInstanceCount(int)}
   */
  @Test
  @DisplayName("Test withInstanceCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withInstanceCount(int)"
  })
  void testWithInstanceCount() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(42)
            .recipientCount(3L)
            .build();

    // Act
    ImmutableAttestationCreateSummary actualWithInstanceCountResult =
        immutableAttestationCreateSummary.withInstanceCount(42);

    // Assert
    assertSame(immutableAttestationCreateSummary, actualWithInstanceCountResult);
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#withInstanceCount(int)}.
   *
   * <ul>
   *   <li>Then return entityCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withInstanceCount(int)}
   */
  @Test
  @DisplayName("Test withInstanceCount(int); then return entityCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withInstanceCount(int)"
  })
  void testWithInstanceCount_thenReturnEntityCountIsThree() {
    // Arrange and Act
    ImmutableAttestationCreateSummary actualWithInstanceCountResult =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build()
            .withInstanceCount(42);

    // Assert
    assertEquals(3, actualWithInstanceCountResult.entityCount());
    assertEquals(3L, actualWithInstanceCountResult.recipientCount());
    assertEquals(42, actualWithInstanceCountResult.instanceCount());
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#withRecipientCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withRecipientCount(long)}
   */
  @Test
  @DisplayName("Test withRecipientCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withRecipientCount(long)"
  })
  void testWithRecipientCount() {
    // Arrange
    ImmutableAttestationCreateSummary immutableAttestationCreateSummary =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(42L)
            .build();

    // Act
    ImmutableAttestationCreateSummary actualWithRecipientCountResult =
        immutableAttestationCreateSummary.withRecipientCount(42L);

    // Assert
    assertSame(immutableAttestationCreateSummary, actualWithRecipientCountResult);
  }

  /**
   * Test {@link ImmutableAttestationCreateSummary#withRecipientCount(long)}.
   *
   * <ul>
   *   <li>Then return entityCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationCreateSummary#withRecipientCount(long)}
   */
  @Test
  @DisplayName("Test withRecipientCount(long); then return entityCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationCreateSummary ImmutableAttestationCreateSummary.withRecipientCount(long)"
  })
  void testWithRecipientCount_thenReturnEntityCountIsThree() {
    // Arrange and Act
    ImmutableAttestationCreateSummary actualWithRecipientCountResult =
        ImmutableAttestationCreateSummary.builder()
            .entityCount(3)
            .instanceCount(3)
            .recipientCount(3L)
            .build()
            .withRecipientCount(42L);

    // Assert
    assertEquals(3, actualWithRecipientCountResult.entityCount());
    assertEquals(3, actualWithRecipientCountResult.instanceCount());
    assertEquals(42L, actualWithRecipientCountResult.recipientCount());
  }
}
