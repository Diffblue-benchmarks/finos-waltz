package org.finos.waltz.model.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.ImmutableStat.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableStat.Json;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat.Stat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableStatDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableStat actualImmutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Assert
    assertEquals(3, actualImmutableStat.personCount());
    assertEquals(EntityKind.ALL, actualImmutableStat.entityKind());
    assertTrue(actualImmutableStat.isCountOfRemovedPeople());
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act
    Builder actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(Stat)}.
   *
   * <p>Method under test: {@link Builder#from(Stat)}
   */
  @Test
  @DisplayName("Test Builder from(Stat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Stat)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();
    ImmutableStat instance =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableStat actualImmutableStat = builderResult.build();
    assertEquals(instance, actualImmutableStat);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isCountOfRemovedPeople(boolean)}.
   *
   * <p>Method under test: {@link Builder#isCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCountOfRemovedPeople(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isCountOfRemovedPeople(boolean)"})
  void testBuilderIsCountOfRemovedPeople() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act
    Builder actualIsCountOfRemovedPeopleResult = builderResult.isCountOfRemovedPeople(true);

    // Assert
    assertSame(builderResult, actualIsCountOfRemovedPeopleResult);
  }

  /**
   * Test Builder {@link Builder#personCount(int)}.
   *
   * <p>Method under test: {@link Builder#personCount(int)}
   */
  @Test
  @DisplayName("Test Builder personCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.personCount(int)"})
  void testBuilderPersonCount() {
    // Arrange
    Builder builderResult = ImmutableStat.builder();

    // Act
    Builder actualPersonCountResult = builderResult.personCount(3);

    // Assert
    assertSame(builderResult, actualPersonCountResult);
  }

  /**
   * Test {@link ImmutableStat#copyOf(Stat)}.
   *
   * <ul>
   *   <li>Then return personCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#copyOf(Stat)}
   */
  @Test
  @DisplayName("Test copyOf(Stat); then return personCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.copyOf(Stat)"})
  void testCopyOf_thenReturnPersonCountIsThree() {
    // Arrange
    ImmutableStat instance =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act
    ImmutableStat actualCopyOfResult = ImmutableStat.copyOf(instance);

    // Assert
    assertEquals(3, actualCopyOfResult.personCount());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertTrue(actualCopyOfResult.isCountOfRemovedPeople());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}, and {@link ImmutableStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStat#equals(Object)}
   *   <li>{@link ImmutableStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();
    ImmutableStat immutableStat2 =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableStat, immutableStat2);
    assertEquals(immutableStat.hashCode(), immutableStat2.hashCode());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}, and {@link ImmutableStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStat#equals(Object)}
   *   <li>{@link ImmutableStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableStat, immutableStat);
    int expectedHashCodeResult = immutableStat.hashCode();
    assertEquals(expectedHashCodeResult, immutableStat.hashCode());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ACTOR)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStat,
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(false)
            .personCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStat,
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableStat,
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableStat.equals(Object)", "int ImmutableStat.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build(),
        "Different type to ImmutableStat");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableStat#toString()}
   *   <li>{@link ImmutableStat#entityKind()}
   *   <li>{@link ImmutableStat#isCountOfRemovedPeople()}
   *   <li>{@link ImmutableStat#personCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableStat.entityKind()",
    "boolean ImmutableStat.isCountOfRemovedPeople()",
    "int ImmutableStat.personCount()",
    "String ImmutableStat.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act
    String actualToStringResult = immutableStat.toString();
    EntityKind actualEntityKindResult = immutableStat.entityKind();
    boolean actualIsCountOfRemovedPeopleResult = immutableStat.isCountOfRemovedPeople();

    // Assert
    assertEquals(
        "Stat{entityKind=ALL, isCountOfRemovedPeople=true, personCount=3}", actualToStringResult);
    assertEquals(3, immutableStat.personCount());
    assertEquals(EntityKind.ALL, actualEntityKindResult);
    assertTrue(actualIsCountOfRemovedPeopleResult);
  }

  /**
   * Test Json {@link Json#entityKind()}.
   *
   * <p>Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKind());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(0, actualJson.personCount);
    assertEquals(EntityKind.ALL, actualJson.entityKind);
    assertFalse(actualJson.isCountOfRemovedPeople);
    assertFalse(actualJson.isCountOfRemovedPeopleIsSet);
    assertFalse(actualJson.personCountIsSet);
  }

  /**
   * Test Json {@link Json#isCountOfRemovedPeople()}.
   *
   * <p>Method under test: {@link Json#isCountOfRemovedPeople()}
   */
  @Test
  @DisplayName("Test Json isCountOfRemovedPeople()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isCountOfRemovedPeople()"})
  void testJsonIsCountOfRemovedPeople() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isCountOfRemovedPeople());
  }

  /**
   * Test Json {@link Json#personCount()}.
   *
   * <p>Method under test: {@link Json#personCount()}
   */
  @Test
  @DisplayName("Test Json personCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.personCount()"})
  void testJsonPersonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().personCount());
  }

  /**
   * Test Json {@link Json#setIsCountOfRemovedPeople(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCountOfRemovedPeople(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsCountOfRemovedPeople(boolean)"})
  void testJsonSetIsCountOfRemovedPeople() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsCountOfRemovedPeople(true);

    // Assert
    assertTrue(json.isCountOfRemovedPeople);
    assertTrue(json.isCountOfRemovedPeopleIsSet);
  }

  /**
   * Test Json {@link Json#setPersonCount(int)}.
   *
   * <p>Method under test: {@link Json#setPersonCount(int)}
   */
  @Test
  @DisplayName("Test Json setPersonCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPersonCount(int)"})
  void testJsonSetPersonCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPersonCount(3);

    // Assert
    assertEquals(3, json.personCount);
    assertTrue(json.personCountIsSet);
  }

  /**
   * Test {@link ImmutableStat#withEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableStat#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withEntityKind(EntityKind)"})
  void testWithEntityKind() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act
    ImmutableStat actualWithEntityKindResult = immutableStat.withEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableStat, actualWithEntityKindResult);
  }

  /**
   * Test {@link ImmutableStat#withEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return personCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind); then return personCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withEntityKind(EntityKind)"})
  void testWithEntityKind_thenReturnPersonCountIsThree() {
    // Arrange and Act
    ImmutableStat actualWithEntityKindResult =
        ImmutableStat.builder()
            .entityKind(EntityKind.ACTOR)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build()
            .withEntityKind(EntityKind.ALL);

    // Assert
    assertEquals(3, actualWithEntityKindResult.personCount());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.entityKind());
    assertTrue(actualWithEntityKindResult.isCountOfRemovedPeople());
  }

  /**
   * Test {@link ImmutableStat#withIsCountOfRemovedPeople(boolean)}.
   *
   * <p>Method under test: {@link ImmutableStat#withIsCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test withIsCountOfRemovedPeople(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withIsCountOfRemovedPeople(boolean)"})
  void testWithIsCountOfRemovedPeople() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build();

    // Act
    ImmutableStat actualWithIsCountOfRemovedPeopleResult =
        immutableStat.withIsCountOfRemovedPeople(true);

    // Assert
    assertSame(immutableStat, actualWithIsCountOfRemovedPeopleResult);
  }

  /**
   * Test {@link ImmutableStat#withIsCountOfRemovedPeople(boolean)}.
   *
   * <ul>
   *   <li>Then return personCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#withIsCountOfRemovedPeople(boolean)}
   */
  @Test
  @DisplayName("Test withIsCountOfRemovedPeople(boolean); then return personCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withIsCountOfRemovedPeople(boolean)"})
  void testWithIsCountOfRemovedPeople_thenReturnPersonCountIsThree() {
    // Arrange and Act
    ImmutableStat actualWithIsCountOfRemovedPeopleResult =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(false)
            .personCount(3)
            .build()
            .withIsCountOfRemovedPeople(true);

    // Assert
    assertEquals(3, actualWithIsCountOfRemovedPeopleResult.personCount());
    assertEquals(EntityKind.ALL, actualWithIsCountOfRemovedPeopleResult.entityKind());
    assertTrue(actualWithIsCountOfRemovedPeopleResult.isCountOfRemovedPeople());
  }

  /**
   * Test {@link ImmutableStat#withPersonCount(int)}.
   *
   * <p>Method under test: {@link ImmutableStat#withPersonCount(int)}
   */
  @Test
  @DisplayName("Test withPersonCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withPersonCount(int)"})
  void testWithPersonCount() {
    // Arrange
    ImmutableStat immutableStat =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(42)
            .build();

    // Act
    ImmutableStat actualWithPersonCountResult = immutableStat.withPersonCount(42);

    // Assert
    assertSame(immutableStat, actualWithPersonCountResult);
  }

  /**
   * Test {@link ImmutableStat#withPersonCount(int)}.
   *
   * <ul>
   *   <li>Then return personCount is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableStat#withPersonCount(int)}
   */
  @Test
  @DisplayName("Test withPersonCount(int); then return personCount is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableStat ImmutableStat.withPersonCount(int)"})
  void testWithPersonCount_thenReturnPersonCountIsFortyTwo() {
    // Arrange and Act
    ImmutableStat actualWithPersonCountResult =
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build()
            .withPersonCount(42);

    // Assert
    assertEquals(42, actualWithPersonCountResult.personCount());
    assertEquals(EntityKind.ALL, actualWithPersonCountResult.entityKind());
    assertTrue(actualWithPersonCountResult.isCountOfRemovedPeople());
  }
}
