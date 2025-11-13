package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse.Builder;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSyncRecipientsResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSyncRecipientsResponse Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSyncRecipientsResponse actualImmutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Assert
    assertEquals(3L, actualImmutableSyncRecipientsResponse.recipientsCreatedCount().longValue());
    assertEquals(3L, actualImmutableSyncRecipientsResponse.recipientsRemovedCount().longValue());
  }

  /**
   * Test Builder {@link Builder#from(SyncRecipientsResponse)}.
   *
   * <p>Method under test: {@link Builder#from(SyncRecipientsResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SyncRecipientsResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SyncRecipientsResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();
    ImmutableSyncRecipientsResponse instance =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSyncRecipientsResponse actualImmutableSyncRecipientsResponse = builderResult.build();
    assertEquals(instance, actualImmutableSyncRecipientsResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#recipientsCreatedCount(Long)}.
   *
   * <p>Method under test: {@link Builder#recipientsCreatedCount(Long)}
   */
  @Test
  @DisplayName("Test Builder recipientsCreatedCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recipientsCreatedCount(Long)"})
  void testBuilderRecipientsCreatedCount() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act
    Builder actualRecipientsCreatedCountResult = builderResult.recipientsCreatedCount(3L);

    // Assert
    assertSame(builderResult, actualRecipientsCreatedCountResult);
  }

  /**
   * Test Builder {@link Builder#recipientsRemovedCount(Long)}.
   *
   * <p>Method under test: {@link Builder#recipientsRemovedCount(Long)}
   */
  @Test
  @DisplayName("Test Builder recipientsRemovedCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recipientsRemovedCount(Long)"})
  void testBuilderRecipientsRemovedCount() {
    // Arrange
    Builder builderResult = ImmutableSyncRecipientsResponse.builder();

    // Act
    Builder actualRecipientsRemovedCountResult = builderResult.recipientsRemovedCount(3L);

    // Assert
    assertSame(builderResult, actualRecipientsRemovedCountResult);
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#copyOf(SyncRecipientsResponse)}.
   *
   * <ul>
   *   <li>Then return recipientsCreatedCount longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#copyOf(SyncRecipientsResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SyncRecipientsResponse); then return recipientsCreatedCount longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.copyOf(SyncRecipientsResponse)"
  })
  void testCopyOf_thenReturnRecipientsCreatedCountLongValueIsThree() {
    // Arrange
    ImmutableSyncRecipientsResponse instance =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act
    ImmutableSyncRecipientsResponse actualCopyOfResult =
        ImmutableSyncRecipientsResponse.copyOf(instance);

    // Assert
    assertEquals(3L, actualCopyOfResult.recipientsCreatedCount().longValue());
    assertEquals(3L, actualCopyOfResult.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}, and {@link
   * ImmutableSyncRecipientsResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSyncRecipientsResponse#equals(Object)}
   *   <li>{@link ImmutableSyncRecipientsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse2 =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableSyncRecipientsResponse, immutableSyncRecipientsResponse2);
    assertEquals(
        immutableSyncRecipientsResponse.hashCode(), immutableSyncRecipientsResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}, and {@link
   * ImmutableSyncRecipientsResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSyncRecipientsResponse#equals(Object)}
   *   <li>{@link ImmutableSyncRecipientsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableSyncRecipientsResponse, immutableSyncRecipientsResponse);
    int expectedHashCodeResult = immutableSyncRecipientsResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableSyncRecipientsResponse.hashCode());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(1L)
            .recipientsRemovedCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSyncRecipientsResponse,
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSyncRecipientsResponse,
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSyncRecipientsResponse.equals(Object)",
    "int ImmutableSyncRecipientsResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build(),
        "Different type to ImmutableSyncRecipientsResponse");
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return recipientsCreatedCount longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return recipientsCreatedCount longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.fromJson(Json)"
  })
  void testFromJson_thenReturnRecipientsCreatedCountLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setRecipientsCreatedCount(1L);
    json.setRecipientsRemovedCount(1L);

    // Act
    ImmutableSyncRecipientsResponse actualFromJsonResult =
        ImmutableSyncRecipientsResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.recipientsCreatedCount().longValue());
    assertEquals(1L, actualFromJsonResult.recipientsRemovedCount().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSyncRecipientsResponse#toString()}
   *   <li>{@link ImmutableSyncRecipientsResponse#recipientsCreatedCount()}
   *   <li>{@link ImmutableSyncRecipientsResponse#recipientsRemovedCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableSyncRecipientsResponse.recipientsCreatedCount()",
    "Long ImmutableSyncRecipientsResponse.recipientsRemovedCount()",
    "String ImmutableSyncRecipientsResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act
    String actualToStringResult = immutableSyncRecipientsResponse.toString();
    Long actualRecipientsCreatedCountResult =
        immutableSyncRecipientsResponse.recipientsCreatedCount();
    Long actualRecipientsRemovedCountResult =
        immutableSyncRecipientsResponse.recipientsRemovedCount();

    // Assert
    assertEquals(
        "SyncRecipientsResponse{recipientsCreatedCount=3, recipientsRemovedCount=3}",
        actualToStringResult);
    assertEquals(3L, actualRecipientsCreatedCountResult.longValue());
    assertEquals(3L, actualRecipientsRemovedCountResult.longValue());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRecipientsCreatedCount(Long)}
   *   <li>{@link Json#setRecipientsRemovedCount(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setRecipientsCreatedCount(Long)",
    "void Json.setRecipientsRemovedCount(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRecipientsCreatedCount(3L);
    actualJson.setRecipientsRemovedCount(3L);

    // Assert
    assertEquals(3L, actualJson.recipientsCreatedCount.longValue());
    assertEquals(3L, actualJson.recipientsRemovedCount.longValue());
  }

  /**
   * Test Json {@link Json#recipientsCreatedCount()}.
   *
   * <p>Method under test: {@link Json#recipientsCreatedCount()}
   */
  @Test
  @DisplayName("Test Json recipientsCreatedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.recipientsCreatedCount()"})
  void testJsonRecipientsCreatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recipientsCreatedCount());
  }

  /**
   * Test Json {@link Json#recipientsRemovedCount()}.
   *
   * <p>Method under test: {@link Json#recipientsRemovedCount()}
   */
  @Test
  @DisplayName("Test Json recipientsRemovedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.recipientsRemovedCount()"})
  void testJsonRecipientsRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recipientsRemovedCount());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#withRecipientsCreatedCount(Long)}.
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#withRecipientsCreatedCount(Long)}
   */
  @Test
  @DisplayName("Test withRecipientsCreatedCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.withRecipientsCreatedCount(Long)"
  })
  void testWithRecipientsCreatedCount() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act
    ImmutableSyncRecipientsResponse actualWithRecipientsCreatedCountResult =
        immutableSyncRecipientsResponse.withRecipientsCreatedCount(3L);

    // Assert
    assertSame(immutableSyncRecipientsResponse, actualWithRecipientsCreatedCountResult);
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#withRecipientsCreatedCount(Long)}.
   *
   * <ul>
   *   <li>Then return recipientsRemovedCount longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#withRecipientsCreatedCount(Long)}
   */
  @Test
  @DisplayName(
      "Test withRecipientsCreatedCount(Long); then return recipientsRemovedCount longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.withRecipientsCreatedCount(Long)"
  })
  void testWithRecipientsCreatedCount_thenReturnRecipientsRemovedCountLongValueIsThree() {
    // Arrange and Act
    ImmutableSyncRecipientsResponse actualWithRecipientsCreatedCountResult =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build()
            .withRecipientsCreatedCount(42L);

    // Assert
    assertEquals(3L, actualWithRecipientsCreatedCountResult.recipientsRemovedCount().longValue());
    assertEquals(42L, actualWithRecipientsCreatedCountResult.recipientsCreatedCount().longValue());
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#withRecipientsRemovedCount(Long)}.
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#withRecipientsRemovedCount(Long)}
   */
  @Test
  @DisplayName("Test withRecipientsRemovedCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.withRecipientsRemovedCount(Long)"
  })
  void testWithRecipientsRemovedCount() {
    // Arrange
    ImmutableSyncRecipientsResponse immutableSyncRecipientsResponse =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build();

    // Act
    ImmutableSyncRecipientsResponse actualWithRecipientsRemovedCountResult =
        immutableSyncRecipientsResponse.withRecipientsRemovedCount(3L);

    // Assert
    assertSame(immutableSyncRecipientsResponse, actualWithRecipientsRemovedCountResult);
  }

  /**
   * Test {@link ImmutableSyncRecipientsResponse#withRecipientsRemovedCount(Long)}.
   *
   * <ul>
   *   <li>Then return recipientsCreatedCount longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSyncRecipientsResponse#withRecipientsRemovedCount(Long)}
   */
  @Test
  @DisplayName(
      "Test withRecipientsRemovedCount(Long); then return recipientsCreatedCount longValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSyncRecipientsResponse ImmutableSyncRecipientsResponse.withRecipientsRemovedCount(Long)"
  })
  void testWithRecipientsRemovedCount_thenReturnRecipientsCreatedCountLongValueIsThree() {
    // Arrange and Act
    ImmutableSyncRecipientsResponse actualWithRecipientsRemovedCountResult =
        ImmutableSyncRecipientsResponse.builder()
            .recipientsCreatedCount(3L)
            .recipientsRemovedCount(3L)
            .build()
            .withRecipientsRemovedCount(42L);

    // Assert
    assertEquals(3L, actualWithRecipientsRemovedCountResult.recipientsCreatedCount().longValue());
    assertEquals(42L, actualWithRecipientsRemovedCountResult.recipientsRemovedCount().longValue());
  }
}
