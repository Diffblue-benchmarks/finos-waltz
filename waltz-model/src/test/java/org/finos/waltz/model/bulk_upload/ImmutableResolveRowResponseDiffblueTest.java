package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.bulk_upload.ImmutableResolveRowResponse.Builder;
import org.finos.waltz.model.bulk_upload.ImmutableResolveRowResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolveRowResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllInputRow(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInputRow(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllInputRow(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInputRow(Iterable)"})
  void testBuilderAddAllInputRow_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllInputRowResult = builderResult.addAllInputRow(elements);

    // Assert
    assertSame(builderResult, actualAddAllInputRowResult);
  }

  /**
   * Test Builder {@link Builder#addAllInputRow(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInputRow(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInputRow(Iterable)"})
  void testBuilderAddAllInputRow_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    Builder actualAddAllInputRowResult = builderResult.addAllInputRow(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInputRowResult);
  }

  /**
   * Test Builder {@link Builder#addInputRow(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addInputRow(String)}
   */
  @Test
  @DisplayName("Test Builder addInputRow(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInputRow(String)"})
  void testBuilderAddInputRowWithElement() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    Builder actualAddInputRowResult = builderResult.addInputRow("Element");

    // Assert
    assertSame(builderResult, actualAddInputRowResult);
  }

  /**
   * Test Builder {@link Builder#addInputRow(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addInputRow(String[])}
   */
  @Test
  @DisplayName("Test Builder addInputRow(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInputRow(String[])"})
  void testBuilderAddInputRowWithElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    Builder actualAddInputRowResult = builderResult.addInputRow("Elements");

    // Assert
    assertSame(builderResult, actualAddInputRowResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#errorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse Builder.build()",
    "Builder Builder.errorMessage(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualErrorMessageResult =
        ImmutableResolveRowResponse.builder().errorMessage("An error occurred");
    Optional<String> errorMessage = Optional.of("foo");
    ImmutableResolveRowResponse actualImmutableResolveRowResponse =
        actualErrorMessageResult.errorMessage(errorMessage).status(ResolutionStatus.NEW).build();

    // Assert
    assertEquals(ResolutionStatus.NEW, actualImmutableResolveRowResponse.status());
    assertTrue(actualImmutableResolveRowResponse.inputRow().isEmpty());
  }

  /**
   * Test Builder {@link Builder#errorMessage(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#errorMessage(Optional)}
   */
  @Test
  @DisplayName("Test Builder errorMessage(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.errorMessage(Optional)"})
  void testBuilderErrorMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    Optional<String> errorMessage = Optional.of("foo");

    // Act
    Builder actualErrorMessageResult = builderResult.errorMessage(errorMessage);

    // Assert
    assertSame(builderResult, actualErrorMessageResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   *
   * <p>Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveRowResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    ImmutableResolveRowResponse instance =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolveRowResponse actualImmutableResolveRowResponse = builderResult.build();
    assertEquals(instance, actualImmutableResolveRowResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   *
   * <ul>
   *   <li>Given {@code instance}.
   *   <li>When builder addInputRow {@code instance}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ResolveRowResponse); given 'instance'; when builder addInputRow 'instance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom_givenInstance_whenBuilderAddInputRowInstance() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    Builder builderResult2 = ImmutableResolveRowResponse.builder();
    builderResult2.addInputRow("instance");
    ImmutableResolveRowResponse instance =
        builderResult2.errorMessage("An error occurred").status(ResolutionStatus.NEW).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableResolveRowResponse actualImmutableResolveRowResponse = builderResult.build();
    assertEquals(instance, actualImmutableResolveRowResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inputRow(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputRow(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder inputRow(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputRow(Iterable)"})
  void testBuilderInputRow_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualInputRowResult = builderResult.inputRow(elements);

    // Assert
    assertSame(builderResult, actualInputRowResult);
  }

  /**
   * Test Builder {@link Builder#inputRow(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputRow(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputRow(Iterable)"})
  void testBuilderInputRow_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    Builder actualInputRowResult = builderResult.inputRow(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInputRowResult);
  }

  /**
   * Test Builder {@link Builder#status(ResolutionStatus)}.
   *
   * <p>Method under test: {@link Builder#status(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolutionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(ResolutionStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test copyOf(ResolveRowResponse); then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.copyOf(ResolveRowResponse)"
  })
  void testCopyOf_thenReturnStatusIsNew() {
    // Arrange
    ImmutableResolveRowResponse instance =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act
    ImmutableResolveRowResponse actualCopyOfResult = ImmutableResolveRowResponse.copyOf(instance);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.inputRow().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}, and {@link
   * ImmutableResolveRowResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveRowResponse#equals(Object)}
   *   <li>{@link ImmutableResolveRowResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();
    ImmutableResolveRowResponse immutableResolveRowResponse2 =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act and Assert
    assertEquals(immutableResolveRowResponse, immutableResolveRowResponse2);
    assertEquals(immutableResolveRowResponse.hashCode(), immutableResolveRowResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}, and {@link
   * ImmutableResolveRowResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveRowResponse#equals(Object)}
   *   <li>{@link ImmutableResolveRowResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act and Assert
    assertEquals(immutableResolveRowResponse, immutableResolveRowResponse);
    int expectedHashCodeResult = immutableResolveRowResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableResolveRowResponse.hashCode());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    builderResult.addInputRow("Element");
    ImmutableResolveRowResponse immutableResolveRowResponse =
        builderResult.errorMessage("An error occurred").status(ResolutionStatus.NEW).build();

    // Act and Assert
    assertNotEquals(
        immutableResolveRowResponse,
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("Error Message")
            .status(ResolutionStatus.NEW)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableResolveRowResponse,
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.EXISTING)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableResolveRowResponse,
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableResolveRowResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveRowResponse.equals(Object)",
    "int ImmutableResolveRowResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build(),
        "Different type to ImmutableResolveRowResponse");
  }

  /**
   * Test {@link ImmutableResolveRowResponse#errorMessage()}.
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#errorMessage()}
   */
  @Test
  @DisplayName("Test errorMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableResolveRowResponse.errorMessage()"})
  void testErrorMessage() {
    // Arrange and Act
    Optional<String> actualErrorMessageResult =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build()
            .errorMessage();

    // Assert
    assertEquals("An error occurred", actualErrorMessageResult.get());
    assertTrue(actualErrorMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code inputRow element}.
   *   <li>Then return inputRow is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add 'inputRow element'; then return inputRow is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveRowResponse ImmutableResolveRowResponse.fromJson(Json)"})
  void testFromJson_givenArrayListAddInputRowElement_thenReturnInputRowIsArrayList() {
    // Arrange
    ArrayList<String> inputRow = new ArrayList<>();
    inputRow.add("inputRow element");
    inputRow.add("Json");

    Json json = new Json();
    json.setInputRow(inputRow);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(inputRow, actualFromJsonResult.inputRow());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Json}.
   *   <li>Then return inputRow size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add 'Json'; then return inputRow size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveRowResponse ImmutableResolveRowResponse.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnInputRowSizeIsOne() {
    // Arrange
    ArrayList<String> inputRow = new ArrayList<>();
    inputRow.add("Json");

    Json json = new Json();
    json.setInputRow(inputRow);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    List<String> inputRowResult = actualFromJsonResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("Json", inputRowResult.get(0));
  }

  /**
   * Test {@link ImmutableResolveRowResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) InputRow is {@link ArrayList#ArrayList()}.
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) InputRow is ArrayList(); then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveRowResponse ImmutableResolveRowResponse.fromJson(Json)"})
  void testFromJson_givenArrayList_whenJsonInputRowIsArrayList_thenReturnStatusIsNew() {
    // Arrange
    Json json = new Json();
    json.setInputRow(new ArrayList<>());
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.inputRow().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code NEW}.
   *   <li>When {@link Json} (default constructor) InputRow is {@code null}.
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'NEW'; when Json (default constructor) InputRow is 'null'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveRowResponse ImmutableResolveRowResponse.fromJson(Json)"})
  void testFromJson_givenNew_whenJsonInputRowIsNull_thenReturnStatusIsNew() {
    // Arrange
    Json json = new Json();
    json.setInputRow(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.inputRow().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ErrorMessage is of {@code foo}.
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ErrorMessage is of 'foo'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableResolveRowResponse ImmutableResolveRowResponse.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonErrorMessageIsOfFoo_thenReturnStatusIsNew() {
    // Arrange
    Json json = new Json();
    json.setInputRow(null);
    json.setStatus(ResolutionStatus.NEW);
    Optional<String> errorMessage = Optional.of("foo");
    json.setErrorMessage(errorMessage);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.inputRow().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveRowResponse#inputRow()}
   *   <li>{@link ImmutableResolveRowResponse#status()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableResolveRowResponse.inputRow()",
    "ResolutionStatus ImmutableResolveRowResponse.status()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act
    List<String> actualInputRowResult = immutableResolveRowResponse.inputRow();

    // Assert
    assertEquals(ResolutionStatus.NEW, immutableResolveRowResponse.status());
    assertTrue(actualInputRowResult.isEmpty());
  }

  /**
   * Test Json {@link Json#errorMessage()}.
   *
   * <p>Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorMessage());
  }

  /**
   * Test Json {@link Json#inputRow()}.
   *
   * <p>Method under test: {@link Json#inputRow()}
   */
  @Test
  @DisplayName("Test Json inputRow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.inputRow()"})
  void testJsonInputRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inputRow());
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
    assertNull(actualJson.status);
    assertFalse(actualJson.errorMessage.isPresent());
    assertTrue(actualJson.inputRow.isEmpty());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolveRowResponse.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ResolveRowResponse{inputRow=[], status=NEW, errorMessage=An error occurred}",
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withErrorMessage(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return builder errorMessage {@code 42} status {@code NEW} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withErrorMessage(Optional)}
   */
  @Test
  @DisplayName(
      "Test withErrorMessage(Optional) with 'optional'; then return builder errorMessage '42' status 'NEW' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withErrorMessage(Optional)"
  })
  void testWithErrorMessageWithOptional_thenReturnBuilderErrorMessage42StatusNewBuild() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("42")
            .status(ResolutionStatus.NEW)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableResolveRowResponse actualWithErrorMessageResult =
        immutableResolveRowResponse.withErrorMessage(optional);

    // Assert
    assertSame(immutableResolveRowResponse, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withErrorMessage(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withErrorMessage(Optional)}
   */
  @Test
  @DisplayName("Test withErrorMessage(Optional) with 'optional'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withErrorMessage(Optional)"
  })
  void testWithErrorMessageWithOptional_thenReturnStatusIsNew() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableResolveRowResponse actualWithErrorMessageResult =
        immutableResolveRowResponse.withErrorMessage(optional);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithErrorMessageResult.status());
    assertTrue(actualWithErrorMessageResult.inputRow().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withErrorMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder errorMessage {@code 42} status {@code NEW} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withErrorMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withErrorMessage(String) with 'value'; then return builder errorMessage '42' status 'NEW' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withErrorMessage(String)"
  })
  void testWithErrorMessageWithValue_thenReturnBuilderErrorMessage42StatusNewBuild() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("42")
            .status(ResolutionStatus.NEW)
            .build();

    // Act
    ImmutableResolveRowResponse actualWithErrorMessageResult =
        immutableResolveRowResponse.withErrorMessage("42");

    // Assert
    assertSame(immutableResolveRowResponse, actualWithErrorMessageResult);
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withErrorMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withErrorMessage(String)}
   */
  @Test
  @DisplayName("Test withErrorMessage(String) with 'value'; then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withErrorMessage(String)"
  })
  void testWithErrorMessageWithValue_thenReturnStatusIsNew() {
    // Arrange and Act
    ImmutableResolveRowResponse actualWithErrorMessageResult =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build()
            .withErrorMessage("42");

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithErrorMessageResult.status());
    assertTrue(actualWithErrorMessageResult.inputRow().isEmpty());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withInputRow(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then return inputRow size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withInputRow(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withInputRow(Iterable) with 'Iterable'; given 'Elements'; then return inputRow size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withInputRow(Iterable)"
  })
  void testWithInputRowWithIterable_givenElements_thenReturnInputRowSizeIsOne() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableResolveRowResponse actualWithInputRowResult =
        immutableResolveRowResponse.withInputRow(elements);

    // Assert
    List<String> inputRowResult = actualWithInputRowResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("Elements", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, actualWithInputRowResult.status());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withInputRow(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withInputRow(String[])}
   */
  @Test
  @DisplayName("Test withInputRow(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withInputRow(String[])"
  })
  void testWithInputRowWithString() {
    // Arrange and Act
    ImmutableResolveRowResponse actualWithInputRowResult =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build()
            .withInputRow("Elements");

    // Assert
    List<String> inputRowResult = actualWithInputRowResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("Elements", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, actualWithInputRowResult.status());
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withStatus(ResolutionStatus)}.
   *
   * <ul>
   *   <li>Then return builder errorMessage {@code An error occurred} status {@code NEW} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withStatus(ResolutionStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(ResolutionStatus); then return builder errorMessage 'An error occurred' status 'NEW' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withStatus(ResolutionStatus)"
  })
  void testWithStatus_thenReturnBuilderErrorMessageAnErrorOccurredStatusNewBuild() {
    // Arrange
    ImmutableResolveRowResponse immutableResolveRowResponse =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.NEW)
            .build();

    // Act
    ImmutableResolveRowResponse actualWithStatusResult =
        immutableResolveRowResponse.withStatus(ResolutionStatus.NEW);

    // Assert
    assertSame(immutableResolveRowResponse, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableResolveRowResponse#withStatus(ResolutionStatus)}.
   *
   * <ul>
   *   <li>Then return status is {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveRowResponse#withStatus(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ResolutionStatus); then return status is 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveRowResponse ImmutableResolveRowResponse.withStatus(ResolutionStatus)"
  })
  void testWithStatus_thenReturnStatusIsNew() {
    // Arrange and Act
    ImmutableResolveRowResponse actualWithStatusResult =
        ImmutableResolveRowResponse.builder()
            .errorMessage("An error occurred")
            .status(ResolutionStatus.EXISTING)
            .build()
            .withStatus(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualWithStatusResult.status());
    assertTrue(actualWithStatusResult.inputRow().isEmpty());
  }
}
