package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataFlowDecoratorsActionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addAddedDecorators(EntityReference)}
   */
  @Test
  void testBuilderAddAddedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDecorators(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addAddedDecorators(EntityReference[])}
   */
  @Test
  void testBuilderAddAddedDecorators2() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAddedDecorators(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addAllAddedDecorators(Iterable)}
   */
  @Test
  void testBuilderAddAllAddedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAddedDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addAllRemovedDecorators(Iterable)}
   */
  @Test
  void testBuilderAddAllRemovedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRemovedDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addRemovedDecorators(EntityReference)}
   */
  @Test
  void testBuilderAddRemovedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDecorators(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addRemovedDecorators(EntityReference[])}
   */
  @Test
  void testBuilderAddRemovedDecorators2() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRemovedDecorators(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#addedDecorators(Iterable)}
   */
  @Test
  void testBuilderAddedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#flowId(Long)}
   */
  @Test
  void testBuilderFlowId() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    ImmutableUpdateDataFlowDecoratorsAction.Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, builderResult.build().flowId().longValue());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#flowId(Long)}
   */
  @Test
  void testBuilderFlowId2() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult.addAddedDecorators(mock(EntityReference.class));

    // Act
    ImmutableUpdateDataFlowDecoratorsAction.Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    ImmutableUpdateDataFlowDecoratorsAction buildResult = builderResult.build();
    assertEquals(1, buildResult.addedDecorators().size());
    assertEquals(1L, buildResult.flowId().longValue());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateDataFlowDecoratorsAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1L, builderResult.build().flowId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(entityReferenceSet);
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateDataFlowDecoratorsAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    ImmutableUpdateDataFlowDecoratorsAction buildResult = builderResult.build();
    assertEquals(1, buildResult.addedDecorators().size());
    assertEquals(1L, buildResult.flowId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(entityReferenceSet);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    ImmutableUpdateDataFlowDecoratorsAction buildResult = builderResult.build();
    assertEquals(1, buildResult.removedDecorators().size());
    assertEquals(1L, buildResult.flowId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Builder#removedDecorators(Iterable)}
   */
  @Test
  void testBuilderRemovedDecorators() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedDecorators(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualCopyOfResult = ImmutableUpdateDataFlowDecoratorsAction
        .copyOf(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualCopyOfResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualCopyOfResult.removedDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(entityReferenceSet);
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualCopyOfResult = ImmutableUpdateDataFlowDecoratorsAction
        .copyOf(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1, actualCopyOfResult.addedDecorators().size());
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    assertTrue(actualCopyOfResult.removedDecorators().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(entityReferenceSet);
    when(instance.removedDecorators()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualCopyOfResult = ImmutableUpdateDataFlowDecoratorsAction
        .copyOf(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    assertTrue(actualCopyOfResult.removedDecorators().isEmpty());
    assertEquals(entityReferenceSet, actualCopyOfResult.addedDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    UpdateDataFlowDecoratorsAction instance = mock(UpdateDataFlowDecoratorsAction.class);
    when(instance.flowId()).thenReturn(1L);
    when(instance.addedDecorators()).thenReturn(new HashSet<>());
    when(instance.removedDecorators()).thenReturn(entityReferenceSet);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualCopyOfResult = ImmutableUpdateDataFlowDecoratorsAction
        .copyOf(instance);

    // Assert
    verify(instance).addedDecorators();
    verify(instance).flowId();
    verify(instance).removedDecorators();
    assertEquals(1, actualCopyOfResult.removedDecorators().size());
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    assertTrue(actualCopyOfResult.addedDecorators().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(ImmutableUpdateDataFlowDecoratorsAction.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction.Json json = new ImmutableUpdateDataFlowDecoratorsAction.Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(null);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult = ImmutableUpdateDataFlowDecoratorsAction
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualFromJsonResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualFromJsonResult.removedDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(ImmutableUpdateDataFlowDecoratorsAction.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<EntityReference> removedDecorators = new LinkedHashSet<>();
    removedDecorators.add(mock(EntityReference.class));

    ImmutableUpdateDataFlowDecoratorsAction.Json json = new ImmutableUpdateDataFlowDecoratorsAction.Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(removedDecorators);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult = ImmutableUpdateDataFlowDecoratorsAction
        .fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removedDecorators().size());
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    assertTrue(actualFromJsonResult.addedDecorators().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Json#addedDecorators()}
   */
  @Test
  void testJsonAddedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataFlowDecoratorsAction.Json()).addedDecorators());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Json#flowId()}
   */
  @Test
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataFlowDecoratorsAction.Json()).flowId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateDataFlowDecoratorsAction.Json actualJson = new ImmutableUpdateDataFlowDecoratorsAction.Json();

    // Assert
    assertNull(actualJson.flowId);
    assertTrue(actualJson.addedDecorators.isEmpty());
    assertTrue(actualJson.removedDecorators.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateDataFlowDecoratorsAction.Json#removedDecorators()}
   */
  @Test
  void testJsonRemovedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableUpdateDataFlowDecoratorsAction.Json()).removedDecorators());
  }
}
