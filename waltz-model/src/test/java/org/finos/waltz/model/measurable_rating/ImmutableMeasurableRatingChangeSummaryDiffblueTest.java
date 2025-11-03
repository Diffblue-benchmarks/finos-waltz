package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingChangeSummary.Builder;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingChangeSummaryDiffblueTest {
  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#builder()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#currentRatingNameAndCode(Tuple2)}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#desiredRatingNameAndCode(Tuple2)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingChangeSummary Builder.build()",
      "Builder Builder.currentRatingNameAndCode(Tuple2)", "Builder Builder.desiredRatingNameAndCode(Tuple2)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableRatingChangeSummary.builder();
    Builder actualCurrentRatingNameAndCodeResult = actualBuilderResult
        .currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    // Assert
    assertSame(actualCurrentRatingNameAndCodeResult,
        actualCurrentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2")));
  }

  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.entityRef()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.measurableRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
    verify(instance).measurableRef();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.measurableCategoryRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.currentRatingNameAndCode()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).currentRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <ul>
   *   <li>Then return build desiredRatingNameAndCode is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary); then return build desiredRatingNameAndCode is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom_thenReturnBuildDesiredRatingNameAndCodeIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.currentRatingNameAndCode()).thenReturn(tuple2);
    when(instance.desiredRatingNameAndCode()).thenReturn(null);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    ImmutableMeasurableRatingChangeSummary buildResult = actualFromResult.build();
    assertNull(buildResult.desiredRatingNameAndCode());
    ImmutableMeasurableRatingChangeSummary buildResult2 = builderResult.build();
    assertNull(buildResult2.desiredRatingNameAndCode());
    assertSame(tuple2, buildResult.currentRatingNameAndCode());
    assertSame(tuple2, buildResult2.currentRatingNameAndCode());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <ul>
   *   <li>Then return build desiredRatingNameAndCode is {@link Tuple2#Tuple2(Object, Object)} with {@code V1} and {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary); then return build desiredRatingNameAndCode is Tuple2(Object, Object) with 'V1' and 'V2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom_thenReturnBuildDesiredRatingNameAndCodeIsTuple2WithV1AndV2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.currentRatingNameAndCode()).thenReturn(new Tuple2<>("V1", "V2"));
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.desiredRatingNameAndCode()).thenReturn(tuple2);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    assertSame(tuple2, actualFromResult.build().desiredRatingNameAndCode());
    assertSame(tuple2, builderResult.build().desiredRatingNameAndCode());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   * <ul>
   *   <li>Then return build desiredRatingNameAndCode toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary); then return build desiredRatingNameAndCode toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom_thenReturnBuildDesiredRatingNameAndCodeToListSizeIsTwo() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.currentRatingNameAndCode()).thenReturn(null);
    when(instance.desiredRatingNameAndCode()).thenReturn(new Tuple2<>("V1", "V2"));
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    ImmutableMeasurableRatingChangeSummary buildResult = actualFromResult.build();
    List<?> toListResult = buildResult.desiredRatingNameAndCode().toList();
    assertEquals(2, toListResult.size());
    assertEquals("V1", toListResult.get(0));
    assertEquals("V2", toListResult.get(1));
    assertNull(buildResult.currentRatingNameAndCode());
    assertNull(builderResult.build().currentRatingNameAndCode());
  }

  /**
   * Test Builder {@link Builder#measurableCategoryRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableCategoryRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder measurableCategoryRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableCategoryRef(EntityReference)"})
  void testBuilderMeasurableCategoryRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategoryRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#measurableRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder measurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRef(EntityReference)"})
  void testBuilderMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRef(mock(EntityReference.class)));
  }
}
