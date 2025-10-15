package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelKindStat.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelKindStat.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelKindStatDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLegalEntityRelKindStat Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat actualImmutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Assert
    assertEquals(1L, actualImmutableLegalEntityRelKindStat.relKindId());
    assertEquals(3, actualImmutableLegalEntityRelKindStat.legalEntityCount());
    assertEquals(3, actualImmutableLegalEntityRelKindStat.relationshipCount());
    assertEquals(3, actualImmutableLegalEntityRelKindStat.targetEntityCount());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelKindStat)}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelKindStat)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelKindStat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelKindStat)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();
    ImmutableLegalEntityRelKindStat instance =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelKindStat actualImmutableLegalEntityRelKindStat = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelKindStat);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#legalEntityCount(int)}.
   *
   * <p>Method under test: {@link Builder#legalEntityCount(int)}
   */
  @Test
  @DisplayName("Test Builder legalEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.legalEntityCount(int)"})
  void testBuilderLegalEntityCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act
    Builder actualLegalEntityCountResult = builderResult.legalEntityCount(3);

    // Assert
    assertSame(builderResult, actualLegalEntityCountResult);
  }

  /**
   * Test Builder {@link Builder#relKindId(long)}.
   *
   * <p>Method under test: {@link Builder#relKindId(long)}
   */
  @Test
  @DisplayName("Test Builder relKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relKindId(long)"})
  void testBuilderRelKindId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act
    Builder actualRelKindIdResult = builderResult.relKindId(1L);

    // Assert
    assertSame(builderResult, actualRelKindIdResult);
  }

  /**
   * Test Builder {@link Builder#relationshipCount(int)}.
   *
   * <p>Method under test: {@link Builder#relationshipCount(int)}
   */
  @Test
  @DisplayName("Test Builder relationshipCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipCount(int)"})
  void testBuilderRelationshipCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act
    Builder actualRelationshipCountResult = builderResult.relationshipCount(3);

    // Assert
    assertSame(builderResult, actualRelationshipCountResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityCount(int)}.
   *
   * <p>Method under test: {@link Builder#targetEntityCount(int)}
   */
  @Test
  @DisplayName("Test Builder targetEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityCount(int)"})
  void testBuilderTargetEntityCount() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelKindStat.builder();

    // Act
    Builder actualTargetEntityCountResult = builderResult.targetEntityCount(3);

    // Assert
    assertSame(builderResult, actualTargetEntityCountResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#copyOf(LegalEntityRelKindStat)}.
   *
   * <ul>
   *   <li>Then return relKindId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#copyOf(LegalEntityRelKindStat)}
   */
  @Test
  @DisplayName("Test copyOf(LegalEntityRelKindStat); then return relKindId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.copyOf(LegalEntityRelKindStat)"
  })
  void testCopyOf_thenReturnRelKindIdIsOne() {
    // Arrange
    ImmutableLegalEntityRelKindStat instance =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act
    ImmutableLegalEntityRelKindStat actualCopyOfResult =
        ImmutableLegalEntityRelKindStat.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.relKindId());
    assertEquals(3, actualCopyOfResult.legalEntityCount());
    assertEquals(3, actualCopyOfResult.relationshipCount());
    assertEquals(3, actualCopyOfResult.targetEntityCount());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}, and {@link
   * ImmutableLegalEntityRelKindStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelKindStat#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelKindStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat2 =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelKindStat, immutableLegalEntityRelKindStat2);
    assertEquals(
        immutableLegalEntityRelKindStat.hashCode(), immutableLegalEntityRelKindStat2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}, and {@link
   * ImmutableLegalEntityRelKindStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelKindStat#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelKindStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelKindStat, immutableLegalEntityRelKindStat);
    int expectedHashCodeResult = immutableLegalEntityRelKindStat.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelKindStat.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(1)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelKindStat,
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(2L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelKindStat,
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(1)
            .targetEntityCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelKindStat,
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelKindStat,
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelKindStat.equals(Object)",
    "int ImmutableLegalEntityRelKindStat.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build(),
        "Different type to ImmutableLegalEntityRelKindStat");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelKindStat#toString()}
   *   <li>{@link ImmutableLegalEntityRelKindStat#legalEntityCount()}
   *   <li>{@link ImmutableLegalEntityRelKindStat#relKindId()}
   *   <li>{@link ImmutableLegalEntityRelKindStat#relationshipCount()}
   *   <li>{@link ImmutableLegalEntityRelKindStat#targetEntityCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableLegalEntityRelKindStat.legalEntityCount()",
    "long ImmutableLegalEntityRelKindStat.relKindId()",
    "int ImmutableLegalEntityRelKindStat.relationshipCount()",
    "int ImmutableLegalEntityRelKindStat.targetEntityCount()",
    "String ImmutableLegalEntityRelKindStat.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act
    String actualToStringResult = immutableLegalEntityRelKindStat.toString();
    int actualLegalEntityCountResult = immutableLegalEntityRelKindStat.legalEntityCount();
    long actualRelKindIdResult = immutableLegalEntityRelKindStat.relKindId();
    int actualRelationshipCountResult = immutableLegalEntityRelKindStat.relationshipCount();

    // Assert
    assertEquals(
        "LegalEntityRelKindStat{relKindId=1, targetEntityCount=3, legalEntityCount=3, relationshipCount=3}",
        actualToStringResult);
    assertEquals(1L, actualRelKindIdResult);
    assertEquals(3, actualLegalEntityCountResult);
    assertEquals(3, actualRelationshipCountResult);
    assertEquals(3, immutableLegalEntityRelKindStat.targetEntityCount());
  }

  /**
   * Test Json {@link Json#legalEntityCount()}.
   *
   * <p>Method under test: {@link Json#legalEntityCount()}
   */
  @Test
  @DisplayName("Test Json legalEntityCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.legalEntityCount()"})
  void testJsonLegalEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().legalEntityCount());
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
    assertEquals(0, actualJson.legalEntityCount);
    assertEquals(0, actualJson.relationshipCount);
    assertEquals(0, actualJson.targetEntityCount);
    assertEquals(0L, actualJson.relKindId);
    assertFalse(actualJson.legalEntityCountIsSet);
    assertFalse(actualJson.relKindIdIsSet);
    assertFalse(actualJson.relationshipCountIsSet);
    assertFalse(actualJson.targetEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#relKindId()}.
   *
   * <p>Method under test: {@link Json#relKindId()}
   */
  @Test
  @DisplayName("Test Json relKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.relKindId()"})
  void testJsonRelKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relKindId());
  }

  /**
   * Test Json {@link Json#relationshipCount()}.
   *
   * <p>Method under test: {@link Json#relationshipCount()}
   */
  @Test
  @DisplayName("Test Json relationshipCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.relationshipCount()"})
  void testJsonRelationshipCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipCount());
  }

  /**
   * Test Json {@link Json#setLegalEntityCount(int)}.
   *
   * <p>Method under test: {@link Json#setLegalEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setLegalEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLegalEntityCount(int)"})
  void testJsonSetLegalEntityCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLegalEntityCount(3);

    // Assert
    assertEquals(3, json.legalEntityCount);
    assertTrue(json.legalEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#setRelKindId(long)}.
   *
   * <p>Method under test: {@link Json#setRelKindId(long)}
   */
  @Test
  @DisplayName("Test Json setRelKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRelKindId(long)"})
  void testJsonSetRelKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRelKindId(1L);

    // Assert
    assertEquals(1L, json.relKindId);
    assertTrue(json.relKindIdIsSet);
  }

  /**
   * Test Json {@link Json#setRelationshipCount(int)}.
   *
   * <p>Method under test: {@link Json#setRelationshipCount(int)}
   */
  @Test
  @DisplayName("Test Json setRelationshipCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRelationshipCount(int)"})
  void testJsonSetRelationshipCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRelationshipCount(3);

    // Assert
    assertEquals(3, json.relationshipCount);
    assertTrue(json.relationshipCountIsSet);
  }

  /**
   * Test Json {@link Json#setTargetEntityCount(int)}.
   *
   * <p>Method under test: {@link Json#setTargetEntityCount(int)}
   */
  @Test
  @DisplayName("Test Json setTargetEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTargetEntityCount(int)"})
  void testJsonSetTargetEntityCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTargetEntityCount(3);

    // Assert
    assertEquals(3, json.targetEntityCount);
    assertTrue(json.targetEntityCountIsSet);
  }

  /**
   * Test Json {@link Json#targetEntityCount()}.
   *
   * <p>Method under test: {@link Json#targetEntityCount()}
   */
  @Test
  @DisplayName("Test Json targetEntityCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.targetEntityCount()"})
  void testJsonTargetEntityCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityCount());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withLegalEntityCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withLegalEntityCount(int)}
   */
  @Test
  @DisplayName("Test withLegalEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withLegalEntityCount(int)"
  })
  void testWithLegalEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(42)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act
    ImmutableLegalEntityRelKindStat actualWithLegalEntityCountResult =
        immutableLegalEntityRelKindStat.withLegalEntityCount(42);

    // Assert
    assertSame(immutableLegalEntityRelKindStat, actualWithLegalEntityCountResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withLegalEntityCount(int)}.
   *
   * <ul>
   *   <li>Then return relKindId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withLegalEntityCount(int)}
   */
  @Test
  @DisplayName("Test withLegalEntityCount(int); then return relKindId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withLegalEntityCount(int)"
  })
  void testWithLegalEntityCount_thenReturnRelKindIdIsOne() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat actualWithLegalEntityCountResult =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build()
            .withLegalEntityCount(42);

    // Assert
    assertEquals(1L, actualWithLegalEntityCountResult.relKindId());
    assertEquals(3, actualWithLegalEntityCountResult.relationshipCount());
    assertEquals(3, actualWithLegalEntityCountResult.targetEntityCount());
    assertEquals(42, actualWithLegalEntityCountResult.legalEntityCount());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withRelKindId(long)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withRelKindId(long)}
   */
  @Test
  @DisplayName("Test withRelKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withRelKindId(long)"
  })
  void testWithRelKindId() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(42L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build();

    // Act
    ImmutableLegalEntityRelKindStat actualWithRelKindIdResult =
        immutableLegalEntityRelKindStat.withRelKindId(42L);

    // Assert
    assertSame(immutableLegalEntityRelKindStat, actualWithRelKindIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withRelKindId(long)}.
   *
   * <ul>
   *   <li>Then return legalEntityCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withRelKindId(long)}
   */
  @Test
  @DisplayName("Test withRelKindId(long); then return legalEntityCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withRelKindId(long)"
  })
  void testWithRelKindId_thenReturnLegalEntityCountIsThree() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat actualWithRelKindIdResult =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build()
            .withRelKindId(42L);

    // Assert
    assertEquals(3, actualWithRelKindIdResult.legalEntityCount());
    assertEquals(3, actualWithRelKindIdResult.relationshipCount());
    assertEquals(3, actualWithRelKindIdResult.targetEntityCount());
    assertEquals(42L, actualWithRelKindIdResult.relKindId());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withRelationshipCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withRelationshipCount(int)}
   */
  @Test
  @DisplayName("Test withRelationshipCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withRelationshipCount(int)"
  })
  void testWithRelationshipCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(42)
            .targetEntityCount(3)
            .build();

    // Act
    ImmutableLegalEntityRelKindStat actualWithRelationshipCountResult =
        immutableLegalEntityRelKindStat.withRelationshipCount(42);

    // Assert
    assertSame(immutableLegalEntityRelKindStat, actualWithRelationshipCountResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withRelationshipCount(int)}.
   *
   * <ul>
   *   <li>Then return relKindId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withRelationshipCount(int)}
   */
  @Test
  @DisplayName("Test withRelationshipCount(int); then return relKindId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withRelationshipCount(int)"
  })
  void testWithRelationshipCount_thenReturnRelKindIdIsOne() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat actualWithRelationshipCountResult =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build()
            .withRelationshipCount(42);

    // Assert
    assertEquals(1L, actualWithRelationshipCountResult.relKindId());
    assertEquals(3, actualWithRelationshipCountResult.legalEntityCount());
    assertEquals(3, actualWithRelationshipCountResult.targetEntityCount());
    assertEquals(42, actualWithRelationshipCountResult.relationshipCount());
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withTargetEntityCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withTargetEntityCount(int)}
   */
  @Test
  @DisplayName("Test withTargetEntityCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withTargetEntityCount(int)"
  })
  void testWithTargetEntityCount() {
    // Arrange
    ImmutableLegalEntityRelKindStat immutableLegalEntityRelKindStat =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(42)
            .build();

    // Act
    ImmutableLegalEntityRelKindStat actualWithTargetEntityCountResult =
        immutableLegalEntityRelKindStat.withTargetEntityCount(42);

    // Assert
    assertSame(immutableLegalEntityRelKindStat, actualWithTargetEntityCountResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelKindStat#withTargetEntityCount(int)}.
   *
   * <ul>
   *   <li>Then return relKindId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelKindStat#withTargetEntityCount(int)}
   */
  @Test
  @DisplayName("Test withTargetEntityCount(int); then return relKindId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelKindStat ImmutableLegalEntityRelKindStat.withTargetEntityCount(int)"
  })
  void testWithTargetEntityCount_thenReturnRelKindIdIsOne() {
    // Arrange and Act
    ImmutableLegalEntityRelKindStat actualWithTargetEntityCountResult =
        ImmutableLegalEntityRelKindStat.builder()
            .legalEntityCount(3)
            .relKindId(1L)
            .relationshipCount(3)
            .targetEntityCount(3)
            .build()
            .withTargetEntityCount(42);

    // Assert
    assertEquals(1L, actualWithTargetEntityCountResult.relKindId());
    assertEquals(3, actualWithTargetEntityCountResult.legalEntityCount());
    assertEquals(3, actualWithTargetEntityCountResult.relationshipCount());
    assertEquals(42, actualWithTargetEntityCountResult.targetEntityCount());
  }
}
