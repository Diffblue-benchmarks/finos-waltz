package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurablePercentageChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#from(MeasurablePercentageChange)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurablePercentageChange)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurablePercentageChange); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurablePercentageChange)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.previousPercentage()).thenReturn(emptyResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    ImmutableMeasurablePercentageChange buildResult = builderResult.build();
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.measurablePercentage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurablePercentageChange)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then builder build operation is {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurablePercentageChange)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurablePercentageChange); given Optional with one; then builder build operation is 'ADD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurablePercentageChange)"})
  void testBuilderFrom_givenOptionalWithOne_thenBuilderBuildOperationIsAdd() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.previousPercentage()).thenReturn(ofResult);
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();
    when(instance.measurablePercentage()).thenReturn(json);
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
    ImmutableMeasurablePercentageChange buildResult = builderResult.build();
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(json, buildResult.measurablePercentage());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurablePercentageChange)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurablePercentageChange)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurablePercentageChange); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurablePercentageChange)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    MeasurablePercentageChange instance = mock(MeasurablePercentageChange.class);
    when(instance.previousPercentage()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurablePercentage()).thenReturn(new ImmutableMeasurableRatingPercentage.Json());
    when(instance.operation()).thenReturn(Operation.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurablePercentage();
    verify(instance).operation();
    verify(instance).previousPercentage();
  }

  /**
   * Test Builder {@link Builder#measurablePercentage(MeasurableRatingPercentage)}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableRatingPercentage.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurablePercentage(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName("Test Builder measurablePercentage(MeasurableRatingPercentage); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurablePercentage(MeasurableRatingPercentage)"})
  void testBuilderMeasurablePercentage_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurablePercentage(new ImmutableMeasurableRatingPercentage.Json()));
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   * <p>
   * Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#previousPercentage(int)} with {@code int}.
   * <p>
   * Method under test: {@link Builder#previousPercentage(int)}
   */
  @Test
  @DisplayName("Test Builder previousPercentage(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.previousPercentage(int)"})
  void testBuilderPreviousPercentageWithInt() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.previousPercentage(1));
  }

  /**
   * Test Builder {@link Builder#previousPercentage(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#previousPercentage(Optional)}
   */
  @Test
  @DisplayName("Test Builder previousPercentage(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.previousPercentage(Optional)"})
  void testBuilderPreviousPercentageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    Optional<Integer> previousPercentage = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.previousPercentage(previousPercentage));
  }

  /**
   * Test Json {@link Json#measurablePercentage()}.
   * <p>
   * Method under test: {@link Json#measurablePercentage()}
   */
  @Test
  @DisplayName("Test Json measurablePercentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRatingPercentage Json.measurablePercentage()"})
  void testJsonMeasurablePercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurablePercentage());
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
    assertNull(actualJson.operation);
    assertNull(actualJson.measurablePercentage);
    assertFalse(actualJson.previousPercentage.isPresent());
  }

  /**
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#previousPercentage()}.
   * <p>
   * Method under test: {@link Json#previousPercentage()}
   */
  @Test
  @DisplayName("Test Json previousPercentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.previousPercentage()"})
  void testJsonPreviousPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).previousPercentage());
  }
}
