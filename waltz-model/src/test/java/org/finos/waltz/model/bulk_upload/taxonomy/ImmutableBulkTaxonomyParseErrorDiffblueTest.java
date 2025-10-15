package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.BulkTaxonomyParseResult.BulkTaxonomyParseError;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyParseError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyParseErrorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#column(Integer)}
   *   <li>{@link Builder#line(Integer)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError Builder.build()",
    "Builder Builder.column(Integer)",
    "Builder Builder.line(Integer)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError actualImmutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Assert
    assertEquals("Not all who wander are lost", actualImmutableBulkTaxonomyParseError.message());
    assertEquals(1, actualImmutableBulkTaxonomyParseError.column().intValue());
    assertEquals(2, actualImmutableBulkTaxonomyParseError.line().intValue());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseError)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    ImmutableBulkTaxonomyParseError instance =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyParseError actualImmutableBulkTaxonomyParseError = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseError)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    ImmutableBulkTaxonomyParseError instance =
        ImmutableBulkTaxonomyParseError.builder()
            .column(null)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyParseError actualImmutableBulkTaxonomyParseError = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyParseError)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    ImmutableBulkTaxonomyParseError instance =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(null)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyParseError actualImmutableBulkTaxonomyParseError = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyParseError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   *
   * <ul>
   *   <li>Then builder build message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName(
      "Test Builder message(String); then builder build message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage_thenBuilderBuildMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyParseError.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError = builderResult.build();
    assertEquals("Not all who wander are lost", immutableBulkTaxonomyParseError.message());
    assertNull(immutableBulkTaxonomyParseError.column());
    assertNull(immutableBulkTaxonomyParseError.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#copyOf(BulkTaxonomyParseError)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#copyOf(BulkTaxonomyParseError)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkTaxonomyParseError); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.copyOf(BulkTaxonomyParseError)"
  })
  void testCopyOf_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableBulkTaxonomyParseError instance =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkTaxonomyParseError actualCopyOfResult =
        ImmutableBulkTaxonomyParseError.copyOf(instance);

    // Assert
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(1, actualCopyOfResult.column().intValue());
    assertEquals(2, actualCopyOfResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyParseError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseError#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyParseError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError2 =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyParseError, immutableBulkTaxonomyParseError2);
    assertEquals(
        immutableBulkTaxonomyParseError.hashCode(), immutableBulkTaxonomyParseError2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyParseError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseError#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyParseError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyParseError, immutableBulkTaxonomyParseError);
    int expectedHashCodeResult = immutableBulkTaxonomyParseError.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyParseError.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(0)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseError,
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(1)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseError,
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder().column(1).line(2).message("Message").build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyParseError,
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyParseError.equals(Object)",
    "int ImmutableBulkTaxonomyParseError.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build(),
        "Different type to ImmutableBulkTaxonomyParseError");
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Column is one.
   *   <li>Then return column intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Column is one; then return column intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonColumnIsOne_thenReturnColumnIntValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(1);

    // Act
    ImmutableBulkTaxonomyParseError actualFromJsonResult =
        ImmutableBulkTaxonomyParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.line());
    assertEquals(1, actualFromJsonResult.column().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Line is one.
   *   <li>Then return line intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Line is one; then return line intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonLineIsOne_thenReturnLineIntValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(1);
    json.setColumn(null);

    // Act
    ImmutableBulkTaxonomyParseError actualFromJsonResult =
        ImmutableBulkTaxonomyParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertEquals(1, actualFromJsonResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Message is {@code Json}.
   *   <li>Then return column is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Message is 'Json'; then return column is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonMessageIsJson_thenReturnColumnIsNull() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(null);

    // Act
    ImmutableBulkTaxonomyParseError actualFromJsonResult =
        ImmutableBulkTaxonomyParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertNull(actualFromJsonResult.line());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseError#toString()}
   *   <li>{@link ImmutableBulkTaxonomyParseError#column()}
   *   <li>{@link ImmutableBulkTaxonomyParseError#line()}
   *   <li>{@link ImmutableBulkTaxonomyParseError#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableBulkTaxonomyParseError.column()",
    "Integer ImmutableBulkTaxonomyParseError.line()",
    "String ImmutableBulkTaxonomyParseError.message()",
    "String ImmutableBulkTaxonomyParseError.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyParseError.toString();
    Integer actualColumnResult = immutableBulkTaxonomyParseError.column();
    Integer actualLineResult = immutableBulkTaxonomyParseError.line();

    // Assert
    assertEquals(
        "BulkTaxonomyParseError{message=Not all who wander are lost, line=2, column=1}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", immutableBulkTaxonomyParseError.message());
    assertEquals(1, actualColumnResult.intValue());
    assertEquals(2, actualLineResult.intValue());
  }

  /**
   * Test Json {@link Json#column()}.
   *
   * <p>Method under test: {@link Json#column()}
   */
  @Test
  @DisplayName("Test Json column()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.column()"})
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().column());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setColumn(Integer)}
   *   <li>{@link Json#setLine(Integer)}
   *   <li>{@link Json#setMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setColumn(Integer)",
    "void Json.setLine(Integer)",
    "void Json.setMessage(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Test Json {@link Json#line()}.
   *
   * <p>Method under test: {@link Json#line()}
   */
  @Test
  @DisplayName("Test Json line()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.line()"})
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().line());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withColumn(Integer)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withColumn(Integer)}
   */
  @Test
  @DisplayName("Test withColumn(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withColumn(Integer)"
  })
  void testWithColumn() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkTaxonomyParseError actualWithColumnResult =
        immutableBulkTaxonomyParseError.withColumn(1);

    // Assert
    assertSame(immutableBulkTaxonomyParseError, actualWithColumnResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withColumn(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withColumn(Integer)}
   */
  @Test
  @DisplayName(
      "Test withColumn(Integer); when forty-two; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withColumn(Integer)"
  })
  void testWithColumn_whenFortyTwo_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError actualWithColumnResult =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build()
            .withColumn(42);

    // Assert
    assertEquals("Not all who wander are lost", actualWithColumnResult.message());
    assertEquals(2, actualWithColumnResult.line().intValue());
    assertEquals(42, actualWithColumnResult.column().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withLine(Integer)}.
   *
   * <ul>
   *   <li>Then return builder column one line one message {@code Not all who wander are lost}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withLine(Integer)}
   */
  @Test
  @DisplayName(
      "Test withLine(Integer); then return builder column one line one message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withLine(Integer)"
  })
  void testWithLine_thenReturnBuilderColumnOneLineOneMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(1)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkTaxonomyParseError actualWithLineResult =
        immutableBulkTaxonomyParseError.withLine(1);

    // Assert
    assertSame(immutableBulkTaxonomyParseError, actualWithLineResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withLine(Integer)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withLine(Integer)}
   */
  @Test
  @DisplayName("Test withLine(Integer); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withLine(Integer)"
  })
  void testWithLine_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError actualWithLineResult =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build()
            .withLine(42);

    // Assert
    assertEquals("Not all who wander are lost", actualWithLineResult.message());
    assertEquals(1, actualWithLineResult.column().intValue());
    assertEquals(42, actualWithLineResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return builder column one line two message {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String); then return builder column one line two message '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withMessage(String)"
  })
  void testWithMessage_thenReturnBuilderColumnOneLineTwoMessage42Build() {
    // Arrange
    ImmutableBulkTaxonomyParseError immutableBulkTaxonomyParseError =
        ImmutableBulkTaxonomyParseError.builder().column(1).line(2).message("42").build();

    // Act
    ImmutableBulkTaxonomyParseError actualWithMessageResult =
        immutableBulkTaxonomyParseError.withMessage("42");

    // Assert
    assertSame(immutableBulkTaxonomyParseError, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyParseError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return message is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyParseError#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return message is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyParseError ImmutableBulkTaxonomyParseError.withMessage(String)"
  })
  void testWithMessage_thenReturnMessageIs42() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError actualWithMessageResult =
        ImmutableBulkTaxonomyParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build()
            .withMessage("42");

    // Assert
    assertEquals("42", actualWithMessageResult.message());
    assertEquals(1, actualWithMessageResult.column().intValue());
    assertEquals(2, actualWithMessageResult.line().intValue());
  }
}
