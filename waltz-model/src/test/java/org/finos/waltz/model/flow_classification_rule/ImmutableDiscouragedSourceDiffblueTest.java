package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.flow_classification_rule.ImmutableDiscouragedSource.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableDiscouragedSource.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiscouragedSourceDiffblueTest {
  /**
   * Test Builder {@link Builder#count(int)}.
   * <p>
   * Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   * <p>
   * Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Test Builder {@link Builder#from(DiscouragedSource)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build dataTypeId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiscouragedSource)}
   */
  @Test
  @DisplayName("Test Builder from(DiscouragedSource); given three; then builder build dataTypeId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiscouragedSource)"})
  void testBuilderFrom_givenThree_thenBuilderBuildDataTypeIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();
    DiscouragedSource instance = mock(DiscouragedSource.class);
    when(instance.count()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).dataTypeId();
    verify(instance).sourceReference();
    ImmutableDiscouragedSource buildResult = builderResult.build();
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(3, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DiscouragedSource)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DiscouragedSource)}
   */
  @Test
  @DisplayName("Test Builder from(DiscouragedSource); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DiscouragedSource)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();
    DiscouragedSource instance = mock(DiscouragedSource.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).sourceReference();
  }

  /**
   * Test Builder {@link Builder#sourceReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#sourceReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder sourceReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceReference(EntityReference)"})
  void testBuilderSourceReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceReference(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setSourceReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setSourceReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setSourceReference(null);

    // Assert
    assertNull(actualJson.sourceReference);
    assertEquals(0, actualJson.count);
    assertEquals(0L, actualJson.dataTypeId);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   * <p>
   * Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   * <p>
   * Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeId(long)"})
  void testJsonSetDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#sourceReference()}.
   * <p>
   * Method under test: {@link Json#sourceReference()}
   */
  @Test
  @DisplayName("Test Json sourceReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.sourceReference()"})
  void testJsonSourceReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sourceReference());
  }
}
