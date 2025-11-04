package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableBucketKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBucketKey#builder()}
   *   <li>{@link ImmutableBucketKey#dataTypeId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBucketKey.Builder actualBuilderResult = ImmutableBucketKey.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.dataTypeId(1L));
  }

  /**
   * Method under test: {@link ImmutableBucketKey.Builder#dataTypeRank(Integer)}
   */
  @Test
  void testBuilderDataTypeRank() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRank(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#from(FlowClassificationRuleUtilities.BucketKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();
    FlowClassificationRuleUtilities.BucketKey instance = mock(FlowClassificationRuleUtilities.BucketKey.class);
    when(instance.vantagePoint()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).vantagePoint();
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#from(FlowClassificationRuleUtilities.BucketKey)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();
    FlowClassificationRuleUtilities.BucketKey instance = mock(FlowClassificationRuleUtilities.BucketKey.class);
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBucketKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    ImmutableBucketKey buildResult = builderResult.build();
    assertEquals(1, buildResult.dataTypeRank().intValue());
    assertEquals(1, buildResult.vantagePointRank().intValue());
    assertEquals(1L, buildResult.dataTypeId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#from(FlowClassificationRuleUtilities.BucketKey)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();
    FlowClassificationRuleUtilities.BucketKey instance = mock(FlowClassificationRuleUtilities.BucketKey.class);
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(null);
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBucketKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    ImmutableBucketKey buildResult = builderResult.build();
    assertNull(buildResult.dataTypeId());
    assertEquals(1, buildResult.dataTypeRank().intValue());
    assertEquals(1, buildResult.vantagePointRank().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#from(FlowClassificationRuleUtilities.BucketKey)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();
    FlowClassificationRuleUtilities.BucketKey instance = mock(FlowClassificationRuleUtilities.BucketKey.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).vantagePoint();
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#vantagePoint(EntityReference)}
   */
  @Test
  void testBuilderVantagePoint() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePoint(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey.Builder#vantagePointRank(Integer)}
   */
  @Test
  void testBuilderVantagePointRank() {
    // Arrange
    ImmutableBucketKey.Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePointRank(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBucketKey#copyOf(FlowClassificationRuleUtilities.BucketKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRuleUtilities.BucketKey instance = mock(FlowClassificationRuleUtilities.BucketKey.class);
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBucketKey actualCopyOfResult = ImmutableBucketKey.copyOf(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).dataTypeRank();
    verify(instance).vantagePoint();
    verify(instance).vantagePointRank();
    assertEquals(1, actualCopyOfResult.dataTypeRank().intValue());
    assertEquals(1, actualCopyOfResult.vantagePointRank().intValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
  }
}
