package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableColumnDescriptor.Builder;
import org.finos.waltz.web.json.ImmutableColumnDescriptor.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableColumnDescriptorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableColumnDescriptor actualImmutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Assert
    assertEquals("42", actualImmutableColumnDescriptor.id());
    assertEquals("Name", actualImmutableColumnDescriptor.name());
  }

  /**
   * Test Builder {@link Builder#from(ColumnDescriptor)}.
   *
   * <ul>
   *   <li>Then builder build is builder id {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ColumnDescriptor)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ColumnDescriptor); then builder build is builder id '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ColumnDescriptor)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderId42NameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();
    ImmutableColumnDescriptor instance =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableColumnDescriptor actualImmutableColumnDescriptor = builderResult.build();
    assertEquals(instance, actualImmutableColumnDescriptor);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(String)"})
  void testBuilderId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act
    Builder actualIdResult = builderResult.id("42");

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableColumnDescriptor#copyOf(ColumnDescriptor)}.
   *
   * <ul>
   *   <li>When builder id {@code 42} name {@code Name} build.
   *   <li>Then return id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#copyOf(ColumnDescriptor)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ColumnDescriptor); when builder id '42' name 'Name' build; then return id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableColumnDescriptor ImmutableColumnDescriptor.copyOf(ColumnDescriptor)"
  })
  void testCopyOf_whenBuilderId42NameNameBuild_thenReturnIdIs42() {
    // Arrange
    ImmutableColumnDescriptor instance =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act
    ImmutableColumnDescriptor actualCopyOfResult = ImmutableColumnDescriptor.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.id());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}, and {@link
   * ImmutableColumnDescriptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableColumnDescriptor#equals(Object)}
   *   <li>{@link ImmutableColumnDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();
    ImmutableColumnDescriptor immutableColumnDescriptor2 =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act and Assert
    assertEquals(immutableColumnDescriptor, immutableColumnDescriptor2);
    assertEquals(immutableColumnDescriptor.hashCode(), immutableColumnDescriptor2.hashCode());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}, and {@link
   * ImmutableColumnDescriptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableColumnDescriptor#equals(Object)}
   *   <li>{@link ImmutableColumnDescriptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act and Assert
    assertEquals(immutableColumnDescriptor, immutableColumnDescriptor);
    int expectedHashCodeResult = immutableColumnDescriptor.hashCode();
    assertEquals(expectedHashCodeResult, immutableColumnDescriptor.hashCode());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("Name").name("Name").build();

    // Act and Assert
    assertNotEquals(
        immutableColumnDescriptor,
        ImmutableColumnDescriptor.builder().id("42").name("Name").build());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("42").build();

    // Act and Assert
    assertNotEquals(
        immutableColumnDescriptor,
        ImmutableColumnDescriptor.builder().id("42").name("Name").build());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableColumnDescriptor.builder().id("42").name("Name").build(), null);
  }

  /**
   * Test {@link ImmutableColumnDescriptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableColumnDescriptor.equals(Object)",
    "int ImmutableColumnDescriptor.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableColumnDescriptor.builder().id("42").name("Name").build(),
        "Different type to ImmutableColumnDescriptor");
  }

  /**
   * Test {@link ImmutableColumnDescriptor#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Id is {@code Json}.
   *   <li>Then return id is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Id is 'Json'; then return id is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor ImmutableColumnDescriptor.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonIdIsJson_thenReturnIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setId("Json");
    json.setName("Json");

    // Act
    ImmutableColumnDescriptor actualFromJsonResult = ImmutableColumnDescriptor.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.id());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableColumnDescriptor#toString()}
   *   <li>{@link ImmutableColumnDescriptor#id()}
   *   <li>{@link ImmutableColumnDescriptor#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableColumnDescriptor.id()",
    "String ImmutableColumnDescriptor.name()",
    "String ImmutableColumnDescriptor.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act
    String actualToStringResult = immutableColumnDescriptor.toString();
    String actualIdResult = immutableColumnDescriptor.id();

    // Assert
    assertEquals("42", actualIdResult);
    assertEquals("ColumnDescriptor{id=42, name=Name}", actualToStringResult);
    assertEquals("Name", immutableColumnDescriptor.name());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setId(String)}
   *   <li>{@link Json#setName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setId(String)", "void Json.setName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.id);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#withId(String)}.
   *
   * <ul>
   *   <li>Given builder id {@code 42} name {@code Name} build.
   *   <li>Then return builder id {@code 42} name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#withId(String)}
   */
  @Test
  @DisplayName(
      "Test withId(String); given builder id '42' name 'Name' build; then return builder id '42' name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor ImmutableColumnDescriptor.withId(String)"})
  void testWithId_givenBuilderId42NameNameBuild_thenReturnBuilderId42NameNameBuild() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build();

    // Act
    ImmutableColumnDescriptor actualWithIdResult = immutableColumnDescriptor.withId("42");

    // Assert
    assertSame(immutableColumnDescriptor, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableColumnDescriptor#withId(String)}.
   *
   * <ul>
   *   <li>Given builder id {@code id} name {@code Name} build.
   *   <li>Then return id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#withId(String)}
   */
  @Test
  @DisplayName(
      "Test withId(String); given builder id 'id' name 'Name' build; then return id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor ImmutableColumnDescriptor.withId(String)"})
  void testWithId_givenBuilderIdIdNameNameBuild_thenReturnIdIs42() {
    // Arrange and Act
    ImmutableColumnDescriptor actualWithIdResult =
        ImmutableColumnDescriptor.builder().id("id").name("Name").build().withId("42");

    // Assert
    assertEquals("42", actualWithIdResult.id());
    assertEquals("Name", actualWithIdResult.name());
  }

  /**
   * Test {@link ImmutableColumnDescriptor#withName(String)}.
   *
   * <ul>
   *   <li>Given builder id {@code 42} name {@code 42} build.
   *   <li>Then return builder id {@code 42} name {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder id '42' name '42' build; then return builder id '42' name '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor ImmutableColumnDescriptor.withName(String)"})
  void testWithName_givenBuilderId42Name42Build_thenReturnBuilderId42Name42Build() {
    // Arrange
    ImmutableColumnDescriptor immutableColumnDescriptor =
        ImmutableColumnDescriptor.builder().id("42").name("42").build();

    // Act
    ImmutableColumnDescriptor actualWithNameResult = immutableColumnDescriptor.withName("42");

    // Assert
    assertSame(immutableColumnDescriptor, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableColumnDescriptor#withName(String)}.
   *
   * <ul>
   *   <li>Given builder id {@code 42} name {@code Name} build.
   *   <li>Then return id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableColumnDescriptor#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder id '42' name 'Name' build; then return id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableColumnDescriptor ImmutableColumnDescriptor.withName(String)"})
  void testWithName_givenBuilderId42NameNameBuild_thenReturnIdIs42() {
    // Arrange and Act
    ImmutableColumnDescriptor actualWithNameResult =
        ImmutableColumnDescriptor.builder().id("42").name("Name").build().withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.id());
    assertEquals("42", actualWithNameResult.name());
  }
}
