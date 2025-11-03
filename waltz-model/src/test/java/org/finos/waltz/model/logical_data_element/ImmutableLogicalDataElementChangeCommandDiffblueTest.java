package org.finos.waltz.model.logical_data_element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand.Builder;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalDataElementChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(LogicalDataElementChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalDataElementChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElementChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand instance = builderResult2.newLogicalDataElement(newLogicalDataElement)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalDataElementChangeCommand)}.
   * <ul>
   *   <li>Then builder build is builder newLogicalDataElement empty build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalDataElementChangeCommand); then builder build is builder newLogicalDataElement empty build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalDataElementChangeCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderNewLogicalDataElementEmptyBuild() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.empty();
    ImmutableLogicalDataElementChangeCommand instance = builderResult2.newLogicalDataElement(newLogicalDataElement)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newLogicalDataElement(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#newLogicalDataElement(Optional)}
   */
  @Test
  @DisplayName("Test Builder newLogicalDataElement(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newLogicalDataElement(Optional)"})
  void testBuilderNewLogicalDataElementWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.newLogicalDataElement(newLogicalDataElement));
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}.
   * <ul>
   *   <li>Then return newLogicalDataElement Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#copyOf(LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalDataElementChangeCommand); then return newLogicalDataElement Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.copyOf(LogicalDataElementChangeCommand)"})
  void testCopyOf_thenReturnNewLogicalDataElementPresent() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand instance = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();

    // Act and Assert
    assertTrue(ImmutableLogicalDataElementChangeCommand.copyOf(instance).newLogicalDataElement().isPresent());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}, and {@link ImmutableLogicalDataElementChangeCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   *   <li>{@link ImmutableLogicalDataElementChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
      "int ImmutableLogicalDataElementChangeCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.empty();
    ImmutableLogicalDataElementChangeCommand buildResult = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();
    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement2 = Optional.empty();
    ImmutableLogicalDataElementChangeCommand buildResult2 = builderResult2.newLogicalDataElement(newLogicalDataElement2)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalDataElementChangeCommand.equals(Object)",
      "int ImmutableLogicalDataElementChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand buildResult = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();
    Builder builderResult2 = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement2 = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand buildResult2 = builderResult2.newLogicalDataElement(newLogicalDataElement2)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) NewLogicalDataElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) NewLogicalDataElement is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonNewLogicalDataElementIsNull() {
    // Arrange
    Json json = new Json();
    json.setNewLogicalDataElement(null);

    // Act and Assert
    assertFalse(ImmutableLogicalDataElementChangeCommand.fromJson(json).newLogicalDataElement().isPresent());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return not newLogicalDataElement Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return not newLogicalDataElement Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnNotNewLogicalDataElementPresent() {
    // Arrange, Act and Assert
    assertFalse(ImmutableLogicalDataElementChangeCommand.fromJson(new Json()).newLogicalDataElement().isPresent());
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
    // Arrange, Act and Assert
    assertFalse((new Json()).newLogicalDataElement.isPresent());
  }

  /**
   * Test Json {@link Json#newLogicalDataElement()}.
   * <p>
   * Method under test: {@link Json#newLogicalDataElement()}
   */
  @Test
  @DisplayName("Test Json newLogicalDataElement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.newLogicalDataElement()"})
  void testJsonNewLogicalDataElement() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newLogicalDataElement());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#newLogicalDataElement()}.
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#newLogicalDataElement()}
   */
  @Test
  @DisplayName("Test newLogicalDataElement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableLogicalDataElementChangeCommand.newLogicalDataElement()"})
  void testNewLogicalDataElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand buildResult = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();

    // Act and Assert
    assertTrue(buildResult.newLogicalDataElement().isPresent());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(Optional)}
   */
  @Test
  @DisplayName("Test withNewLogicalDataElement(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.withNewLogicalDataElement(Optional)"})
  void testWithNewLogicalDataElementWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand buildResult = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();
    Optional<? extends EntityReference> optional = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertTrue(buildResult.withNewLogicalDataElement(optional).newLogicalDataElement().isPresent());
  }

  /**
   * Test {@link ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(EntityReference)} with {@code value}.
   * <ul>
   *   <li>Then return newLogicalDataElement Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalDataElementChangeCommand#withNewLogicalDataElement(EntityReference)}
   */
  @Test
  @DisplayName("Test withNewLogicalDataElement(EntityReference) with 'value'; then return newLogicalDataElement Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalDataElementChangeCommand ImmutableLogicalDataElementChangeCommand.withNewLogicalDataElement(EntityReference)"})
  void testWithNewLogicalDataElementWithValue_thenReturnNewLogicalDataElementPresent() {
    // Arrange
    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.of(mock(EntityReference.class));
    ImmutableLogicalDataElementChangeCommand buildResult = builderResult.newLogicalDataElement(newLogicalDataElement)
        .build();
    EntityReference value = mock(EntityReference.class);

    // Act and Assert
    Optional<EntityReference> newLogicalDataElementResult = buildResult.withNewLogicalDataElement(value)
        .newLogicalDataElement();
    assertTrue(newLogicalDataElementResult.isPresent());
    assertSame(value, newLogicalDataElementResult.get());
  }
}
