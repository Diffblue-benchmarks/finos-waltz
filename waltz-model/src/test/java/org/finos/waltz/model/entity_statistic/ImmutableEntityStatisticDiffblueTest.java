package org.finos.waltz.model.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityStatistic.Builder#definition(EntityStatisticDefinition)}
   */
  @Test
  void testBuilderDefinition() {
    // Arrange
    ImmutableEntityStatistic.Builder builderResult = ImmutableEntityStatistic.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definition(new ImmutableEntityStatisticDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatistic.Builder#from(EntityStatistic)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityStatistic.Builder builderResult = ImmutableEntityStatistic.builder();
    EntityStatistic instance = mock(EntityStatistic.class);
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();
    when(instance.value()).thenReturn(json);
    ImmutableEntityStatisticDefinition.Json json2 = new ImmutableEntityStatisticDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableEntityStatistic.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definition();
    verify(instance).value();
    ImmutableEntityStatistic buildResult = builderResult.build();
    assertSame(json2, buildResult.definition());
    assertSame(json, buildResult.value());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatistic.Builder#from(EntityStatistic)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityStatistic.Builder builderResult = ImmutableEntityStatistic.builder();
    EntityStatistic instance = mock(EntityStatistic.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.definition()).thenReturn(new ImmutableEntityStatisticDefinition.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definition();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatistic.Builder#value(EntityStatisticValue)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableEntityStatistic.Builder builderResult = ImmutableEntityStatistic.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value(new ImmutableEntityStatisticValue.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatistic.Builder#value(EntityStatisticValue)}
   */
  @Test
  void testBuilderValue2() {
    // Arrange
    ImmutableEntityStatistic.Builder builderResult = ImmutableEntityStatistic.builder();

    ImmutableEntityStatisticValue.Json value = new ImmutableEntityStatisticValue.Json();
    value.setEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.value(value));
  }

  /**
   * Method under test: {@link ImmutableEntityStatistic#copyOf(EntityStatistic)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityStatistic instance = mock(EntityStatistic.class);
    ImmutableEntityStatisticValue.Json json = new ImmutableEntityStatisticValue.Json();
    when(instance.value()).thenReturn(json);
    ImmutableEntityStatisticDefinition.Json json2 = new ImmutableEntityStatisticDefinition.Json();
    when(instance.definition()).thenReturn(json2);

    // Act
    ImmutableEntityStatistic actualCopyOfResult = ImmutableEntityStatistic.copyOf(instance);

    // Assert
    verify(instance).definition();
    verify(instance).value();
    assertSame(json2, actualCopyOfResult.definition());
    assertSame(json, actualCopyOfResult.value());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatistic#fromJson(ImmutableEntityStatistic.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityStatistic.Json json = new ImmutableEntityStatistic.Json();
    ImmutableEntityStatisticDefinition.Json definition = new ImmutableEntityStatisticDefinition.Json();
    json.setDefinition(definition);
    ImmutableEntityStatisticValue.Json value = new ImmutableEntityStatisticValue.Json();
    json.setValue(value);

    // Act
    ImmutableEntityStatistic actualFromJsonResult = ImmutableEntityStatistic.fromJson(json);

    // Assert
    assertSame(definition, actualFromJsonResult.definition());
    assertSame(value, actualFromJsonResult.value());
  }

  /**
   * Method under test: {@link ImmutableEntityStatistic.Json#definition()}
   */
  @Test
  void testJsonDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatistic.Json()).definition());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableEntityStatistic.Json}
   *   <li>
   * {@link ImmutableEntityStatistic.Json#setDefinition(EntityStatisticDefinition)}
   *   <li>{@link ImmutableEntityStatistic.Json#setValue(EntityStatisticValue)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEntityStatistic.Json actualJson = new ImmutableEntityStatistic.Json();
    actualJson.setDefinition(new ImmutableEntityStatisticDefinition.Json());
    actualJson.setValue(new ImmutableEntityStatisticValue.Json());

    // Assert
    assertFalse(((ImmutableEntityStatisticDefinition.Json) actualJson.definition).id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableEntityStatistic.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityStatistic.Json()).value());
  }
}
