package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.notification.ImmutableNotificationSummary.Builder;
import org.finos.waltz.model.notification.ImmutableNotificationSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableNotificationSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationSummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableNotificationSummary actualImmutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Assert
    assertEquals(3, actualImmutableNotificationSummary.count().intValue());
    assertEquals(EntityKind.ALL, actualImmutableNotificationSummary.kind());
  }

  /**
   * Test Builder {@link Builder#count(Integer)}.
   *
   * <p>Method under test: {@link Builder#count(Integer)}
   */
  @Test
  @DisplayName("Test Builder count(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(Integer)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(NotificationSummary)}.
   *
   * <ul>
   *   <li>Then builder build is builder count three kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NotificationSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NotificationSummary); then builder build is builder count three kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NotificationSummary)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCountThreeKindAllBuild() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();
    ImmutableNotificationSummary instance =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableNotificationSummary actualImmutableNotificationSummary = builderResult.build();
    assertEquals(instance, actualImmutableNotificationSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test {@link ImmutableNotificationSummary#copyOf(NotificationSummary)}.
   *
   * <ul>
   *   <li>When builder count three kind {@code ALL} build.
   *   <li>Then return count intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#copyOf(NotificationSummary)}
   */
  @Test
  @DisplayName(
      "Test copyOf(NotificationSummary); when builder count three kind 'ALL' build; then return count intValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationSummary ImmutableNotificationSummary.copyOf(NotificationSummary)"
  })
  void testCopyOf_whenBuilderCountThreeKindAllBuild_thenReturnCountIntValueIsThree() {
    // Arrange
    ImmutableNotificationSummary instance =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act
    ImmutableNotificationSummary actualCopyOfResult = ImmutableNotificationSummary.copyOf(instance);

    // Assert
    assertEquals(3, actualCopyOfResult.count().intValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}, and {@link
   * ImmutableNotificationSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableNotificationSummary#equals(Object)}
   *   <li>{@link ImmutableNotificationSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();
    ImmutableNotificationSummary immutableNotificationSummary2 =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableNotificationSummary, immutableNotificationSummary2);
    assertEquals(immutableNotificationSummary.hashCode(), immutableNotificationSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}, and {@link
   * ImmutableNotificationSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableNotificationSummary#equals(Object)}
   *   <li>{@link ImmutableNotificationSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act and Assert
    assertEquals(immutableNotificationSummary, immutableNotificationSummary);
    int expectedHashCodeResult = immutableNotificationSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableNotificationSummary.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(1).kind(EntityKind.ALL).build();

    // Act and Assert
    assertNotEquals(
        immutableNotificationSummary,
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ACTOR).build();

    // Act and Assert
    assertNotEquals(
        immutableNotificationSummary,
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build(), null);
  }

  /**
   * Test {@link ImmutableNotificationSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationSummary.equals(Object)",
    "int ImmutableNotificationSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build(),
        "Different type to ImmutableNotificationSummary");
  }

  /**
   * Test {@link ImmutableNotificationSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return count intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return count intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationSummary ImmutableNotificationSummary.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnCountIntValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setKind(EntityKind.ALL);
    json.setCount(1);

    // Act
    ImmutableNotificationSummary actualFromJsonResult = ImmutableNotificationSummary.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.count().intValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableNotificationSummary#toString()}
   *   <li>{@link ImmutableNotificationSummary#count()}
   *   <li>{@link ImmutableNotificationSummary#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableNotificationSummary.count()",
    "EntityKind ImmutableNotificationSummary.kind()",
    "String ImmutableNotificationSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act
    String actualToStringResult = immutableNotificationSummary.toString();
    Integer actualCountResult = immutableNotificationSummary.count();
    EntityKind actualKindResult = immutableNotificationSummary.kind();

    // Assert
    assertEquals("NotificationSummary{kind=ALL, count=3}", actualToStringResult);
    assertEquals(3, actualCountResult.intValue());
    assertEquals(EntityKind.ALL, actualKindResult);
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCount(Integer)}
   *   <li>{@link Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCount(Integer)",
    "void Json.setKind(EntityKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCount(3);
    actualJson.setKind(EntityKind.ALL);

    // Assert
    assertEquals(3, actualJson.count.intValue());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test {@link ImmutableNotificationSummary#withCount(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return count intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#withCount(Integer)}
   */
  @Test
  @DisplayName("Test withCount(Integer); when forty-two; then return count intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationSummary ImmutableNotificationSummary.withCount(Integer)"
  })
  void testWithCount_whenFortyTwo_thenReturnCountIntValueIsFortyTwo() {
    // Arrange and Act
    ImmutableNotificationSummary actualWithCountResult =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build().withCount(42);

    // Assert
    assertEquals(42, actualWithCountResult.count().intValue());
    assertEquals(EntityKind.ALL, actualWithCountResult.kind());
  }

  /**
   * Test {@link ImmutableNotificationSummary#withCount(Integer)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return builder count three kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#withCount(Integer)}
   */
  @Test
  @DisplayName(
      "Test withCount(Integer); when three; then return builder count three kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationSummary ImmutableNotificationSummary.withCount(Integer)"
  })
  void testWithCount_whenThree_thenReturnBuilderCountThreeKindAllBuild() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act
    ImmutableNotificationSummary actualWithCountResult = immutableNotificationSummary.withCount(3);

    // Assert
    assertSame(immutableNotificationSummary, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableNotificationSummary#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given builder count three kind {@code ACTOR} build.
   *   <li>Then return count intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); given builder count three kind 'ACTOR' build; then return count intValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationSummary ImmutableNotificationSummary.withKind(EntityKind)"
  })
  void testWithKind_givenBuilderCountThreeKindActorBuild_thenReturnCountIntValueIsThree() {
    // Arrange and Act
    ImmutableNotificationSummary actualWithKindResult =
        ImmutableNotificationSummary.builder()
            .count(3)
            .kind(EntityKind.ACTOR)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals(3, actualWithKindResult.count().intValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableNotificationSummary#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder count three kind {@code ALL} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationSummary#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return builder count three kind 'ALL' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationSummary ImmutableNotificationSummary.withKind(EntityKind)"
  })
  void testWithKind_thenReturnBuilderCountThreeKindAllBuild() {
    // Arrange
    ImmutableNotificationSummary immutableNotificationSummary =
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build();

    // Act
    ImmutableNotificationSummary actualWithKindResult =
        immutableNotificationSummary.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableNotificationSummary, actualWithKindResult);
  }
}
