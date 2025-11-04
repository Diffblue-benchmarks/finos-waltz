package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.FlowDirection;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDirectionKeyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDataTypeDirectionKey.Builder#DatatypeId(Long)}
   */
  @Test
  void testBuilderDatatypeId() {
    // Arrange
    ImmutableDataTypeDirectionKey.Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.DatatypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDirectionKey.Builder#flowDirection(FlowDirection)}
   */
  @Test
  void testBuilderFlowDirection() {
    // Arrange
    ImmutableDataTypeDirectionKey.Builder builderResult = ImmutableDataTypeDirectionKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowDirection(FlowDirection.INBOUND));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDirectionKey.Builder#from(DataTypeDirectionKey)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeDirectionKey.Builder builderResult = ImmutableDataTypeDirectionKey.builder();
    DataTypeDirectionKey instance = mock(DataTypeDirectionKey.class);
    when(instance.DatatypeId()).thenReturn(1L);
    when(instance.flowDirection()).thenReturn(FlowDirection.INBOUND);

    // Act
    ImmutableDataTypeDirectionKey.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).DatatypeId();
    verify(instance).flowDirection();
    ImmutableDataTypeDirectionKey buildResult = builderResult.build();
    assertEquals(1L, buildResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, buildResult.flowDirection());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDirectionKey#copyOf(DataTypeDirectionKey)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeDirectionKey instance = mock(DataTypeDirectionKey.class);
    when(instance.DatatypeId()).thenReturn(1L);
    when(instance.flowDirection()).thenReturn(FlowDirection.INBOUND);

    // Act
    ImmutableDataTypeDirectionKey actualCopyOfResult = ImmutableDataTypeDirectionKey.copyOf(instance);

    // Assert
    verify(instance).DatatypeId();
    verify(instance).flowDirection();
    assertEquals(1L, actualCopyOfResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualCopyOfResult.flowDirection());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDirectionKey#fromJson(ImmutableDataTypeDirectionKey.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDataTypeDirectionKey.Json json = new ImmutableDataTypeDirectionKey.Json();
    json.setDatatypeId(1L);
    json.setFlowDirection(FlowDirection.INBOUND);

    // Act
    ImmutableDataTypeDirectionKey actualFromJsonResult = ImmutableDataTypeDirectionKey.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.DatatypeId().longValue());
    assertEquals(FlowDirection.INBOUND, actualFromJsonResult.flowDirection());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDirectionKey.Json#DatatypeId()}
   */
  @Test
  void testJsonDatatypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDirectionKey.Json()).DatatypeId());
  }

  /**
   * Method under test: {@link ImmutableDataTypeDirectionKey.Json#flowDirection()}
   */
  @Test
  void testJsonFlowDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeDirectionKey.Json()).flowDirection());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDataTypeDirectionKey.Json}
   *   <li>{@link ImmutableDataTypeDirectionKey.Json#setDatatypeId(Long)}
   *   <li>
   * {@link ImmutableDataTypeDirectionKey.Json#setFlowDirection(FlowDirection)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDataTypeDirectionKey.Json actualJson = new ImmutableDataTypeDirectionKey.Json();
    actualJson.setDatatypeId(1L);
    actualJson.setFlowDirection(FlowDirection.INBOUND);

    // Assert
    assertEquals(1L, actualJson.DatatypeId.longValue());
  }
}
