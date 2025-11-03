package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.data_flow_decorator.ImmutableDataTypeDirectionKey.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableDataTypeDirectionKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDirectionKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#DatatypeId(Long)}.
   * <p>
   * Method under test: {@link Builder#DatatypeId(Long)}
   */
  @Test
  @DisplayName("Test Builder DatatypeId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.DatatypeId(Long)"})
  void testBuilderDatatypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.DatatypeId(1L));
  }

  /**
   * Test Builder {@link Builder#flowDirection(FlowDirection)}.
   * <p>
   * Method under test: {@link Builder#flowDirection(FlowDirection)}
   */
  @Test
  @DisplayName("Test Builder flowDirection(FlowDirection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowDirection(FlowDirection)"})
  void testBuilderFlowDirection() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowDirection(FlowDirection.INBOUND));
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDirectionKey)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build DatatypeId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeDirectionKey)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDirectionKey); given one; then builder build DatatypeId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeDirectionKey)"})
  void testBuilderFrom_givenOne_thenBuilderBuildDatatypeIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDirectionKey.builder();
    DataTypeDirectionKey instance = mock(DataTypeDirectionKey.class);
    when(instance.DatatypeId()).thenReturn(1L);
    when(instance.flowDirection()).thenReturn(FlowDirection.INBOUND);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).DatatypeId();
    verify(instance).flowDirection();
    ImmutableDataTypeDirectionKey buildResult = builderResult.build();
    assertEquals(1L, buildResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, buildResult.flowDirection());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#DatatypeId()}.
   * <p>
   * Method under test: {@link Json#DatatypeId()}
   */
  @Test
  @DisplayName("Test Json DatatypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.DatatypeId()"})
  void testJsonDatatypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).DatatypeId());
  }

  /**
   * Test Json {@link Json#flowDirection()}.
   * <p>
   * Method under test: {@link Json#flowDirection()}
   */
  @Test
  @DisplayName("Test Json flowDirection()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowDirection Json.flowDirection()"})
  void testJsonFlowDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowDirection());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDatatypeId(Long)}
   *   <li>{@link Json#setFlowDirection(FlowDirection)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDatatypeId(Long)",
      "void Json.setFlowDirection(FlowDirection)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDatatypeId(1L);
    actualJson.setFlowDirection(FlowDirection.INBOUND);

    // Assert
    assertEquals(1L, actualJson.DatatypeId.longValue());
  }
}
