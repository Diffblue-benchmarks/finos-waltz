package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingChangeSummaryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#builder()}
   *   <li>
   * {@link ImmutableMeasurableRatingChangeSummary#currentRatingNameAndCode(Tuple2)}
   *   <li>
   * {@link ImmutableMeasurableRatingChangeSummary#desiredRatingNameAndCode(Tuple2)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRatingChangeSummary.Builder actualBuilderResult = ImmutableMeasurableRatingChangeSummary
        .builder();
    ImmutableMeasurableRatingChangeSummary.Builder actualCurrentRatingNameAndCodeResult = actualBuilderResult
        .currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    // Assert
    assertSame(actualCurrentRatingNameAndCodeResult,
        actualCurrentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2")));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#entityRef(EntityReference)}
   */
  @Test
  void testBuilderEntityRef() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.entityRef()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.measurableRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
    verify(instance).measurableRef();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
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
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.currentRatingNameAndCode()).thenReturn(tuple2);
    Tuple2<String, String> tuple22 = new Tuple2<>("V1", "V2");

    when(instance.desiredRatingNameAndCode()).thenReturn(tuple22);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    ImmutableMeasurableRatingChangeSummary buildResult = builderResult.build();
    assertSame(tuple2, buildResult.currentRatingNameAndCode());
    assertSame(tuple22, buildResult.desiredRatingNameAndCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.currentRatingNameAndCode()).thenReturn(null);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.desiredRatingNameAndCode()).thenReturn(tuple2);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    ImmutableMeasurableRatingChangeSummary buildResult = builderResult.build();
    assertNull(buildResult.currentRatingNameAndCode());
    assertSame(tuple2, buildResult.desiredRatingNameAndCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.currentRatingNameAndCode()).thenReturn(tuple2);
    when(instance.desiredRatingNameAndCode()).thenReturn(null);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    ImmutableMeasurableRatingChangeSummary buildResult = builderResult.build();
    assertNull(buildResult.desiredRatingNameAndCode());
    assertSame(tuple2, buildResult.currentRatingNameAndCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
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
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#measurableCategoryRef(EntityReference)}
   */
  @Test
  void testBuilderMeasurableCategoryRef() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategoryRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary.Builder#measurableRef(EntityReference)}
   */
  @Test
  void testBuilderMeasurableRef() {
    // Arrange
    ImmutableMeasurableRatingChangeSummary.Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary#copyOf(MeasurableRatingChangeSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.currentRatingNameAndCode()).thenReturn(tuple2);
    Tuple2<String, String> tuple22 = new Tuple2<>("V1", "V2");

    when(instance.desiredRatingNameAndCode()).thenReturn(tuple22);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary actualCopyOfResult = ImmutableMeasurableRatingChangeSummary.copyOf(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    assertSame(tuple2, actualCopyOfResult.currentRatingNameAndCode());
    assertSame(tuple22, actualCopyOfResult.desiredRatingNameAndCode());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary#copyOf(MeasurableRatingChangeSummary)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    when(instance.currentRatingNameAndCode()).thenReturn(null);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.desiredRatingNameAndCode()).thenReturn(tuple2);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary actualCopyOfResult = ImmutableMeasurableRatingChangeSummary.copyOf(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    assertNull(actualCopyOfResult.currentRatingNameAndCode());
    assertSame(tuple2, actualCopyOfResult.desiredRatingNameAndCode());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingChangeSummary#copyOf(MeasurableRatingChangeSummary)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    MeasurableRatingChangeSummary instance = mock(MeasurableRatingChangeSummary.class);
    Tuple2<String, String> tuple2 = new Tuple2<>("V1", "V2");

    when(instance.currentRatingNameAndCode()).thenReturn(tuple2);
    when(instance.desiredRatingNameAndCode()).thenReturn(null);
    when(instance.measurableCategoryRef()).thenReturn(mock(EntityReference.class));
    when(instance.measurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableMeasurableRatingChangeSummary actualCopyOfResult = ImmutableMeasurableRatingChangeSummary.copyOf(instance);

    // Assert
    verify(instance).currentRatingNameAndCode();
    verify(instance).desiredRatingNameAndCode();
    verify(instance).entityRef();
    verify(instance).measurableCategoryRef();
    verify(instance).measurableRef();
    assertNull(actualCopyOfResult.desiredRatingNameAndCode());
    assertSame(tuple2, actualCopyOfResult.currentRatingNameAndCode());
  }
}
