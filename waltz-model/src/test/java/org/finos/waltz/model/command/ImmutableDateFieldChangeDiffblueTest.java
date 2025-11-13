package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.command.ImmutableDateFieldChange.Builder;
import org.finos.waltz.model.command.ImmutableDateFieldChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateFieldChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#newVal(Date)}
   *   <li>{@link Builder#oldVal(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateFieldChange Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.newVal(Date)",
    "Builder Builder.oldVal(Date)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");
    Date newVal =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder actualNewValResult = actualDescriptionResult.newVal(newVal);
    Date oldVal =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableDateFieldChange actualImmutableDateFieldChange =
        actualNewValResult.oldVal(oldVal).build();

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableDateFieldChange.description());
    assertSame(newVal, actualImmutableDateFieldChange.newVal());
    assertSame(oldVal, actualImmutableDateFieldChange.oldVal());
  }

  /**
   * Test Builder {@link Builder#from(DateFieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(DateFieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(DateFieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateFieldChange)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDateFieldChange.builder();

    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange instance =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableDateFieldChange actualImmutableDateFieldChange = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDateFieldChange);
    ImmutableDateFieldChange actualImmutableDateFieldChange2 = builderResult.build();
    assertEquals(instance, actualImmutableDateFieldChange2);
  }

  /**
   * Test Builder {@link Builder#from(DateFieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(DateFieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(DateFieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateFieldChange)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDateFieldChange.builder();

    Builder descriptionResult = ImmutableDateFieldChange.builder().description(null);

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange instance =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableDateFieldChange actualImmutableDateFieldChange = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDateFieldChange);
    ImmutableDateFieldChange actualImmutableDateFieldChange2 = builderResult.build();
    assertEquals(instance, actualImmutableDateFieldChange2);
  }

  /**
   * Test Builder {@link Builder#from(DateFieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(DateFieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(DateFieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateFieldChange)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableDateFieldChange.builder();

    Builder newValResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something")
            .newVal(null);
    ImmutableDateFieldChange instance =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableDateFieldChange actualImmutableDateFieldChange = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDateFieldChange);
    ImmutableDateFieldChange actualImmutableDateFieldChange2 = builderResult.build();
    assertEquals(instance, actualImmutableDateFieldChange2);
  }

  /**
   * Test Builder {@link Builder#from(DateFieldChange)}.
   *
   * <p>Method under test: {@link Builder#from(DateFieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(DateFieldChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateFieldChange)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableDateFieldChange.builder();

    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");
    ImmutableDateFieldChange instance =
        descriptionResult
            .newVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .oldVal(null)
            .build();

    // Act and Assert
    ImmutableDateFieldChange actualImmutableDateFieldChange = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableDateFieldChange);
    ImmutableDateFieldChange actualImmutableDateFieldChange2 = builderResult.build();
    assertEquals(instance, actualImmutableDateFieldChange2);
  }

  /**
   * Test {@link ImmutableDateFieldChange#copyOf(DateFieldChange)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#copyOf(DateFieldChange)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DateFieldChange); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.copyOf(DateFieldChange)"})
  void testCopyOf_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange instance =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(
        "The characteristics of someone or something",
        ImmutableDateFieldChange.copyOf(instance).description());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}, and {@link
   * ImmutableDateFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateFieldChange#equals(Object)}
   *   <li>{@link ImmutableDateFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult2 =
        descriptionResult2.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange2 =
        newValResult2
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableDateFieldChange, immutableDateFieldChange2);
    assertEquals(immutableDateFieldChange.hashCode(), immutableDateFieldChange2.hashCode());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}, and {@link
   * ImmutableDateFieldChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateFieldChange#equals(Object)}
   *   <li>{@link ImmutableDateFieldChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableDateFieldChange, immutableDateFieldChange);
    int expectedHashCodeResult = immutableDateFieldChange.hashCode();
    assertEquals(expectedHashCodeResult, immutableDateFieldChange.hashCode());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult = ImmutableDateFieldChange.builder().description("Description");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult2 =
        descriptionResult2.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(
        immutableDateFieldChange,
        newValResult2
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult2 =
        descriptionResult2.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(
        immutableDateFieldChange,
        newValResult2
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder descriptionResult2 =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult2 =
        descriptionResult2.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(
        immutableDateFieldChange,
        newValResult2
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDateFieldChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateFieldChange.equals(Object)",
    "int ImmutableDateFieldChange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "Different type to ImmutableDateFieldChange");
  }

  /**
   * Test {@link ImmutableDateFieldChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setNewVal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setOldVal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    json.setDescription("Json");

    // Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableDateFieldChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnDescriptionIsNull() {
    // Arrange and Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateFieldChange#toString()}
   *   <li>{@link ImmutableDateFieldChange#description()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableDateFieldChange.description()",
    "String ImmutableDateFieldChange.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    immutableDateFieldChange.toString();

    // Assert
    assertEquals(
        "The characteristics of someone or something", immutableDateFieldChange.description());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setNewVal(Date)}
   *   <li>{@link Json#setOldVal(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setNewVal(Date)",
    "void Json.setOldVal(Date)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setNewVal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualJson.setOldVal(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Test Json {@link Json#newVal()}.
   *
   * <p>Method under test: {@link Json#newVal()}
   */
  @Test
  @DisplayName("Test Json newVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.newVal()"})
  void testJsonNewVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newVal());
  }

  /**
   * Test Json {@link Json#oldVal()}.
   *
   * <p>Method under test: {@link Json#oldVal()}
   */
  @Test
  @DisplayName("Test Json oldVal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.oldVal()"})
  void testJsonOldVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().oldVal());
  }

  /**
   * Test {@link ImmutableDateFieldChange#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder descriptionResult = ImmutableDateFieldChange.builder().description("42");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableDateFieldChange actualWithDescriptionResult =
        immutableDateFieldChange.withDescription("42");

    // Assert
    assertSame(immutableDateFieldChange, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableDateFieldChange#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(
        "42",
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withDescription("42")
            .description());
  }

  /**
   * Test {@link ImmutableDateFieldChange#withNewVal(Date)}.
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#withNewVal(Date)}
   */
  @Test
  @DisplayName("Test withNewVal(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.withNewVal(Date)"})
  void testWithNewVal() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableDateFieldChange actualWithNewValResult =
        immutableDateFieldChange.withNewVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableDateFieldChange, actualWithNewValResult);
  }

  /**
   * Test {@link ImmutableDateFieldChange#withOldVal(Date)}.
   *
   * <p>Method under test: {@link ImmutableDateFieldChange#withOldVal(Date)}
   */
  @Test
  @DisplayName("Test withOldVal(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDateFieldChange ImmutableDateFieldChange.withOldVal(Date)"})
  void testWithOldVal() {
    // Arrange
    Builder descriptionResult =
        ImmutableDateFieldChange.builder()
            .description("The characteristics of someone or something");

    Builder newValResult =
        descriptionResult.newVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ImmutableDateFieldChange immutableDateFieldChange =
        newValResult
            .oldVal(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableDateFieldChange actualWithOldValResult =
        immutableDateFieldChange.withOldVal(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableDateFieldChange, actualWithOldValResult);
  }
}
