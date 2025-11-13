package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipParseErrorDiffblueTest {
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
    "ImmutableBulkUploadRelationshipParseError Builder.build()",
    "Builder Builder.column(Integer)",
    "Builder Builder.line(Integer)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError actualImmutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Assert
    assertEquals(
        "Not all who wander are lost", actualImmutableBulkUploadRelationshipParseError.message());
    assertEquals(1, actualImmutableBulkUploadRelationshipParseError.column().intValue());
    assertEquals(2, actualImmutableBulkUploadRelationshipParseError.line().intValue());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParseError)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParseError.builder();
    ImmutableBulkUploadRelationshipParseError instance =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipParseError actualImmutableBulkUploadRelationshipParseError =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipParseError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParseError)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParseError.builder();
    ImmutableBulkUploadRelationshipParseError instance =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(null)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipParseError actualImmutableBulkUploadRelationshipParseError =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipParseError);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipParseError)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipParseError)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipParseError)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipParseError.builder();
    ImmutableBulkUploadRelationshipParseError instance =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(null)
            .message("Not all who wander are lost")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipParseError actualImmutableBulkUploadRelationshipParseError =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipParseError);
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
    Builder builderResult = ImmutableBulkUploadRelationshipParseError.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        builderResult.build();
    assertEquals(
        "Not all who wander are lost", immutableBulkUploadRelationshipParseError.message());
    assertNull(immutableBulkUploadRelationshipParseError.column());
    assertNull(immutableBulkUploadRelationshipParseError.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipParseError#copyOf(BulkUploadRelationshipParseError)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipParseError#copyOf(BulkUploadRelationshipParseError)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkUploadRelationshipParseError); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.copyOf(BulkUploadRelationshipParseError)"
  })
  void testCopyOf_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError instance =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParseError actualCopyOfResult =
        ImmutableBulkUploadRelationshipParseError.copyOf(instance);

    // Assert
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(1, actualCopyOfResult.column().intValue());
    assertEquals(2, actualCopyOfResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipParseError#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError2 =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipParseError, immutableBulkUploadRelationshipParseError2);
    assertEquals(
        immutableBulkUploadRelationshipParseError.hashCode(),
        immutableBulkUploadRelationshipParseError2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipParseError#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipParseError, immutableBulkUploadRelationshipParseError);
    int expectedHashCodeResult = immutableBulkUploadRelationshipParseError.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadRelationshipParseError.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(0)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParseError,
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(1)
            .message("Not all who wander are lost")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParseError,
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Message")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipParseError,
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipParseError.equals(Object)",
    "int ImmutableBulkUploadRelationshipParseError.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build(),
        "Different type to ImmutableBulkUploadRelationshipParseError");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Line is one.
   *   <li>Then return column intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Line is one; then return column intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonLineIsOne_thenReturnColumnIntValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(1);
    json.setColumn(1);

    // Act
    ImmutableBulkUploadRelationshipParseError actualFromJsonResult =
        ImmutableBulkUploadRelationshipParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertEquals(1, actualFromJsonResult.column().intValue());
    assertEquals(1, actualFromJsonResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Column is {@code null}.
   *   <li>Then return column is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Column is 'null'; then return column is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonColumnIsNull_thenReturnColumnIsNull() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(1);
    json.setColumn(null);

    // Act
    ImmutableBulkUploadRelationshipParseError actualFromJsonResult =
        ImmutableBulkUploadRelationshipParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertEquals(1, actualFromJsonResult.line().intValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Line is {@code null}.
   *   <li>Then return line is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Line is 'null'; then return line is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonLineIsNull_thenReturnLineIsNull() {
    // Arrange
    Json json = new Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(1);

    // Act
    ImmutableBulkUploadRelationshipParseError actualFromJsonResult =
        ImmutableBulkUploadRelationshipParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.line());
    assertEquals(1, actualFromJsonResult.column().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#column()}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#line()}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableBulkUploadRelationshipParseError.column()",
    "Integer ImmutableBulkUploadRelationshipParseError.line()",
    "String ImmutableBulkUploadRelationshipParseError.message()",
    "String ImmutableBulkUploadRelationshipParseError.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipParseError.toString();
    Integer actualColumnResult = immutableBulkUploadRelationshipParseError.column();
    Integer actualLineResult = immutableBulkUploadRelationshipParseError.line();

    // Assert
    assertEquals(
        "BulkUploadRelationshipParseError{message=Not all who wander are lost, line=2, column=1}",
        actualToStringResult);
    assertEquals(
        "Not all who wander are lost", immutableBulkUploadRelationshipParseError.message());
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
   * Test {@link ImmutableBulkUploadRelationshipParseError#withColumn(Integer)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withColumn(Integer)}
   */
  @Test
  @DisplayName("Test withColumn(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withColumn(Integer)"
  })
  void testWithColumn() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(2)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParseError actualWithColumnResult =
        immutableBulkUploadRelationshipParseError.withColumn(1);

    // Assert
    assertSame(immutableBulkUploadRelationshipParseError, actualWithColumnResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#withColumn(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withColumn(Integer)}
   */
  @Test
  @DisplayName(
      "Test withColumn(Integer); when forty-two; then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withColumn(Integer)"
  })
  void testWithColumn_whenFortyTwo_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError actualWithColumnResult =
        ImmutableBulkUploadRelationshipParseError.builder()
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
   * Test {@link ImmutableBulkUploadRelationshipParseError#withLine(Integer)}.
   *
   * <ul>
   *   <li>Then return builder column one line one message {@code Not all who wander are lost}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withLine(Integer)}
   */
  @Test
  @DisplayName(
      "Test withLine(Integer); then return builder column one line one message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withLine(Integer)"
  })
  void testWithLine_thenReturnBuilderColumnOneLineOneMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder()
            .column(1)
            .line(1)
            .message("Not all who wander are lost")
            .build();

    // Act
    ImmutableBulkUploadRelationshipParseError actualWithLineResult =
        immutableBulkUploadRelationshipParseError.withLine(1);

    // Assert
    assertSame(immutableBulkUploadRelationshipParseError, actualWithLineResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#withLine(Integer)}.
   *
   * <ul>
   *   <li>Then return message is {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withLine(Integer)}
   */
  @Test
  @DisplayName("Test withLine(Integer); then return message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withLine(Integer)"
  })
  void testWithLine_thenReturnMessageIsNotAllWhoWanderAreLost() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError actualWithLineResult =
        ImmutableBulkUploadRelationshipParseError.builder()
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
   * Test {@link ImmutableBulkUploadRelationshipParseError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return builder column one line two message {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String); then return builder column one line two message '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withMessage(String)"
  })
  void testWithMessage_thenReturnBuilderColumnOneLineTwoMessage42Build() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError immutableBulkUploadRelationshipParseError =
        ImmutableBulkUploadRelationshipParseError.builder().column(1).line(2).message("42").build();

    // Act
    ImmutableBulkUploadRelationshipParseError actualWithMessageResult =
        immutableBulkUploadRelationshipParseError.withMessage("42");

    // Assert
    assertSame(immutableBulkUploadRelationshipParseError, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipParseError#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return message is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipParseError#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return message is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipParseError ImmutableBulkUploadRelationshipParseError.withMessage(String)"
  })
  void testWithMessage_thenReturnMessageIs42() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError actualWithMessageResult =
        ImmutableBulkUploadRelationshipParseError.builder()
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
