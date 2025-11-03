package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristicsRequest); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristicsRequest)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();
    DataTypeDecoratorRatingCharacteristicsRequest instance = mock(DataTypeDecoratorRatingCharacteristicsRequest.class);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).source();
    verify(instance).target();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristicsRequest); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristicsRequest)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();
    DataTypeDecoratorRatingCharacteristicsRequest instance = mock(DataTypeDecoratorRatingCharacteristicsRequest.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setSource(EntityReference)}
   *   <li>{@link Json#setTarget(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setSource(EntityReference)",
      "void Json.setTarget(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setSource(null);
    actualJson.setTarget(null);

    // Assert
    assertNull(actualJson.source);
    assertNull(actualJson.target);
  }

  /**
   * Test Json {@link Json#source()}.
   * <p>
   * Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).source());
  }

  /**
   * Test Json {@link Json#target()}.
   * <p>
   * Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).target());
  }
}
