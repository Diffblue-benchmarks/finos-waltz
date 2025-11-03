package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableResolveRowResponse#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableResolveRowResponse#builder()}
   *   <li>{@link ImmutableResolveRowResponse#errorMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableResolveRowResponse Builder.build()", "Builder Builder.errorMessage(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualErrorMessageResult = ImmutableResolveRowResponse.builder().errorMessage("An error occurred");
    Optional<String> errorMessage = Optional.of("foo");

    // Assert
    assertSame(actualErrorMessageResult, actualErrorMessageResult.errorMessage(errorMessage));
  }

  /**
   * Test Builder {@link Builder#addAllInputRow(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInputRow(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInputRow(Iterable)"})
  void testBuilderAddAllInputRow_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInputRow(elements));
  }

  /**
   * Test Builder {@link Builder#addAllInputRow(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllInputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInputRow(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllInputRow(Iterable)"})
  void testBuilderAddAllInputRow_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInputRow(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addInputRow(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addInputRow(String)}
   */
  @Test
  @DisplayName("Test Builder addInputRow(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInputRow(String)"})
  void testBuilderAddInputRowWithElement() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInputRow("Element"));
  }

  /**
   * Test Builder {@link Builder#addInputRow(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addInputRow(String[])}
   */
  @Test
  @DisplayName("Test Builder addInputRow(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addInputRow(String[])"})
  void testBuilderAddInputRowWithElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInputRow("Elements"));
  }

  /**
   * Test Builder {@link Builder#errorMessage(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#errorMessage(Optional)}
   */
  @Test
  @DisplayName("Test Builder errorMessage(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.errorMessage(Optional)"})
  void testBuilderErrorMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    Optional<String> errorMessage = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.errorMessage(errorMessage));
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code instance}.</li>
   *   <li>Then builder build inputRow size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveRowResponse); given ArrayList() add 'instance'; then builder build inputRow size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom_givenArrayListAddInstance_thenBuilderBuildInputRowSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(stringList);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    ImmutableResolveRowResponse buildResult = builderResult.build();
    List<String> inputRowResult = buildResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("instance", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ResolveRowResponse} {@link ResolveRowResponse#errorMessage()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveRowResponse); given empty; when ResolveRowResponse errorMessage() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom_givenEmpty_whenResolveRowResponseErrorMessageReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.errorMessage()).thenReturn(emptyResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveRowResponse); given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveRowResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ResolveRowResponse)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveRowResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ResolveRowResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
  }

  /**
   * Test Builder {@link Builder#inputRow(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#inputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputRow(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputRow(Iterable)"})
  void testBuilderInputRow_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.inputRow(elements));
  }

  /**
   * Test Builder {@link Builder#inputRow(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#inputRow(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputRow(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.inputRow(Iterable)"})
  void testBuilderInputRow_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputRow(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#status(ResolutionStatus)}.
   * <p>
   * Method under test: {@link Builder#status(ResolutionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ResolutionStatus)")
  @Tag("MaintainedByDiffblue")
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
   * Test Json {@link Json#errorMessage()}.
   * <p>
   * Method under test: {@link Json#errorMessage()}
   */
  @Test
  @DisplayName("Test Json errorMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.errorMessage()"})
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorMessage());
  }

  /**
   * Test Json {@link Json#inputRow()}.
   * <p>
   * Method under test: {@link Json#inputRow()}
   */
  @Test
  @DisplayName("Test Json inputRow()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.inputRow()"})
  void testJsonInputRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).inputRow());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResolutionStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }
}
