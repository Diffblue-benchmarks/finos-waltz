package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleUtilities.BucketKey;
import org.finos.waltz.service.flow_classification_rule.ImmutableBucketKey.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBucketKeyDiffblueTest {
  /**
   * Test {@link ImmutableBucketKey#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBucketKey#builder()}
   *   <li>{@link ImmutableBucketKey#dataTypeId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBucketKey Builder.build()", "Builder Builder.dataTypeId(Long)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBucketKey.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.dataTypeId(1L));
  }

  /**
   * Test Builder {@link Builder#dataTypeRank(Integer)}.
   * <p>
   * Method under test: {@link Builder#dataTypeRank(Integer)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRank(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeRank(Integer)"})
  void testBuilderDataTypeRank() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRank(1));
  }

  /**
   * Test Builder {@link Builder#from(BucketKey)}.
   * <ul>
   *   <li>Then builder build dataTypeId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey); then builder build dataTypeId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom_thenBuilderBuildDataTypeIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();
    BucketKey instance = mock(BucketKey.class);
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(null);
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BucketKey)}.
   * <ul>
   *   <li>Then builder build dataTypeId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey); then builder build dataTypeId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom_thenBuilderBuildDataTypeIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();
    BucketKey instance = mock(BucketKey.class);
    when(instance.dataTypeRank()).thenReturn(1);
    when(instance.vantagePointRank()).thenReturn(1);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BucketKey)}.
   * <ul>
   *   <li>When {@link BucketKey} {@link BucketKey#dataTypeId()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey); when BucketKey dataTypeId() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom_whenBucketKeyDataTypeIdThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();
    BucketKey instance = mock(BucketKey.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.vantagePoint()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).vantagePoint();
  }

  /**
   * Test Builder {@link Builder#from(BucketKey)}.
   * <ul>
   *   <li>When {@link BucketKey} {@link BucketKey#vantagePoint()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey); when BucketKey vantagePoint() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom_whenBucketKeyVantagePointThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();
    BucketKey instance = mock(BucketKey.class);
    when(instance.vantagePoint()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).vantagePoint();
  }

  /**
   * Test Builder {@link Builder#vantagePointRank(Integer)}.
   * <p>
   * Method under test: {@link Builder#vantagePointRank(Integer)}
   */
  @Test
  @DisplayName("Test Builder vantagePointRank(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vantagePointRank(Integer)"})
  void testBuilderVantagePointRank() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePointRank(1));
  }

  /**
   * Test Builder {@link Builder#vantagePoint(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#vantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder vantagePoint(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.vantagePoint(EntityReference)"})
  void testBuilderVantagePoint_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePoint(mock(EntityReference.class)));
  }
}
