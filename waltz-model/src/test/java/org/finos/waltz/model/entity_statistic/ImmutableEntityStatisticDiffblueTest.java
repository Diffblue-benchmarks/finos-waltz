package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatistic.Builder;
import org.finos.waltz.model.entity_statistic.ImmutableEntityStatistic.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDiffblueTest {
  /**
   * Test Builder {@link Builder#definition(EntityStatisticDefinition)}.
   * <ul>
   *   <li>When {@link ImmutableEntityStatisticDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definition(EntityStatisticDefinition)}
   */
  @Test
  @DisplayName("Test Builder definition(EntityStatisticDefinition); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definition(EntityStatisticDefinition)"})
  void testBuilderDefinition_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(new ImmutableEntityStatisticDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#from(EntityStatistic)}.
   * <ul>
   *   <li>Given {@link ImmutableEntityStatisticValue.Json} (default constructor).</li>
   *   <li>Then builder build definition is {@link ImmutableEntityStatisticDefinition.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatistic)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatistic); given Json (default constructor); then builder build definition is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatistic)"})
  void testBuilderFrom_givenJson_thenBuilderBuildDefinitionIsJson() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();
    EntityStatistic instance = mock(EntityStatistic.class);
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();
    when(instance.value()).thenReturn(json);
    ImmutableEntityStatisticDefinition.Json json2 = new ImmutableEntityStatisticDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).value();
    ImmutableEntityStatistic buildResult = builderResult.build();
    assertSame(json2, buildResult.definition());
    assertSame(json, buildResult.value());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatistic)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatistic)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatistic); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatistic)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();
    EntityStatistic instance = mock(EntityStatistic.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.definition()).thenReturn(new ImmutableEntityStatisticDefinition.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definition();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#value(EntityStatisticValue)}.
   * <ul>
   *   <li>When {@link ImmutableEntityStatisticValue.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#value(EntityStatisticValue)}
   */
  @Test
  @DisplayName("Test Builder value(EntityStatisticValue); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(EntityStatisticValue)"})
  void testBuilderValue_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatistic.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value(new ImmutableEntityStatisticValue.Json()));
  }

  /**
   * Test Json {@link Json#definition()}.
   * <p>
   * Method under test: {@link Json#definition()}
   */
  @Test
  @DisplayName("Test Json definition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityStatisticDefinition Json.definition()"})
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definition());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDefinition(EntityStatisticDefinition)}
   *   <li>{@link Json#setValue(EntityStatisticValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDefinition(EntityStatisticDefinition)",
      "void Json.setValue(EntityStatisticValue)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDefinition(new ImmutableEntityStatisticDefinition.Json());
    actualJson.setValue(new ImmutableEntityStatisticValue.Json());

    // Assert
    assertFalse(((ImmutableEntityStatisticDefinition.Json) actualJson.definition).id.isPresent());
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityStatisticValue Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
